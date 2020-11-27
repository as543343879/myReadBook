package com.designPatterns;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ITest class
 *
 * @author 谢小平
 * @date 2020-11-24
 */
public class ITest {
	public static void main(String[] args) {
		SingletonEnum single = SingletonEnum.single;
		System.out.println(single.getName());
	}

	@Test
	public void classTest() {
		System.out.println(SingletonClass.getSingleton().getName());
	}

	@Test
	public void  damageClassTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		//获得构造器
		Constructor<SingletonClass> con = SingletonClass.class.getDeclaredConstructor(String.class);
		con.setAccessible(true);
		try{
			SingletonClass xxdSingle= con.newInstance("xxd");
			System.out.println(xxdSingle.getName());
		}catch (RuntimeException e) {
			e.printStackTrace();
		}

		System.out.println(SingletonClass.getSingleton().getName());



	}

	@Test
	public void test() {
		System.out.println(Integer.MAX_VALUE);
		System.out.println("100001501");
	}
}
