package com.example.day1.basic_class_07;

import java.util.*;

public class Tets4 {
    public static void main(String[] args) {
        Map<String,String>map = new HashMap<>();
        map.put("1","2");
        map.put("2","3");
        map.values();
        System.out.println();
        int[] test =  {100,4,200,1,3,2};
        int i = longestConsecutive(test);
        System.out.println(i);

        int ii = 234;

        System.out.println(Math.abs(6 - 12));

        System.out.println(53 / 10);
        reverse(53);

    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x = x / 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


    class Solution {
        public void sortColors(int[] nums) {

            int l = 0;
            int r = nums.length - 1;

            int less = l - 1;
            int more = r + 1;
            int p = 1;

            while (l < more){
                if (nums[l] < p){
                    swap(nums,++less,l++);
                }else if (nums[l] > p){
                    swap(nums,--more,l);
                }else {
                    l++;
                }
            }


        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

/*
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preLen = preorder.length;
        int inLen = inorder.length;

        Map<Integer,Integer>map = new HashMap();
        for(int i = 0; i < inLen; i++){
            map.put(inorder[i],i);
        }

        return dfs(preorder,0,preLen - 1,map,0,inLen - 1);

    }

    public TreeNode dfs(int[] preorder,int preLeft,int preRight,Map<Integer,Integer> map,int inLeft,int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }

        //前序遍历的第一个节点就是根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);

        //前序的左边界从0开始依次往后推 直到preLeft > preRight 前序的右边的边界  pIndex - inLeft为根节点的左边的长度
        //中序的左边界从0开始不动 右边界就是当前根节点下标减1
        root.left = dfs(preorder,preLeft + 1,pIndex - inLeft + preLeft,map,inLeft,pIndex - 1);
        //前序的左边界从刨去根的所有左子树加1往右推   右边界就是整体数组长度
        //中序的左边界就是当前根节点下标加1 一直往右推 右边界就是整体数组长度
        root.right = dfs(preorder,pIndex - inLeft + preLeft + 1,preRight,map,pIndex + 1,inRight);
        return root;


    }*/

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

     输入：nums = [100,4,200,1,3,2]
     输出：4
     解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

     输入：nums = [0,3,7,2,5,8,4,6,0,1]
     输出：9
     */


        public static int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }



    class Solution2 {
        public int longestConsecutive(int[] nums) {

            Set<Integer>num_set = new HashSet<>();
            for (int num : nums){
                num_set.add(num);
            }
            int longestNumber = 0;
            for (int num : num_set){
                if (!num_set.contains(num - 1)){
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum + 1)){
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestNumber = Math.max(currentStreak,longestNumber);

                }


            }
            return longestNumber;

        }
    }


    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     *
     * 回文字符串 是正着读和倒过来读一样的字符串。
     *
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     *
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     */
    class Solution1 {
        public int countSubstrings(String s) {
            int n = s.length(), ans = 0;
            for (int i = 0; i < 2 * n - 1; ++i) {
                int l = i / 2, r = i / 2 + i % 2;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    --l;
                    ++r;
                    ++ans;
                }
            }
            return ans;
        }
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     *
     */

    /*public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode pos = head;
            Set<ListNode> visited = new HashSet<ListNode>();
            while (pos != null) {
                if (visited.contains(pos)) {
                    return pos;
                } else {
                    visited.add(pos);
                }
                pos = pos.next;
            }
            return null;
        }
    }*/


    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     *
     * 实现 LRUCache 类：
     *
     *     LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     *     int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     *     void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     *     当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     *
     *
     * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *
     */


    class LRUCache extends LinkedHashMap<Integer, Integer>{
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    /*class LRUCache extends LinkedHashMap<Integer,Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity,0.75F,true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            super.put(key,value);

        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer>eldest){
            return size() > capacity;
        }
    }*/




}
