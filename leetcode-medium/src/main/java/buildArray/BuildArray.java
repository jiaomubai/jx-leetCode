package buildArray;

import util.ArraysUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BuildArray
 * @Description: leetCode-1441: 用栈操作构建数组
 * @Author: jiaoxian
 * @Date: 2022/10/20 17:34
 **/
public class BuildArray {

    public List<String> buildArray(int[] target, int n) {
        // 操作的对象是 1 到 n 按顺序排列的数字, 每次操作一个数字时, 如果它在 target 中, 则只需要将它 Push 入栈即可.
        // 如果不在 target 中, 需要先将其 Push 入栈, 紧接着 Pop 出栈.
        // 需要注意的是, 如果当前遍历的值已经大于 target[] 数组中的最大元素了, 那么就停止遍历, 即遍历终止的条件是 i <= Math.min(target[target.length - 1], n)

        List<String> resultList = new ArrayList<>();
        int maxTarget = Math.min(target[target.length - 1], n);
        for (int i = 1; i <= maxTarget; i++) {
            // 如果当前值不在 target[] 数组中, 则需要 "Push" 和 "Pop"
            if (!isExist(target, i)) {
                resultList.add("Push");
                resultList.add("Pop");
            } else {
                // 当前值在 target[] 数组中, 只需要 "Push"
                resultList.add("Push");
            }
        }
        return resultList;
    }


    public boolean isExist(int[] target, int n) {
        for (int value : target) {
            if (value == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] p=new int[]{2,1};
        ArraysUtil.displayIntArray(p);
//        BuildArray buildArray = new BuildArray();
//        int[] target = {1, 3};
//        System.out.println(buildArray.buildArray(target, 3));
    }

}
