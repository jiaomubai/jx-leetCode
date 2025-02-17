package trainingPlan;

/**
 * @ClassName: TrainingPlan
 * @Description: leetCode-LCR 139:训练计划 I
 * @Author: jiaoxian
 * @Date: 2025-02-07 16:54:51
 * @Version: 1.0
 **/

public class TrainingPlan {

    public int[] trainingPlan(int[] actions) {
        int i = 0, j = actions.length - 1;
        while (i < j) {
            // i 为奇数, j 为偶数, 则 i++, j--
            if (actions[i] % 2 == 1 && actions[j] % 2 == 0) {
                i++;
                j--;
                continue;
            }
            // i 为偶数, j 为奇数, 则 交换, 并且 i++, j--
            if (actions[i] % 2 == 0 && actions[j] % 2 == 1) {
                int temp = actions[i];
                actions[i] = actions[j];
                actions[j] = temp;
                i++;
                j--;
                continue;
            }
            // i 为奇数, i++
            if (actions[i] % 2 == 1) {
                i++;
            }
            // j 为偶数, j--
            if (actions[j] % 2 == 0) {
                j--;
            }

        }
        return actions;
    }

    public static void main(String[] args) {
        int[] actions = new int[]{1,2,3,4,5,6,9,10};
        System.out.println(new TrainingPlan().trainingPlan(actions));
    }

}
