//package moveZeroes;
//
//
//import util.ArraysUtil;
//
///**
// * @ClassName: MoveZeroes
// * @Author: jiaoxian
// * @Date: 2022/5/2 15:32
// * @Description: leetCode-283: 移动零
// */
//public class MoveZeroes {
//
//    /**
//     * 遍历
//     * @param nums
//     */
//    public static void moveZeroes1(int[] nums) {
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0 ) {
//                nums[index] = nums[i];
//                index++;
//            }
//        }
//        for (int i = index; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//    }
//
//    /**
//     * 双指针
//     * @param nums
//     */
//    public static void moveZeroes2(int[] nums) {
//        int j = 0 ;
//        for (int i = 0 ; i< nums.length; i ++){
//            if (nums[i] != 0) {
//                if( j < i ) {
//                    nums[j] = nums[i];
//                    nums[i] = 0 ;
//                }
//                j++;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1,0,0,3,12};
//        moveZeroes1(nums);
//        ArraysUtil.displayIntArray(nums);
//        moveZeroes2(nums);
//        ArraysUtil.displayIntArray(nums);
//    }
//
//}
