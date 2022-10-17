package totalFruit;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TotalFruit
 * @Description: leetCode-904: 水果成篮
 * @Author: jiaoxian
 * @Date: 2022/10/17 14:37
 **/
public class TotalFruit {

    public int totalFruit(int[] fruits) {
        // 滑动窗口,
        // left 指向数组左边, right 指向数组右边, 使用 hashMap 来存储 [left, right] 区间内的数据及其出现的次数
        // 对于 [left, right] 内的数据全部存入 hashMap 中, 如果此时 hashMap 中的键值大于 2, 则不断移动左指针 left, 直到 hashMap 符合条件为止
        // 需要注意的是, 在左指针 left 向右移动的过程中, 需要移除 hashMap 中左指针的对应的键值

        int n = fruits.length;
        Map<Integer, Integer> hanshMap = new HashMap<Integer, Integer>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < n; right++) {
            hanshMap.put(fruits[right], hanshMap.getOrDefault(fruits[right], 0) + 1);
            while (hanshMap.size() > 2) {
                hanshMap.put(fruits[left], hanshMap.get(fruits[left]) - 1);
                if (hanshMap.get(fruits[left]) == 0) {
                    hanshMap.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        int[] fruits = new int[]{1,0};
        int result = totalFruit.totalFruit(fruits);
        System.out.println(result);
    }

}
