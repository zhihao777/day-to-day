package com.example.sort;

/**
 * @ClassName XuanZe
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/7/29
 * @Version V1.0
 **/
public class XuanZe {

    public static void main(String[] args){
        //选择排序
        int[] arr = new int[]{3,3,7,7,12,8,653,1,6,5};
        //每次遍历寻找最小的，然后与已经排好的末尾下一个元素交换
        for(int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            if(i!=minIndex){
                swap(arr,i,minIndex);
            }
        }
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void swap (int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
