package getMaximumGenerated;

import java.util.Arrays;

/**
 * @ClassName: GetMaximumGenerated
 * @Description: leetCode-1646: 获取生成数组中的最大值
 * @Author: jiaoxian
 * @Date: 2025-02-18 18:13:14
 * @Version: 1.0
 **/

public class GetMaximumGenerated {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }

}
