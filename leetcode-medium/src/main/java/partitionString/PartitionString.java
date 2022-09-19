package partitionString;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: PartitionString
 * @Description: leetCode-2405: 子字符串的最优划分
 * @Author: jiaoxian
 * @Date: 2022/9/14 16:00
 **/
public class PartitionString {

    // 哈希集合(set 或 map 都行) + 遍历
    // 遍历字符串 s, 若字符没有在集合中出现过, 则继续遍历
    // 若字符已经在集合中出现过, 则清空集合, 同时对结果加 1
    // 遍历完成之后再判断集合是否为空, 如果不为空, 则再对结果进行加 1 操作
    public int partitionString(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        Set<Character> hashSet = new HashSet<>();
        int result = 0;
        for (Character character : s.toCharArray()) {
            if (hashSet.contains(character)) {
                result += 1;
                hashSet.clear();
            }
            hashSet.add(character);

        }
        if (!hashSet.isEmpty()) {
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionString partitionString = new PartitionString();
        String str = "abcababa";
        System.out.println(partitionString.partitionString(str));
    }

}
