package com.example.design.invoke;

/**
 * @author wangyihao
 * @ClassName Invoke
 * @date 2021/6/30 10:00
 * @Description
 */
public class Invoke implements Service {

    private Service service;

    public Invoke(Service service) {
        this.service = service;
    }

    @Override
    public void save() {
        service.save();
        System.out.println("增强的方法");
    }
}
