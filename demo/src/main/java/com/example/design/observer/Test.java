package com.example.design.observer;

/**
 * @author wangyihao
 * @ClassName Test
 * @date 2021/6/23 18:19
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        DSubject dSubject = new DSubject();

        ObserverOne observerOne = new ObserverOne(dSubject);
        ObserverTwo observerTwo = new ObserverTwo(dSubject);

        dSubject.setMsg("11111111");
        /*observerTwo.update("22222222222");*/


    }

}
