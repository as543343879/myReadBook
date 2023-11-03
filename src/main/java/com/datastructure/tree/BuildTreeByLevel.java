package com.datastructure.tree;

/**
 * BuildTreeByLevel class
 *
 * @author 格林
 * @date 2023-03-20
 *         其中，我们使用-1来表示某个节点为空。在创建节点时，我们使用了一个 TreeNode 类来存储节点信息。在队列中使用节点的目的是为了方便查找其父节点，并给其添加子节点。最终得到的就是一棵二叉树。
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

 对于一棵二叉树的层次遍历序列，可以通过以下方法建立二叉树：

 1. 创建一个空根节点，将序列的第一个元素作为根节点的值。
 2. 创建一个空队列。
 3. 将根节点加入队列。
 4. 从序列的第二个元素开始遍历，每次从队列中取出队头节点。
 5. 将当前遍历到的元素作为该节点的左儿子。如果该元素为非空，则将左儿子加入队列。
 6. 然后再从序列中取下一个元素作为该节点的右儿子。如果该元素为非空，则将右儿子加入队列。
 7. 重复步骤4-6，直到遍历完整个序列。

 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */



public class BuildTreeByLevel {
    public TreeNode root;

    // 层次遍历序列构建二叉树
    public TreeNode buildTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        root = new TreeNode(array[0]);
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            TreeNode cur = queue.poll();
            if (array[i] != -1) {
                cur.left = new TreeNode(array[i]);
                queue.offer(cur.left);
            }
            i++;
            if (i < array.length && array[i] != -1) {
                cur.right = new TreeNode(array[i]);
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    // 二叉树节点类
     static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void  trace(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while ( !stack.isEmpty() || node != null) {
            while (node != null) {
                System.out.print(" " + node.val);
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()) {
               node = stack.pop().right;
            }
        }

        System.out.println(" " );

    }
    public static void main(String[] args) {
        int[] res = new int[] {1,2,3,4,5,6,7,9};
        TreeNode treeNode = new BuildTreeByLevel().buildTree(res);
        trace(treeNode);

         treeNode = new BuildTreeByLevel().CreateTree(res);
        trace(treeNode);
    }
    private int  size = 0;
    public TreeNode CreateTree(int[] c) {
        int var = size < c.length ? c[size++] : -1;
        if (var == -1) {
            return null;
        }
        //创建根节点
        TreeNode node = new TreeNode(var);
        //构造左子树
        node.left = CreateTree(c);
        //构造右子树
        node.right = CreateTree(c);
        //返回根节点
        return node;
    }

}

