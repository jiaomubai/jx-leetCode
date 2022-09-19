package totalMoney;

/**
 * @ClassName: TotalMoney
 * @Description: leetCode-1716: �����������е�Ǯ
 * @Author: jiaoxian
 * @Date: 2022/9/19 16:10
 **/
public class TotalMoney {

    // ����, ÿһ�ܴ��Ǯ���ǹ̶���, ��򵥵ľ����и�ö��ֱ�Ӳ�ѯ
    // ���߳�ʼ����һ�ܴ��ǮΪ 28, ��ô�ڶ��ܴ��Ǯ�ȵ�һ�ܴ��Ǯ�� 7, �����ܱȵڶ��ܴ��Ǯ�� 7 ......
    // �Դ�����, �� n �ܴ��Ǯ�ȵ� n - 1 �ܴ��Ǯ�� 7
    public int totalMoney(int n) {
        int total = 0;
        // ����������
        int fullWeek = n / 7;
        // ʣ������
        int othersDays = n - fullWeek * 7;
        // �������һ��
        if (fullWeek == 0 && othersDays > 0) {
            for (int i = 1; i <= othersDays; i++) {
                total += i;
            }
            return total;
        }
        // ������ڵ���һ��, ��ô�����͵��� 28 * fullWeek + (1 + 2 + 3 + ...... + fullWeek - 1) * 7
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
