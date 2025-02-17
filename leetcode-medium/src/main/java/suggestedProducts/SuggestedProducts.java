package suggestedProducts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: SuggestedProducts
 * @Description: leetCode-1268:搜索推荐系统
 * @Author: jiaoxian
 * @Date: 2025-01-10 15:22:35
 * @Version: 1.0
 **/

public class SuggestedProducts {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> resultList = new ArrayList<>();
        int size = searchWord.length();
        for (int i = 0; i < size; i++) {
            List<String> tempList = new ArrayList<>();
            String temp = searchWord.substring(0, i + 1);
            for (String product : products) {
                if (product.startsWith(temp)) {
                    if (tempList.size() < 3) {
                        tempList.add(product);
                    }
                }
            }
            resultList.add(tempList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] products = {"bags","baggage","banner","box","cloths"};
        String searchWord = "bags";
        System.out.println(new SuggestedProducts().suggestedProducts(products, searchWord));
    }

}
