package com.example.sort;

/**
 * @ClassName MaoPao
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/7/29
 * @Version V1.0
 **/
public class MaoPao {

    public static void main(String[] args) {
        // 冒泡
        int [] arr = {1,4,6,3,1,8};
		if(arr == null || arr.length<2){
			//return null;
		}
		for(int i =0;i<arr.length-1;i++){
			for(int j = 0; j<arr.length-1-i;j++){
				//开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i =0;i<arr.length;i++){
			System.out.print(arr[i]);
		}

    }

}
