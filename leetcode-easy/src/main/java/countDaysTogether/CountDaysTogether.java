package countDaysTogether;

/**
 * @ClassName: CountDaysTogether
 * @Description: leetCode-2409: 统计共同度过的日子数
 * @Author: jiaoxian
 * @Date: 2022/9/19 11:12
 **/
public class CountDaysTogether {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // 1. 获取 Alice 和 Bob 中较晚到达的人的时间
        int[] laterArrive = getLaterArrive(arriveAlice, arriveBob);
        // 2. 获取 Alice 和 Bob 中较早离开的人的时间
        int[] earlierLeave = getEarlierLeave(leaveAlice, leaveBob);
        // 3. 计算两个时间差
        int diffDays = getDiffDays(laterArrive, earlierLeave);
        return diffDays;
    }

    /**
     * @Author jiaoxian
     * @Description getDiffDays
     * @Date 2022/9/19 13:59
     * @param date1: 较晚到达时间
     * @param date2: 较早离开时间
     * @return int
     **/
    private int getDiffDays(int[] date1, int[] date2) {
        int countDays = 0;
        int arriveDateMonth = date1[0];
        int leaveDateMonth = date2[0];
        if (arriveDateMonth > leaveDateMonth) {
            // 如果较晚到达的月份 > 较早离开的月份, return 0
            return countDays;
        }
        int diffMonth = leaveDateMonth - arriveDateMonth;
        if (diffMonth == 0) {
            // 如果在同一月, 继续判断离开时间是否早于到达时间
            int arriveDateDay = date1[1];
            int leaveDateDay = date2[1];
            if (leaveDateDay < arriveDateDay) {
                // 如果离开时间早于到达时间, return 0
                return countDays;
            }
            countDays += date2[1] - date1[1] + 1;
        } else {
            // 如果不在同一月
            int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            // 开始月
            countDays += days[arriveDateMonth] - date1[1] + 1;
            // 结束月
            countDays += date2[1];
            for (int i = arriveDateMonth + 1; i < leaveDateMonth; i++) {
                countDays += days[i];
            }
        }
        return countDays;
    }

    /**
     * @Author jiaoxian
     * @Description getEarlierLeave 根据两个 "MM-dd" 类型的时间获取较早的时间
     * @Date 2022/9/19 11:51
     * @param leaveDate1:
     * @param leaveDate2:
     * @return int[]
     **/
    private int[] getEarlierLeave(String leaveDate1, String leaveDate2) {
        int[] leaveAlice = getMonthAndDay(leaveDate1);
        int[] leaveBob = getMonthAndDay(leaveDate2);
        if (leaveAlice[0] < leaveBob[0]) {
            // 如果 Alice 到离开的月份比 Bob 离开的月份小, 则证明离开较早的为 Alice
            return leaveAlice;
        } else if (leaveAlice[0] > leaveBob[0]) {
            // 如果 Alice 离开的月份比 Bob 离开的月份大, 则证明离开较早的为 Bob
            return leaveBob;
        } else {
            // 如果 Alice 离开的月份与 Bob 离开的月份一样, 则比较日期
            if (leaveAlice[1] > leaveBob[1]) {
                // 如果 Alice 离开的日期比 Bob 离开的日期大, 则证明 Bob 离开的较早
                return leaveBob;
            } else {
                // 如果 Alice 离开的日期比 Bob 离开的日期小, 或者两者离开的日期一样, 则认为 Alice 离开的较早
                return leaveAlice;
            }
        }
    }

    /**
     * @Author jiaoxian
     * @Description getLaterArrive 根据两个 "MM-dd" 类型的时间获取较晚的时间
     * @Date 2022/9/19 11:33
     * @param arriveDate1:
     * @param arriveDate2:
     * @return int[]
     **/
    private int[] getLaterArrive(String arriveDate1, String arriveDate2) {
        int[] arriveAlice = getMonthAndDay(arriveDate1);
        int[] arriveBob = getMonthAndDay(arriveDate2);
        if (arriveAlice[0] < arriveBob[0]) {
            // 如果 Alice 到达的月份比 Bob 到达的月份小, 则证明到达较晚的为 Bob
            return arriveBob;
        } else if (arriveAlice[0] > arriveBob[0]) {
            // 如果 Alice 到达的月份比 Bob 到达的月份大, 则证明到达较晚的为 Alice
            return arriveAlice;
        } else {
            // 如果 Alice 到达的月份与 Bob 到达的月份一样, 则比较日期
            if (arriveAlice[1] > arriveBob[1]) {
                // 如果 Alice 到达的日期比 Bob 到达的日期大, 则证明 Alice 到达的较晚
                return arriveAlice;
            } else {
                // 如果 Alice 到达的日期比 Bob 到达的日期小, 或者两者到达的日期一样, 则认为 Bob 到达的较晚
                return arriveBob;
            }
        }
    }

    /**
     * @Author jiaoxian
     * @Description getMonthAndDay 根据 "MM-dd" 格式的字符串提取月份和日期
     * @Date 2022/9/19 11:35
     * @param date:
     * @return int[] 下标 0 存月份, 下标 1 存日期
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
     * @Description getMonth 根据 "MM-dd" 格式的字符串获取日期
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
     * @Description getMonth 根据 "MM-dd" 格式的字符串获取日期
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
