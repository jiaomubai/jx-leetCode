package maximumValue;

/**
 * @author jiaoxian
 * @name maximumValue
 * @date 2023/5/19 15:09
 * @description leetCode-2496: 数组中字符串的最大值
 */
public class MaximumValue {

    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            if (isContainsLetter(str)) {
                max = Math.max(max, str.length());
            } else {
                max = Math.max(max, Integer.parseInt(str));
            }
        }
        return max;
    }

    public boolean isContainsLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] strs = {"01", "abc", "101abc"};
        System.out.println(new MaximumValue().maximumValue(strs));
    }


}
