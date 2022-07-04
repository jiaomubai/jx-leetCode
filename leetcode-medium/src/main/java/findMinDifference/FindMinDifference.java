package findMinDifference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: FindMinDifference
 * @Author: jiaoxian
 * @Date: 2022/6/17 17:35
 * @Description:
 */
public class FindMinDifference {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
        // 转成分钟数
        for (String timePoint : timePoints) {
            String[] timePointsArray = timePoint.split(":");
            int hours = Integer.parseInt(timePointsArray[0]);
            if (hours == 0) {
                hours = 24;
            }
            int minute = hours * 60 + Integer.parseInt(timePointsArray[1]);
            minutesList.add(minute);
        }
        // 排序
        Collections.sort(minutesList);
        // 遍历 minutesList 获取最小差值
        int minDiff = 1440;
        for (int i = 1; i < minutesList.size(); i++) {
            int diff = minutesList.get(i) - minutesList.get(i - 1);
//            if (diff > 720) {
//                diff = 1440 - diff;
//            }
            minDiff = Math.min(minDiff, diff);
        }
        int diff = minutesList.get(minutesList.size() - 1) - minutesList.get(0);
        if (diff > 720) {
            diff = 1440 - diff;
        }
        minDiff = Math.min(minDiff, diff);
        return minDiff;
    }

    public static void main(String[] args) {
        String timePoint1 = "01:39";
        String timePoint2 = "10:26";
        String timePoint3 = "21:43";
        List<String> timePoints = new ArrayList<>();
        timePoints.add(timePoint1);
        timePoints.add(timePoint2);
        timePoints.add(timePoint3);
        System.out.println(new FindMinDifference().findMinDifference(timePoints));
    }

}
