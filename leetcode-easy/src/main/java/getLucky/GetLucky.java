package getLucky;

/**
 * @author jiaoxian
 * @name getLucky
 * @date 2022/12/15 9:09
 * @description leetCode-1945: 字符串转化后的各位数字之和
 */
public class GetLucky {

    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            stringBuilder.append(s.charAt(i) - 96);
        }
        String digits = stringBuilder.toString();
        for (int i = 1; i <= k && digits.length() > 1; i++) {
            int sum = 0;
            for (int j = 0; j < digits.length(); j++) {
                sum += digits.charAt(j) - '0';
            }
            digits = Integer.toString(sum);
        }
        return Integer.parseInt(digits);
    }

    public static void main(String[] args) {
        GetLucky getLucky = new GetLucky();
        String s = "leetcode";
        int k = 2;
        System.out.println(getLucky.getLucky(s, k));
    }

}
