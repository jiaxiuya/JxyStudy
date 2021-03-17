package com.jxy.jvmtest;

/**
 * Created by jiaxiuya
 * <p>
 * 一个对象逃离GC的自我拯救的过程，但是只有一次机会，因为Finalize只会被执行一次
 *
 * @Date 2016/5/14 17:45.
 * @Version nothing
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() { System.out.println("yes, i am still alive :)"); }

    /**
     * 对象拯救自己最后的机会，gc标记阶段会会执行，且只执行一次
     * 但是不建议使用，因为之前的时间顺序太不可控
     * 有些教材可以用来清理外部依赖对象，但是try finally可以做的更好
     * 咱们忘了这个方法吧
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        //对象第一次成功拯救自己
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) { SAVE_HOOK.isAlive(); } else {
            System.out.println("no, i am dead :(");
        }

        // 下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else { System.out.println("no, i am dead :("); }
    }
}
