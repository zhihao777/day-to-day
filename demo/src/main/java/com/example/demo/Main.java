package com.example.demo;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.LinkedList;

/**
 * @ClassName Main
 * @Description: TODO
 * @Author zhiHao
 * @Date 2020/9/8
 * @Version V1.0
 **/
public class Main {
	public static void main(String[] args) {

		boolean a = "0".equals(0);
		Integer abc = 0;
		boolean b = abc.equals(0);
		System.out.println(a);
		System.out.println(b);

		
		/*LinkedList<Object> linkedList = new LinkedList<>();
		linkedList.offer();
		int res = 0;
		Integer.toString(777,7);
		while(!linkedList.isEmpty()){
			int size = linkedList.size();
			while (size>0){
				TreeNode node = (TreeNode)linkedList.peek();
				if(node.left!=null){
					linkedList.offer(node.left);
				}
				if(node.right!=null){
					linkedList.offer(node.right);
				}
				size--;
			}
			res++;
		}*/
	}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}