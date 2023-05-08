package fizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaoxian
 * @name fizzBuzz
 * @date 2023/1/6 10:37
 * @description leetCode-412: Fizz Buzz
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resultList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resultList.add("Fizz");
            } else if (i % 5 == 0) {
                resultList.add("Buzz");
            } else {
                resultList.add(String.valueOf(i));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> resultList = fizzBuzz.fizzBuzz(n);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }

    }

}
