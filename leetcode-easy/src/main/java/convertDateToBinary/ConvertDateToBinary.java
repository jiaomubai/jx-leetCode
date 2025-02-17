package convertDateToBinary;

/**
 * @ClassName: ConvertDateToBinary
 * @Description: leetCode-3280:将日期转换为二进制表示
 * @Author: jiaoxian
 * @Date: 2025-01-09 18:07:10
 * @Version: 1.0
 **/

public class ConvertDateToBinary {

    public String convertDateToBinary(String date) {
        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
//        return Integer.toBinaryString(year) + "-" + Integer.toBinaryString(month) + "-" + Integer.toBinaryString(day);
        return binary(year) + "-" + binary(month) + "-" + binary(day);
    }

    private String binary(int x) {
        StringBuilder s = new StringBuilder();
        for (; x != 0; x >>= 1) {
            s.append(x & 1);
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        String date = "2025-01-01";
        System.out.println(new ConvertDateToBinary().convertDateToBinary(date));
    }
}
