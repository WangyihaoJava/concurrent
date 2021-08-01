package com.example.design.invoke;

import com.example.design.invoke.dynamic.DynamicInvoke;

/**
 * @author wangyihao
 * @ClassName Test
 * @date 2021/6/30 10:02
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Source source = new Source();
        Invoke invoke = new Invoke(source);
        invoke.save();


    }
}
