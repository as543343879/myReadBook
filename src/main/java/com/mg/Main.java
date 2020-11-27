package com.mg;

import java.io.Serializable;

/**
 * Main class
 * 职责（单一职责原则）
 * 继承类 合成/聚合复用原则
 * 实现接口 接口隔离原则
 * 类权限 开闭原则
 * @date 2020-11-23
 */
public class Main extends Object implements Serializable {
	// 字段 或者方法参数  是否需要 迪米特法则
	Integer fied; // 考虑 依赖倒置原则，里氏替换原则
}



