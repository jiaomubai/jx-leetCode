package minEatingSpeed;

import java.util.Arrays;

/**
 * @ClassName: MinEatingSpeed
 * @Author: jiaoxian
 * @Date: 2022/6/7 09:00
 * @Description:
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;
        Arrays.sort(piles);
        if (length == h ) {
            return piles[length - 1];
        }
        int left = 1;
        int right = piles[length - 1];
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int totalHours = countHours(piles, middle);
            System.out.println("left = " + left + ", right = " + right + ", middle = " + middle + ", totalHours = " + totalHours);
            if (totalHours > h) {
                // 如果实际计算的时间大于入参 h，则右移左区间
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;

    }

    private int countHours(int[] piles, int middle) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += pile % middle == 0 ? pile / middle : pile / middle + 1;
        }
        return totalHours;
    }

    public static void main(String[] args) {
        int[] piles = {312884470};
        int h = 312884469;
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;
        System.out.println(new MinEatingSpeed().minEatingSpeed(piles, h));
    }

}
