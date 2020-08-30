package com.acm.lico;

/**
 * Solution_459 class
 *
 * @author 谢小平
 * @date 2020-08-24
 */
public class Solution_459 {
	public boolean repeatedSubstringPattern(String s) {
		char first = s.charAt(0);
		int len = s.length();
		if(s.trim().length() == 1) {
			return false;
		}
		String child ;
		for(int i = len-1; i >= len / 2 ; i -- ) {
				if(s.charAt(i) == first) {
					child = s.substring(i,len);
					if(child.equals(s.substring(0,child.length()))) {
						String value = s.replaceAll(child,"");
						if(value.length() == 0){
							return true;
						}
					}
				}
		}
		return false;
	}
	public static void main(String[] args) {
		Solution_459 solution_459 = new Solution_459();
		boolean aba = solution_459.repeatedSubstringPattern("\"a\"");
		System.out.println(aba);
	}
}
