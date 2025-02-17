package assignElements;

import java.util.Arrays;

/**
 * @ClassName: AssignElements
 * @Description: leetCode-3447:将元素分配给有约束条件的组
 * @Author: jiaoxian
 * @Date: 2025-02-10 17:29:41
 * @Version: 1.0
 **/

public class AssignElements {

    public int[] assignElements(int[] groups, int[] elements) {
        for (int i = 0; i < groups.length; i++) {
            boolean flag = false;
            for (int j = 0; j < elements.length; j++) {
                if (groups[i] % elements[j] == 0) {
                    groups[i] = j;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                groups[i] = -1;
            }
        }
        return groups;
    }

    // 设 groups 中的最大值为 mx。我们直接预处理 1,2,3,…,mx 中的每个数能被哪个 elements[i] 整除。如果有多个相同的 elements[i]，只考虑最左边的那个。
    // 从左到右遍历 elements，设 x=elements[i]。枚举 x 的倍数 y=x,2x,3x,⋯，标记 y 可以被下标为 i 的元素整除，记作 target[y]=i。已标记的数字不再重复标记。由于我们是从左到右遍历的，这可以保证如果有多个数字都是 y 的因子，我们只会记录最左边的下标。
    // 注意：如果我们之前遍历过 x 的因子 d，那么不用枚举 x 的倍数，因为这些数必然已被 d 标记。例如 elements=[2,4]，由于 4 的倍数一定都是偶数（2 的倍数），所以 4 的倍数一定都被 2 标记，所以无需枚举 4 的倍数。
    // 这也保证了每个数 x 我们只会循环枚举其倍数一次，不会在 elements=[2,2,2,…,2] 这种数据下退化成暴力。
    public int[] assignElements2(int[] groups, int[] elements) {
        int mx = 0;
        for (int x : groups) {
            mx = Math.max(mx, x);
        }
        int[] target = new int[mx + 1];
        Arrays.fill(target, -1);

        for (int i = 0; i < elements.length; i++) {
            int x = elements[i];
            if (x > mx || target[x] >= 0) { // x 及其倍数一定已被标记，跳过
                continue;
            }
            for (int y = x; y <= mx; y += x) { // 枚举 x 的倍数 y
                if (target[y] < 0) { // 没有标记过
                    target[y] = i; // 标记 y 可以被 x 整除（记录 x 的下标）
                }
            }
        }

        // 回答询问
        for (int i = 0; i < groups.length; i++) {
            groups[i] = target[groups[i]]; // 原地修改
        }
        return groups;
    }

    public static void main(String[] args) {
        int[] groups = {8,4,4,2,3};
        int[] elements = {4,2};
        System.out.println(new AssignElements().assignElements2(groups, elements));
    }

}
