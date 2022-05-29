package finalValueAfterOperations;

/**
 * @ClassName: FinalValueAfterOperations
 * @Author: jiaoxian
 * @Date: 2022/5/28 17:43
 * @Description: leetCode-2011: 执行操作后的变量值
 */
public class FinalValueAfterOperations {

    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] operations = {"x++", "x--", "++x", "x++"};
        int result = finalValueAfterOperations(operations);
        System.out.println(result);
    }

}
