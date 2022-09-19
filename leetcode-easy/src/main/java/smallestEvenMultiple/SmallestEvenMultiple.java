package smallestEvenMultiple;

/**
 * @ClassName: SmallestEvenMultiple
 * @Description: leetCode-2413: ��Сż����
 * @Author: jiaoxian
 * @Date: 2022/9/19 10:19
 **/
public class SmallestEvenMultiple {

    // ����һ�������� n, ���� 2 �� n ����С������(������).

    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            // ��� n ��ż��, ��ֱ�ӷ��� n
            return n;
        }
        // ��� n ������, ���� n * 2
        return 2 * n;
    }

    public static void main(String[] args) {
        SmallestEvenMultiple smallestEvenMultiple = new SmallestEvenMultiple();
        System.out.println(smallestEvenMultiple.smallestEvenMultiple(5));
    }

}
