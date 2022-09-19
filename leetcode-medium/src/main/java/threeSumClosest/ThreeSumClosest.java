package threeSumClosest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ThreeSumClosest
 * @Description: leetCode-16: ��ӽ�������֮��
 * @Author: jiaoxian
 * @Date: 2022/9/14 17:39
 **/
public class ThreeSumClosest {

    // ����ѭ��(�ᳬʱ)
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        // ����֮���� target �Ĳ�ֵ
        int diff = 2147483647;
        // map ��¼����֮���Լ�����֮���� target �Ĳ�ֵ, key Ϊ��ֵ, value Ϊ����֮��
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // ����֮��
                    int sum = nums[i] + nums[j] + nums[k];
                    int diffClose = Math.abs(sum - target);
                    hashMap.put(diffClose, sum);
                }
            }
        }
        // ���� map �� key, ��ѯ��С��ֵ(key)��Ӧ�� value
        for (Integer key : hashMap.keySet()) {
            if (key <= diff) {
                diff = Math.min(diff, key);
            }
        }
        return hashMap.get(diff);
    }

    // ���� + ˫ָ��
    // ʹ�� i��j��k ָ�����ѭ��, ��Ӧ��ֵ�ֱ�Ϊ a��b��c, ������֮�;�Ϊ a + b + c
    // Ϊ�˸��õ�ʹ��˫ָ��, ������Ҫ�����������������
    // ö�ٵ�һ��Ԫ�� a, ��Ӧָ��Ϊ i, ����ʣ�µ�����Ԫ�� b �� c, ���ǿ��Խ���˫ָ��, ʹ��? j �� k �ֱ��ʾָ�� b �� c ��ָ��,
    // ��ʼʱ, j ָ��λ�� i + 1, ����߽�; k ָ��λ�� n - 1, ���ұ߽�.
    // ��ÿһ��ö�ٵĹ�����, ������ a + b + c �����´�, ����, ��Ϊ�����������, ����
    // ��� a + b + c �� target, ��ô�ͽ� k? �����ƶ�һ��λ��;
    // ��� a + b + c < target, ��ô�ͽ� j? �����ƶ�һ��λ��.
    // ʵ����, j? �� k? �ͱ�ʾ�����ǵ�ǰ����ѡ������ķ�Χ, ��ÿһ��ö�ٵĹ�����, ���ǳ��Ա߽��ϵ�����Ԫ��, ���������� target ��ֵ�Ĺ�ϵ, ѡ����������߽��Ԫ�ػ����ұ߽��Ԫ��, �Ӷ�������ö�ٵķ�Χ.
    // ͬʱ, ������ö�ٵ�ǡ�õ��� target ʱ, ����ֱ�ӷ��� target ��Ϊ��, ��Ϊ�������ٱ�������ӽ���ֵ��.
    // ����һ����: ������ö�� a, b, c ������Ԫ�ز��ƶ�ָ��ʱ, ����ֱ�ӽ����ƶ�����һ�������ö�ٵ��Ĳ���ͬ��Ԫ��, ����ö�ٵĴ���.
    public int threeSumClosest2(int[] nums, int target) {
        // ��������
        Arrays.sort(nums);
        // ���鳤��
        int n = nums.length;
        // ��ʼ������֮���� target �Ĳ�ֵ
        int best = 10000000;
        // ö�� a
        for (int i = 0; i < n; ++i) {
            // ��֤����һ��ö�ٵ�Ԫ�ز����
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // ʹ��˫ָ��ö�� b �� c
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // �����Ϊ target ֱ�ӷ��ش�
                if (sum == target) {
                    return target;
                }
                // ���ݲ�ֵ�ľ���ֵ�����´�
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // ����ʹ��� target, �ƶ� c ��Ӧ��ָ�� k
                    int kk = k - 1;
                    // �ƶ�����һ������ȵ�Ԫ��
                    while (j < kk && nums[kk] == nums[k]) {
                        --kk;
                    }
                    k = kk;
                } else {
                    // �����С�� target, �ƶ� b ��Ӧ��ָ�� j
                    int jj = j + 1;
                    // �ƶ�����һ������ȵ�Ԫ��
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
        System.out.println("��ʱ:" + (endTime - startTime) + "ms");
        long startTime2 = System.currentTimeMillis();
        int result2 = threeSumClosest.threeSumClosest2(nums, 7675);
        System.out.println("result = " + result2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("��ʱ:" + (endTime2 - startTime2) + "ms");

    }

}