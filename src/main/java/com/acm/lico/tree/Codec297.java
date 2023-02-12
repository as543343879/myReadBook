package com.acm.lico.tree; /**
297 ,二叉树的序列化与反序列化
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1024 👎 0

**/
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
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询

 官网思路： 两个方法复杂度一样
     时间复杂度 O(N)
     空间复杂度  O(N) 栈的元素个数
 2 定位问题
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
     序列化：
        通过 广度遍历来 做层次遍历，为null 的记录 字符串null。
     反序列化：
         通过 层次遍历 恢复 树。
         问题：null的节点，左右节点也要补充完整，不然有问题， 会耗费内存。


 官网思路：
     序列化：
         通过先序遍历，序列号节点
     反序列化：
        通过先序遍历的结果，依次填充。


 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果

 官网思路：
 解答成功:
 执行耗时:14 ms,击败了63.15% 的Java用户
 内存消耗:44 MB,击败了29.81% 的Java用户
 */
public class Codec297 {

    // Encodes a tree to a single string.
//    public String serialize3(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        StringBuilder res = new StringBuilder();
//        queue.offer(root);
//        res.append(String.valueOf(root.val));
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i ++) {
//                TreeNode node = queue.remove(i);
//                if(node == null) {
//                }
//            }
//        }
//        return null;
//    }

    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        doSerialize(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void doSerialize(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append("null,");
        } else {
            str.append( root.val + ",");
            doSerialize(root.left, str);
            doSerialize(root.right, str);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        TreeNode treeNode = doDeserialize(list);
        return treeNode;
    }
    private TreeNode doDeserialize( List<String> list ) {
        if("null".equals(list.get(0)) ) {
            list.remove(0);
            return  null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            node.left = doDeserialize(list);
            node.right = doDeserialize(list);
            return node;
        }
    }



    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode4.left = treeNode5;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;

//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode3.left = treeNode4;
//        treeNode3.right = treeNode5;
//        treeNode5.right = treeNode6;

        String s = new Solution297().serialize3(treeNode1);
        System.out.println(s);
        s = new Solution297().serialize2(treeNode1);
        System.out.println(s);

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
