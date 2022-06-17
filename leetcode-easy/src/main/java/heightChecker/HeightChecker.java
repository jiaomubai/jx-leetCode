package heightChecker;

import java.util.Arrays;

/**
 * @ClassName: HeightChecker
 * @Author: jiaoxian
 * @Date: 2022/6/13 08:52
 * @Description: leetCode-1051: 高度检查器
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        // 开辟新数据, 排序, 比较新数组数据与原数组数据不同的数量
        int[] tempArray = Arrays.copyOf(heights, heights.length);
        Arrays.sort(tempArray);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (tempArray[i] != heights[i]) {
                count++;
            }
        }
        int rerult = 0 & ~((1 << 29) - 1);
        System.out.println(rerult);
        return count;
    }

    public static void main(String[] args) {
        int[] heights = {5,1,2,3,4,6};
        System.out.println(new HeightChecker().heightChecker(heights));
    }

}
