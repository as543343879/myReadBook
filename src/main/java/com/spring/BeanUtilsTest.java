package com.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * BeanUtilsTest class
 *
 * @author 谢小平
 * @date 2021/8/4
 */

public class BeanUtilsTest {
    @Test
    public void test1(){
        BeanTest beanTest = new BeanTest("id",1);
        Map<String,Object> data = new HashMap<>();
        data.put("name","id");
        data.put("id",1);

//        BeanTest beanTestNew = new BeanTest("id2",12);
////        BeanUtils.copyProperties(data,beanTestNew);
//        try {
////            org.apache.commons.beanutils.BeanUtils.populate(beanTestNew,data);
//            System.out.println(beanTestNew);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }

}
