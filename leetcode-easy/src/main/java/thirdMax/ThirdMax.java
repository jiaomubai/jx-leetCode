package thirdMax;

import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: ThirdMax
 * @Author: jiaoxian
 * @Date: 2022/4/29 16:13
 * @Description: leetCode-414: 第三大的数
 */
public class ThirdMax {

    public static int thirdMax1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Integer firstMaxNum = null;
        Integer secondMaxNum = null;
        Integer thirdMaxNum = null;
        for (Integer currentNum : nums) {
            if (currentNum.equals(firstMaxNum) || currentNum.equals(secondMaxNum) || currentNum.equals(thirdMaxNum)) {
                continue;
            }
            if (firstMaxNum == null || currentNum > firstMaxNum) {
                thirdMaxNum = secondMaxNum;
                secondMaxNum = firstMaxNum;
                firstMaxNum = currentNum;
            } else if (secondMaxNum == null || currentNum > secondMaxNum) {
                thirdMaxNum = secondMaxNum;
                secondMaxNum = currentNum;
            } else if (thirdMaxNum == null || currentNum > thirdMaxNum) {
                thirdMaxNum = currentNum;
            }
        }
        return thirdMaxNum == null ? firstMaxNum : thirdMaxNum;
    }

    public static int thirdMax2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int firstMaxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMaxNum)  {
                firstMaxNum = nums[i];
            }
        }
        int secondMaxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondMaxNum && nums[i] < firstMaxNum)  {
                secondMaxNum = nums[i];
            }
        }
        int thirdMaxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > thirdMaxNum && nums[i] < secondMaxNum)  {
                thirdMaxNum = nums[i];
            }
        }
        return thirdMaxNum;
    }

    public static int thirdMax3(int[] nums) {
        Set set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Object[] array = set.toArray();
        if (set.size() < 3){
            return (Integer)array[array.length - 1];
        }
        return (Integer)array[array.length - 3];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -2147483648};
        System.out.println(thirdMax3(nums));
    }

}
