package areAlmostEqual;

/**
 * @ClassName: AreAlmostEqual
 * @Description: leetCode-1790: 仅执行一次字符串交换能否使两个字符串相等
 * @Author: jiaoxian
 * @Date: 2022/10/11 10:53
 **/
public class AreAlmostEqual {

    // s1 和 s2 中一定得存在两个位置处的元素不同, 如果存在两个以上位置处的元素不同, 则直接返回 false.
    // 之后再判断 s1 中这两个位置处的元素交换之后与 s2 中这两个位置处的元素是否相等

    public boolean areAlmostEqual(String s1, String s2) {
        boolean result = false;
        if (s1.length() != s2.length()) {
            return result;
        }
        // 使用数组记录元素不相同的位置, 如果数量大于 2, 直接返回 false
        int[] diffIndexArray = new int[2];
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index < 2) {
                    diffIndexArray[index++] = i;
                } else {
                    // 不同元素的位置大于大于 2
                    return result;
                }
            }
        }
        if (index == 0) {
            // 无不同元素, 即两个字符串已经相等
            return true;
        }
        if (index == 1) {
            // 只有一个位置处的元素不同
            return result;
        }
        result = s1.charAt(diffIndexArray[0]) == s2.charAt(diffIndexArray[1]) && s1.charAt(diffIndexArray[1]) == s2.charAt(diffIndexArray[0]);
        return result;
    }

    public static void main(String[] args) {
        AreAlmostEqual areAlmostEqual = new AreAlmostEqual();
        String s1 = "abcd";
        String s2 = "dcba";
        System.out.println(areAlmostEqual.areAlmostEqual(s1, s2));
    }

}
