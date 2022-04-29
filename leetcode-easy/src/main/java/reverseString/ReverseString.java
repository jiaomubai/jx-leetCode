package reverseString;

/**
 * @ClassName: ReverseString
 * @Author: jiaoxian
 * @Date: 2022/4/28 17:10
 * @Description: leetCode-344:反转字符串
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
            left++;
            right--;
        }
        display(s);
    }

    public static void display(char[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
    }

}
