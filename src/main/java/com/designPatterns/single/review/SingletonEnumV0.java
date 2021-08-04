package com.designPatterns.single.review;

/**
 * SingletonEnum class
 *
 * @author 谢小平
 * @date 2020-11-24
 */
public enum SingletonEnumV0 {
//	SingletonEnumV0()
	;


	private Singleton singleton = new Singleton("name");

	class Singleton{
		private String name;

		public Singleton(String name) {
			this.name = name;
		}
	}

	 SingletonEnumV0(Singleton singleton) {
		this.singleton = singleton;
	}}


