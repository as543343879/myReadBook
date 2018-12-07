package com.mg.learn;


import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;
import com.singularsys.jep.functions.If;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2018/9/17
 */
public class Main {


    public static void main(String[] args) {
        Jep jep = new Jep();
        String exp = "((a+b)*(c+b))/(c+a)/b"; //给变量赋值
        try { //执行
            jep.addVariable("a", 10);
            jep.addVariable("b", 10);
            jep.addVariable("c", 10);
            jep.parse(exp);
            Object result = jep.evaluate();
            System.out.println("计算结果： " + result); }
        catch (JepException e)
        {
            System.out.println("An error occured: " + e.getMessage());
        }

    }
    @Test
    public void test1() {
        Map<String, Object> data = new HashMap<>();
        data.put("status", 1);
        String exp = "(status == 1 ? 0:status)";
        System.out.println(iotJep(data,exp));
    }

    public static Object iotJep (Map<String, Object> data, String exp) {
        if(data == null || exp == null || data.size() <= 0 ) {
            throw new RuntimeException("参数不能为空");
        }
        try{
            Jep jep = new Jep();
            for(Map.Entry<String, Object> entry : data.entrySet()) {
                jep.addVariable(entry.getKey(), entry.getValue());
            }
            jep.parse(exp);
            Object result = jep.evaluate();
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
