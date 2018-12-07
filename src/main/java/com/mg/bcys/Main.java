package com.mg.bcys;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2018/9/11
 */
class  Singletion {

}
public class Main {
    private  volatile  Singletion singletion;
    public static void main(String[] args) {
        Main main = new Main();
         main.singletion   = new Singletion();
    }
}
