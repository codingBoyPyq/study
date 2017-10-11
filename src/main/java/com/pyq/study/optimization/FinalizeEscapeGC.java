package com.pyq.study.optimization;

/**
 * Created by pangyueqiang on 17/7/27.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK= null;

    public void isAlive(){
        System.out.println("yes ,i am still alive");
    }

    //垃圾回收器准备释放内存的时候，会先调用finalize()
    @Override
    protected  void  finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method eexecuted!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args)throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;

        System.gc();
        //因为Finalize方法优先级很低，暂停0.5秒等待他

        Thread.sleep(500l);

        if(SAVE_HOOK!=null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("no i am is dead");

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500l);

        if(SAVE_HOOK!=null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("no i am is dead");
    }
}
