package com.offer.mayi;

/**
 * StrTest class
 *
 * @author 格林
 * @date 2023-11-01
 */
public class StrTest {
    public static void main(String[] args) {
        System.out.println(new StrTest().getCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(new StrTest().getCommonPrefix(new String[] {"dog","racecar","car"}));
    }
    public String getCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < strs[0].length(); i ++ ) {
            char temp = strs[0].charAt(i);
            boolean tempBoolean = true;
            for(int j =  1; j < strs.length; j ++ ) {
                if(  strs[j].length() <= i ||  strs[j].charAt(i) != temp ) {
                    tempBoolean = false;
                    break;
                }
            }
            if(tempBoolean) {
                stringBuilder.append(temp);
            } else {
                break;
            }

        }
        return stringBuilder.toString();

    }
}
