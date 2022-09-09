package minOperations;

/**
 * @ClassName: MinOperations
 * @Description: leetCode-1598: �ļ��в�����־�Ѽ���
 * @Author: jiaoxian
 * @Date: 2022/9/9 14:34
 **/
public class MinOperations {

    // �������Ϊ���㵱ǰ�����ļ��е����,
    // ���ļ������ڵĲ��Ϊ��0��, ��ص����ļ�������Ҫ�Ĳ�������Ϊ0��
    // ÿִ��һ�� "x/" ����, ��ǰ�����ļ��е���� depth += 1, ��ص����ļ�������Ҫ�Ĳ�����Ϊ depth
    // ÿִ��һ�� "../" ����, ��������һ��(������Ŀ¼), Ҳ���ǵ�ǰ�����ļ��е���� depth -= 1, ����Ѿ�λ�����ļ�����, �� depth ���ֲ���
    // ÿִ��һ�� "./" ����, ����ͣ���ڵ�ǰ�ļ���, ����� depth ���ֲ���
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            // ͣ���ڵ�ǰ�ļ���, ��ȱ��ֲ���
            if ("./".equals(log)) {
                continue;
            } else if ("../".equals(log)) {
                // �ص���һ��, ��� - 1
                if (depth > 0) {
                    depth--;
                }
            } else {
                // ִ�� "x/" ����, ��� + 1
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
