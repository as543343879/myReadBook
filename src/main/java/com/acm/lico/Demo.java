package com.acm.lico;

public class Demo {
    public static void main(String[] args) {

        System.out.println(helper("12345689", "789"));
        System.out.println(helper("13", "25"));
        System.out.println(helper("33", "22"));
    }
 
    public static String helper(String num1, String num2) {

        while(num1.length() < num2.length()) {
            num1 = "0" + num1;     //预处理成等长字符串
        }
        while(num2.length() < num1.length()) {
            num2 = "0" + num2;     //预处理成等长字符串
        }
        StringBuilder r = new StringBuilder();
        StringBuilder pre =  new StringBuilder();;
        if(num1.compareTo(num2) < 0) {
            pre = pre.append("-");
            String t = num1;
            num1 = num2;
            num2 =  t;
        }
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);       //反过来0下标对应个位

        int flag =0;                                             //用flag标记借位
        for(int i = s1.length()-1; i >= 0; --i) {
            int sum = f(s1.charAt(i)) - flag  - f(s2.charAt(i));
            flag = 0;
            r.append((sum+10)%10);
            if (sum < 0){
                flag = 1;
            }
        }
        String str =  r.reverse().toString();
        int len = str.length();
        int index = 0;
        while( index < len && str.charAt(index) == '0' ) {
            index++;
        }
        if (index == len) {
            return "0";
        }else {
            return pre.append( str.substring(index, len)).toString();
        }
    }
    public static int f(char c) { return c - '0';}     //字符变数字
}

