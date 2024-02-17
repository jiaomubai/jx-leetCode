package convertToTitle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * @ClassName: ConvertToTitle
 * @Author: jiaoxian
 * @Date: 2022/3/23 12:15
 * @Description:
 */
@Slf4j
public class ConvertToTitle {

    public static String convertToTitle(int columnNumber) {
        String result = "";
        while (columnNumber > 0){
            char charResult = (char) ((columnNumber - 1) % 26 + 'A');
            result = charResult + result;
            columnNumber = (columnNumber - 1) / 26;
         }
        return result;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int columnNumber = 701;
        String result = convertToTitle(columnNumber);
        stopWatch.stop();
        //log.info("result = {}, 耗时:{}ms", result, stopWatch.getTotalTimeMillis());
    }

}
