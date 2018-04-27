package com.pmpa.basic;

import java.util.Arrays;

/**
 * Created by jay on 2018/4/17.
 *
 *
 * 最大连续子数组问题。
 * 解决方案：分治策略，递归解决。
 *
 * 分析连续的最大子数组，可能出现在这3种不同的情况（对于选定的mid中线）：
 * (1)最大子数组在mid左侧；
 * (2)最大子数组在mid右侧；
 * (3)最大子数组横跨mid中线；
 *
 *
 *
 */
public class MaxConsequentSubArray {


    /**
     *
     * @param a    查询最大子数组的原数组
     * @param m    数组的起始点
     * @param r    选取中间的标线（r必须在查到的子数组中，因为该子数组属于“最大子数组横跨mid中线”的情况）
     * @param n    数组的终点
     * @return   数组int[]  包含3个元素，第一个元素是最大连续子数组的起始坐标；第二个元素是最大连续子数组的终止坐标；
     *            第三个元素是最大连续子数组的和。
     */
    public static int[] findCrossingMaxSubArray(int[] a , int m, int r, int n){
        //输出结果3个值，第一个是求得子数组的和，第二个值是最大子数组的左下标，第三个值是最大子数组的右下标。
        int[] output = new int[3];
        //记录左右数组下标
        int left,right;
        int left_final=r,right_final=r;
        //记录左右数组的和
        int left_sum_final = Integer.MIN_VALUE,right_sum_final = Integer.MIN_VALUE;
        int left_sum = 0,right_sum = 0;
        left = r ;
        while(left >= m){
            left_sum = left_sum + a[left];
            if (left_sum > left_sum_final) {left_sum_final = left_sum;left_final = left;}
            left--;
        }
        right = r+1;
        while (right<=n){
            right_sum = right_sum+ a[right];
            if (right_sum > right_sum_final) {right_sum_final = right_sum;right_final = right;}
            right++;
        }
        output[0] = left_sum_final + right_sum_final;
        output[1] = left_final;
        output[2] = right_final;
        return output;
    }


    public static int[] findMaxSubArray(int[] a , int m, int n){
        int[] fin =null;
        if (m<n){
            int mid = (m+n)/2;
            int[] left_array = findMaxSubArray(a,m,mid);
            int[] right_array = findMaxSubArray(a,mid+1,n);
            int[] crossing_array = findCrossingMaxSubArray(a,m,mid,n);

            if(left_array[0] >= right_array[0] && left_array[0] >= crossing_array[0])
                fin = left_array;
            else if (right_array[0] >= left_array[0] && right_array[0] >= crossing_array[0])
                fin = right_array;
            else if (crossing_array[0] >= left_array[0] && crossing_array[0] >= right_array[0])
                fin= crossing_array;
            System.out.print("比较：" + Arrays.toString(left_array) + "||" + Arrays.toString(crossing_array) + "||" + Arrays.toString(right_array) + "  ===> " );
        }
        else
        {
            int[] output = {a[m],m,m};
            fin = output;
        }

        System.out.println(Arrays.toString(fin));
        return fin;
    }

    public static void main(String[] args)
    {
        int[] test = {13,46,-25,20,-3,-16,-23,18,-20,-7,12,-5,-22,15,-4,7};

        int[] output = MaxConsequentSubArray.findMaxSubArray(test,0,15);
        System.out.println(Arrays.toString(output));

    }
}
