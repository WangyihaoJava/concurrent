package com.example.demo;


/**
 * @author wangyihao
 * @ClassName Test
 * @date 2021/6/18 14:37
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        int[]ints = {1,4,5,7};
        int target = 2;
        int index = getIndexByNumber(ints,target);
        System.out.println(index);
    }

    private static int getIndexByNumber(int[] ints,int target) {
        int index = 0;
        for (int i : ints){
            if (i == target){
                return index;
            }
            index ++;
        }

        int[]newInts = new int[ints.length + 1];
        for (int j = 0; j < ints.length; j++){
            newInts[j] = ints[j];
        }
        newInts[ints.length] = target;

        for (int i = 0; i < newInts.length; i++){
            for (int j = 0; j < newInts.length; j++ ){
                if (newInts[j] < newInts[i]){
                    int tem = newInts[i];
                    newInts[i] = newInts[j];
                    newInts[j] = tem;
                }

            }
        }

        for (int i = 0; i < ints.length; i++){
            if (ints[i] < target && ints[i + 1] > target){
                index = i + 1;
            }
        }

        return index;

    }


}
