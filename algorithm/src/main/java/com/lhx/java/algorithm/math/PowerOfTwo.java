package com.lhx.java.algorithm.math;


/**
 * Created by lihongxin on 2019/2/21
 * 判断一个数是不是2的n次方
 */
public class PowerOfTwo {

    //是否是2的幂次方
    public boolean isPowerOfTwo(int value) {
        if ((value & (value - 1)) == 0) {
            int n = getN(value);
            System.out.println(value + "是2的n次方 n=" + n);
            return true;
        }
        System.out.println(value + "不是2的n次方");
        return false;

    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 1)
            return true;
        if (n >= 2 && n % 2 == 0)
            return isPowerOfTwo(n / 2);
        return false;
    }

    //得到n的值
    //非递归判断一个数是2的多少次方
    //右位移 溢出
    private int getN(int value) {
        int number = 0;
        while (value > 1) {
            value = value >> 1;
            number++;
        }
        return number;
    }

    //求一个数n的二进制中1的个数
    //num&num-1 可以去除掉末位的1
    public int getOneNumber(int value) {
        int origin = value;
        int number = 0;
        while (value > 1) {
            value = value & (value - 1);
            number++;
        }
        System.out.println(origin + "的二进制中有【" + number + "】个1");
        return number;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        powerOfTwo.isPowerOfTwo(8);
        powerOfTwo.getOneNumber(7);
    }

}
