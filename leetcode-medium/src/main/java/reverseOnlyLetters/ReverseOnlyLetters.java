package reverseOnlyLetters;

import java.util.*;

/**
 * @author jiaoxian
 * @name reverseOnlyLetters
 * @date 2023/3/20 17:21
 * @description leetCode-917: 仅仅反转字母
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        String[] strArr = s.split("");
        int i = 0;
        int j = strArr.length - 1;
        while (i < j) {
            char iStr = s.charAt(i);
            char jStr = s.charAt(j);
            if (!('a' < iStr && iStr < 'z' || 'A' < iStr && iStr < 'Z')) {
                i++;
             } else if (!('a' < jStr && jStr < 'z' || 'A' < jStr && jStr < 'Z')) {
                j--;
            } else if (!('a' < iStr && iStr < 'z' || 'A' < iStr && iStr < 'Z') &&
                    !('a' < jStr && jStr < 'z' || 'A' < jStr && jStr < 'Z')) {
                i++;
                j--;
            } else {
                String temp = String.valueOf(iStr);
                strArr[i] = String.valueOf(jStr);
                strArr[j] = temp;
                i++;
                j--;
            }
        }
        String result = "";
        for (int k = 0; k < strArr.length; k++) {
            result += strArr[k];
        }

        return result;
    }


    public static void main(String[] args) {


        String str = Integer.valueOf("2") + 1 + "";
        System.out.println(str);




//        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
//        String s = "-St-rin-g";
//        System.out.println(reverseOnlyLetters.reverseOnlyLetters(s));

//        System.out.println((new Double("0.01") * 100).intValue());

//        Map<String, String> brandIdCategoryIdsMap = new HashMap<>();
        List<Map<String, Object>> authBrandList = new ArrayList<>();
//        for (int i = 0; i < authBrandList.size(); i++) {
//            Map<String, Object> mapData = authBrandList.get(i);
//            String brandId = mapData.get("brand_id").toString();
//            for (Map.Entry<String, Object> entry : mapData.entrySet()) {
//                logger.info(entry.getKey() + ":" + entry.getValue().toString());
//                if (entry.getKey().equals("categories:")) {
//                    List<Map<String, Object>> categoriesList =  (ArrayList<Map<String, Object>>) entry.getValue();
//                    String categoryIds = null;
//                    for (int j = 0; j < categoriesList.size(); j++) {
//                        Map<String, Object> categoriesMap = categoriesList.get(j);
//                        for (Map.Entry<String, Object> entry2 : categoriesMap.entrySet()) {
//                            if (entry2.getKey().equals("category_id")) {
//                                categoryIds += entry2.getValue().toString() + ",";
//                            }
//                        }
//                        logger.info(categoriesList.get(i).toString());
//                    }
//                    brandIdCategoryIdsMap.put(brandId, categoryIds);
//                }
//            }
//        }


//        String totalNums = "123";
//        String currentPageNo = "2";
//        String currengPageSize = "20";
//        Integer currentTotalNums = Integer.valueOf(currentPageNo) * 20;
//        if (currentTotalNums < Integer.valueOf(totalNums)) {
//            // 继续查询
//        }




    }

}
