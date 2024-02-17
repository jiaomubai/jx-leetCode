package reformat;

/**
 * @author jiaoxian
 * @name reformat
 * @date 2023/6/2 17:10
 * @description leetCode-1417: 重新格式化字符串
 */
public class Reformat {

    public String reformat(String s) {
        StringBuilder result = new StringBuilder();
        int countNum = 0;
        int countLetter = 0;
        StringBuilder numStr = new StringBuilder();
        StringBuilder letterStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numStr.append(s.charAt(i));
                countNum++;
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                letterStr.append(s.charAt(i));
                countLetter++;
            }
        }
        if (Math.abs(countNum - countLetter) <= 1) {
            if (countLetter > countNum) {
                for (int i = 0; i < countNum; i++) {
                    result.append(letterStr.charAt(i));
                    result.append(numStr.charAt(i));
                }
                result.append(letterStr.charAt(countLetter - 1));
            } else if (countNum > countLetter) {
                for (int i = 0; i < countLetter; i++) {
                    result.append(numStr.charAt(i));
                    result.append(letterStr.charAt(i));
                }
                result.append(numStr.charAt(countNum - 1));
            } else {
                for (int i = 0; i < countLetter; i++) {
                    result.append(letterStr.charAt(i));
                    result.append(numStr.charAt(i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abcde1234";
        System.out.println(new Reformat().reformat(s));
    }

}
