package com.example;


import java.util.*;

public class Sql {

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        Map<Long,Integer> map = new HashMap<>();
        for (Long l : list){
            map.put(l,map.get(l) == null ? 0 : map.get(l)+1);
        }

        for (Long l : map.keySet()){

        }

    }

}
