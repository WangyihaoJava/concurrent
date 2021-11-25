package com.example.algorithm;

import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSum {

    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     *
     *  
     *
     * 示例:
     * 给定如下二叉树，以及目标和 target = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     *
     * class Solution {
     *     List<List<Integer>> ret = new LinkedList<List<Integer>>();
     *     Deque<Integer> path = new LinkedList<Integer>();
     *
     *     public List<List<Integer>> pathSum(TreeNode root, int target) {
     *         dfs(root, target);
     *         return ret;
     *     }
     *
     *     public void dfs(TreeNode root, int target) {
     *         if (root == null) {
     *             return;
     *         }
     *         path.offerLast(root.val);
     *         target -= root.val;
     *         if (root.left == null && root.right == null && target == 0) {
     *             ret.add(new LinkedList<Integer>(path));
     *         }
     *         dfs(root.left, target);
     *         dfs(root.right, target);
     *         path.pollLast();
     *     }
     * }
     *
     */


    public static void main(String[] args) {

        int i = 10;

        System.out.println(i -= 2);
        Deque<Integer> path = new LinkedList<Integer>();

        path.pollLast();


    }

    /*public List<List<Integer>> pathSum(TreeNode root, int target) {
            dfs(root, target);
            return ret;
        }

              public void dfs(TreeNode root, int target) {
            if (root == null) {
                return;
            }
            path.offerLast(root.val);
            target -= root.val;
            if (root.left == null && root.right == null && target == 0) {
                ret.add(new LinkedList<Integer>(path));
            }
            dfs(root.left, target);
            dfs(root.right, target);
            path.pollLast();
        }*/
}
