package com.xiaohui.demo.datastructure.arrays;

/**
 * <b>功能描述: 数组crud 操作</b>
 * @author : guqy
 * <b>创建日期 :</b>
 * @date 2020/4/29 11:28
 */
public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int initSize) {
        size = 0;
        this.array = new int[initSize];
    }


    public void insert(int element,int index){
        if(index <0 || index > size){
            throw new IndexOutOfBoundsException("超过数组下标");
        }
        //如果十几元素达到数组容量上限，对数组进行扩容
        if(size >= array.length){
            resize();
        }
        /*
         * 移动元素
         * 从插入位置左边向右各自移动一步
         */
        for (int i = size -1 ; i >= index; i--) {
            array[i+1] = array[i];
        }
        //赋值插入数值
        array[index] = element;
        size++;
    }
    //扩容
    private void resize() {
        System.out.println("进行resize");
        int[] arrayNew = new int[array.length *2];
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }


    public void output(){
        for(int i=0; i<size; i++){
           System.out.println(array[i]);
        }
    }


    public int delete(int index){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("数组下标越界");
        }
        int deleteElement = array[index];
        //启始位置是删除元素位置，右边元素全部向左移动一位
        for (int i = index; i < size -1; i++) {
            array[i] = array[i+1];
        }
        size --;
        return  deleteElement;
    }


    public static void main(String[] args) {
        MyArray myArray = new MyArray(4);
        myArray.insert(3,0);
        myArray.insert(31,1);
        myArray.insert(32,2);
        myArray.insert(33,3);
        myArray.insert(34,4);
        myArray.insert(35,5);
        myArray.insert(311,1);
        myArray.output();
        System.out.println("~~~~~~~~~~~~~~~~~分割线~~~~~~~~~~~~~~~~~~~");
        myArray.delete(1);
        myArray.output();
    }
}
