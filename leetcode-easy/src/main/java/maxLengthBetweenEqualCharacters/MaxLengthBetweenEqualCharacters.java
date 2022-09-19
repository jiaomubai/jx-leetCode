package maxLengthBetweenEqualCharacters;

import java.util.Arrays;

/**
 * @ClassName: MaxLengthBetweenEqualCharacters
 * @Description: leetCode-1624: 两个相同字符之间的最长子字符串
 * @Author: jiaoxian
 * @Date: 2022/9/19 9:49
 **/
public class MaxLengthBetweenEqualCharacters {

    // 对于字符 c 来说, 只需要求出 c 第一次出现在字符串中的索引位置 first 和最后一次出现在字符串中的索引位置 last 即可, 则以 c 为相同字符之间的子字符串的最大长度就是 last - first - 1, 我们可以依次求出所有可能的子字符的长度的最大值.
    // 我们借助数组 tempArray[26] 记录每个字符 i 在字符串中第一次出现的索引, maxLength 表示当前子字符串的最大长度.
    // 初始化时 tempArray 中的每个元素都初始化为 -1, 表示该字符还未出现.
    // 循环遍历字符串 s, 当遍历到第 i 个字符 c 时, 如果当前数组中 tempArray[c] = -1 时, 则记录该字符第一次出现的索引为 i, 同时更新 tempArray[c] = i;
    // 如果当前数组中 tempArray[c] ≥ 0 时, 则表示字符 c 在此之前已经出现过, 此时两个 c 之间的子字符串长度为 i - tempArray[c] - 1, 同时更新 maxLength.
    // 返回最大的长度 maxLength\textit{maxLength}maxLength 即可。

    public int maxLengthBetweenEqualCharacters(String s) {
        // 临时数组 tempArray(字符 'a' 的下标是 0, 字符 'b' 的下标是 1, 字符 'z' 的下标是 25), 记录字符出现的索引
        int[] tempArray = new int[26];
        // 初始化 tempArray, 元素为 -1
        Arrays.fill(tempArray, -1);
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            if (tempArray[s.charAt(i) - 'a'] < 0) {
                // 如果该字符之前没有出现过, 则更新 tempArray
                tempArray[s.charAt(i) - 'a'] = i;
            } else {
                // 如果已经出现过, 则计算最长子字符串的长度即可
                maxLength = Math.max(maxLength, i - tempArray[s.charAt(i) - 'a'] - 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MaxLengthBetweenEqualCharacters maxLengthBetweenEqualCharacters = new MaxLengthBetweenEqualCharacters();
        String s = "abcdefbfedcb";
        int result = maxLengthBetweenEqualCharacters.maxLengthBetweenEqualCharacters(s);
        System.out.println("result = " + result);
    }

}
