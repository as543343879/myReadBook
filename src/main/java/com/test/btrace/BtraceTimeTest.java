package com.test.btrace;

import com.sun.btrace.AnyType;
import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * @date 2020-09-22
 */
@BTrace
public class BtraceTimeTest {
	@TLS private static long startTime = 0;

	@OnMethod(
			clazz="com.wp.ecs.controller.login.DjgLoginRelatedController",
			method="codeLogin",location = @Location(Kind.ENTRY)
	)
	public static void start() {
		startTime = timeMillis();
	}


	@OnMethod(
			clazz = "com.wp.ecs.controller.login.DjgLoginRelatedController",
			method = "codeLogin",
			location = @Location(Kind.RETURN)
	)
	public static void end(@ProbeClassName String pcn,
	                           @ProbeMethodName String pmn,
	                           AnyType[] args
	) {
		long timecost = timeMillis() - startTime;
		println(Strings.strcat("time taken : ",str(timecost)));
		printArray(args);
		println("className: " + pcn);
		println("MethodName: " + pmn);
	}
}
