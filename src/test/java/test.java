import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <类描述>
 * <功能详细描述>
 *
 * @author 贾秀亚
 * @version [版本号, 2015/10/19 14:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class test {

    static ScheduledExecutorService schedule = Executors.newScheduledThreadPool(50);

    public static void main(String[] args) {

        Future result = schedule.schedule(new Runnable() {
            @Override
            public void run() {
                    System.out.println("send timeNotice start  10000!");
            }
        }, 10000, TimeUnit.MILLISECONDS);

        System.out.println(1111);

        Future result1 = schedule.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("send timeNotice start  5000!");
            }
        }, 5000, TimeUnit.MILLISECONDS);

        System.out.println(1);

    }
}
