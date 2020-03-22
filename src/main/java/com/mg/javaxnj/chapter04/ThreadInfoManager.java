package com.mg.javaxnj.chapter04;

import java.util.Map;

public class ThreadInfoManager {
	public static void showAllThreadInfo(){
		for(Map.Entry<Thread, StackTraceElement[]> stackTrace:
                        Thread.getAllStackTraces().entrySet()){
			Thread thread=stackTrace.getKey();
			StackTraceElement[] stack=stackTrace.getValue();
			if(thread.equals(Thread.currentThread())){
				continue;
			}
			System.out.println("\nThreadName:\t"+thread.getName());
			for(StackTraceElement element:stack){
				System.out.println("\tElement:\t"+element);
			}
			
		}

		
	}
	public static void main(String[] args) {
		showAllThreadInfo();
	}
}