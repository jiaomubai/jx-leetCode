package checkPermutation;

import java.util.Arrays;

/**
 * @ClassName: CheckPermutation
 * @Description: leetCode-面试题 01.02: 判定是否互为字符重排
 * @Author: jiaoxian
 * @Date: 2022/9/27 9:38
 **/
public class CheckPermutation {

    public boolean checkPermutation(String s1, String s2) {
        // 如果 s1 的长度与 s2 的长度不相等, 则直接 return
        if (s1.length() != s2.length()) {
            return false;
        }
        // 将字符串转换为字符数组之后进行排序, 看是否相等
        char[] strArray1 = s1.toCharArray();
        Arrays.sort(strArray1);
        char[] strArray2 = s2.toCharArray();
        Arrays.sort(strArray2);
        return Arrays.equals(strArray1, strArray2);
    }

    public boolean checkPermutation2(String s1, String s2) {
        // 如果 s1 的长度与 s2 的长度不相等, 则直接 return
        if (s1.length() != s2.length()) {
            return false;
        }
        // 使用一个大小为 26 的数组 temp[] 去记录 s1 中每个字符出现的次数, 下标为 0 的存字符 'a' 出现的次数, 下标为 25 存字符 'z' 出现的次数.
        // 然后遍历 s2 的每个字符, 对 temp[] 中相应下标的值进行 -- 操作
        int[] temp = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            temp[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            temp[s2.charAt(i) - 'a']--;
            // 如果某个下标的值小于 0, 则 return false
            // 注意为什么只判断小于 0 就能达到要求？举个例子, s1 = "aacba", s2 = "cbaad"
            // 因为此时 s1 与 s2 的长度是相等的, s1 遍历结束后 temp[0] = 3, 遍历 s2 时, 当字符为 'a' 时, temp[0] 进行自减操作, 那么首先肯定不能去判断大于 0
            // 判断小于 0 的原因是: 长度相等的两个字符串 s1 和 s2, 如果 s1 中某个字符出现的次数比该字符在 s2 中出现的次数多, 那么就肯定有一个字符在 s2 中出现的次数比在 s1 中出现的次数多
            // 结合示例来讲, 虽然 'a' 在 s1 中出现的次数比在 s2 中出现的次数多, 也意味着遍历完 s2 之后 temp[0] > 0, 但是字符 'd' 在 s2 中出现的次数比在 s1 中出现的次数多, 所以 temp[3] < 0
            // 这也是我们在遍历完 s2 之后没有再去遍历 temp[] 寻找值 > 0 和 < 0 的原因
            if (temp[s2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPermutation checkPermutation = new CheckPermutation();
        String s1 = "aacba";
        String s2 = "cbaad";
        System.out.println(checkPermutation.checkPermutation2(s1, s2));
    }

}
