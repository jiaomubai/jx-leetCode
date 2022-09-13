package minOperations;

/**
 * @ClassName: MinOperations
 * @Description: leetCode-1598: 文件夹操作日志搜集器
 * @Author: jiaoxian
 * @Date: 2022/9/9 14:34
 **/
public class MinOperations {

    // 可以理解为计算当前所在文件夹的深度,
    // 主文件夹所在的层次为第0层, 则回到主文件夹所需要的步数最少为0步
    // 每执行一次 "x/" 命令, 当前所在文件夹的深度 depth += 1, 则回到主文件夹所需要的步数就为 depth
    // 每执行一次 "../" 命令, 代表返回上一层(即父级目录), 也就是当前所在文件夹的深度 depth -= 1, 如果已经位于主文件夹下, 则 depth 保持不变
    // 每执行一次 "./" 命令, 代表停留在当前文件夹, 即深度 depth 保持不变
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            // 停留在当前文件夹, 深度保持不变
            if ("./".equals(log)) {
                continue;
            } else if ("../".equals(log)) {
                // 回到上一层, 深度 - 1
                if (depth > 0) {
                    depth--;
                }
            } else {
                // 执行 "x/" 命令, 深度 + 1
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
        System.out.println(minOperations.minOperations(logs));
    }

}
