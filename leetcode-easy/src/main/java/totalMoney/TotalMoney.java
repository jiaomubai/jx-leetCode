package totalMoney;

/**
 * @ClassName: TotalMoney
 * @Description: leetCode-1716: 计算力扣银行的钱
 * @Author: jiaoxian
 * @Date: 2022/9/19 16:10
 **/
public class TotalMoney {

    // 首先, 每一周存的钱都是固定的, 最简单的就是列个枚举直接查询
    // 或者初始化第一周存的钱为 28, 那么第二周存的钱比第一周存的钱多 7, 第三周比第二周存的钱多 7 ......
    // 以此类推, 第 n 周存的钱比第 n - 1 周存的钱多 7
    public int totalMoney(int n) {
        int total = 0;
        // 计算整周数
        int fullWeek = n / 7;
        // 剩余天数
        int othersDays = n - fullWeek * 7;
        // 如果不足一周
        if (fullWeek == 0 && othersDays > 0) {
            for (int i = 1; i <= othersDays; i++) {
                total += i;
            }
            return total;
        }
        // 如果大于等于一周, 那么总数就等于 28 * fullWeek + (1 + 2 + 3 + ...... + fullWeek - 1) * 7
        for (int i = 0; i < fullWeek; i++) {
            total = total + 28 + i * 7;
        }
        if (othersDays > 0) {
            for (int i = 1; i <= othersDays; i++) {
                total = total + i + fullWeek;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        TotalMoney totalMoney = new TotalMoney();
        System.out.println(totalMoney.totalMoney(365));
    }

}
