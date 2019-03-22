package com.lhx.java.algorithm.string;

import sun.rmi.runtime.Log;

/**
 * Created by lihongxin on 2019/2/8
 * 替换空白字符 @#$
 */
public class ReplaceSpaceClass {

    public String replaceSpace(String originStr) {
        //首先或得空格的数量
        int spaceCount = 0;
        if (originStr != null && originStr.length() != 0) {
            char[] string = originStr.toCharArray();
            for (int i = 0; i < string.length; i++) {
                if (string[i] == ' ') {
                    spaceCount++;
                }
            }
        }
        char[] newString = new char[originStr.length() + 2 * spaceCount];
        //倒叙遍历
        int newStringLength = newString.length - 1;
        for (int i = originStr.length() - 1; i >= 0; i--) {
            if (originStr.charAt(i) == ' ') {
                newString[newStringLength--] = '$';
                newString[newStringLength--] = '#';
                newString[newStringLength--] = '@';
            } else {
                newString[newStringLength--] = originStr.charAt(i);
            }

        }
        return String.valueOf(newString);
    }


    public String replaceSpace2(String originStr) {
        //思路 从后往前插入
        //从后往前，每个空格后面的字符只需要移动一次。
        //从前往后，当遇到第一个空格时，要移动第一个空格后所有的字符一次；
        //当遇到第二个空格时，要移动第二个空格后所有的字符一次；以此类推。所以总的移动次数会更多。
        String oldStr = originStr.toString();
        char[] oldChar = oldStr.toCharArray();
        int spaceNum = 0;
        for (int i = 0; i < oldChar.length; i++) {
            if (oldChar[i] == ' ') {
                spaceNum++;
            }
        }
        int oldLength = oldChar.length ;
        int newLength = oldLength + 2 * spaceNum ;
        char[] newChar = new char[newLength];
        newLength--;
        for (int j = oldLength-1 ; j >= 0; j--) {
            if (oldChar[j] == ' ') {
                newChar[newLength--] = '0';
                newChar[newLength--] = '2';
                newChar[newLength--] = '%';
            } else {
                newChar[newLength--] = oldChar[j];
            }
        }
        return String.valueOf(newChar);

    }

    public static void main(String[] args) {
        ReplaceSpaceClass replaceSpaceClass = new ReplaceSpaceClass();
        System.out.println(replaceSpaceClass.replaceSpace2("123 456 789"));


    }
}
