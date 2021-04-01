package com.example.concurrent;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyihao
 * @ClassName demo01
 * @date 2020/12/11 15:53
 * @Description
 */
public class demo01 {

    @Test
    public void test1(){

        System.out.println("测试接口");



    }


    public static void main(String[] args) {

        int test = test();

        System.out.println(test);
        /*System.out.println("number"+test.size());*/
    }


    private static int test() {

        List<String> test = new ArrayList<>();

        Map<String,Object>map = new HashMap<>();
        map.put("1","1");

        try {
            test.add("11");

            System.out.println("try"+test);
            return test.size();

        } catch (Exception e) {

            System.out.println("catch"+test);

        } finally {

            System.out.println("finally"+test);
            test.add("22");
        }

        return test.size();
    }

}
