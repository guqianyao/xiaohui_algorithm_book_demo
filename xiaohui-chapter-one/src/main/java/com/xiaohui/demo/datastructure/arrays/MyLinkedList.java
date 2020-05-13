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
    public void insert(int data,int index){
        if(index <0 || index > size){
            throw new IndexOutOfBoundsException("oversize MyLinkedList size");
        }

        Node insertNode = new Node(data);
        if(size == 0){
            head = insertNode;
            last = insertNode;
        }else if(index == 0){
            insertNode.next = head;
            head = insertNode;
        }else if (index == size){
            last.next = insertNode;
            last = insertNode;
        } else {
        }
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
    public Node get(int index){
        if(index <0 || index > size){
            throw new IndexOutOfBoundsException("");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }



    //节点
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
}


