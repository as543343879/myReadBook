package com.acm.lico;

/**
 * Solution988 class
 * 988. 从叶结点开始的最小字符串
 *  给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 *
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 *
 * @author 格林
 * @date 2021-06-20
 */
public class Solution988 {
    private StringBuilder str = new StringBuilder();
    private String minStr = "~";
    public String smallestFromLeaf(TreeNode root) {
        if(root == null)
            return null;
        dfs(root);
        return minStr;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return ;
        }
        str.append((char)(root.val + 'a'));
        if(root.left == null &&  root.right == null ) {
            str.reverse();
            String s = str.toString();
            if(s.compareTo(minStr) < 0) {
                minStr = s;
            }
            str.reverse();
        }
        dfs(root.left);
        dfs(root.right);
        str.deleteCharAt(str.length() - 1);

    }
}
