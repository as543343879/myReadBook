package com.jdk8.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TestAdd class
 * https://mp.weixin.qq.com/s?__biz=MzI1NDQ3MjQxNA==&mid=2247503081&idx=1&sn=128ff9b2a26a42ba5db2be92f8c889c5&chksm=e9c63558deb1bc4e238d06b239eaa4a9520b073c7b6314d278afbe9d83cb952ceb4b669bbbc9&scene=21#wechat_redirect
 *
 * @author 谢小平
 * @date 2022/9/23
 */
public class TestAdd {

    @Test
    public void test1() {
        // int[] 是一个类型。
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        System.out.println(list.size());


        Integer[] arr3 = {1, 2, 3};
        List list3 = Arrays.asList(arr3);
        System.out.println(list3.size());
    }

}
