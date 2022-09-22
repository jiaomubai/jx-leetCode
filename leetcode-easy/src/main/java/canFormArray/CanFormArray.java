package canFormArray;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CanFormArray
 * @Description: leetCode-1640: �ܷ������γ�����
 * @Author: jiaoxian
 * @Date: 2022/9/22 17:16
 **/
public class CanFormArray {

    // ��Ϊ���� arr ��ÿ������������ͬ, �� pieces �е�����Ҳ������ͬ, �������ǿ���ͨ�� arr ���̶� pieces �ķ���.
    // ʹ�� HashMap ����¼ pieces �и����������Ԫ���������±�Ķ�Ӧ��ϵ.
    // ��ѭ������ pieces, �� pieces ��ÿ��Ԫ��(����)�ĵ�һ��Ԫ����Ϊ Map �� key, ÿ��Ԫ�ص��±���Ϊ value �洢�� HashMap ��
    // Ȼ��ȥ�������� arr, ������� arr ��Ԫ�ز������� HashMap ��, ��ֱ�� return false
    // �������, ���ҵ���Ӧ������ pieces[j], Ȼ������ arr[i] ��֮����������бȽ�
    // �ڱȽϹ�����, ����ж���Ȳ�����, ��ֱ�ӷ��� false, �������ȵĻ�, �� i ��Ӧ������ƶ� pieces[j].length λ.
    // ȫ�� pieces ��ƥ��ɹ���, ���� true.

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int m = pieces.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        // ���� pieces, �洢�� hashMap
        for (int i = 0; i < m; i++) {
            hashMap.put(pieces[i][0], i);
        }
        // ���� arr, �ж��Ƿ������ hashMap ��, ���ж��Ƿ�������Ӧ����
        for (int i = 0; i < n;) {
            if (!hashMap.containsKey(arr[i])) {
                return false;
            }
            int j = hashMap.get(arr[i]);
            int len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }
            i = i + len;
        }
        return true;
    }

    public static void main(String[] args) {
        CanFormArray canFormArray = new CanFormArray();
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        System.out.println(canFormArray.canFormArray(arr, pieces));
    }

}
