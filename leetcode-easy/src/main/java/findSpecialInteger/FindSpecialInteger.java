package findSpecialInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: FindSpecialInteger
 * @Description: leetCode-1287. 有序数组中出现次数超过25%的元素
 * @Author: jiaoxian
 * @Date: 2025-02-17 17:53:22
 * @Version: 1.0
 **/

public class FindSpecialInteger {

    public int findSpecialInteger(int[] arr) {
        int baseNum = arr.length / 4;
        Map<Integer, Integer> map  = new HashMap<Integer, Integer>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
            if (map.get(j) > baseNum) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
