package countPrefixes;

/**
 * @ClassName: CountPrefixes
 * @Description: leetCode-2255: 统计是给定字符串前缀的字符串数目
 * @Author: jiaoxian
 * @Date: 2022/9/21 10:27
 **/
public class CountPrefixes {

    // 循环遍历 words[], 判断 s 是以 words 中元素开始的数量
    public int countPrefixes(String[] words, String s) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (s.startsWith(words[i])) {
                ++result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountPrefixes countPrefixes = new CountPrefixes();
        String[] words = {"a", "ab", "abc", "c", "d"};
        String s = "abcd";
        System.out.println(countPrefixes.countPrefixes(words, s));
    }

}
