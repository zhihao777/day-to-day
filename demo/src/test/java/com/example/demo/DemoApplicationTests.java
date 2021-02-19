package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Stack;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void contextLoads() {
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < 10; i++) {
            Node tmp = new Node(i);
            cur.next = tmp;
            cur = tmp;
        }

        Node reverse = reverse(head);

    }
    public Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverseList(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static class Node{
        public int value;
        public Node next;
        public Node (int date){
            this.value = date;
        }
    }


    @Test
    public void myNodeR(){
        //生成一个长度为10的单向链表
        Node node = new Node(0);
        //与cur = temp配合，循环添加新节点后，移动指针至最后一个节点；
        //联想java的地址传递，理解指针的实现。
        //之所以会再声明一个cur，是因为让node始终作为头节点可直接使用，
        //否则，到最后cur会身处倒数第二个节点。
        Node cur = node;
        for(int i = 1;i<10;i++){
            Node temp = new Node(i);
            cur.next = temp;
            cur = temp;
        }
        //反转链表 1.递归。2.遍历。3.栈
        Node node1 = R2(node);
    }

    public Node R1(Node node){
        if(null == node || node.next == null){
            return node;
        }
        Node returnNode = R1(node.next);
        node.next.next = node;
        node.next = null;
        return returnNode;
    }

    public Node R2(Node node){
        //前一节点
        Node pre = null;
        //下一节点，缓存起来
        Node next = null;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public Node R3(Node node){
        Stack stack = new Stack();
        while(node!=null){
            stack.push(node.value);
            node = node.next;
        }
        int value = (int)stack.pop();
        Node reNode = new Node(value);
        Node cur = reNode;
        while(!stack.empty()){
            int value2 = (int)stack.pop();
            Node node1 = new Node(value2);
            cur.next = node1;
            cur = cur.next;
        }
        return reNode;
    }

}
