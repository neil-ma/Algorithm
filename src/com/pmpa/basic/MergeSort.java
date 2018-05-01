package com.pmpa.basic;

import java.util.Arrays;

/**
 * Created by jay on 2018/4/16.
 *
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
 *
 */
public class MergeSort {
    public static void mergeSort(int[] a , int m, int n){
        if ( m < n )
        {
            int mid = (m+n)/2 ;
            mergeSort(a,m,mid);
            mergeSort(a,mid+1,n);
            merging(a,m,mid,n);
        }
        else
        {
            return;
        };
        //System.out.println(Arrays.toString(a));
    }

    public static void merging(int[] a, int m, int mid, int n){
        int i = m ,  j = mid+1 ;
        int k = 0;
        int[] temp = new int[n-m+1];
        //左右两个数组的值比较，选择一个较小的值放到temp数组里。
        while(i<=mid && j<=n){
            if(a[i]<=a[j]){
                temp[k++] = a[i++];
            }
            else{
                temp[k++] = a[j++];
            }
        }

        //左边的数组剩余的数据都放到temp数组里。
        while(i<=mid){
            temp[k++] = a[i++];
        }

        //右边的数组剩余的数据都放到temp数组里。
        while(j<=n){
            temp[k++] = a[j++];
        }

        for(int c=0 ; c<n-m+1 ; c++)
        {
            a[m+c] = temp[c];
        }

    }

    public static void main(String[] args){
        int[] a = {8,23,1,345,12,9,3,123,2345,342,12};
        MergeSort.mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
