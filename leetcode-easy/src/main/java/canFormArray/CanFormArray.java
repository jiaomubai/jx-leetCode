package canFormArray;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CanFormArray
 * @Description: leetCode-1640: 能否连接形成数组
 * @Author: jiaoxian
 * @Date: 2022/9/22 17:16
 **/
public class CanFormArray {

    // 因为数组 arr 中每个整数互不相同, 且 pieces 中的整数也互不相同, 所以我们可以通过 arr 来固定 pieces 的放置.
    // 使用 HashMap 来记录 pieces 中各个数组的首元素与数组下标的对应关系.
    // 即循环遍历 pieces, 将 pieces 中每个元素(数组)的第一个元素作为 Map 的 key, 每个元素的下标作为 value 存储进 HashMap 中
    // 然后去遍历数组 arr, 如果数组 arr 的元素不存在于 HashMap 中, 则直接 return false
    // 如果存在, 则找到对应的数组 pieces[j], 然后将它与 arr[i] 及之后的整数进行比较
    // 在比较过程中, 如果判断相等不成立, 则直接返回 false, 如果都相等的话, 则将 i 相应地向后移动 pieces[j].length 位.
    // 全部 pieces 都匹配成功后, 返回 true.

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int m = pieces.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 遍历 pieces, 存储进 hashMap
        for (int i = 0; i < m; i++) {
            hashMap.put(pieces[i][0], i);
        }
        // 遍历 arr, 判断是否存在于 hashMap 中, 并判断是否满足相应条件
        for (int i = 0; i < n;) {
            if (!hashMap.containsKey(arr[i])) {
                return false;
            }
            int j = hashMap.get(arr[i]);
            int len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }
            i = i + len;
        }
        return true;
    }

    public static void main(String[] args) {
        CanFormArray canFormArray = new CanFormArray();
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        System.out.println(canFormArray.canFormArray(arr, pieces));
    }

}
