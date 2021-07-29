package com.example.sort;

/**
 * @ClassName KuaiPai
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/7/29
 * @Version V1.0
 **/
public class KuaiPai {

    public static void main(String[] args) {

        // 快排
        int [] arr = {1,4,6,3,1,8};

        if(arr == null || arr.length<2){
            //return null;
        }
        fastSort(arr,0,arr.length-1);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
    static void fastSort(int[] nums,int l,int r){
        if(l<r){
            int mid = handle(nums, l, r);
            fastSort(nums, l, mid-1);
            fastSort(nums, mid+1, r);
        }
    }
    static int handle(int[] nums,int l,int r){
        int i = l;
        int point = nums[l];
        while (l<r){
            while (l<r && nums[r]>=point){
                r--;
            }
            while (l<r && nums[l]<=point){
                l++;
            }
            swap(nums,l,r);
        }
        //交换最左基数至正确位置
        swap(nums,i,r);
        return l;
    }
    static void swap (int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
