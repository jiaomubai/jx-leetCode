package decConvert;

/**
 * @ClassName: DecConvert
 * @Author: jiaoxian
 * @Date: 2022/6/7 16:36
 * @Description: 十进制数转换
 */
public class DecConvert {

    public String binaryToDecimal(int n) {
        // 用来记录最终的结果
        StringBuilder stringBuilder = new StringBuilder();
        // 用来存储余数
        int remainder = 0;
        while (n != 0) {
            remainder = n % 2;
            n = n / 2;
            stringBuilder.append(remainder);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        new DecConvert().binaryToDecimal(4);
    }

}
