package com.pmpa.basic;

import java.util.Arrays;

/**
 * 归并排序实现算法，采用了分治策略，递归完成。  伪代码：
 * MergeSrot(a, p, q)       //a是待排序数组，p是起始位置，q是结束位置。
 *   r = (q-p)/2  + p           //取p，q的中位数，拆为2个来进行分治处理。
 *   MergeSort(a,p,r)
 *   MergeSort(a,r+1,q)
 *   MergeSort(a,p,r,q)       //假如说a[p,r]有序，并且a[r,q]有序，那么让a整体有序。
 *
 * MergeSort(a,p,r,q)
 *   leftLength=r-p+1         //左数组长
 *   rightLength=q-r+1
 *   alloc new array left[leftLength+1]          //分配一个新数组，长度是p到r，并预留最后一位是哨兵（无穷大）。
 *   for i= p to leftLength
 *      left[i] = a[i]
 *   left[-1] = 无穷大
 *
 *   alloc new array right[rightLength+1]          //分配一个新数组，长度是r到q，并预留最后一位是哨兵（无穷大）。
 *   for i=r+1 to q
 *       right[i] = a[i+1+r]
 *   right[-1] = 无穷大
 *
 *   int cursor1 = 0  ,cursor2 = 0 , cursor3 = 0          //左右数组的迭代游标。cursor3是output数组的游标。
 *   alloc new array output[q - p + 1]      //创建保存排好序的新数组。
 *   while (cursor1 < leftLength || cursor2 < rightLength)
 *      if (left[cursor1] <= right[cursor2])
 *         output[cursor3] = left[cursor1]
 *         cursor1 ++
 *      else
 *         output[cursor3] = right[cursor2]
 *         cursor2 ++
 *      cursor3 ++
 *
 *
 * Created by jay on 2018/4/16.
 */
public class MergeSort {

    /**
     *
     * @param a    待排序数组
     * @param p    起始位置
     * @param q    结束位置
     * @return   排好序的数组
     */

    public static void MergeSort(int[]a , int p, int q ){
        if (p < q)
        {
            int r = (p+q) / 2 ;
            MergeSort(a , p, r );
            MergeSort(a , r+1, q );
            MergeSortQueue(a, p, r, q);
        }
    }

    public static void MergeSortQueue(int[]a , int p, int r, int q){
        int leftLength = r - p + 1;
        int rightLenth = q - r + 1;

        int[] left = new int[leftLength+1];
        int[] right = new int[rightLenth+1];
        int[] output = new int[q-p+1];

        for (int i = 0 ; i < leftLength ; i ++)
            left[i] = a[p+i];
        left[-1] = Integer.MAX_VALUE;
        for(int i = 0 ; i < rightLenth ; i ++)
            right[i] = a[r+1+i];
        right[-1] = Integer.MAX_VALUE;
        for(int i=0 ; i<q-p+1 ;i++ )
            output[i] = a[p+i];

        int j =0,k=0,l = 0;
        while (j<leftLength || k < rightLenth)
        {
            if(left[j] <=  right[k])
            {
                output[l] = left[j];
                j++;
            }
            else{
                output[l] = right[k];
                k++;
            }
            l++;
        }
        for(int i=0 ; i < q - p + 1 ; i ++)
        {
            a[p+i] = output[i];
        }
    }

    public static void main(String[] args){
        int[] a = {23,98,2,17,31,93};
        MergeSort.MergeSort(a,0,a.length);
        System.out.println(Arrays.toString(a));
    }


}
