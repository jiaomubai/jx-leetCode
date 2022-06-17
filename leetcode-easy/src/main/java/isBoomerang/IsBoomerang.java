package isBoomerang;

/**
 * @ClassName: IsBoomerang
 * @Author: jiaoxian
 * @Date: 2022/6/8 16:55
 * @Description:
 */
public class IsBoomerang {

    public boolean isBoomerang(int[][] points) {
        if (points.length != 3) {
            return false;
        }
        // 拿到每个点的横纵坐标
        int x1 = points[0][0];
        int x2 = points[1][0];
        int x3 = points[2][0];
        int y1 = points[0][1];
        int y2 = points[1][1];
        int y3 = points[2][1];
        if (x1 == x2 && x2 == x3) {
            // 斜率不存在且三点共线垂直于 x 轴时
            return false;
        }
        // 判断两条线段的斜率是否相等, 使用乘法计算, 避免除数为 0 的情况
        // k1 = (y1 - y2) / (x1 - x2); k2 = (y2 - y3) / (x2 - x3)
        // 两边同时乘以 (x1 - x2) * (x2 - x3), 得: (y1 - y2) * (x2 - x3) == (y2 - y3) * (x1 - x2)
        return (y1 - y2) * (x2 - x3) != (y2 - y3) * (x1 - x2);
    }

    private double calculateSlope(int[] point, int[] point1) {
        int x = point1[0] - point[0];
        int y = point1[1] - point[1];
        double slope = x / y;
        System.out.println("斜率为:" + slope);
        return slope;
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{7,7}};
        System.out.println(new IsBoomerang().isBoomerang(points));
    }

}
