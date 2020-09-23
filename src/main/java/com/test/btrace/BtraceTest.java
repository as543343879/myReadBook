package com.test.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * @date 2020-09-22
 */
@BTrace
public class BtraceTest {
	@OnMethod(
			clazz = "com.wp.ecs.controller.login.DjgLoginRelatedController",
			method = "codeLogin",
			location = @Location(Kind.ENTRY)
	)
	public static void anyRead(@ProbeClassName String pcn,
	                           @ProbeMethodName String pmn,
	                           AnyType[] args
	) {
		BTraceUtils.printArray(args);
		BTraceUtils.println("className: " + pcn);
		BTraceUtils.println("MethodName: " + pmn);
		BTraceUtils.println();
	}
}
