package minDeletionSize;

import java.util.Arrays;

/**
 * @ClassName: MinDeletionSize
 * @Description: leetCode-944: …æ¡–‘Ï–Ú
 * @Author: jiaoxian
 * @Date: 2022/10/18 9:24
 **/
public class MinDeletionSize {

    public int minDeletionSize(String[] strs) {
        int result = 0;
        int length = strs.length;
        int m = strs[0].length();
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < length; i++) {
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinDeletionSize minDeletionSize = new MinDeletionSize();
        String[] strs = {"rrjk", "furt", "guzm"};
        System.out.println(minDeletionSize.minDeletionSize(strs));
    }

}
