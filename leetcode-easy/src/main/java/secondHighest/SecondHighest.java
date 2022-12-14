package secondHighest;

/**
 * @author jiaoxian
 * @name secondHighest
 * @date 2022/12/14 9:45
 * @description leetCode-1796: 字符串中第二大的数字
 */
public class SecondHighest {

    public int secondHighest(String s) {
        int maxValue = -1;
        int secondValue = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // 如果当前字符是数字
                if (c - 48 > maxValue) {
                    // 如果当前数字大于最大的，则更新最大的数字，并将之前最大的数字赋值给第二大的
                    secondValue = maxValue;
                    maxValue = c - 48;
                } else if (c - 48 < maxValue && c - 48 > secondValue) {
                    // 如果当前数字小于最大的但是大于第二大的，则更新第二大的
                    secondValue = c - 48;
                }
            }
        }
        return secondValue;
    }

    public static void main(String[] args) {
        SecondHighest secondHighest = new SecondHighest();
        String s = "dfa12321afd";
        System.out.println(secondHighest.secondHighest(s));
    }

}
