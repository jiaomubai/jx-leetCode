package nextGreaterElement;

import java.util.Arrays;

/**
 * @ClassName: NextGreaterElement
 * @Description: leetCode-496: 下一个更大元素
 * @Author: jiaoxian
 * @Date: 2022/9/6 15:52
 **/
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m];
        Arrays.fill(result, -1);
        for (int i = 0; i < m; i++) {
            int greaterElement = findGreaterElement(nums1[i], nums2, n);
            if (greaterElement != -1) {
                result[i] = greaterElement;
            }
        }
        return result;
    }

    private int findGreaterElement(int element, int[] nums2, int n) {
        // 1. 先找到 element 在 nums2 中的下标
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (element == nums2[i]) {
                index = i;
            }
        }
        // 2. 遍历 nums2, 找出比 element 大且下标也大的元素
        if (index == n - 1) {
            return -1;
        }
        for (int i = index + 1; i < n; i++) {
            if (nums2[i] > element) {
                return nums2[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement.nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%4d", result[i]);
        }
        System.out.println();
    }

}
