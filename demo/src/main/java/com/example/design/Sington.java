package com.example.design;

import java.util.ArrayList;
import java.util.List;

public class Sington {

    private volatile List<String> list;

    private Sington(List<String> list) {
    }

    public List<String> getList(){
        if (list == null){
            synchronized (this){
                if (list == null){
                    list = new ArrayList<>();
                }
            }
        }
        return this.list;
    }

}
