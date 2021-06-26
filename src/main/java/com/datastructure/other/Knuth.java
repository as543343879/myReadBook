package com.datastructure.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//import javax.annotation.concurrent.NotThreadSafe;

/**
 * Knuth class
 *
 * @date 2020-11-18
 */
//@NotThreadSafe
public class Knuth {


	public static <T> List<T> knuth(List<T> dest, int toEvict ) {
		if(dest == null  || dest.size() == 0) {
			return null;
		}
		toEvict = Math.min(dest.size(), toEvict);
		Random random = new Random(System.currentTimeMillis());
		for(int i = 0; i < toEvict; i ++) {
			int next = random.nextInt(dest.size() - i);
			Collections.swap(dest,i,next);
//			T t = dest.get(i);
			dest.remove(i);
		}
		return dest;
	}


	@Test
	public void testKnuth() {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i ++ ) {
			list.add(i);
		}
		list = Collections.synchronizedList(list);
		list = knuth(list, 5);
		list.forEach((e)->{ System.out.print( " " + e); });
	}
}
