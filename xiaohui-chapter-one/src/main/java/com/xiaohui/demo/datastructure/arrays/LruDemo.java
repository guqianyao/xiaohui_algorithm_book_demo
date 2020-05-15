package com.xiaohui.demo.datastructure.arrays;

import java.util.HashMap;

/**
 * <b>功能描述: Lru 缓存淘汰算法</b>
 * @author : guqy
 * <b>创建日期 :</b>
 * @date 2020/5/15 10:56
 * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
 */
public class LruDemo {
    private Node head;
    private Node end;
    //缓存长度
    private int limit;

    private HashMap<String,Node> hashMap;

    //带长度参构造
    public LruDemo(int limit) {
        this.limit = limit;
        this.hashMap = new HashMap<String,Node>();
    }

    /**
     * 刷新被访问节点文职
     */

    private void refreshNode(Node node){
        //直接访问尾端
        if(node == end){
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入
        addNode(node);
    }

    /**
     * 尾部插入节点
     * @param node
     */
    private void addNode(Node node) {
        if(end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        //如果是第一个，头部赋值
        if(head == null){
            head = node;
        }
    }
    /**
     * <b>功能描述: 删除目标节点</b>
     * @author : guqy
     * <b>创建日期 :</b>
     * @date 2020/5/15 10:37
     * @param node
     * @return void
     * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
     */
    private String removeNode(Node node) {
        if(node == end && node == head){
            //移除唯一节点
            head = null;
            end = null;
        }else if (node == end){
            //移除末尾节点
            end = end.pre;
            end.next = null;
        } else if(node == head){
            head = head.next;
            head.pre = null;
        } else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if(node == null){
            return  null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put (String key,String value){
        Node node = hashMap.get(key);
        if(node == null){
            //新插入数据
            if(hashMap.size() >= limit){
                //超过长度，删除非热点数据
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key,value);
            addNode(node);
            hashMap.put(key,node);
        }else {
            //存在的key 刷新keyvalue
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }



    public static void main(String[] args) {
        LruDemo lruDemo = new LruDemo(5);
        lruDemo.put("001","用户1信息001");
        lruDemo.put("002","用户1信息002");
        lruDemo.put("003","用户1信息003");
        lruDemo.put("004","用户1信息004");
        lruDemo.put("005","用户1信息005");
        lruDemo.get("002");
        lruDemo.put("004","用户2信息更新004");
        lruDemo.put("006","用户2信息006");
        System.out.println(lruDemo.get("001"));
        System.out.println(lruDemo.get("006"));
    }

    private class Node{
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node pre;
        public Node next;
        public String key;
        public String value;
    }


}




