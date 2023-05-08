package longestPalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoxian
 * @name longestPalindrome
 * @date 2023/1/6 9:19
 * @description leetCode-409: 最长回文串
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        // 遍历字符串, 统计字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }
        // 遍历 map, 统计 value 的奇偶数量
        // 偶数直接加 result, 之后选最大的奇数加入 result
        boolean haveEven = false;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                // 偶数直接加
                result += entry.getValue();
            } else {
                // 加一个奇数, 其余的奇数 - 1 之后再加
                if (!flag) {
                    result += entry.getValue();
                    flag = true;
                } else {
                    result += entry.getValue() - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(s));
    }

}
