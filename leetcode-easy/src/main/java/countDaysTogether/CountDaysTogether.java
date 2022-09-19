package countDaysTogether;

/**
 * @ClassName: CountDaysTogether
 * @Description: leetCode-2409: ͳ�ƹ�ͬ�ȹ���������
 * @Author: jiaoxian
 * @Date: 2022/9/19 11:12
 **/
public class CountDaysTogether {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // 1. ��ȡ Alice �� Bob �н�������˵�ʱ��
        int[] laterArrive = getLaterArrive(arriveAlice, arriveBob);
        // 2. ��ȡ Alice �� Bob �н����뿪���˵�ʱ��
        int[] earlierLeave = getEarlierLeave(leaveAlice, leaveBob);
        // 3. ��������ʱ���
        int diffDays = getDiffDays(laterArrive, earlierLeave);
        return diffDays;
    }

    /**
     * @Author jiaoxian
     * @Description getDiffDays
     * @Date 2022/9/19 13:59
     * @param date1: ������ʱ��
     * @param date2: �����뿪ʱ��
     * @return int
     **/
    private int getDiffDays(int[] date1, int[] date2) {
        int countDays = 0;
        int arriveDateMonth = date1[0];
        int leaveDateMonth = date2[0];
        if (arriveDateMonth > leaveDateMonth) {
            // �����������·� > �����뿪���·�, return 0
            return countDays;
        }
        int diffMonth = leaveDateMonth - arriveDateMonth;
        if (diffMonth == 0) {
            // �����ͬһ��, �����ж��뿪ʱ���Ƿ����ڵ���ʱ��
            int arriveDateDay = date1[1];
            int leaveDateDay = date2[1];
            if (leaveDateDay < arriveDateDay) {
                // ����뿪ʱ�����ڵ���ʱ��, return 0
                return countDays;
            }
            countDays += date2[1] - date1[1] + 1;
        } else {
            // �������ͬһ��
            int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            // ��ʼ��
            countDays += days[arriveDateMonth] - date1[1] + 1;
            // ������
            countDays += date2[1];
            for (int i = arriveDateMonth + 1; i < leaveDateMonth; i++) {
                countDays += days[i];
            }
        }
        return countDays;
    }

    /**
     * @Author jiaoxian
     * @Description getEarlierLeave �������� "MM-dd" ���͵�ʱ���ȡ�����ʱ��
     * @Date 2022/9/19 11:51
     * @param leaveDate1:
     * @param leaveDate2:
     * @return int[]
     **/
    private int[] getEarlierLeave(String leaveDate1, String leaveDate2) {
        int[] leaveAlice = getMonthAndDay(leaveDate1);
        int[] leaveBob = getMonthAndDay(leaveDate2);
        if (leaveAlice[0] < leaveBob[0]) {
            // ��� Alice ���뿪���·ݱ� Bob �뿪���·�С, ��֤���뿪�����Ϊ Alice
            return leaveAlice;
        } else if (leaveAlice[0] > leaveBob[0]) {
            // ��� Alice �뿪���·ݱ� Bob �뿪���·ݴ�, ��֤���뿪�����Ϊ Bob
            return leaveBob;
        } else {
            // ��� Alice �뿪���·��� Bob �뿪���·�һ��, ��Ƚ�����
            if (leaveAlice[1] > leaveBob[1]) {
                // ��� Alice �뿪�����ڱ� Bob �뿪�����ڴ�, ��֤�� Bob �뿪�Ľ���
                return leaveBob;
            } else {
                // ��� Alice �뿪�����ڱ� Bob �뿪������С, ���������뿪������һ��, ����Ϊ Alice �뿪�Ľ���
                return leaveAlice;
            }
        }
    }

    /**
     * @Author jiaoxian
     * @Description getLaterArrive �������� "MM-dd" ���͵�ʱ���ȡ�����ʱ��
     * @Date 2022/9/19 11:33
     * @param arriveDate1:
     * @param arriveDate2:
     * @return int[]
     **/
    private int[] getLaterArrive(String arriveDate1, String arriveDate2) {
        int[] arriveAlice = getMonthAndDay(arriveDate1);
        int[] arriveBob = getMonthAndDay(arriveDate2);
        if (arriveAlice[0] < arriveBob[0]) {
            // ��� Alice ������·ݱ� Bob ������·�С, ��֤����������Ϊ Bob
            return arriveBob;
        } else if (arriveAlice[0] > arriveBob[0]) {
            // ��� Alice ������·ݱ� Bob ������·ݴ�, ��֤����������Ϊ Alice
            return arriveAlice;
        } else {
            // ��� Alice ������·��� Bob ������·�һ��, ��Ƚ�����
            if (arriveAlice[1] > arriveBob[1]) {
                // ��� Alice ��������ڱ� Bob ��������ڴ�, ��֤�� Alice ����Ľ���
                return arriveAlice;
            } else {
                // ��� Alice ��������ڱ� Bob ���������С, �������ߵ��������һ��, ����Ϊ Bob ����Ľ���
                return arriveBob;
            }
        }
    }

    /**
     * @Author jiaoxian
     * @Description getMonthAndDay ���� "MM-dd" ��ʽ���ַ�����ȡ�·ݺ�����
     * @Date 2022/9/19 11:35
     * @param date:
     * @return int[] �±� 0 ���·�, �±� 1 ������
     **/
    private int[] getMonthAndDay(String date) {
        int[] monthAndDay = new int[2];
        int month = getMonth(date);
        int day = getDay(date);
        monthAndDay[0] = month;
        monthAndDay[1] = day;
        return monthAndDay;
    }

    /**
     * @Author jiaoxian
     * @Description getMonth ���� "MM-dd" ��ʽ���ַ�����ȡ����
     * @Date 2022/9/19 11:14
     * @param date:
     * @return int
     **/
    private int getMonth(String date) {
        String month = date.substring(0, 2);
        if (month.startsWith("0")) {
            return Integer.parseInt(month.substring(1));
        }
        return Integer.parseInt(month);
    }

    /**
     * @Author jiaoxian
     * @Description getMonth ���� "MM-dd" ��ʽ���ַ�����ȡ����
     * @Date 2022/9/19 11:14
     * @param date:
     * @return java.lang.String
     **/
    private int getDay(String date) {
        String day = date.substring(3);
        if (day.startsWith("0")) {
            return Integer.parseInt(day.substring(1));
        }
        return Integer.parseInt(day);
    }

    public static void main(String[] args) {
        CountDaysTogether countDaysTogether = new CountDaysTogether();
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";
        System.out.println(countDaysTogether.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

}
