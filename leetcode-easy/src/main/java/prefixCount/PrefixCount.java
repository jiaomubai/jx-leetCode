package prefixCount;

/**
 * @author jiaoxian
 * @name prefixCount
 * @date 2023/5/15 17:21
 * @description leetCode-2185: 统计包含给定前缀的字符串
 */
public class PrefixCount {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
