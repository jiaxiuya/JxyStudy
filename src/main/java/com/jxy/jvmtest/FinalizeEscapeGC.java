package jxy.jvmtest;

/**
 * Created by jiaxiuya
 * <p>
 * 一个对象逃离GC的自我拯救的过程，但是只有一次机会，因为Finalize只会被执行一次
 *
 * @Date 2016/5/14 17:45.
 * @Version nothing
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC finalizeEscapeGC = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法被调用");
        FinalizeEscapeGC.finalizeEscapeGC = this;
    }

    public static void main(String[] args) {
        // 第一次拯救自己
        finalizeEscapeGC = new FinalizeEscapeGC();

        finalizeEscapeGC= null;
        System.gc();

        try {
            // 由于gc方法的优先级很低，所以先睡眠0.5秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(finalizeEscapeGC != null){
            System.out.println("第一次拯救成功");
        }else{
            System.out.printf("第一次拯救失败");
        }


        // 第二次拯救失败
        finalizeEscapeGC = null;
        System.gc();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(finalizeEscapeGC != null){
            System.out.println("第二次拯救成功");
        }else{
            System.out.printf("第二次拯救失败");
        }

    }
}
