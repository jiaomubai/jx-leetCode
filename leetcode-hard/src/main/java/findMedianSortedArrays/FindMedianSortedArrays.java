package findMedianSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FindMedianSortedArrays
 * @Author: jiaoxian
 * @Date: 2022/6/7 16:15
 * @Description:
 */
public class FindMedianSortedArrays {

    /**
     * 不考虑时间复杂度, 合并两个有序数组为一个有序数组或列表
     * 之后根据数组或列表长度获取中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 遍历 nums1 数组指针
        int i = 0;
        // 遍历 nums2 数组指针
        int j = 0;
        // 开辟临时空间
        List<Integer> resultList = new ArrayList<>();
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                resultList.add(nums2[j]);
                j++;
                continue;
            }
            if (j == nums2.length) {
                resultList.add(nums1[i]);
                i++;
                continue;
            }
            if (nums1[i] == nums2[j]) {
                resultList.add(nums1[i]);
                resultList.add(nums2[j]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                resultList.add(nums1[i]);
                i++;
            } else {
                resultList.add(nums2[j]);
                j++;
            }
        }
        if (resultList.size() % 2 == 1) {
            return resultList.get(resultList.size() / 2);
        } else {
            return (resultList.get(resultList.size() / 2) + resultList.get(resultList.size() / 2 - 1)) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6,7, 7};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

}
