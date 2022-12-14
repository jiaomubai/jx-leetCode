package numDifferentIntegers;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiaoxian
 * @name numDifferentIntegers
 * @date 2022/12/14 10:37
 * @description leetCode-1805: 字符串中不同整数的数目
 */
public class NumDifferentIntegers {

    public int numDifferentIntegers(String word) {
        int length = word.length();
        // 不同的数字, 以字符串形式存储
        StringBuffer numberStringBuffer = new StringBuffer();
        // 使用 HashSet 来存储不同的数字
        Set<String> numberStrSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                // 如果是数字
                numberStringBuffer.append(c);
            } else {
                // 如果是字母
                String numberStr = numberStringBuffer.toString();
                numberStr = removeZero(numberStr);
                if (numberStr != null && numberStr.length() > 0) {
                    numberStrSet.add(numberStr);
                    numberStringBuffer = new StringBuffer();
                }
            }
        }
        if (!numberStringBuffer.toString().isEmpty()) {
            String numberStr = numberStringBuffer.toString();
            numberStr = removeZero(numberStr);
            if (numberStr != null && numberStr.length() > 0) {
                numberStrSet.add(numberStr);
            }
        }
        return numberStrSet.size();
    }

    private String removeZero(String resource) {
        int length = resource.length();
        int i = 0;
        while (i < length) {
            if (resource.charAt(i) == '0') {
                i++;
            } else {
                break;
            }
        }
        if (length > 0) {
            if (i == length) {
                return String.valueOf(resource.charAt(length - 1));
            } else {
                return resource.substring(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        NumDifferentIntegers numDifferentIntegers = new NumDifferentIntegers();
        String word = "a123bc34d8ef34";
        System.out.println(numDifferentIntegers.numDifferentIntegers(word));
    }

}
