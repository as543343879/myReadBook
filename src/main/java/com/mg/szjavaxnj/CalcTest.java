package com.mg.szjavaxnj;

/**
 * Calc class
 *
 * @author 谢小平
 * @date 2018/12/18
 */
public class CalcTest {
    private int xxp;
    private  final  int xxd = 1;
    private static String  sxxp;
    private static  Integer sxxd;
    private final static String  fsxxp = "1";
    private final static  Integer fsxxd = 0;
    private final static  int ifsxxd = 0;
    public synchronized String calc2() {
        sxxp = "xxd";
        return sxxp;
    }
    public synchronized String calc3(CalcTest calcTest) {
        synchronized (calcTest) {
            sxxp = "xxd2";
            return sxxp;
        }
    }
    public int calc() throws IllegalArgumentException, ArithmeticException {
        int 天下 = 1;
        int a = 500;
        int b = 200;
        int c = 50;
        int k = 1;
        try{
            k = 2;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            k = 3;
        }

        return (a + b) / c * 天下 + k;
    }
}
