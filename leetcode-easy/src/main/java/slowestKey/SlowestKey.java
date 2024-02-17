package slowestKey;

import com.sun.javafx.collections.MappingChange;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jiaoxian
 * @name slowestKey
 * @date 2023/5/10 15:40
 * @description leetCode-1629: 按键持续时间最长的键
 */
public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = 0;
        char slowestKey = 0;
        TreeMap<String, Integer> keyTimeMap = new TreeMap<>();
        char[] pressArr = keysPressed.toCharArray();
        for (int i = 0; i < releaseTimes.length; i++) {
            if (i == 0) {
                keyTimeMap.put(String.valueOf(pressArr[0]), releaseTimes[0]);
                maxTime = Math.max(maxTime, releaseTimes[0]);
            } else {
                String key = String.valueOf(pressArr[i]);
                int time = releaseTimes[i] - releaseTimes[i - 1];
                maxTime = Math.max(maxTime, time);
                if (keyTimeMap.containsKey(key)) {
                    time = Math.max(time, keyTimeMap.get(key));
                    keyTimeMap.put(key, time);
                } else {
                    keyTimeMap.put(key, time);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : keyTimeMap.entrySet()) {
            if (entry.getValue() == maxTime) {
                slowestKey = entry.getKey().charAt(0);
                break;
            }
        }
        return slowestKey;
    }

    public static void main(String[] args) {
        int[] releaseTimes = {9,29,49,50};
        String keysPressed = "cbcd";
        System.out.println(new SlowestKey().slowestKey(releaseTimes, keysPressed));
    }

}
