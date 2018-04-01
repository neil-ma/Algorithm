package com.pmpa.basic;

import java.util.Arrays;

/**
 * Created by jay on 2018/4/1.
 * 插入排序
 */

public class InsertionSort {
    /**
     *
     * @param a
     * @return
     */
    public static int[] insertionSort(int[] a)
    {
        int key,i;
        for (int j=1 ; j<a.length ; j++)
        {
            key = a[j];
            i=j-1;
            while (i>=0 && key<a[i])
            {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
            //System.out.println(Arrays.toString(a));
        }
        return a;
    }

   public static void main(String[] args){
       int[] a = {23,98,2,17,31,93};
       System.out.println(Arrays.toString(InsertionSort.insertionSort(a)));
   }
}
