package romanToInt;

import java.util.HashMap;

/**
 * @ClassName: RomanToInt
 * @Author: jiaomubai
 * @Date: 2021/9/13 09:42
 * @Description: 罗马数字转整数, LeetCode 题库第13题
 */
public class RomanToInt {

    public static int romanToInt(String s) {
        int sum = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>(7);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if (i < chars.length - 1 && map.get(chars[i]) < map.get(chars[i + 1])) {
                sum -= map.get(chars[i]);
            } else {
                sum += map.get(chars[i]);
            }
        }
        return sum;
    }

    public static int romanToInt2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    result = result + 1;
                    break;
                case 'V':
                    result = result + 5;
                    break;
                case 'X':
                    result = result + 10;
                    break;
                case 'L':
                    result = result + 50;
                    break;
                case 'C':
                    result = result + 100;
                    break;
                case 'D':
                    result = result + 500;
                    break;
                case 'M':
                    result = result + 1000;
                    break;
                default:
                    break;
            }
            if (i != s.length() - 1) {
                if (s.charAt(i) == 'I' && ((s.charAt(i + 1) == 'V') || (s.charAt(i + 1) == 'X'))) {
                    result = result - 2;
                }
                if (s.charAt(i) == 'X' && ((s.charAt(i + 1) == 'L') || (s.charAt(i + 1) == 'C'))) {
                    result = result - 20;
                }
                if (s.charAt(i) == 'C' && ((s.charAt(i + 1) == 'D') || (s.charAt(i + 1) == 'M'))) {
                    result = result - 200;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int result = romanToInt2("MCMXCIV");
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
