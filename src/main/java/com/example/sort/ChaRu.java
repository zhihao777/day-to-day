package com.example.sort;

/**
 * @ClassName ChaRu
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/7/29
 * @Version V1.0
 **/
public class ChaRu {

    public static void main(String[] args){
        //插入排序
        int[] arr = new int[]{3,3,7,7,12,8,653,1,6,5};
        //遍历未排序的数据，插入已排序的队列中的相应位置
        for(int i =1;i<arr.length;i++){
            int temp = arr[i];
            //向前遍历
            int j = i;
            while(j>0){
                if(arr[j-1] > temp){
                    arr[j] = arr[j-1];
                    j--;
                }else{
                    arr[j] = temp;
                    break;
                }
            }
        }
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
