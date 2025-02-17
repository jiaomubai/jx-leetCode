package validNumber;

/**
 * @ClassName: ValidNumber
 * @Description: leetCode-LCR 138:有效数字
 * @Author: jiaoxian
 * @Date: 2025-02-07 17:17:06
 * @Version: 1.0
 **/

public class ValidNumber {

    // '.'出现正确情况：只出现一次，且在e的前面
    // 'e'、'E'出现正确情况：只出现一次，且出现前有数字
    // '+'、'-'出现正确情况：只能在开头和e后一位
    public boolean validNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //去掉首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            // 判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                // 没出现过 . 并且没出现过e
                dotFlag = true;
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                // 判定为e、E，需要没出现过e、E，并且出过数字
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                //判定为+-符号，只能出现在第一位或者紧接e后面
                //其他情况，都是非法的
                //numFlag = true;
            } else {
                return false;
            }
        }
        return numFlag;
    }

    public static void main(String[] args) {
        System.out.println(new ValidNumber().validNumber("123"));
    }

}
