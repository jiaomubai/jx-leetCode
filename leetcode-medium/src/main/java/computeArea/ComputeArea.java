package computeArea;

/**
 * @ClassName: ComputeArea
 * @Author: jiaoxian
 * @Date: 2022/6/9 17:08
 * @Description: leetCode-223: 矩形面积
 */
public class ComputeArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        if (bx1 >= ax2 || by1 >= ay2 || bx2 <= ax1 || by2 <= ay1) {
            // 无重叠
            return area1 + area2;
        }
        int ax1_ = Math.max(ax1, bx1);
        int ay1_ = Math.max(ay1, by1);
        int ax2_ = Math.min(ax2, bx2);
        int ay2_ = Math.min(ay2, by2);
        int area3 = (ax2_ - ax1_) * (ay2_ - ay1_);
        return area1 + area2 - area3;
    }

    public static void main(String[] args) {
        System.out.println(new ComputeArea().computeArea(-3,0,3,4,0,-1,9,2));
    }

}
