package com.axw;

public class Solution {
    public int solution(int N) {
          String strN = N+"";
          char[] strValue = new char[strN.length() + 1];
          Integer index = null;
          if(strN.charAt(0) == '-') {
                for(int i = 1; i < strN.length(); i ++) {
                    if(strN.charAt(i) >= '5') {
                        index = i ;
                        break;
                    }
                }
                if (index == null) {
                   strN  = strN + '5';
                }
          } else  {
              for(int i = 0; i < strN.length(); i ++) {
                  if(strN.charAt(i) <= '5') {
                      index = i ;
                      break;
                  }
              }
              if (index == null) {
                  strN  =  '5' + strN;
              }
          }
          if(index == null) {
              return Integer.valueOf(strN);
          } else {
              int len = 0;
              for(int i = 0; i < strN.length() ; i ++) {
                  if(i == index) {
                      strValue[i] = '5';
                      len = 1;
                      strValue[i + len] = strN.charAt(i );
                  } else {
                      strValue[i + len] =strN.charAt(i );
                  }
              }

              return Integer.valueOf(String.valueOf(strValue));
          }



    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(666));
        System.out.println(solution.solution(670));
        System.out.println(solution.solution(0));
        System.out.println(solution.solution(-677));
        System.out.println(solution.solution(-270));
        System.out.println(solution.solution(-222));
        System.out.println(solution.solution(-999));
    }
}
