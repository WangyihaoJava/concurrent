package com.example.algorithm;

public class Arrays {

    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
     * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     *
     * 示例:
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     *
     * 提示：
     * 所有元素乘积之和不会溢出 32 位整数
     * a.length <= 100000
     *
     *  public int[] constructArr(int[] a) {
     *         int len = a.length;
     *         if(len == 0) return new int[0];
     *         int[] b = new int[len];
     *         b[0] = 1;
     *         int tmp = 1;
     *         for(int i = 1; i < len; i++) {
     *             b[i] = b[i - 1] * a[i - 1];
     *         }
     *         for(int i = len - 2; i >= 0; i--) {
     *             tmp *= a[i + 1];
     *             b[i] *= tmp;
     *         }
     *         return b;
     *     }
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {

       int[]a = {1,2,3,4,5};
        int len = a.length;
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
       /*int[]res = new int[ii.length];
       int flag = 0;
       for (int i = 0; i < ii.length; i++){
           for (int j = 0; j < ii.length; j++){
               if (j != i){
                   flag = flag * ii[j];
               }
           }
           res[i] = flag;
           flag = 0;

       }
*/
        System.out.println(b);
    }

}
