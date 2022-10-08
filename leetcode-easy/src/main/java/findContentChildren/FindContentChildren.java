package findContentChildren;

import java.util.Arrays;

/**
 * @ClassName: FindContentChildren
 * @Description: leetCode-455: �ַ�����
 * @Author: jiaoxian
 * @Date: 2022/10/8 15:17
 **/
public class FindContentChildren {

    // �����ⷨ
    // ����ÿ����� j, ���СΪ s[j], ����ÿ������ i, ��θ�ڴ�СΪ g[i], ֻ�е� s[j] �� g[i] ��ʱ��, ���ǲŻ���Ϊ���� j ����ʹ���� i �õ�����
    // ��ô�����ⷨ��Ϊ: �� s[] �� g[] ��������, Ȼ�����ͳ�� s[j] �� g[i] ������
    // ��Ȼ, ����ѭ����ʱ��������ú����ұ���, ��������θ�ڽ�С�ĺ���, Ҳ�������ñ����Һ���, �����ҵ����ı��ɿ�������ĺ���
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        // ��ƥ��θ�ڽ�С�ĺ���
//        for (int j = 0; result < g.length && j < s.length; j++ ) {
//            if (g[result] <= s[j]) {
//                result++;
//            }
//        }
        // ��ƥ��ߴ�ϴ�ı���
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
