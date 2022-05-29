package convert;

/**
 * @ClassName: Convert
 * @Author: jiaoxian
 * @Date: 2022/5/13 21:33
 * @Description: leetCode-6: Z 字形变换
 */
public class Convert {

    public static String convert(String s, int numRows) {
        // 如果只有 1 行,原样返回
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] stringBuilder = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilder[i] = new StringBuilder();
        }
        // 1 表示往下遍历, -1 表示往上遍历
        int direction = 1;
        int lines = 0;
        for (int i = 0; i < s.length(); i++) {
            stringBuilder[lines].append(s.charAt(i));
            if (lines == 0) {
                direction = 1;
            }
            if (lines == numRows - 1) {
                direction = -1;
            }
            lines += direction;
        }
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            resultString.append(stringBuilder[i]);
        }
        return resultString.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 5;
        String result = convert(s, numRows);
        System.out.println(result);
    }

}
