package findContentChildren;

import java.util.Arrays;

/**
 * @ClassName: FindContentChildren
 * @Description: leetCode-455: 分发饼干
 * @Author: jiaoxian
 * @Date: 2022/10/8 15:17
 **/
public class FindContentChildren {

    // 暴力解法
    // 对于每块饼干 j, 其大小为 s[j], 对于每个孩子 i, 其胃口大小为 g[i], 只有当 s[j] ≥ g[i] 的时候, 我们才会认为饼干 j 可以使孩子 i 得到满足
    // 那么暴力解法就为: 对 s[] 和 g[] 进行排序, 然后遍历统计 s[j] ≥ g[i] 的数量
    // 当然, 暴力循环的时候可以先让孩子找饼干, 即先满足胃口较小的孩子, 也可以先让饼干找孩子, 即先找到最大的饼干可以满足的孩子
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        // 先匹配胃口较小的孩子
//        for (int j = 0; result < g.length && j < s.length; j++ ) {
//            if (g[result] <= s[j]) {
//                result++;
//            }
//        }
        // 先匹配尺寸较大的饼干
        int j = s.length - 1;
        for (int i = g.length - 1; i >= 0 && j >= 0; i--) {
            if (g[i] <= s[j]) {
                result++;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{3};
        System.out.println(findContentChildren.findContentChildren(g, s));
    }

}
