package com.example.design.invoke;

/**
 * @author wangyihao
 * @ClassName Source
 * @date 2021/6/30 9:59
 * @Description
 */
public class Source implements Service {
    @Override
    public void save() {
        System.out.println("原方法执行");
    }
}
