package isPathCrossing;

/**
 * @ClassName: IsPathCrossing
 * @Description: leetCode-1496: �ж�·���Ƿ��ཻ
 * @Author: jiaoxian
 * @Date: 2022/9/29 14:05
 **/
public class IsPathCrossing {

    public boolean isPathCrossing(String path) {
        // �����ϱ����������Ҷ��涨: ��(N)������ֵ +2, ��(E)������ֵ +1, ����(S)������ֵ -2, ����(W)������ֵ -1
        // ���� path, ʹ�� result1 ��¼�ϱ������·����, result2 ��¼���������·����, ����ϱ�������߶��������·���͵��� 0, ��֤��·�����ཻ, ֱ�ӷ��� true
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                result1 += 2;
                if (result1 == 0) {
                    return true;
                }
            } else if (c == 'E'){
                result2 += 1;
                if (result2 == 0) {
                    return true;
                }
            } else if (c == 'S') {
                result1 -= 2;
                if (result1 == 0) {
                    return true;
                }
            } else {
                result2 -= 1;
                if (result2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPathCrossing isPathCrossing = new IsPathCrossing();
        System.out.println(isPathCrossing.isPathCrossing("ES"));
    }

}
