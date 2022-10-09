package hardestWorker;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HardestWorker
 * @Description: leetCode-6200: 处理用时最长的那个任务的员工
 * @Author: jiaoxian
 * @Date: 2022/10/9 16:09
 **/
public class HardestWorker {

    // 借助中间数组 time[] 来记录每个任务需要花费的时间
    // 找到最长用时的任务 id
    // 根据任务 id 找到处理此任务的员工 id

    public int hardestWorker(int n, int[][] logs) {
        // logs[i][0]-处理 i 任务的员工
        // logs[i][1]-处理 i 任务需要花费的时间

        // 任务数
        int worksCount = logs.length;
        int[] time = new int[worksCount];
        time[0] = logs[0][1];
        for (int i = 1; i < worksCount; i++) {
            time[i] = logs[i][1] - logs[i - 1][1];
        }
        // 找到最长用时的任务 id
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
        // 根据最长用时的任务 id, 找到处理此任务的员工
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
