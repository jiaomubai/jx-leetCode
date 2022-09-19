package hanota;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Hanota
 * @Description: leetCode-08.06: ��ŵ������
 * @Author: jiaoxian
 * @Date: 2022/9/14 17:01
 **/
public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        // �� A ���� n - 1 ��ͨ�� C �ƶ��� B
        move(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        // �� B ���� n - 1 ��ͨ�� A �ƶ��� C
        move(n - 1, B, A, C);
    }

    public static void main(String[] args) {
        Hanota hanota = new Hanota();
        List<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(2);
        hanota.hanota(A, new ArrayList<>(), new ArrayList<>());
    }

}
