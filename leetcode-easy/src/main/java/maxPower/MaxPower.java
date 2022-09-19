package maxPower;

/**
 * @ClassName: MaxPower
 * @Description: leetCode-1446: 连续字符
 * @Author: jiaoxian
 * @Date: 2022/9/19 16:53
 **/
public class MaxPower {

    public int maxPower(String s) {
        int result = 1;
        int current = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // 如果当前字符与前一个字符相等, current 加 1, 即当前连续字符的长度 + 1
                current++;
            } else {
                // 如果当前字符与前一个字符不相等, 更新最长连续字符的长度
                result = Math.max(current, result);
                // 恢复 current
                current = 1;
            }
        }
        return Math.max(current, result);
    }

    public static void main(String[] args) {
        MaxPower maxPower = new MaxPower();
        System.out.println(maxPower.maxPower("cc"));
    }

}
