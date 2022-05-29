package intToRoman;

/**
 * @ClassName: IntToRoman
 * @Author: jiaoxian
 * @Date: 2022/5/28 19:30
 * @Description: leetCode-12: 整数转罗马数字
 */
public class IntToRoman {

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        StringBuilder romanStringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] intNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < intNum.length; i++) {
            while (num >= intNum[i]) {
                num = num - intNum[i];
                romanStringBuilder.append(roman[i]);
                // 输出往 romanStringBuilder 中 append 元素时的循环变量
//                System.out.print("i = " + i + ":");
//                System.out.println(romanStringBuilder);
            }
        }
        return romanStringBuilder.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        String roman = intToRoman(num);
        System.out.println(roman);
    }

}
