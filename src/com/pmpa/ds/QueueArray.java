package com.pmpa.ds;
import  java.lang.Exception;
import java.util.Arrays;

/**
 * Created by jay on 2018/4/24.
 * 基于数组实现的简单队列数据结构。FIFO 先入先出数据结构
 *
 * 实现方法：
 * void ENQUEUE(x)   将x元素入队
 * int DEQUEUE()    出队
 */
public class QueueArray {
    private int[] data;    //数据存储
    private int size;      //队列大小
    private int head;      //队列头指针   head指针指向头节点。
    private int tail;      //队列尾指针   tail指针指向尾节点。《书中》将尾指针指向尾部节点的下一个节点。

    //初始化一个空的队列，head和tail指针都指向开始的0，建一个长度为x的空数组。
    public QueueArray(int x) throws Exception
    {
        if(x<=0) {
            throw new Exception("bigger than 0!");
        }
        else {
            data = new int[x];
            size = 0;
            head = 0;
            tail = -1;
        }
    }

    public void enqueue(int x){
        //数组溢出，需要扩展数组。 头尾指针相同时，是空队列。
        if(data.length == size){
            int[] data_incre = new int[size*2];
            for(int j=0;j<size;j++)
            {
                int data_index = (head+j>=size)?((head + j) - size):(head + j);
                //重新构造一个数组，头指针指向0，尾指针指向最后一个节点
                data_incre[j] = data[data_index];
            }
            head = 0 ;
            tail = size - 1;
            data = data_incre;
        }
        if (tail == data.length - 1){
            tail = 0;
        }
        else{
            tail++;
        }
        data[tail] = x;
        size++;
        System.out.println(Arrays.toString(data));
    }

    public int dequeue() throws Exception{
        int dequeue = 0 ;
        if(size == 0)
        {
            throw new Exception("The queue is empty!!");
        }
        else{
            dequeue = data[head];
            data[head] = 0 ;
            head = (head == data.length-1)?0:head+1;
        }
        size --;
        System.out.println(Arrays.toString(data));
        return dequeue;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(head == tail)
        {sb.append("");}
        else if(head < tail)
        {
            for(int j =head ; j< tail+1;j++)
            {sb.append(data[j]);
            sb.append(",");}
        }
        else{
            for(int j =head ; j< data.length;j++)
            {sb.append(data[j]);
                sb.append(",");}
            for (int j=0;j<=tail;j++)
            {
                sb.append(data[j]);
                sb.append(",");
            }
        }
        return sb.toString();
    }


    public static void main (String[] args) throws Exception{
        QueueArray qa = new QueueArray(5);
        qa.enqueue(4);
        qa.enqueue(3);
        qa.enqueue(5);
        qa.enqueue(8);
        qa.dequeue();
        qa.dequeue();
        qa.dequeue();
        qa.enqueue(7);
        qa.enqueue(1);
        System.out.println(qa);
        System.out.println(Arrays.toString(qa.data));
    }

}
