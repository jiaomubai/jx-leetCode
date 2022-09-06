package shuffle;


import util.ArraysUtil;

/**
 * @ClassName: Shuffle
 * @Description: leetCode-1470: 新排列数组
 * @Author: jiaoxian
 * @Date: 2022/9/6 17:46
 **/
public class Shuffle {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        // 开辟额外的数组存储结果
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index] = nums[i];
            index++;
            result[index] = nums[i + n];
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        int[] nums = {2, 5, 1, 3, 4, 7};
        ArraysUtil.displayIntArray(nums);
        int[] result = shuffle.shuffle(nums, 3);
        ArraysUtil.displayIntArray(result);
    }

}
