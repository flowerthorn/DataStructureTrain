package com.lhx.java.algorithm.string;

/**
 * Created by lihongxin on 2019/2/8
 * 检查是否是旋转字符串
 */
public class RotationClass {
    public boolean chkRotation(String str1, String str2) {
        // write code here

        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        String sum = str1 + str1;
        if (sum.contains(str2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RotationClass rotationClass = new RotationClass();
        String str1 = "2342";
        String str2 = "1234";
        //判断str1是否是str2的旋转字符串
        boolean isRoataion = rotationClass.chkRotation(str1, str2);
        System.out.println(str1 + "是" + str2+"的旋转字符串吗?" + isRoataion);
    }
}
