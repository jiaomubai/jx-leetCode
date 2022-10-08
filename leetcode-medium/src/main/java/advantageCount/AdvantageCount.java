package advantageCount;

import util.ArraysUtil;

import java.util.Arrays;

/**
 * @ClassName: AdvantageCount
 * @Description: leetCode-870: 优势洗牌(田忌赛马)
 * @Author: jiaoxian
 * @Date: 2022/10/8 16:15
 **/
public class AdvantageCount {

    // 田忌赛马（贪心法解决）
    // 把 nums1[]? 当成是田忌的马, nums2[] 当成是齐威王的马
    // 每次用 nums1[] 中的下等马去跟 nums2[] 中的下等马 pk
    // 如果 pk 的过就下一个继续 pk; 如果 pk 不过就用 nums1[] 中的下等马去当炮灰, 去 pk nums2[] 中的上等马
    // 在本题中, 如果 pk 的过, 就用 nums2[] 中的下等马的下标当做 nums1[] 中的下等马的下标
    // pk 不过, 就用 nums2[] 中的上等马的下标当作 nums1[] 中的下等马的下标
    // 则首先分别将数组 nums1[]? 和 nums2[]? 进行排序, 即排序出下等马和上等马, 随后只需要不断考虑这两个数组的首个元素（即下等马）
    // 如果 nums1[]? 的首个元素大于 nums2[]? 的首个元素, 即田忌的下等马 pk 赢了齐威王的下等马, 那么就将它们在答案中对应起来, 同时从数组中移除这两个元素, 避免重复使用, 并增加一点优势;
    // 如果 nums1[]? 的首个元素小于等于 nums2[]? 的首个元素, 那么移除 nums1[] 的首个元素。
    // 当 nums1[]? 中没有元素时, 遍历结束.
    // 这样做的正确性在于: 对于第一种情况, 由于 nums1[] 是有序的, 那么 nums1[] 的任意元素大于 nums2[] 的首个元素;
    // 如果我们不与 nums2[] 的首个元素配对, 由于 nums2[] 是有序的, 之后的元素会更大, 这样并不划算;
    // 如果我们与 nums2[] 的首个元素配对, 我们使用 nums1[]的首个元素, 可以使得剩余的元素尽可能大, 之后可以获得更多优势.
    // 对于第二种情况, 由于 nums2[]是有序的, 那么 nums1[] 的首个元素小于等于 nums2[] 中的任意元素, 因此 nums1[] 的首个元素无法增加任何优势, 可以直接移除.
    // 在本题中, 由于 nums1[] 中的每一个元素都要与 nums2[]? 中的元素配对, 而我们是按照顺序考虑 nums2[] 中的元素的, 因此在遍历结束后, nums2[] 中剩余的元素实际上是原先 nums2[] 的一个后缀.
    // 因此当 nums1[] 的首个元素无法配对时, 我们给它配对一个 nums2[] 的尾元素即可, 并将该尾元素移除.
    // 在实际的代码编写中, 我们无需真正地移除元素. 对于 nums1[], 我们使用一个循环依次遍历其中的每个元素;
    // 对于 nums2[], 我们可以使用双指针 left 和 right. 如果 nums1[] 的首个元素可以增加优势, 就配对 left 对应的元素并向右移动一个位置;
    // 如果无法配对, 就配对 right 对应的元素并向左移动一个位置.

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        // 将 nums1[] 和 nums2[] 中的值所对应的下标按照其值大小排序
        // 即排序后的 idx1[] 中第一个元素是 nums1[] 中值最小的元素的下标, 最后一个元素是 nums1[] 中值最大的元素的下标
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                // 如果 nums1[] 的首元素大于 nums2[] 的首元素, 即田忌的下等马可以赢齐威王的下等马, 则建立田忌的下等马与齐威王的下等马的对应关系, 将田忌的下等马添加到与齐威王的下等马的对应位置上
                result[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                // 如果 nums1[] 的首元素小于等于 nums2[] 的首元素, 即田忌的下等马无法赢齐威王的下等马, 则建立田忌的下等马与齐威王的上等马的对应关系, 将田忌的下等马添加到与齐威王的上等马的对应位置上
                result[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AdvantageCount advantageCount = new AdvantageCount();
        int[] nums1 = new int[]{12, 24, 8, 32};
        int[] nums2 = new int[]{12, 25, 32, 11};
        int[] result = advantageCount.advantageCount(nums1, nums2);
        ArraysUtil.displayIntArray(result);
    }

}
