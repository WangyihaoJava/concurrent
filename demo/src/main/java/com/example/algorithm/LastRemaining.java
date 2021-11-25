package com.example.algorithm;

import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * @author wangyihao
 * @ClassName: LastRemaining
 * @Description:
 * @date 2021/7/29 10:21
 */
public class LastRemaining {

    public static void main(String[] args) {

        int n = 4;
        int m = 2;


        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        System.out.println(f);


        String s ="1";
        HashSet<String> hashSet = new HashSet<>();
        System.out.println(hashSet.add("4"));
        System.out.println(hashSet.add("4"));

        char[] c = s.toCharArray();
        System.out.println(c);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(c[1]);



        System.out.println(f(4,2));

    }

    public static int f(int n, int m){
        /**
         * 0  1
         * 5  2
         * 4  3
         */
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        int i = (m + x) % n;
        return i;

    }

}
