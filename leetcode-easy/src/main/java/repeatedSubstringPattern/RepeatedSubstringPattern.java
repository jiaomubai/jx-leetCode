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

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        String str1 = s.substring(0, s.length() / 2);
        String str2 = s.substring(s.length() / 2);
        if (str1.equals(str2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabc";
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s));

    }

}
