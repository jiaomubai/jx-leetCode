package maxDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MaxDifference
 * @Description: leetCode-3442:奇偶频次间的最大差值 I
 * @Author: jiaoxian
 * @Date: 2025-02-08 17:32:05
 * @Version: 1.0
 **/

public class MaxDifference {

    // 最大的奇数 - 最小的偶数
    public int maxDifference(String s) {
        int odd = 0;
        int even = 100;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                // 偶数次
                if (entry.getValue() < even) {
                    even = entry.getValue();
                }
            } else {
                // 奇数次
                if (entry.getValue() > odd) {
                    odd = entry.getValue();
                }
            }
        }
        return odd - even;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDifference().maxDifference("aaaaabbc"));
    }

}
