//package intersect;
//
//
//import util.ArraysUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ClassName: Intersect
// * @Author: jiaoxian
// * @Date: 2022/5/2 16:32
// * @Description: leetCode-350: 两个数组的交集 II
// */
//public class Intersect {
//
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        if (nums1.length == 0 || nums2.length == 0) {
//            return null;
//        }
//        List<Integer> list1 = new ArrayList<>();
//        for (int i : nums1) {
//            list1.add(i);
//        }
//        List<Integer> list2 = new ArrayList<>();
//        for (int j = 0; j < nums2.length; j++) {
//            if (list1.contains(nums2[j])) {
//                list2.add(nums2[j]);
//                list1.remove(Integer.valueOf(nums2[j]));
//            }
//        }
//        int[] result = new int[list2.size()];
//        for (int i = 0; i < list2.size(); i++) {
//            result[i] = list2.get(i);
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};
//        ArraysUtil.displayIntArray(intersect(nums1, nums2));
//    }
//
//}
