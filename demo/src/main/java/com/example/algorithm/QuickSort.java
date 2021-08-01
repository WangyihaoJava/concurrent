package com.example.algorithm;

/**
 * @author wangyihao
 * @ClassName: QuickSort
 * @Description:
 * @date 2021/7/28 18:27
 */
public class QuickSort {
    public void sort(int[] nums,int start,int end) {
        // 递归停止条件
        if(start>end) return;
        int left=start,right=end,key=nums[start];
        int temp=0;
        while(left<right){
            // 这里顺序很重要，要先从右边找。为了避免找过了的情况，还要限制 left<right
            while(left<right && nums[right]>=key)
                right--;
            while (left<right && nums[left]<=key)
                left++;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        nums[start] = nums[left];
        nums[left] = key;

        sort(nums,start,left-1);  // 这里对子组求一个递归即可
        sort(nums,left+1,end);
    }

    public static void main(String args[]){
        int a[] = {6,1,2,7,9,3,4,5,10,8};
        QuickSort q = new QuickSort();
        q.sort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
