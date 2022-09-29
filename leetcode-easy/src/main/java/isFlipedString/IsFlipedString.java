package isFlipedString;

/**
 * @ClassName: IsFlipedString
 * @Description: leetCode-������ 01.09: �ַ�����ת
 * @Author: jiaoxian
 * @Date: 2022/9/29 9:04
 **/
public class IsFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        for (int i = 0; i < s1.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < s2.length(); j++) {
                // �� s1 ��ת�� i λ, �� s1[(i + j) % s1.length()] �� s2[j] �ַ����
                if (s1.charAt((i + j) % s1.length()) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;

//        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        IsFlipedString isFlipedString = new IsFlipedString();
        String s1 = "water";
        String s2 = "aterw";
        System.out.println(isFlipedString.isFlipedString(s1, s2));
    }

}


