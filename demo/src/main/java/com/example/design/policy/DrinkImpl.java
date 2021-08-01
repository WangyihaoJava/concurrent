package com.example.design.policy;

/**
 * @author wangyihao
 * @ClassName DrinkImpl
 * @date 2021/6/23 16:52
 * @Description
 */
public class DrinkImpl implements Drink {
    @Override
    public void drink() {
        System.out.println("喝牛奶");
    }
}
