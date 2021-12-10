package com.acm.lico.greedy;

/**
 * Solution860 class
 * https://leetcode-cn.com/problems/lemonade-change/
 *860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * @author 谢小平
 * @date 2021/12/6
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
 - 贪心
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution860 {
    int[] prices = new int[2];
    public boolean lemonadeChange(int[] bills) {
//        int i = 0;
        for(int price: bills) {
//            i++;
            if(!checkAndCorrection(price)){
//                System.out.println(i);
                return false;
            }
        }
        return true;
    }
    public boolean checkAndCorrection(int value) {
        int int10 = (value-5) / 10;
        prices[1] = prices[1] - int10 ;
        if(prices[1] < 0) {
            if(prices[0] < 2) {
                return false;
            }
            prices[0] = prices[0] - 2;
            prices[1] = 0;
        }
        int int5 = (value-5) % 10;

        prices[0] = prices[0] - int5 / 5 ;
        if(prices[0] < 0) {
            return false;
        }
        if( value== 5 ) {
            prices[0] ++;
        }
        if(value == 10) {
            prices[1] ++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] bills = {5,5,10,5,20,5,5,5,5,5,20,5,10,5,5,5,5,20,20,5};
        System.out.println(bills.length);
        System.out.println(new Solution860().lemonadeChange(bills));
    }
}
