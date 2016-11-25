package com.jxy.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2016/11/25 11:42]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ProducerTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.18.173.131:9092");
        //  ack配置，控制请求被视为完整的标准。我们已经指定了“all”，这会阻塞提交完整的消息，这种设置性能最低，但是是最可靠的。
        props.put("acks", "all");
        //  retries，如果请求失败，生产者会自动重试，我们指定是0次，如果启用多次，则会有重复消息的可能性。
        props.put("retries", 0);
        // 生产者缓存每个分区未发送消息。这些缓存的大小是通过 batch.size 配置指定的。
        // 值较大的话将会产生更多的批。但是需要更多的内存（通常每个“活动”分区都有缓冲区）。
        props.put("batch.size", 16384);
        /*默认缓冲可以立即发送，即使有额外未使用的缓冲空间，但是，如果你想减少请求的数量，可以设置linger.ms大于0。
          这将指示生产者发送请求之前等待一段时间，希望更多的消息填补到同一个批次。这类似于TCP的算法，例如上面的代码段，
          可能100条消息在一个请求发送，因为我们设置了linger(逗留)时间为1毫秒，然后，如果我们没有填满缓冲区，
          这个设置将增加1毫秒的延迟请求来等待更多的消息。需要注意的是，在高负载下，相近的时间一般也会组成批，
          不管linger.ms=0，然后，设置比0大，将会有更少的，更有效的请求，在最大负荷时少量的延迟的成本。*/
        props.put("linger.ms", 1);

        /* buffer.memory 控制生产者可用内存缓冲的总量，如果消息发送速度比他们快可以传输到服务器的快，
           会耗尽这个缓冲区空间。当缓冲区空间耗尽，其他发送调用将被阻塞，如果不想任何阻塞，
           你可以设置block.on.buffer.full=false，但是这将会导致发送调用异常。*/
        props.put("buffer.memory", 33554432);

        // key.serializer和value.serializer示例，如何将用户提供的key和value对象ProducerRecord转换成字节，
        // 您可以使用附带的ByteArraySerializaer或StringSerializer简单的string或byte类型
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 10; i++) {
            // send()方法是异步的，添加消息到缓冲区等待发送，并立即返回。这使生产者通过批量发送消息来提高效率。
            Future<RecordMetadata> send = producer.send(
                    new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)),
                    (metadata, exception) -> {
                        if (exception != null) {
                            exception.printStackTrace();
                        }
                        System.out.println("The offset of the record we just sent is: " + metadata.offset());
                    });
            try {
                // 调用Future的get方法阻塞，直到发送消息成功
                send.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        producer.close();
    }
}
