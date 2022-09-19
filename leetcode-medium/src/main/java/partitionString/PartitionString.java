package partitionString;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: PartitionString
 * @Description: leetCode-2405: ���ַ��������Ż���
 * @Author: jiaoxian
 * @Date: 2022/9/14 16:00
 **/
public class PartitionString {

    // ��ϣ����(set �� map ����) + ����
    // �����ַ��� s, ���ַ�û���ڼ����г��ֹ�, ���������
    // ���ַ��Ѿ��ڼ����г��ֹ�, ����ռ���, ͬʱ�Խ���� 1
    // �������֮�����жϼ����Ƿ�Ϊ��, �����Ϊ��, ���ٶԽ�����м� 1 ����
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
