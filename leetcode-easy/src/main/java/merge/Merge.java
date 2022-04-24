package merge;

import java.util.Arrays;

/**
 * @ClassName: Merge
 * @Author: jiaoxian
 * @Date: 2021/11/3 15:51
 * @Description:
 */
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // i 用来循环 nums1[] 中所有的元素
        // m 用来循环 nums1[] 中非零元素
        // n 用来循环 nums2[] 中的元素
        int i = m + n - 1;
        m--;
        n--;
        // nums1[] 中的非零元素与 nums2[] 中的元素倒序进行比较
        // 当 nums2[n] 大于等于 nums1[m] 时，设置 nums1[i] 为两者中较大的元素，之后对循环变量 i、m、n 进行自减
        while (m >= 0 && n >= 0) {
            if (nums2[n] >= nums1[m]) {
                nums1[i--] = nums2[n--];
            } else {
                nums1[i--] = nums1[m--];
            }
        }
        // 处理 nums1[] 中剩余元素
        for (; m >= 0; m--, i--) {
            nums1[i] = nums1[m];
        }
        // 处理 nums2[] 中剩余元素
        for (; n >= 0; n--, i--) {
            nums1[i] = nums2[n];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 从 nums2 中下标为 0 的位置取出 n 个元素，放到 nums1 中从下标 m 开始的位置
        System.arraycopy(nums2, 0, nums1, m, n);
        // 排序
        Arrays.sort(nums1, 0, m + n);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m = 3;
        int n = 3;
        merge2(nums1, m, nums2, n);
        // 打印输出
        for (int x = 0; x < nums1.length; x++) {
            System.out.print(nums1[x] + "  ");
        }
        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }


}
