package com.mg.learn.btrace.scripts;

//@BTrace
//public class TraceMethodArgsAndReturn {
//    @OnMethod(
//            clazz="com.mg.learn.btrace.StringTableTest",
//            method="intern",
//            location=@Location(Kind.RETURN)
//    )
//    public static void traceExecute(int sSrc,@Return long result){
//        println("invoke StringTableTest.intern");
//        println(strcat("input arg is:", str(sSrc)));
//        println(strcat("result is:",str(result)));
//        println(strcat("time is:",str(timeMillis())));
//        jstack();
//    }
//	@OnMethod(
//            clazz="com.mg.learn.btrace.StringTableTest",
//            location=@Location(value=Kind.LINE,line=12)
//    )
//    public static void traceExecute(@ProbeClassName String pcn,@ProbeMethodName String pmn,int line){
//        println(strcat(strcat(strcat("call ",pcn),"."),pmn));
//    }
//}