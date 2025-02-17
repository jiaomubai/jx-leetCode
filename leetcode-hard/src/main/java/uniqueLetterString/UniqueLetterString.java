package uniqueLetterString;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: UniqueLetterString
 * @Description: leetCode-828: ͳ���Ӵ��е�Ψһ�ַ�
 * @Author: jiaoxian
 * @Date: 2022/9/6 11:21
 **/
@Slf4j
public class UniqueLetterString {

    // 1. List<String> ��ÿһ���Ӵ�
    // 2. Map<Character, Integer> �洢ÿ���Ӵ���ÿ���ַ����ֵĴ���
    // 3. ���� Map ��ֵΪ 1 ��Ԫ��, ������Ϊ�Ӵ���Ψһ�ַ�������֮��

    public int uniqueLetterString(String s) {
        int result = 0;
        if (StringUtils.isBlank(s)) {
            return result;
        }
        // 1. ����Դ�ַ���, �洢ÿ���Ӵ�
        List<String> subStringList = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(s.charAt(i)));
            subStringList.add(stringBuffer.toString());
            for (int j = i + 1; j < s.length(); j++) {
                stringBuffer.append(s.charAt(j));
                subStringList.add(stringBuffer.toString());
            }
        }
        subStringList.add(String.valueOf(s.charAt(s.length() - 1)));
        // 2. �����Ӵ� List, ����ÿ���Ӵ���Ψһ�ַ�������
        for (String list : subStringList) {
            result += calc(list);
        }
        return result;
    }

    private int calc(String subString) {
        // 1. �洢�Ӵ���ÿ���ַ����ֵĴ���
        Map<Character, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < subString.length(); i++) {
            Character character = subString.charAt(i);
            // �����ǰ Map �в��������ַ�, �� put
            if (!tempMap.containsKey(character)) {
                tempMap.put(character, 1);
            } else {
                // �����ǰ Map ���Ѿ��������ַ�, ����Ӧ��ֵ��1
                Integer count = tempMap.get(character);
                tempMap.put(character, ++count);
            }
        }
        // 2. ���� Map, ����ֵΪ1��Ԫ������
        int sum = 0;
        for (Character character : tempMap.keySet()) {
            Integer value = tempMap.get(character);
            if (value == 1) {
                sum++;
            }
        }
//        log.info("��ǰ�Ӵ�: {} ��ΨһԪ�ص�����Ϊ: {}", subString, sum);
        return sum;
    }

    public int uniqueLetterString2(String s) {
        // key ֵΪΨһԪ��, value Ϊ��Ԫ�����ַ����е��±�
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        // ���� Map, ����ÿ���ַ���ΪΨһ�ַ����ֵĴ���
        // ���ַ��� "LeetCode" Ϊ��, ��������ѭ���ж� List �� һ�� add ����, �ַ� 'e' ����Ӧ�±� List Ϊ {-1, 1, 2, 7, 8}
        // -1 �Ĵ�����Ϊ�˼��㷽��, ���� List ʱ, ѡ����±�Ϊ 1 ��ʼ�Լ��� List ����һ�� add �Ĳ���Ҳ��Ϊ�˼��㷽��
        // ������ List, �����±�Ϊ 1 �� 'e' ��˵, ����ΪΨһ�ַ�ʱ���ɵ��Ӵ�Ϊ: e��Le, ʹ�ù�ʽ����Ϊ (1 - (-1)) * (2 - 1) = 2;
        // �����±�Ϊ 2 �� 'e' ��˵, ����ΪΨһ�ַ�ʱ���ɵ��Ӵ�Ϊ: e��et��etC��etCod��etCode, ʹ�ù�ʽ����Ϊ (2 - 1) * (7 - 2) = 5;
        // �����±�Ϊ 7 �� 'e' ��˵, ����ΪΨһ�ַ�ʱ���ɵ��Ӵ�Ϊ: e��de��ode��Code��tCode, ʹ�ù�ʽ����Ϊ (7 - 2) * (8 - 7) = 5
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueLetterString uniqueLetterString = new UniqueLetterString();
        String s = "DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU";
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start("һ");
        int result = uniqueLetterString.uniqueLetterString(s);
        stopWatch1.stop();
        //log.info("��һ�ַ�����ʱ:{}ms", stopWatch1.getTotalTimeMillis());
        stopWatch1.start("��");
        int result2 = uniqueLetterString.uniqueLetterString2(s);
        stopWatch1.stop();
        //log.info("�ڶ��ַ�����ʱ:{}ms", stopWatch1.getTotalTimeMillis());
        System.out.println(stopWatch1.prettyPrint());
        //log.info("�ַ���: {} ���Ӵ���Ψһ�ַ�������Ϊ: {}", s, result);
        //log.info("�ַ���: {} ���Ӵ���Ψһ�ַ�������Ϊ: {}", s, result2);
    }

}
