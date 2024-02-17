package numberOfLines;

/**
 * @author jiaoxian
 * @name numberOfLines
 * @date 2023/6/26 14:00
 * @description leetCode-806: д�ַ�����Ҫ������
 */
public class NumberOfLines {

    public int[] numberOfLines(int[] widths, String s) {
        // �ܹ���Ҫ row �У����һ���� cross ������
        int row = 0, cross = 0;
        int[] result = new int[]{row, cross};
        if (s == null || "".equals(s)) {
            return result;
        }
        row = 1;
        // ��ǰ���ܹ�����
        int currentTotalLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // ��ǰ��ĸ
            char temp = s.charAt(i);
            // ��ǰ��ĸ���賤��
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
