package isSubsequence;

/**
 * leetCode-392: еп╤овспРап
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < t.length()) {
            while (j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    j++;
                }
                break;
            }
            i++;
        }
        if (i == t.length() && j == s.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc";
        String t = "ahdbc";
        System.out.println(isSubsequence.isSubsequence(s, t));
    }

}
