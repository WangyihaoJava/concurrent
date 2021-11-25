package com.example.concurrent.exception;

/**
 * @author wangyihao
 * @ClassName Person
 * @date 2020/12/18 14:52
 * @Description
 */
public class Person {

    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
