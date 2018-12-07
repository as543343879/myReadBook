package com.mg.javaxnj.chapter02;

/**
 * FinalizeEscapGC class
 *
 * @author 谢小平
 * @date 2018/9/13
 */
public class FinalizeEscapGC {
    public static FinalizeEscapGC SAVE_HOOK = null;
    public void isAlive(){
        System.out.println("yes , i am still alive : )");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed！");
        FinalizeEscapGC.SAVE_HOOK = this;
    }
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i am dead ;");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i am dead ;");
        }
    }
}
