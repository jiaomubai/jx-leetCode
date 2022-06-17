package smallestDifference;

import java.util.Arrays;

/**
 * @ClassName: SmallestDifference
 * @Author: jiaoxian
 * @Date: 2022/6/8 21:20
 * @Description: leetCode-面试题 16.06: 最小差
 */
public class SmallestDifference {

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        while (left < a.length && right < b.length) {
            long diff = a[left] - b[right];
            long diffAbs = Math.abs(diff);
            result = (int)Math.min(diffAbs, result);
            if (diff > 0) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-2147483648,1};
        int[] b = {0,2147483647};
        System.out.println(new SmallestDifference().smallestDifference(a, b));
    }

}
