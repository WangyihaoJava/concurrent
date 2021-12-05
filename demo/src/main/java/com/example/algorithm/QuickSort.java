package com.example.algorithm;

/**
 * @author wangyihao
 * @ClassName: QuickSort
 * @Description:
 * @date 2021/7/28 18:27
 *
 */
public class QuickSort {
    public void sort(int[] nums,int start,int end) {//612753
        // 递归停止条件
        if(start>end){
            return;
        }
        int left=start,right=end,key=nums[start];
        int temp=0;
        while(left<right){
            // 这里顺序很重要，要先从右边找。为了避免找过了的情况，还要限制 left<right
            //从右往左找出第一个比key小的数
            while(left<right && nums[right]>=key) {
                right--;
            }
            //从左往右找出第一个比key大的数
            while (left<right && nums[left]<=key) {
                left++;
            }
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
//612357 512367
        //key当前指针指向交换位置 把比key小的放左边 大的放右边
        nums[start] = nums[left];
        nums[left] = key;

        sort(nums,start,left-1);  // 这里对子组求一个递归即可
        sort(nums,left+1,end);
    }




    public void sort1(int[] nums,int start,int end) {

        if (start > end){
            return;
        }
        int tem = 0;
        int left = start;
        int right = end;
        int key = nums[start];
        while (left < right){
            while (left < right && nums[right] >= key){
                right--;
            }

            while (left < right && nums[left] <= key){
                left++;
            }
            tem = nums[left];
            nums[left] = nums[right];
            nums[right] = tem;

        }

        nums[start] = nums[left];
        nums[left] = key;

        sort(nums,start,left-1);
        sort(nums,left+1,end);

    }


    public void sort2(int[] nums,int start,int end) {

        if (start > end){
            return;
        }
        int left = start;
        int right = end;
        int key = nums[start];
        int tem = 0;
        while (left < right){

            while (left < right && nums[right] >= key){
                right--;
            }

            while (left < right && nums[left] <= key){
                left++;
            }

            tem = nums[left];
            nums[left] = nums[right];
            nums[right] = tem;

        }

        nums[start] = nums[left];
        nums[left] = key;

        sort2(nums,start,left-1);
        sort2(nums,left+1,end);


    }





    public static void main(String args[]) throws InterruptedException {

        int a[] = {6,1,2,7,5,3};
        QuickSort q = new QuickSort();
        q.sort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
