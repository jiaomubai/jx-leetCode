package numberOfLines;

/**
 * @author jiaoxian
 * @name numberOfLines
 * @date 2023/6/26 14:00
 * @description leetCode-806: 写字符串需要的行数
 */
public class NumberOfLines {

    public int[] numberOfLines(int[] widths, String s) {
        // 总共需要 row 行，最后一行有 cross 个长度
        int row = 0, cross = 0;
        int[] result = new int[]{row, cross};
        if (s == null || "".equals(s)) {
            return result;
        }
        row = 1;
        // 当前行总共长度
        int currentTotalLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // 当前字母
            char temp = s.charAt(i);
            // 当前字母所需长度
            int currentLength = widths[temp - 'a'];
            if (currentTotalLength + currentLength > 100) {
                row += 1;
                currentTotalLength = 0;
            }
            currentTotalLength += currentLength;
        }
        result[0] = row;
        result[1] = currentTotalLength;
        return result;
    }

    public static void main(String[] args) {
        NumberOfLines numberOfLines = new NumberOfLines();
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] result = numberOfLines.numberOfLines(widths, s);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
