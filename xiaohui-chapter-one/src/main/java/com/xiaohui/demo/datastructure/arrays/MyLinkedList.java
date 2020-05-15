package com.xiaohui.demo.datastructure.arrays;

/**
 * <b>功能描述:自定义双向链表</b>
 *
 * @author : guqy
 * <b>创建日期 :</b>
 * @date 2020/5/9 16:07
 * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
 */
public class MyLinkedList {
    //头部节点
    private Node head;
    //尾部节点
    private Node last;
    //链表大小
    private int size;
    /**
     * <b>功能描述:</b>
     * @author : guqy
     * <b>创建日期 :</b>
     * @date 2020/5/9 16:09
     * @param data 插入元素
     * @param index 插入位置
     * @return void
     * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
     */
    public void insert(int data,int index) throws Exception {
        if(index <0 || index > size){
            throw new IndexOutOfBoundsException("oversize MyLinkedList size");
        }

        Node insertNode = new Node(data);
        if(size == 0){
            //空链表
            head = insertNode;
            last = insertNode;
        }else if(index == 0){
            //头部插入
            insertNode.next = head;
            head = insertNode;
        }else if (index == size){
            //尾部插入
            last.next = insertNode;
            last = insertNode;
        } else {
            //中间插入
            Node preNode = get(index -1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size ++;
    }

    /**
     * <b>功能描述:</b>
     * @author : guqy
     * <b>创建日期 :</b>
     * @date 2020/5/9 16:13
     * @param index 查找坐标
     * @return com.xiaohui.demo.datastructure.arrays.MyLinkedList.Node
     * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
     */
    public Node get(int index) throws Exception{
        if(index <0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    /**
     * <b>功能描述: 删除链表节点元素</b>
     * @author : guqy
     * <b>创建日期 :</b>
     * @date 2020/5/15 11:29
     * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
     */
    public Node remove(int index) throws Exception{
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点长度");
        }
        Node removeNode = null;
        if(index == 0){
            //删除头部节点
            removeNode = head;
            head = head.next;
        } else if(index == size -1){
            //删除尾部节点
            Node prevNode = get(index -1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            //删除中间节点
            Node prevNode = get(index -1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size --;
        return removeNode;
    }
    //输出链表
    public void output(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    //节点
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3,0);
        myLinkedList.insert(7,1);
        myLinkedList.insert(9,2);
        myLinkedList.insert(5,3);
        myLinkedList.insert(6,1);
        myLinkedList.remove(0);
        myLinkedList.output();
    }
}


