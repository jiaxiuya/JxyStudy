import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static void main(String[] args) {

        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

        System.out.println(myFmt.format(new Date()));

        System.out.println(System.nanoTime());
    }
}
