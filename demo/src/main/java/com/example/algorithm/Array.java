package com.example.algorithm;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        /**
         * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
         *
         * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
         *
         * 输入：target = 9
         * 输出：[[2,3,4],[4,5]]
         * 示例 2：
         *
         * 输入：target = 15
         * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
         *
         *
         */
        int target = 9;

        System.out.println(target++ == 9);


        /*int[][] res = new int[10][10];

        int a = 0;
        int limit = target / 2;
        System.out.println(1 / 2);*/

        /*for (int i = 1; i <= limit; i++){
            for (int j = i; j <= limit; j++){
                System.out.println("-----");
            }
        }*/

        /*List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int i = 1; i <= limit; ++i) {
            for (int j = i;; ++j) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        System.out.println( vec.toArray(new int[vec.size()][]));*/

        /**
         *
         class Solution {
         public int[][] findContinuousSequence(int target) {
         List<int[]> vec = new ArrayList<int[]>();
         int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
         for (int i = 1; i <= limit; ++i) {
         for (int j = i;; ++j) {
         sum += j;
         if (sum > target) {
         sum = 0;
         break;
         } else if (sum == target) {
         int[] res = new int[j - i + 1];
         for (int k = i; k <= j; ++k) {
         res[k - i] = k;
         }
         vec.add(res);
         sum = 0;
         break;
         }
         }
         }
         return vec.toArray(new int[vec.size()][]);
         }
         }
         */

        /**
         * 要求是输出所有和为 target 的连续正整数序列（至少含有两个数）所以思路可以从1 - target 依次递增循环相加
         * 比如 1 2 3 4 第一次就是 1 + 2 + 3 + 4 第二次就是 2 + 3 + 4 第三次就是 3 + 4
         * 这样的循环 在循环的过程中只要有相加的结果等于target说明刚刚循环的数就是我们要找的 通过 i初始指针 j末尾指针来遍历我们需要的数字将其放进数组 数组的长度就是当前的尾指针减去头指针加一
         * 最后加入到list
         */

        /*List<int[]>res = new ArrayList<>();
        int sum = 0;
        int limit = (target - 1) / 2;
        for (int i = 1; i <= limit; i++){
            for (int j = i;; j++){
                sum += j;

                if (sum == target){
                    int[]tem = new int[j - i + 1];
                    for (int k = i; k <= j; k++){
                        tem[k - i] = k;
                    }
                    res.add(tem);
                    sum = 0;
                    break;
                }else if (sum > target){
                    sum = 0;
                    break;
                }
            }
        }

        return res.toArray(new int[res.size()][]);*/


        /**
         *  public Node copyRandomList(Node head) {
         *         Node cur = head;
         *         Node dum = new Node(0), pre = dum;
         *         while(cur != null) {
         *             Node node = new Node(cur.val); // 复制节点 cur
         *             pre.next = node;               // 新链表的 前驱节点 -> 当前节点
         *             // pre.random = "???";         // 新链表的 「 前驱节点 -> 当前节点 」 无法确定
         *             cur = cur.next;                // 遍历下一节点
         *             pre = node;                    // 保存当前新节点
         *         }
         *         return dum.next;
         *     }
         *
         *
         *     public Node copyRandomList(Node head) {
         *         if(head == null) return null;
         *         Node cur = head;
         *         Map<Node, Node> map = new HashMap<>();
         *         // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
         *         while(cur != null) {
         *             map.put(cur, new Node(cur.val));
         *             cur = cur.next;
         *         }
         *         cur = head;
         *         // 4. 构建新链表的 next 和 random 指向
         *         while(cur != null) {
         *             map.get(cur).next = map.get(cur.next);
         *             map.get(cur).random = map.get(cur.random);
         *             cur = cur.next;
         *         }
         *         // 5. 返回新链表的头节点
         *         return map.get(head);
         *     }
         *
         *
         */



    }
}
