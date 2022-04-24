package lengthOfLastWord;


/**
 * @ClassName: LengthOfLastWord
 * @Author: jiaoxian
 * @Date: 2021/9/23 18:44
 * @Description:
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ' ) {
                result += 1;
            } else {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "    I Love China    ";
        int result = lengthOfLastWord(str);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }


}
