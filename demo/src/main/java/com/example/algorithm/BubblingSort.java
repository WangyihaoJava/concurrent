package com.example.algorithm;

public class BubblingSort {
    public static void main(String[] args) {
        int []target = {3,5,2,7,1,9};

        for (int i = 0; i < target.length; i++){
            for (int j = 0; j < target.length; j++){
                if (target[i] > target[j]){
                    int temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;
                }
            }
        }

        for (int i = 0; i < target.length; i++){
            System.out.println(target[i]);
        }

    }
}
