package distanceBetweenBusStops;

/**
 * @ClassName: DistanceBetweenBusStops
 * @Description: leetCode-1184: 公交站间的距离
 * @Author: jiaoxian
 * @Date: 2022/9/14 14:50
 **/
public class DistanceBetweenBusStops {

    // 双指针法
    // 使用两个指针 i 和 j 去遍历公交站, 并规定 i 从 start 到 destination 正向遍历, j 从 start 到 destination 逆向遍历
    // 另使用两个变量去分别记录正向遍历的距离和逆向遍历的距离
    // 取两个距离的最小值即可
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int i = start;
        int j = start;
        // 正向距离和
        int sumAsc = 0;
        // 逆向距离和
        int sumDesc = 0;
        while (i != destination) {
            sumAsc += distance[i];
            if (++i == distance.length) {
                i = 0;
            }
        }
        while (j != destination) {
            if (--j < 0) {
                j = distance.length - 1;
            }
            sumDesc += distance[j];
        }
        int result = Math.min(sumAsc, sumDesc);
        return result;
    }

    public static void main(String[] args) {
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        int[] distance = {1, 2, 3, 4};
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(distance, 0, 1));
    }

}
