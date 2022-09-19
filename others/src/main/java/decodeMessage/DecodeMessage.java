package decodeMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DecodeMessage
 * @Description: TODO
 * @Author: jiaoxian
 * @Date: 2022/9/14 10:42
 **/
public class DecodeMessage {

    // 给你字符串 key 和 message, 分别表示一个加密密钥和一段加密消息.解密 message 的步骤如下：
    // 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母顺序.
    // 将替换表与普通英文字母表对齐, 形成对照表.
    // 按照对照表替换 message 中的每个字母.
    // 空格 ' ' 保持不变。
    // 如 key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
    // 第一步: 建立 key 与字母表中字母的对应关系
    // t h e q u i c k b r o w n f x j m p s v l a z y d g
    // a b c d e f g h i j k l m n o p q r s t u v w x y z
    // 第二步: 解密
    // message = "vkbs bs t suepuv" 对应的明文即为 "this is a secret"
    public String decodeMessage(String key, String message) {
        // 1. 使用 map 来存储 key 与字母表的对应关系, map 的 key 为 字符串 key 的字符, value 为其对应的字母表中的字母
        Map<Character, Character> keyMap = new HashMap<>();
        char value = 'a';
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ' || keyMap.containsKey(key.charAt(i))) {
                continue;
            }else {
                keyMap.put(key.charAt(i), value++);
            }
        }
        // 2. 遍历 message, 以 message 中的字符为 key, 寻找 keyMap 中的 value, 组成的新的字符串即为 message 解密后的明文
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                stringBuilder.append(' ');
            } else {
                stringBuilder.append(keyMap.get(message.charAt(i)));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeMessage decodeMessage = new DecodeMessage();
//        String key = "the quick brown fox jumps over the lazy dog";
//        String message = "vkbs bs t suepuv";
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage.decodeMessage(key, message));
    }

}
