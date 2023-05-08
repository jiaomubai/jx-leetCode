package digitCount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoxian
 * @name digitCount
 * @date 2023/1/11 15:43
 * @description leetCode-2283: 判断一个数的数字计数是否等于数位的值
 */
public class DigitCount {

    public boolean digitCount(String num) {
        // 使用 HashMap 去记录数字与次数的对应关系

        int length = num.length();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Integer key = num.charAt(i) - 48;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            Integer key = i;
            Integer value = map.getOrDefault(key, 0);
            if (value != num.charAt(i) - 48) {
             return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        }


    }

