package flipLights;

/**
 * @ClassName: FlipLights
 * @Description: leetCode-672: 灯泡开关II
 * @Author: jiaoxian
 * @Date: 2022/9/16 17:03
 **/
public class FlipLights {

    public int flipLights(int n, int presses) {
        //不按开关
        if (presses == 0) {
            return 1;
        }
        //特殊情况处理
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            //特殊情况
            return presses == 1 ? 3 : 4;
        } else {
            //n >= 3
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

    public static void main(String[] args) {
        FlipLights flipLights = new FlipLights();
        System.out.println(flipLights.flipLights(4, 4));
    }

    // 需要注意的是按压开关时并不是同一个开关按压 presses 次, 而是总共按压开关 presses 次, 也就意味着每次按压都可以是不同的开关

    // n = 1    presses = 1     result = 2
    // n = 2    presses = 1     result = 4

    // 灯泡数量                     按压开关次数(1)           按压开关次数(2)
    // 灯泡数量为 1 时, 初始状态为 [开], 编号为 1
    // 1号开关, 反转所有灯              [0]                     [1]
    // 2号开关, 反转偶数灯              [1]                     [1]
    // 3号开关, 反转奇数灯              [0]                     [0]
    // 4号开关, 反转3k+1灯              [0]                     [1]
    // 灯泡数量为 2 时, 初始状态为 [开, 开], 编号为 1、2
    // 1号开关, 反转所有灯              [00]                     [11](按两次 1 号开关)    [01](先按 1 号开关, 再按 2 号开关)[10](先按 1 号开关, 再按 3 号开关)    [10](先按 1 号开关, 再按 4 号开关)
    // 2号开关, 反转偶数灯              [10]                     [01](先按 2 号开关, 再按 1 号开关)   [11](按两次 2 号开关) [00](先按 2 号开关, 再按 3 号开关)    [00](先按 2 号开关, 再按 4 号开关)
    // 3号开关, 反转奇数灯              [01]                     [10](先按 3 号开关, 再按 1 号开关)   [00](先按 3 号开关, 再按 2 号开关)    [11](按两次 3 号开关) [11](先按 3 号开关, 再按 4 号开关)
    // 4号开关, 反转3k+1灯              [01]                     [10](先按 4 号开关, 再按 1 号开关)   [00](先按 4 号开关, 再按 2 号开关)    [11](先按 4 号开关, 再按 3 号开关) [11](按两次 4 号开关)

}
