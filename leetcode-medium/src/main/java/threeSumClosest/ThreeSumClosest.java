package threeSumClosest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ThreeSumClosest
 * @Description: leetCode-16: 最接近的三数之和
 * @Author: jiaoxian
 * @Date: 2022/9/14 17:39
 **/
public class ThreeSumClosest {

    // 暴力循环(会超时)
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        // 三数之和与 target 的差值
        int diff = 2147483647;
        // map 记录三数之和以及三数之和与 target 的差值, key 为差值, value 为三数之和
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // 三数之和
                    int sum = nums[i] + nums[j] + nums[k];
                    int diffClose = Math.abs(sum - target);
                    hashMap.put(diffClose, sum);
                }
            }
        }
        // 遍历 map 的 key, 查询最小差值(key)对应的 value
        for (Integer key : hashMap.keySet()) {
            if (key <= diff) {
                diff = Math.min(diff, key);
            }
        }
        return hashMap.get(diff);
    }

    // 排序 + 双指针
    // 使用 i、j、k 指针进行循环, 对应的值分别为 a、b、c, 则三数之和就为 a + b + c
    // 为了更好的使用双指针, 首先需要对数组进行升序排序
    // 枚举第一个元素 a, 对应指针为 i, 对于剩下的两个元素 b 和 c, 我们可以借助双指针, 使用? j 和 k 分别表示指向 b 和 c 的指针,
    // 初始时, j 指向位置 i + 1, 即左边界; k 指向位置 n - 1, 即右边界.
    // 在每一步枚举的过程中, 我们用 a + b + c 来更新答案, 而且, 因为数组是有序的, 所以
    // 如果 a + b + c ≥ target, 那么就将 k? 向左移动一个位置;
    // 如果 a + b + c < target, 那么就将 j? 向右移动一个位置.
    // 实际上, j? 和 k? 就表示了我们当前可以选择的数的范围, 而每一次枚举的过程中, 我们尝试边界上的两个元素, 根据它们与 target 的值的关系, 选择「抛弃」左边界的元素还是右边界的元素, 从而减少了枚举的范围.
    // 同时, 当我们枚举到恰好等于 target 时, 可以直接返回 target 作为答案, 因为不会有再比这个更接近的值了.
    // 还有一点是: 当我们枚举 a, b, c 中任意元素并移动指针时, 可以直接将其移动到下一个与这次枚举到的不相同的元素, 减少枚举的次数.
    public int threeSumClosest2(int[] nums, int target) {
        // 排序数组
        Arrays.sort(nums);
        // 数组长度
        int n = nums.length;
        // 初始化三数之和与 target 的差值
        int best = 10000000;
        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target, 移动 c 对应的指针 k
                    int kk = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < kk && nums[kk] == nums[k]) {
                        --kk;
                    }
                    k = kk;
                } else {
                    // 如果和小于 target, 移动 b 对应的指针 j
                    int jj = j + 1;
                    // 移动到下一个不相等的元素
                    while (jj < k && nums[jj] == nums[j]) {
                        ++jj;
                    }
                    j = jj;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {667,937,103,-426,405,888,-203,690,-749,-604,-284,-657,-84,648,845,477,-122,-337,-308,-344,-654,-387,462,-905,-23,520,-861,-683,-720,656,-189,106,-9,-632,-24,996,98,-376,8,195,-389,-975,473,839,120,118,282,241,578,895,416,-876,254,674,932,-666,-505,-694,906,-271,576,-440,-148,660,92,-822,-957,683,-409,499,803,596,-233,168,583,-687,-290,560,964,654,-978,792,627,-901,734,376,224,-380,917,-487,-377,-764,946,847,-348,-977,791,-139,-481,-164,-520,670,-258,188,348,231,764,699,468,518,-674,805,640,481,246,2,618,-340,556,933,-969,-636,-698,-205,-756,475,-723,-762,48,-754,-72,730,-385,486,-962,542,-532,879,483,-185,-524,33,637,-924,-844,682,561,-107,131,586,540,-484,-500,-961,-868,105,553,110,509,-960,814,-854,790,157,265,-177,819,689,-370,941,-214,-884,-353,-257,-669,-204,550,-278,169,211,-646,187,-87,-58,853,931,-131,248,-890,975,55,31,824,388,543,-745,472,82,128,-264,460,-486,896,-411,191,419,345,-430,394,-446,753,337,559,-903,44,132,-814,140,-443,161,-534,-103,-932,-813,-951,979,104,568,-710,312,649,-448,352,-709,229,-431,487,623,465,-757,-702,-916,838,-54,445,-998,406,100,-414,786,-580,837,-638,363,-333,782,249,180,549,14,346,296,422,-912,605,-536,-622,-171,573,-599,-603,144,443,-717,-644,-321,-111,886,-127,107,297,-862,418,-999,434,826,-872,-701,-832,25,-149,-489,-343,-917,-399,147,-607,-801,-641,135,-375,-165,990,-403,-424,953,86,978,50,-1000,84,-279,-579,-318,-981,-128,295,841,938,780,-88,611,-725,-236,914,802,500,390,-168,-390,-297,490,356,-922,-472,-939,130,916,449,60,672,212,-679,725,-200,-368,167,-143,3,-891,146,266,869,-989,262,-413,-610,-869,-252,260,182,-995,777,410,-879,973,377,178,-187,706,495,414,451,681,-738,177,444,-441,762,855,127,-537,-991,711,-793,-659,-946,230};
        long startTime = System.currentTimeMillis();
        int result = threeSumClosest.threeSumClosest(nums, 7675);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime) + "ms");
        long startTime2 = System.currentTimeMillis();
        int result2 = threeSumClosest.threeSumClosest2(nums, 7675);
        System.out.println("result = " + result2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime2 - startTime2) + "ms");

    }

}
