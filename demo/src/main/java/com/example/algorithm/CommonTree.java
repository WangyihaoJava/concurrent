package com.example.algorithm;

public class CommonTree {

    /**
     *
     class Solution {
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     TreeNode ancestor = root;
     while (true) {
     if (p.val < ancestor.val && q.val < ancestor.val) {
     ancestor = ancestor.left;
     } else if (p.val > ancestor.val && q.val > ancestor.val) {
     ancestor = ancestor.right;
     } else {
     break;
     }
     }
     return ancestor;
     }
     }
     给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

     例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]












     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

     TreeNode ancestor = root;
     while(true){
     if(p.val > ancestor.val && q.val > ancestor.val){
     ancestor = ancestor.right();
     }else(p.val < ancestor.val && q.val < ancestor){
     ancestor = ancestor.left;
     }else{
     break;
     }

     return ancestor.val;
     }


     }









      

     示例 1:

     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     输出: 6
     解释: 节点 2 和节点 8 的最近公共祖先是 6。
     示例 2:

     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     输出: 2
     解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。

     第二个

     class Solution {
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


     if(root == null || root == p || root == q){
        return root;
     }

     TreeNode l = lowestCommonAncestor(root.left,p,q);
     TreeNode r = lowestCommonAncestor(root.right,p,q);

     return l == null ? r : (r == null ? l : root);



     if (root == null || p == root || q == root) {
     return root;
     }

     TreeNode l = lowestCommonAncestor(root.left, p, q);
     TreeNode r = lowestCommonAncestor(root.right, p, q);

     return l == null ? r : (r == null ? l : root);
     }
     }



     class Solution {

     private TreeNode ans;

     public Solution() {
     this.ans = null;
     }

     private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
     if (root == null) return false;
     boolean lson = dfs(root.left, p, q);
     boolean rson = dfs(root.right, p, q);
     if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
     ans = root;
     }
     return lson || rson || (root.val == p.val || root.val == q.val);
     }

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     this.dfs(root, p, q);
     return this.ans;
     }

     class Solution {
     private boolean flag = true;
     public boolean isBalanced(TreeNode root) {
     if(root == null){
     return true;
     }
     deepLength(root);
     return flag;
     public int deepLength(TreeNode root){
     if(root==null){
     return 0;
     }
     int l = deepLength(root.left);
     int r = deepLength(root.right);
     if(Math.abs(l-r)>1) flag=false;
     return Math.max(l,r)+1;

     }
     }




     */


    public static void main(String[] args) {
        String s = "the sky is blue";
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--; // 搜索首个空格
            }
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') {
                i--; // 跳过单词间空格
            }
            j = i; // j 指向下个单词的尾字符
        }
        System.out.println( res.toString().trim()); // 转化为字符串并返回
    }

















}
