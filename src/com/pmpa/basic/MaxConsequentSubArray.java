package com.pmpa.basic;

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
    public int[] findCrossingMaxSubArray(int[] a , int m, int r, int n){
        int[] output = new int[3];
        //记录左右数组下标
        int left,right;
        //记录左右数组的和
        int left_sum =





        return output;
    }


    public static void main(String[] args)
    {
        int[] test = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
    }
}
