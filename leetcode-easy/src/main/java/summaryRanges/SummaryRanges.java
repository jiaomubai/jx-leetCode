package summaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SummaryRanges
 * @Author: jiaoxian
 * @Date: 2022/5/1 18:22
 * @Description: leetCode-228: 汇总区间
 */
public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        int size = nums.length;
        if (size == 1) {
            resultList.add(String.valueOf(nums[0]));
            return resultList;
        }
        if (size == 0) {
            return resultList;
        }
        int i = 0;
        String leftRange = "";
        while (i < size - 1) {
            if (nums[i] + 1 == nums[i + 1]) {
                if ("".equals(leftRange)) {
                    leftRange = String.valueOf(nums[i]);
                }
            } else {
                String result = "";
                if ("".equals(leftRange)) {
                    result = String.valueOf(nums[i]);
                } else {
                    result = leftRange + "->" + nums[i];
                }
                resultList.add(result);
                leftRange = "";
            }
            i++;
        }
        if ("".equals(leftRange)) {
            resultList.add(String.valueOf(nums[nums.length - 1]));
        } else {
            resultList.add(leftRange + "->" + nums[nums.length - 1]);
        }
        return resultList;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i){
            if(!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)) {
                if (sb.length() > 0) {
                    sb.append("->");
                }
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,8};
        System.out.println(summaryRanges2(nums));
    }

}
