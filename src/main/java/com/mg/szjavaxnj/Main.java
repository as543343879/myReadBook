package com.mg.szjavaxnj;

/**
 * Main class

 */
public class Main {
	private int m = 2;
	private static volatile String   istr = "istrValue";
	protected static volatile String   istr2 = "istrValue2";
	private final String finalX = "finalXValue";
	public static void main(String[] args) {
	    istr = "21312";
	    istr2 = "12312";
	}
}
