package maxArea;

/**
 * @ClassName: maxArea
 * @Author: jiaoxian
 * @Date: 2022/5/20 21:03
 * @Description: leetCode-11: 盛最多水的容器
 */
public class maxArea {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            // 左指针的值
            int iValue = height[i];
            // 右指针的值
            int jValue = height[j];
            // 当前左右指针围成的区域的面积
            int currentArea = Math.min(iValue, jValue) * (j - i);
            maxArea = Math.max(maxArea, currentArea);
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

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println(result);
    }

}
