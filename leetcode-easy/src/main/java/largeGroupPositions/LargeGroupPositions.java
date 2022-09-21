package largeGroupPositions;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LargeGroupPositions
 * @Description: leetCode-830: �ϴ�����λ��
 * @Author: jiaoxian
 * @Date: 2022/9/20 16:38
 **/
public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> resultList = new ArrayList();
        if (s.length() < 3) {
            return resultList;
        }
        int n = s.length();
        int start = 0;
        int length = 1;
        char startChar = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == startChar) {
                // �����ǰ�ַ�����һ���ַ���ͬ, ���¼���ϴ����
                ++length;
            } else {
                // �����ǰ�ַ�����һ���ַ������
                // �ж� end �� start �ĳ���, ���Ƿ���Ҫ��¼�����ؽ��
                if (length >= 3) {
                    List<Integer> currentList = new ArrayList<>();
                    currentList.add(start);
                    currentList.add(i - 1);
                    resultList.add(currentList);
                }
                // ��ֵ start = i
                start = i;
                startChar = s.charAt(i);
                length = 1;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        LargeGroupPositions largeGroupPositions = new LargeGroupPositions();
        List<List<Integer>> resultList = largeGroupPositions.largeGroupPositions("abcdddeeeeaabbbcd");
        System.out.println();
    }

}
