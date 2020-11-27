package com.jdk8;

import java.io.File;

/**
 * FileTest class
 *
 * @author 谢小平
 * @date 2020-11-23
 */
public class FileTest {
	public static void main(String[] args) {
		File file = new File("G:\\test\\专业");
		change(file);

	}

	public static void change(File file) {
		if(file.isFile()) {
			System.out.println(file.getAbsolutePath());
			return;
		} else if(file.isDirectory()) {
			File[] files = file.listFiles();
			if(files.length > 0) {
				for(File i : files) {
					change(i);
				}
			} else {
				return ;
			}
		} else {
			return ;
		}

	}


}
