package com.example.algorithm;

public class qunaerwang {
    public static void main(String[] args) {
        int[]ints = {5,4,-1,-2,10,11};
       /* int length = ints.length;
        int max = 0, tempMax = 0, tMax = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                int ttMax = tMax + ints[j];
                tMax = Math.max(tMax, ttMax);
                tempMax = Math.max(tempMax, tMax);
            }
            max = Math.max(max, tempMax);
        }


        System.out.println(tempMax);*/
        int greatestSumOfSubArray = findGreatestSumOfSubArray(ints);
        System.out.println(greatestSumOfSubArray);

    }

    public static int findGreatestSumOfSubArray(int[] arr) {
        // 参数校验
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Array must contain an element");
        }
        // 记录最大的子数组和，开始时是最小的整数
        int max = Integer.MIN_VALUE;
        // 当前的和
        int curMax = 0;
        // 数组遍历 冒泡
        for (int i : arr) {
            // 如果当前和小于等于0，就重新设置当前和
            if (curMax <= 0) {
                curMax = i;
            }
            // 如果当前和大于0，累加当前和
            else {
                curMax += i;
            }
            // 更新记录到的最在的子数组和
            if (max < curMax) {
                max = curMax;
            }
        }
        return max;
    }
}
