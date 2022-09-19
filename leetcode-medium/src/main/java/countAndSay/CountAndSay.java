package countAndSay;

/**
 * @ClassName: CountAndSay
 * @Description: leetCode-38: 外观数列
 * @Author: jiaoxian
 * @Date: 2022/9/14 11:23
 **/
public class CountAndSay {

    // 本质上只是依次统计字符串中连续相同字符的个数
    // 遍历法
    // 采用双指针遍历, pos 指针为当前位置, start 指针记录与当前指针所指元素相同的起始位置;
    // pos - start 即为相同字符出现的次数
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < result.length()) {
                while (pos < result.length() && result.charAt(pos) == result.charAt(start)) {
                    pos++;
                }
                sb.append((pos - start)).append(result.charAt(start));
                start = pos;
            }
            result = sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }

}
