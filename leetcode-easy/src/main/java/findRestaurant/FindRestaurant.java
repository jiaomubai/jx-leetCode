package findRestaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaoxian
 * @name findRestaurant
 * @date 2023/5/19 17:04
 * @description leetCode-599: 两个列表的最小索引总和
 */
public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> resultList = new ArrayList<>();
        int minIndex = list1.length + list2.length;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int currentIndexSum = i + j;
                    if (currentIndexSum < minIndex) {
                        minIndex = currentIndexSum;
                        resultList.clear();
                        resultList.add(list1[i]);
                    } else if (currentIndexSum == minIndex) {
                        resultList.add(list1[i]);
                    }
                }
            }
        }
        String[] resultArr = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        new FindRestaurant().findRestaurant(list1, list2);
    }

}
