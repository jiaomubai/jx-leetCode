package reverseOnlyLetters;

/**
 * @author jiaoxian
 * @name reverseOnlyLetters
 * @date 2023/6/2 16:48
 * @description leetCode-917: 仅仅反转字母
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        String result = "";
        int i = 0;
        int j = s.length() - 1;
        char[] sArray = s.toCharArray();
        while (i < j) {
            boolean flagI = sArray[i] >= 'a' && sArray[i] <= 'z' || sArray[i] >= 'A' && sArray[i] <= 'Z';
            boolean flagJ = sArray[j] >= 'a' && s.charAt(j) <= 'z' || s.charAt(j) >= 'A' && s.charAt(j) <= 'Z';
            if (flagI && flagJ) {
                char temp = sArray[i];
                sArray[i] = sArray[j];
                sArray[j] = temp;
                i++;
                j--;
            } else if (flagI && !flagJ) {
                j--;
            } else if (!flagI && flagJ) {
                i++;
            } else if (!flagI && !flagJ) {
                i++;
                j--;
            }
        }
        for (int k = 0; k < sArray.length; k++) {
            result += String.valueOf(sArray[k]);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ab-cd-e-f";
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters(s));
    }

}
