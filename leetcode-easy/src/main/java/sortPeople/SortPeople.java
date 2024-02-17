//package sortPeople;
//
//import util.ArraysUtil;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName: SortPeople
// * @Description: leetCode-6188: ���������
// * @Author: jiaoxian
// * @Date: 2022/9/26 11:14
// **/
//public class SortPeople {
//
//    // ��ϣ�� + ����
//    public String[] sortPeople(String[] names, int[] heights) {
//        int length = heights.length;
//        String[] result = new String[length];
//        // �� name �� height �Ķ�Ӧ��ϵ�洢�� hashMap ��, key Ϊ���, value Ϊ����
//        Map<Integer, String> hashMap = new HashMap<>();
//        for (int i = 0; i < heights.length; i++) {
//            // ��Ϊ heights[] �� names[] �е�Ԫ�ض�������ͬ, ��ζ��û����ͬ��ߵ���, Ҳû����ͬ��������
//            hashMap.put(heights[i], names[i]);
//        }
//        // ��ԭ heights[] ���������������
//        Arrays.sort(heights);
//        // ������� heights[] ����, ���� hashMap �ж�ȡ��Ӧ�� value
//        for (int i = length - 1; i >= 0; i--) {
//            result[length - i - 1] = hashMap.get(heights[i]);
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        SortPeople sortPeople = new SortPeople();
//        String[] names = {"A", "C", "D", "B", "G", "E"};
//        int[] heights = {177, 176, 180, 159, 168, 170};
//        String[] result = sortPeople.sortPeople(names, heights);
//        ArraysUtil.commonDisplay(result);
//    }
//
//}
