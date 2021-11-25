package com.example.design.policy;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyihao
 * @ClassName Test
 * @date 2021/6/23 16:56
 * @Description
 */
public class Test {

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        RoleA role = new RoleA("大");
        role.setEat(new EatImpl());
        role.setDrink(new DrinkImpl());
        System.out.println(role.name + "naem========策略模式");

        role.eat();
        role.drink();

    }


}
