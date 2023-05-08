package repeatedSubstringPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaoxian
 * @name repeatedSubstringPattern
 * @date 2023/1/6 14:41
 * @description leetCode-459: 重复的子字符串
 */
public class RepeatedSubstringPattern {

    // 先遍历字符串 s, 找到可构成字符串的唯一子字符串 subString
    // 然后按照子字符串 subString 的长度切割原字符串 s
    // 若不能完整切割, 则 false
    // 可以完整切割的情况下, 再判断每一个子字符串是否和 subString 相等, 如果不相等, 则 false

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        // 子字符串
        String subString = stringBuilder.toString();
        for (int i = 0; i < length; i++) {
            if (subString.contains(String.valueOf(s.charAt(i)))) {
                // 如果子字符串中已经包含当前字符, 则 break 掉循环
                break;
            } else {
                stringBuilder.append(s.charAt(i));
                subString = stringBuilder.toString();
            }
        }
        int subLength = subString.length();
        if (subLength == length) {
            return false;
        }
        if (length % subLength != 0) {
            return false;
        }
        // 拆分字符串
        int size = length / subLength;
        for (int i = 0; i < size; i++) {
            String element = s.substring(i * subLength, (i + 1) * subLength);
            if (!subString.equals(element)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "abcabcabcabc";
//        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
//        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s));
    try {
        Thread.sleep(1000);
    } catch (Exception e) {

    }


    }

}
