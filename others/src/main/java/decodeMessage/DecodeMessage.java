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

    // �����ַ��� key �� message, �ֱ��ʾһ��������Կ��һ�μ�����Ϣ.���� message �Ĳ������£�
    // ʹ�� key �� 26 ��Ӣ��Сд��ĸ��һ�γ��ֵ�˳����Ϊ�滻���е���ĸ˳��.
    // ���滻������ͨӢ����ĸ�����, �γɶ��ձ�.
    // ���ն��ձ��滻 message �е�ÿ����ĸ.
    // �ո� ' ' ���ֲ��䡣
    // �� key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
    // ��һ��: ���� key ����ĸ������ĸ�Ķ�Ӧ��ϵ
    // t h e q u i c k b r o w n f x j m p s v l a z y d g
    // a b c d e f g h i j k l m n o p q r s t u v w x y z
    // �ڶ���: ����
    // message = "vkbs bs t suepuv" ��Ӧ�����ļ�Ϊ "this is a secret"
    public String decodeMessage(String key, String message) {
        // 1. ʹ�� map ���洢 key ����ĸ��Ķ�Ӧ��ϵ, map �� key Ϊ �ַ��� key ���ַ�, value Ϊ���Ӧ����ĸ���е���ĸ
        Map<Character, Character> keyMap = new HashMap<>();
        char value = 'a';
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ' || keyMap.containsKey(key.charAt(i))) {
                continue;
            }else {
                keyMap.put(key.charAt(i), value++);
            }
        }
        // 2. ���� message, �� message �е��ַ�Ϊ key, Ѱ�� keyMap �е� value, ��ɵ��µ��ַ�����Ϊ message ���ܺ������
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
