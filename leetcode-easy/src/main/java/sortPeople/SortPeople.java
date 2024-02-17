//package sortPeople;
//
//import util.ArraysUtil;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName: SortPeople
// * @Description: leetCode-6188: 按身高排序
// * @Author: jiaoxian
// * @Date: 2022/9/26 11:14
// **/
//public class SortPeople {
//
//    // 哈希表 + 排序
//    public String[] sortPeople(String[] names, int[] heights) {
//        int length = heights.length;
//        String[] result = new String[length];
//        // 将 name 与 height 的对应关系存储于 hashMap 中, key 为身高, value 为姓名
//        Map<Integer, String> hashMap = new HashMap<>();
//        for (int i = 0; i < heights.length; i++) {
//            // 因为 heights[] 和 names[] 中的元素都各不相同, 意味着没有相同身高的人, 也没有相同姓名的人
//            hashMap.put(heights[i], names[i]);
//        }
//        // 对原 heights[] 数组进行升序排序
//        Arrays.sort(heights);
//        // 倒序遍历 heights[] 数组, 并从 hashMap 中读取相应的 value
//        for (int i = length - 1; i >= 0; i--) {
//            result[length - i - 1] = hashMap.get(heights[i]);
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        SortPeople sortPeople = new SortPeople();
//        String[] names = {"A", "C", "D", "B", "G", "E"};
//        int[] heights = {177, 176, 180, 159, 168, 170};
//        String[] result = sortPeople.sortPeople(names, heights);
//        ArraysUtil.commonDisplay(result);
//    }
//
//}
