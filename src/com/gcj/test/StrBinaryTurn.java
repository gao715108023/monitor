package com.gcj.test;

/**
 * Created by gaochuanjun on 14-5-13.
 */
public class StrBinaryTurn {

    //将Unicode字符串转换成bool型数组
    public boolean[] StrToBool(String input) {
        return Binstr16ToBool(BinstrToBinstr16(StrToBinstr(input)));
    }

    //将bool型数组转换成Unicode字符串
    public String BoolToStr(boolean[] input) {
        return BinstrToStr(Binstr16ToBinstr(BoolToBinstr16(input)));
    }

    //将字符串转换成二进制字符串，以空格相隔
    private String StrToBinstr(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (char aStrChar : strChar) {
            result += Integer.toBinaryString(aStrChar) + " ";
        }
        return result;
    }

    //将二进制字符串转换成Unicode字符串
    private String BinstrToStr(String binStr) {
        String[] tempStr = StrToStrArray(binStr);
        char[] tempChar = new char[tempStr.length];
        for (int i = 0; i < tempStr.length; i++) {
            tempChar[i] = BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }

    //将二进制字符串格式化成全16位带空格的Binstr
    private String BinstrToBinstr16(String input) {
        StringBuilder output = new StringBuilder();
        String[] tempStr = StrToStrArray(input);
        for (String aTempStr : tempStr) {
            for (int j = 16 - aTempStr.length(); j > 0; j--)
                output.append('0');
            output.append(aTempStr).append(" ");
        }
        return output.toString();
    }

    //将全16位带空格的Binstr转化成去0前缀的带空格Binstr
    private String Binstr16ToBinstr(String input) {
        StringBuilder output = new StringBuilder();
        String[] tempStr = StrToStrArray(input);
        for (String aTempStr : tempStr) {
            for (int j = 0; j < 16; j++) {
                if (aTempStr.charAt(j) == '1') {
                    output.append(aTempStr.substring(j)).append(" ");
                    break;
                }
                if (j == 15 && aTempStr.charAt(j) == '0')
                    output.append("0" + " ");
            }
        }
        return output.toString();
    }

    //二进制字串转化为boolean型数组  输入16位有空格的Binstr
    private boolean[] Binstr16ToBool(String input) {
        String[] tempStr = StrToStrArray(input);
        boolean[] output = new boolean[tempStr.length * 16];
        for (int i = 0, j = 0; i < input.length(); i++, j++)
            if (input.charAt(i) == '1')
                output[j] = true;
            else if (input.charAt(i) == '0')
                output[j] = false;
            else
                j--;
        return output;
    }

    //boolean型数组转化为二进制字串  返回带0前缀16位有空格的Binstr
    private String BoolToBinstr16(boolean[] input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (input[i])
                output.append('1');
            else
                output.append('0');
            if ((i + 1) % 16 == 0)
                output.append(' ');
        }
        output.append(' ');
        return output.toString();
    }

    //将二进制字符串转换为char
    private char BinstrToChar(String binStr) {
        int[] temp = BinstrToIntArray(binStr);
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[temp.length - 1 - i] << i;
        }
        return (char) sum;
    }

    //将初始二进制字符串转换成字符串数组，以空格相隔
    private String[] StrToStrArray(String str) {
        return str.split(" ");
    }

    //将二进制字符串转换成int数组
    private int[] BinstrToIntArray(String binStr) {
        char[] temp = binStr.toCharArray();
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i] - 48;
        }
        return result;
    }

    public static void main(String[] args) {
        StrBinaryTurn strBinaryTurn = new StrBinaryTurn();
        String src = "";
        strBinaryTurn.BinstrToStr(src);
    }
}
