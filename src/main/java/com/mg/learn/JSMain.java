package com.mg.learn;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
import java.util.Map;
import java.util.TreeMap;

/**
 * JSMain class
 *
 * @author 谢小平
 * @date 2018/9/17
 */
public class JSMain {
    public static ScriptEngine engine;
    private static String str;
    public static void putValue() throws Exception{
        str="Math.pow(a,b)";
        Map<String, Object> input=new TreeMap<>();
        input.put("a",2);
        input.put("b",8);
        System.out.println(engine.eval(str,new SimpleBindings(input)));
    }
    public static void callJsFunction() throws Exception{
        engine.eval("function add (a, b) {return a+b; }");
        Invocable jsInvoke = (Invocable) engine;
        Object res = jsInvoke.invokeFunction("add", new Object [] { 10, 5 });
        System.out.println(res);
    }

    public static void callJsFunction2() throws Exception{
        engine.eval("function add( status ) {\n" +
                "\t\tif(status == 1) {\n" +
                "\t\t\tstatus  = 0;\n" +
                "\t\t} else  if(status == 2) {\n" +
                "\t\t\tstatus  = 1;\n" +
                "\t\t} else {\n" +
                "\t\t\tstatus = -1;\n" +
                "\t\t}\n" +
                "\t\treturn  status;\n" +
                "\t}");
        Invocable jsInvoke = (Invocable) engine;
        Object res = jsInvoke.invokeFunction("add", new Object [] {  1 });
        System.out.println(res);
    }
    public static  final String FUNCTION_START = "function afunction(";
    public static  final String FUNCTION_END = "}";
    public static  final String FUNCTION_MID = "){";

    public static Object callsJsFunction(String function, String param, Object... data) {
        try{
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine engines = sem.getEngineByName("javascript");
            String functions = FUNCTION_START + param + FUNCTION_MID  + function + FUNCTION_END;
            System.out.println(functions);
            engines.eval(functions);
            Invocable jsInvoke = (Invocable) engines;
            Object res = jsInvoke.invokeFunction("afunction", data);
            return res;
        }catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }
    @Test
    public void   test2() {
        String str = "1";
        System.out.println(callsJsFunction("return status + 2;", "status", (Object) str) );
//        System.out.println(callsJsFunction("return a + b;", "a,b", new Object[]{1,3}));
//        System.out.println(callsJsFunction("return a + b;", "a,b", new Object[]{1,4}));
//        System.out.println(callsJsFunction("return a + b;", "a,b", new Object[]{1,5}));
    }
    @Test
    public void test3() {
        int[] ar = {1,2};
        for(int i = 0; i < 3; i ++) {
            if(i == 0 ) {
                System.out.println(i +"--------------");
                break;
            }
            System.out.println(i +"--------------");
        }
    }


    public static void main(String[] args) {
        ScriptEngineManager sem = new ScriptEngineManager();
        engine=sem.getEngineByName("javascript");
        try {
            callJsFunction2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
