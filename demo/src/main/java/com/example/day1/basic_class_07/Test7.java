package com.example.day1.basic_class_07;

public class Test7 {
    public static int getWater4(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int value = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int l = 1;
        int r = height.length - 2;
        while (l <= r) {
            if (leftMax <= rightMax) {
                value += Math.max(0, leftMax - height[l]);
                leftMax = Math.max(leftMax, height[l++]);
            } else {
                value += Math.max(0, rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r--]);
            }
        }
        return value;
    }



}
