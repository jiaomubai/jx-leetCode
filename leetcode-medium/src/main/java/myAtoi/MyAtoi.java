package myAtoi;

/**
 * @ClassName: MyAtoi
 * @Author: jiaoxian
 * @Date: 2022/5/13 20:25
 * @Description: leetCode-8: 字符串转换整数(atoi)
 */
public class MyAtoi {

    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 遍历字符串 s 的开始位置
        int index = 0;
        // 考虑到会有越界情况发生, 所以使用 long 类型
        long result = 0L;
        // 正数和负数标记, 1-正数, -1-负数
        int flag = 1;
        // 字符串长度
        int length = s.length();
        // 去掉字符串 s 的前导空格
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }
        // 字符串 s 全部由 ' ' 组成
        if (index == length) {
            return 0;
        }
        // 判断符号
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            flag = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        // 遍历字符串
        for (; index < length; index++) {
            int number = s.charAt(index) - '0';
            if (number < 0 || number > 9) {
                break;
            }
            result = result * 10 + number;
            // 判断是否越界
            if (result * flag > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * flag < Integer.MIN_VALUE) {
                return  Integer.MIN_VALUE;
            }
        }
        return (int) result * flag;
    }

    public static void main(String[] args) {
        String s = "   -+123";
        System.out.println("字符串:" + s);
        int result = myAtoi(s);
        System.out.println("转换为数字为:" + result);
    }

}
