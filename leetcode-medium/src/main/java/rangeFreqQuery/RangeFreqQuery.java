package rangeFreqQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RangeFreqQuery
 * @Description: leetCode-2080:区间内查询数字的频率
 * @Author: jiaoxian
 * @Date: 2025-02-18 17:42:46
 * @Version: 1.0
 **/

public class RangeFreqQuery {

    // 初始化数组
    public static int[] arr = new int[]{};
    // 缓存
    public static Map<String, Integer> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int value) {
        int result = 0;
        String key = left + "-" + right + "-" + value;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = left; i <= right; i++) {
            if (value == arr[i]) {
                result++;
            }
        }
        map.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        System.out.println(rangeFreqQuery.query(0, 1, 2));
        System.out.println(rangeFreqQuery.query(0, 2, 1));

    }

}
