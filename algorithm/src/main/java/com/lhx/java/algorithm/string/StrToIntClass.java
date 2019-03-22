package com.lhx.java.algorithm.string;

/**
 * Created by lihongxin on 2019/2/8
 * 字符串转数字
 * 参考Integer.parseInt(str)
 */
public class StrToIntClass {
    int strToInt(String str) {
        int var1 = 10;
        if (str == null) {
            throw new NumberFormatException("null");
        } else {
            int var2 = 0;
            boolean isNegative = false;
            int var4 = 0;
            int strLength = str.length();
            int var6 = -2147483647;
            if (strLength > 0) {
                char first = str.charAt(0);
                if (first < '0') {
                    if (first == '-') {
                        isNegative = true;
                        var6 = -2147483648;
                    } else if (first != '+') {
//                        throw  new NumberFormatException();
                    }

                    if (strLength == 1) {
//                        throw NumberFormatException.forInputString(str);
                    }

                    ++var4;
                }

                int var8;
                for (int var7 = var6 / var1; var4 < strLength; var2 -= var8) {
                    var8 = Character.digit(str.charAt(var4++), var1);
                    if (var8 < 0) {
//                        throw NumberFormatException.forInputString(str);
                    }

                    if (var2 < var7) {
//                        throw NumberFormatException.forInputString(str);
                    }

                    var2 *= var1;
                    if (var2 < var6 + var8) {
//                        throw NumberFormatException(str+"");
                    }
                }

                return isNegative ? var2 : -var2;
            } else {
                throw new NumberFormatException("null");
            }
        }
    }

    public static void main(String[] args) {
        StrToIntClass strToIntClass = new StrToIntClass();
        System.out.println(strToIntClass.strToInt("-234566"));
    }
}
