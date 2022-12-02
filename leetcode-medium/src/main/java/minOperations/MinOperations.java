package minOperations;

/**
 * @author jiaoxian
 * @name minOperations
 * @date 2022/12/2 10:45
 * @description leetCode-1769: 移动所有球到每个盒子所需的最小操作数
 */
public class MinOperations {

    /**
     * @description
     * @author jiaoxian
     * @date 2022/12/2 10:46
     * @param boxes 入参
     * @return int[]
     */
    public int[] minOperations(String boxes) {
        // 字符串长度
        int length = boxes.length();
        // 结果数组
        int[] result = new int[length];
        // 双层循环进行处理, 外层循环控制循环次数
        // 内层循环计算当前位置左右两边的小球移动到当前盒子的操作数
        for (int i = 0; i < length; i++) {
            // 计算当前盒子左边的小球移动到当前位置所需要的次数
            for (int j = 0; j < i; j++) {
                // 如果当前位置上有小球, 计算所需要的操作数
                if (boxes.charAt(j) == '1') {
                    int count = i - j;
                    result[i] += count;
                }
            }
            // 计算当前盒子右边的小球移动到当前位置所需要的次数
            for (int k = i + 1; k < length; k++) {
                // 如果当前位置上有小球, 计算所需要的操作数
                if (boxes.charAt(k) == '1') {
                    int count = k - i;
                    result[i] += count;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String boxes = "110";
        MinOperations minOperations = new MinOperations();
        int[] result = minOperations.minOperations(boxes);
        System.out.println(result);
    }

}
