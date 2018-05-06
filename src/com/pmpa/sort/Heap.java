package com.pmpa.sort;
import java.util.Arrays;

/**
 * Created by jay on 2018/4/19 ~  2018/4/22.
 * 2018/4/19: 堆节点最大化
 * 2018/4/20: 构建最大堆
 * 2018/4/21: 堆排序
 * 2018/4/22: 优先队列
 *
 * 堆的概念：
 * 堆：堆是一个数组，可以被看成是一个近似的完全二叉树。
 *     表示堆的数组包含2个属性，一个是数组的长度，a.length ； 一个表示有多少个堆元素存储在这个数组中，a.heap_size。
 * 优先队列：是一种用来维护一组元素构成的集合S的数据结构。其中的每个元素都有一个相关值，称为关键字(Key)。
 *      操作：
 *      INSERT(S,x) ： 将x插入集合。
 *      MAXIMUM(S)：返回S中最大关键字的元素。
 *      EXTRACT-MAX(S): 返回并删除S中最大关键字的元素。
 *      INCREASE-KEY(S,x,key)： 将元素x的关键字增加到key，假设key大于原来x的关键字。
 *
 */
public class Heap {
    //数组存储底层数据
    private int[] data;
    //堆大小，节点数
    private int heap_size;

    /**
     * 将数组inial初始化成一个最大堆。在初始化时，直接最大堆。
     * @param inial
     */
    public Heap(int[] inial)
    {
        int len = inial.length;
        this.data = new int[len];
        this.heap_size = inial.length;
        for (int i=0;i<len;i++)
        {
            data[i] = inial[i];
        }
        maximizeHeap();
    }


    /**
     * 将堆的第i个节点根节点最大化（以i节点为根节点的子树，根节点最大化）
     * 对于第i个节点，比较第i个节点和它的左右子孩子，将i节点和这3个中最大的节点调换位置。完成一次调换。
     * 递归调整下去的节点，以保证下边的有序。
     * @param i
     */
    public void maxNode(int i) {
        int left = leftChild(i);
        int right = rightChild(i);

        int largest;

        if(left >= 0 && data[left] > data[i] && left <= heap_size-1 ) {
            largest = left;
        }
        else
        {
            largest = i;
        }

        if(right>=0 && data[right] >data[largest] && right <= heap_size -1 )  {
            largest=right;
        }

        //

        if ((left >=0 || right >= 0) && largest != i ) {
            swap(data,i,largest);
            maxNode(largest);
        }
    }

    /**
     * 最大化堆，从第一个非叶子节点开始，往上依次到根节点进行最大化。
     * 第一个非叶子节点的下标：  lenght/2 -1
     */
    public void maximizeHeap() {
        for(int i=(this.heap_size/2 - 1) ; i>=0; i--) {
            maxNode(i);
            //System.out.println(Arrays.toString(this.data));
        }
    }


    /**
     * 堆排序：
     * 算法：(1)初始时，构建一个最大堆，保证最大的元素在根节点。
     *       (2)调换根节点和最后一个节点的位置，并将最后一个节点移出堆(将heap_size减一即可)。
     *       (3)将调换后的堆，对根节点做依次最大化（这里原来思考创建最大堆，其实没必要，根节点最大化即可）。
     *       (4)再次取出最大堆的根节点，这个节点是第二大的元素，放在数组的前边。
     *       (5)依次进行上边的过程，直到最后一个元素。
     *       (6)最后得到从小到大排序的一个数组。
     */
    public void heapSort() {
        int heap_back = this.heap_size;
        //初始创建一个最大堆
        maximizeHeap();

        while(this.heap_size>0) {
            swap(data,0,heap_size-1);
            this.heap_size--;
            //对根节点最大化
            maxNode(0);
        }
        this.heap_size = heap_back;
    }

    /**
     * 返回第i个节点的左孩子节点
     * @param i
     * @return 左孩子节点的数组下标
     */
    public int leftChild(int i) {
        int left = 2*i + 1 ;
        if(left <= data.length-1 && left <= heap_size-1 ) {
            return left;
        }
        else{
            return -1;
        }
    }

    /**
     * 返回第i个节点的右孩子节点
     * @param i
     * @return 右孩子节点的数组下标
     */
    public int rightChild(int i) {
        int right = 2*i + 2 ;
        if(right <= data.length-1 && right <= heap_size-1 ) {
            return right;
        }
        else{
            return -1;
        }
    }

    /**
     * 调换数组a的m，n位置的元素
     * @param a
     * @param m
     * @param n
     */
    public void swap(int[] a,int m, int n) {
        int c = a[m];
        a[m] = a[n];
        a[n] = c;
    }


    //优先队列（最大优先队列）操作----------------------------------------------
    //返回优先队列中最大的元素的关键字。
    public int maximum()
    {
        int max=data[0];
        return max;
    }

    //返回最大元素的关键字，并在优先队列中去掉这个元素。
    public int extract_max(){
        int max = 0;
        return max;
    }

    //将第i个节点的关键字增加到key
    public void increase_key(int i,int key)
    {

    }

    //将key值，插入到该优先队列，并保证原来最大优先队列的属性正确。
    public void insert_queue(int key){

    }
    //优先队列（最大优先队列）操作----------------------------------------------






    public static void main(String[] args) {
        int[] a = {4,1,3,2,16,9,10,14,8,7};
        Heap hp =  new Heap(a);
        //hp.maximizeHeap();
        hp.heapSort();
        System.out.println(Arrays.toString(hp.data));
        System.out.println(hp.heap_size);
    }
}
