package com.example.algorithm;

import java.util.HashSet;
import java.util.Set;

public class StringTransferNumber {

    public static void main(String[] args) {

        Set<Integer>set = new HashSet<>();


        System.out.println(5 / 2);

        /**
         * （1）一个字符串 1234,如何转换为数字1234.
         *
         * （2）假如是不固定位数的一个字符串如何转换为数字
         */

        String string = "12345";
        char[] chars = string.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            /**
             * pow表示10的多少次幂
             */
            int pow = (int) Math.pow(10, chars.length - i - 1);
            /**
             * 为啥-48，其实是为了转换为数字。
             * 字符’0’的ascii码是48
             * 数字0的值是0
             * 所以’0’和0差48
             * 以此类推
             * 一个字符转换对应的值，就要减去48。
             */
            int aChar =  chars[i] - 48;
            sum = sum + (aChar * pow);
        }

        System.out.println(sum);
    }

}
