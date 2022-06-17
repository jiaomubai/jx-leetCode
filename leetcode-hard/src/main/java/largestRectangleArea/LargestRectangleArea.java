package largestRectangleArea;

/**
 * @ClassName: LargestRectangleArea
 * @Author: jiaoxian
 * @Date: 2022/6/9 18:53
 * @Description: TODO
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        if (heights.length == 2) {
            if (heights[0] == 0 ) {
                return heights[1];
            } else if (heights[1] == 0) {
                return heights[0];
            } else {
                return Math.min(heights[0], heights[1]) * 2;
            }
        }
        int maxArea = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            // 左指针的值
            int iValue = heights[i];
            // 右指针的值
            int jValue = heights[j];
            // 当前左右指针围成的区域的面积
            int currentArea = calculateArea(i,  j, heights);
            if (heights[i] == 0) {
                maxArea = heights[j];
            } else if (heights[j] == 0) {
                maxArea = heights[i];
            } else {
                maxArea = Math.max(maxArea, currentArea);
            }
            System.out.println(maxArea);
            // 改变短板, 左边短就向右移, 右边短就向左移, 左右一样则左右随机移动
            if (iValue <= jValue) {
                i++;
            }
            if (iValue > jValue) {
                j--;
            }
        }
        return maxArea;
    }

    private int calculateArea(int i, int j, int[] heights) {
//        if (heights[i] == 0 ) {
//            return heights[j];
//        } else if (heights[j] == 0) {
//            return heights[i];
//        } else {
            return Math.min(heights[i], heights[j]) * (j - i);
//        }

    }

    public static void main(String[] args) {
        int[] heights = {2,1,2};
        System.out.println(new LargestRectangleArea().largestRectangleArea(heights));
    }

}
