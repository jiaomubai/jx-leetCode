package repeatedCharacter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiaoxian
 * @name repeatedCharacter
 * @date 2023/1/3 15:12
 * @description leetCode-2351: 第一个出现两次的字母
 */
public class RepeatedCharacter {

    public char repeatedCharacter(String s) {
        // 借助 HashSet 存储字符, 如果 add 成功, 表示第一次出现, 如果 add 失败, 标识第二次出现
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return '0';
    }

}
