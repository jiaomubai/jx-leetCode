package hardestWorker;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HardestWorker
 * @Description: leetCode-6200: ������ʱ����Ǹ������Ա��
 * @Author: jiaoxian
 * @Date: 2022/10/9 16:09
 **/
public class HardestWorker {

    // �����м����� time[] ����¼ÿ��������Ҫ���ѵ�ʱ��
    // �ҵ����ʱ������ id
    // �������� id �ҵ�����������Ա�� id

    public int hardestWorker(int n, int[][] logs) {
        // logs[i][0]-���� i �����Ա��
        // logs[i][1]-���� i ������Ҫ���ѵ�ʱ��

        // ������
        int worksCount = logs.length;
        int[] time = new int[worksCount];
        time[0] = logs[0][1];
        for (int i = 1; i < worksCount; i++) {
            time[i] = logs[i][1] - logs[i - 1][1];
        }
        // �ҵ����ʱ������ id
        int maxTime = time[0];
        List<Integer> maxTimeIdList = new ArrayList<>();
        maxTimeIdList.add(0);
        for (int i = 1; i < worksCount; i++) {
            if (maxTime < time[i]) {
                maxTime = time[i];
                maxTimeIdList.clear();
                maxTimeIdList.add(i);
            } else if (maxTime == time[i]) {
                maxTimeIdList.add(i);
            }
        }
        // �������ʱ������ id, �ҵ�����������Ա��
        int minWorkerId = n;
        for (int i = 0; i < maxTimeIdList.size(); i++) {
           int wordId = maxTimeIdList.get(i);
           minWorkerId = Math.min(minWorkerId, logs[wordId][0]);
        }
        return minWorkerId;
    }

    public static void main(String[] args) {
        HardestWorker hardestWorker = new HardestWorker();
        int[][] logs = {{0, 10},
                        {1, 20}};
        System.out.println(hardestWorker.hardestWorker(20, logs));
    }

}
