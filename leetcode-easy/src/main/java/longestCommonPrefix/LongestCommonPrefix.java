package longestCommonPrefix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: LongestCommonPrefix
 * @Author: jiaomubai
 * @Date: 2021/9/13 10:08
 * @Description: LeetCode-14: 最长公共前缀
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 字典排序
        Arrays.sort(strs);
        System.out.println(new ArrayList<String>(Arrays.asList(strs)));
        // 取排序后第一个串
        String prefix = strs[0];
        // 取最后一个串与第一个串进行比较，取公共前缀
        while (!strs[strs.length - 1].startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length() - 1);
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        // 如果数组为空，返回""
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 如果数组长度为1，则原样返回
        if (strs.length == 1) {
            return strs[0];
        }
        // 默认最长公共前缀为数组中第一个元素
        String prefix = strs[0];
        for (String str : strs) {
            // 循环判断数组个元素是否以指定前缀 prefix 开头，如果不是，则将 prefix 截去最后一个字符，再进入循环
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[] strs = new String[]{"flower", "flow", "flight"};
        String result = longestCommonPrefix2(strs);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
