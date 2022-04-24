package majorityElement;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MajorityElement
 * @Author: jiaoxian
 * @Date: 2022/3/22 16:38
 * @Description:
 */
@Slf4j
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int element : nums) {
            if (resultMap.containsKey(element)) {
                int times = resultMap.get(element);
                resultMap.put(element, times + 1);
            } else {
                resultMap.put(element, 1);
            }
        }
        int result = nums[0];
        for (Integer key : resultMap.keySet()) {
            if (resultMap.get(key) > resultMap.get(result)) {
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        log.info("");
        int[] intArray = {3, 2, 3};
        int result = majorityElement(intArray);
        System.out.println(result);
    }


}
