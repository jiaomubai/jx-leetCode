package flipAndInvertImage;

/**
 * @ClassName: FlipAndInvertImage
 * @Description: leetCode-832: ��תͼ��
 * @Author: jiaoxian
 * @Date: 2022/9/21 9:30
 **/
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] image) {
        // ����
        int m = image.length;
        // ����
        int n = image[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                // ����Ԫ�ص�ͬʱ��ת 0 �� 1
                int temp = image[i][j] == 0 ? 1 : 0;
                image[i][j] = image[i][n - j - 1] == 0 ? 1 : 0;
                image[i][n - j - 1] = temp;
            }
            if (n % 2 == 1) {
                // ���ÿ����������Ԫ��, ��ı����м�Ԫ�ص�ֵ
                image[i][n / 2] = image[i][n / 2] == 0 ? 1 : 0;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FlipAndInvertImage flipAndInvertImage = new FlipAndInvertImage();
        int [][] image = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        flipAndInvertImage.flipAndInvertImage(image);
    }



}
