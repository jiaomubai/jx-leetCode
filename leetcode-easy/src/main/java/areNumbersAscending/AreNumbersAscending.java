package areNumbersAscending;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaoxian
 * @name areNumbersAscending
 * @date 2023/1/3 13:55
 * @description leetCode-2042: 检查句子中的数字是否递增
 */
public class AreNumbersAscending {

    public boolean areNumbersAscending(String s) {
        // 遍历字符串 s, 如果是字母, 不做处理, 如果是数字, 转换成数字类型
        // 使用 List, 将所有数字存储
        // 遍历 List, 判断数字是否严格递增

        int length = s.length();
        List<Integer> resultList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // 如果是数字
                stringBuilder.append(s.charAt(i));
            } else {
                // 如果是字母, 转换成数字类型, 并存储进 List 中
                if (stringBuilder.length() > 0) {
                    resultList.add(Integer.parseInt(stringBuilder.toString()));
                    stringBuilder = new StringBuilder();
                }
            }
        }
        if (stringBuilder.length() > 0) {
            resultList.add(Integer.parseInt(stringBuilder.toString()));
        }
        for (int i = 0; i < resultList.size() - 1; i++) {
            if (resultList.get(i + 1) <= resultList.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        AreNumbersAscending areNumbersAscending = new AreNumbersAscending();
        System.out.println(areNumbersAscending.areNumbersAscending(s));
    }

}
