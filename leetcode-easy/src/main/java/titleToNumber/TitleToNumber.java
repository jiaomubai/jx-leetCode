package titleToNumber;

//import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: TitleToNumber
 * @Author: jiaoxian
 * @Date: 2022/3/23 10:55
 * @Description:
 */
//@Slf4j
public class TitleToNumber {

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length() ; i++) {
            Integer value = (int) columnTitle.charAt(i) - 64;
            result = result * 26 + value;
        }
        return result;
    }

    public static void main(String[] args) {
        String columnTitle = "ABCD";
        int result = titleToNumber(columnTitle);
//        log.info("result = {}", result);
    }


}
