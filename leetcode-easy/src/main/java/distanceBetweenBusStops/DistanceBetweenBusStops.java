package distanceBetweenBusStops;

/**
 * @ClassName: DistanceBetweenBusStops
 * @Description: leetCode-1184: ����վ��ľ���
 * @Author: jiaoxian
 * @Date: 2022/9/14 14:50
 **/
public class DistanceBetweenBusStops {

    // ˫ָ�뷨
    // ʹ������ָ�� i �� j ȥ��������վ, ���涨 i �� start �� destination �������, j �� start �� destination �������
    // ��ʹ����������ȥ�ֱ��¼��������ľ������������ľ���
    // ȡ�����������Сֵ����
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int i = start;
        int j = start;
        // ��������
        int sumAsc = 0;
        // ��������
        int sumDesc = 0;
        while (i != destination) {
            sumAsc += distance[i];
            if (++i == distance.length) {
                i = 0;
            }
        }
        while (j != destination) {
            if (--j < 0) {
                j = distance.length - 1;
            }
            sumDesc += distance[j];
        }
        int result = Math.min(sumAsc, sumDesc);
        return result;
    }

    public static void main(String[] args) {
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        int[] distance = {1, 2, 3, 4};
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(distance, 0, 1));
    }

}
