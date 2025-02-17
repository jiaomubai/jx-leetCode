package masterMind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiaoxian
 * @name masterMind
 * @date 2023/7/7 15:10
 * @description leetCode-������ 16.15: ��������
 */
public class MasterMind {

    public int[] masterMind(String solution, String guess) {
        // α���е��ַ���
        Set<String> set1 = new HashSet<>();
        // ���е��ַ���
        Set<String> set2 = new HashSet<>();
        // α���еĴ���
        int count1 = 0;
        // ���еĴ���
        int count2 = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                set2.add(String.valueOf(guess.charAt(i)));
                set1.remove(String.valueOf(guess.charAt(i)));
            } else {
                if (solution.contains(String.valueOf(guess.charAt(i)))) {
                    set1.add(String.valueOf(guess.charAt(i)));
                }
            }
        }
        return new int[]{set2.size(), set1.size()};
    }

    public static void main(String[] args) {
        System.out.println(new MasterMind().masterMind("RGBY", "GGRR"));
    }

}
