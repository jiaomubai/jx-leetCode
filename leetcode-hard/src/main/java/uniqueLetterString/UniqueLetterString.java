package uniqueLetterString;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: UniqueLetterString
 * @Description: leetCode-828: 统计子串中的唯一字符
 * @Author: jiaoxian
 * @Date: 2022/9/6 11:21
 **/
@Slf4j
public class UniqueLetterString {

    // 1. List<String> 存每一个子串
    // 2. Map<Character, Integer> 存储每个子串中每个字符出现的次数
    // 3. 遍历 Map 中值为 1 的元素, 总数即为子串中唯一字符的数量之和

    public int uniqueLetterString(String s) {
        int result = 0;
        if (StringUtils.isBlank(s)) {
            return result;
        }
        // 1. 遍历源字符串, 存储每个子串
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
        // 2. 遍历子串 List, 计算每个子串中唯一字符的数量
        for (String list : subStringList) {
            result += calc(list);
        }
        return result;
    }

    private int calc(String subString) {
        // 1. 存储子串中每个字符出现的次数
        Map<Character, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < subString.length(); i++) {
            Character character = subString.charAt(i);
            // 如果当前 Map 中不包含该字符, 则 put
            if (!tempMap.containsKey(character)) {
                tempMap.put(character, 1);
            } else {
                // 如果当前 Map 中已经包含该字符, 则相应的值加1
                Integer count = tempMap.get(character);
                tempMap.put(character, ++count);
            }
        }
        // 2. 遍历 Map, 计算值为1的元素数量
        int sum = 0;
        for (Character character : tempMap.keySet()) {
            Integer value = tempMap.get(character);
            if (value == 1) {
                sum++;
            }
        }
//        log.info("当前子串: {} 中唯一元素的数量为: {}", subString, sum);
        return sum;
    }

    public int uniqueLetterString2(String s) {
        // key 值为唯一元素, value 为该元素在字符串中的下标
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
        // 遍历 Map, 计算每个字符作为唯一字符出现的次数
        // 以字符串 "LeetCode" 为例, 包括下面循环中对 List 的 一次 add 操作, 字符 'e' 的相应下标 List 为 {-1, 1, 2, 7, 8}
        // -1 的存在是为了计算方便, 遍历 List 时, 选择从下标为 1 开始以及给 List 进行一次 add 的操作也是为了计算方便
        // 遍历该 List, 对于下标为 1 的 'e' 来说, 其作为唯一字符时构成的子串为: e、Le, 使用公式计算为 (1 - (-1)) * (2 - 1) = 2;
        // 对于下标为 2 的 'e' 来说, 其作为唯一字符时构成的子串为: e、et、etC、etCod、etCode, 使用公式计算为 (2 - 1) * (7 - 2) = 5;
        // 对于下标为 7 的 'e' 来说, 其作为唯一字符时构成的子串为: e、de、ode、Code、tCode, 使用公式计算为 (7 - 2) * (8 - 7) = 5
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
        stopWatch1.start("一");
        int result = uniqueLetterString.uniqueLetterString(s);
        stopWatch1.stop();
        //log.info("第一种方法耗时:{}ms", stopWatch1.getTotalTimeMillis());
        stopWatch1.start("二");
        int result2 = uniqueLetterString.uniqueLetterString2(s);
        stopWatch1.stop();
        //log.info("第二种方法耗时:{}ms", stopWatch1.getTotalTimeMillis());
        System.out.println(stopWatch1.prettyPrint());
        //log.info("字符串: {} 的子串中唯一字符的数量为: {}", s, result);
        //log.info("字符串: {} 的子串中唯一字符的数量为: {}", s, result2);
    }

}
