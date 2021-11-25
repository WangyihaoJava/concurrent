package com.example.design.policy;

/**
 * @author wangyihao
 * @ClassName Role
 * @date 2021/6/23 16:53
 * @Description
 */
public class Role {

    protected String name;

    protected Eat eat;
    protected Drink drink;

    public void setEat(Eat eat) {
        this.eat = eat;

    }

    public void setDrink(Drink drink) {
        this.drink = drink;

    }

    protected void eat(){
        eat.eat();
    }

    protected void drink(){
        drink.drink();
    }

}
