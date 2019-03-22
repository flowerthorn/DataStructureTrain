package com.lhx.java.algorithm.arr;

/**
 * Created by lihongxin on 2019/2/16
 * n 复杂度
 */
public class TwoOrderArrMerge {
    //两个有序数组的合并
    public int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }

    public static void main(String[] args) {
        TwoOrderArrMerge twoOrderArrMerge = new TwoOrderArrMerge();
        int[] c = twoOrderArrMerge.merge(new int[]{1, 2, 7, 8, 9}, new int[]{1, 7, 8});
        for (int i : c) {
            System.out.println(i);
        }
    }
}
