package com.designPatterns.single.review;

/**
 * SingletonClassV0 class
 *
 * @author 谢小平
 * @date 2020-11-24
 */
public class SingletonClass {
	private static class LazyHolder {
		private static SingletonClass singletonClass = new SingletonClass("xxp");
	}

	private String name;

	private SingletonClass(String name) {
		if(getSingleton() != null) {
			throw new RuntimeException("请通过 getSingleton 方法获取实例");
		}
		this.name = name;
	}
	public static SingletonClass getSingleton() {
		return LazyHolder.singletonClass;
	}

	public String getName() {
		return name;
	}
}
