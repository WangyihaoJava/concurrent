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


        System.out.println(strToInt(string));

    }


        public static int strToInt(String str) {
            //去前后空格
            char[] chars = str.trim().toCharArray();
            if (chars.length == 0) return 0;
            //记录第一个符合是否为负数
            int sign = 1;
            //开始遍历的位置
            int i = 1;
            //如果首个非空格字符为负号，那么从位置1开始遍历字符串，并且结果需要变成负数
            if (chars[0] == '-') {
                sign = -1;
            } else if (chars[0] != '+') { //如果首个非空格字符不是负号也不是加号，那么从第一个元素开始遍历
                i = 0;
            }
            int number = Integer.MAX_VALUE / 10;
            //结果
            int res = 0;
            for (int j = i; j < chars.length; j++) {
                //遇到非数字直接退出
                if (chars[j] > '9' || chars[j] < '0') break;
                /*
                    这里这个条件的意思为，因为题目要求不能超过int范围，所以需要判断结果是否越界
                    因为res每次都会 * 10 ，所以外面定义了一个int最大值除以10的数字
                    此时只需要保证本次循环的res * 10 + chars[j] 不超过 int 即可保证不越界
                    res > number 意思是，此时res已经大于number了，他 * 10 一定越界
                    res == number && chars[j] > '7' 的意思是，当res == number时，即：214748364
                    此时res * 10 变成 2147483640 此时没越界，但是还需要 + chars[j]，
                    而int最大值为 2147483647，所以当chars[j] > 7 时会越界
                 */
                if (res > number || (res == number && chars[j] > '7')) {
                    //根据字符串首负号判断返回最大值还是最小值
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                //字符获取数字需要 - '0' 的位移
                res = res * 10 + (chars[j] - '0');
            }
            //返回结果，需要判断正负
            return res * sign;
        }


}
