package nearestValidPoint;

/**
 * @author jiaoxian
 * @name nearestValidPoint
 * @date 2022/12/1 17:39
 * @description leetCode-1779: 找到最近的有相同 X 或 Y 坐标的点
 */
public class NearestValidPoint {

    /**
     * @description
     * @author jiaoxian
     * @date 2022/12/1 17:41
     * @param x 横坐标
     * @param y 纵坐标
     * @param points 坐标组
     * @return int
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minIndex = points.length;
        int maxDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            // 当前点的横坐标
            int a = points[i][0];
            // 当前点的纵坐标
            int b = points[i][1];
            if (a == x || b == y) {
                // 如果当前点有效
                int distance = Math.abs(x - a) + Math.abs(y - b);
                if (distance < maxDistance) {
                    maxDistance = distance;
                    minIndex = i;
                }
            }

        }
        return minIndex == points.length ? -1 : minIndex;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 4}};
        NearestValidPoint nearestValidPoint = new NearestValidPoint();
        int result = nearestValidPoint.nearestValidPoint(3, 4, points);
        System.out.println(result);
    }

}
