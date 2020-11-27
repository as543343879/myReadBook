package com.designPatterns;

/**
 * SingletonEnumV2 class
 *
 * @author 谢小平
 * @date 2020-11-24
 */
public enum SingletonEnum {
	single("xxp")
	;


	private String name;

	private SingletonEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
