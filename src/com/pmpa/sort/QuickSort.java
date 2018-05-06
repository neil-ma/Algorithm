package com.pmpa.sort;

import java.util.Arrays;

/**
 * Created by jay on 2018/4/23.
 *
 * 快速排序实现
 * 算法：(1) 分治方法：
 *       分解：对于QuickSort(A,p,r)，通过一个方法PARTITION挪动数组元素，找到一个q元素，使得：
 *            A[p ... q-1] 所有的元素都小于等于A[q]，而A[q]小于等于A[q+1 ... r] 所有元素。
 *            这样原来的数组(p,r)，就被分成了(p,q-1) 和 (q+1,r)两个部分。
 *       解决：对A[p ... q-1] 和 A[q+1 ... r] 递归调用上边的方式。
 *       复杂度：最坏情况 o(n^2)   一般情况 o(nlg(n))
 *      (2)传统的简单方式：
 */
public class QuickSort {


    public static void sort(int[] a, int p, int r){
        if(p<r) {
            int q = partition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }

    /**
     * 找到中位元素
     * 算法：把最后一个元素作为主元。
     * @param a
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] a,int p ,int r){
        int i = p-1;
        int j;
        int x = a[r];
        for (j=p;j<r;j++){
            if(a[j] <= x){
                i = i +1;
                swap(a,i,j);
            }
        }
        swap(a,i+1,r);
        System.out.println("点数"+(i+1)+"array："+Arrays.toString(a));
        return (i+1);
    }

    /**
     * 工具类，调换位置。
     * @param a
     * @param m
     * @param n
     */
    public static void swap(int[] a, int m, int n)
    {
        int c = a[m];
        a[m] = a[n];
        a[n] = c;
    }

    public static void main(String[] args){

        int[] a = {23,98,2,17,31,93,2,234,12,23};
        QuickSort.sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
