package dayOfYear;


/**
 * @author jiaoxian
 * @name dayOfYear
 * @date 2023/10/7 16:31
 * @description leetCode-1154: 一年中的第几天
 */
public class DayOfYear {

    public int dayOfYear(String date) {
        int sum = 0;
        // 提取年月日
        String[] dateArray = date.split("-");
        Integer year = Integer.valueOf(dateArray[0]);
        Integer month = Integer.valueOf(dateArray[1]);
        Integer day = Integer.valueOf(dateArray[2]);
        // 是否闰年
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            Integer[] monthArray = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
            sum = monthArray[month - 1] + day;
        } else {
            Integer[] monthArray = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
            sum = monthArray[month - 1] + day;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new DayOfYear().dayOfYear("2020-12-31"));

    }


}
