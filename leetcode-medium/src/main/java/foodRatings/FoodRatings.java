package foodRatings;

import com.nbcb.sdk.OpenSDK;

import java.util.Objects;

/**
 * @ClassName: FoodRatings
 * @Description: leetCode-2353: 设计食物评分系统
 * @Author: jiaoxian
 * @Date: 2025-02-28 16:31:14
 * @Version: 1.0
 **/

public class FoodRatings {

    public static String[] foods = new String[]{};
    public static String[] cuisines = new String[]{};
    public static int[] ratings = new int[]{};

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }

    public void changeRating(String food, int newRating) {
        for (int i = 0; i < foods.length; i++) {
            if (Objects.equals(foods[i], food)) {
                ratings[i] = newRating;
            }
        }
    }

    public String highestRated(String cuisine) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < cuisines.length; i++) {
            if (Objects.equals(cuisines[i], cuisine)) {
                if (ratings[i] > max) {
                    max = ratings[i];
                    index = i;
                }
            }
        }
        if (index == -1) {
            return null;
        } else {
            return foods[index];
        }
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});

        System.out.println(foodRatings.highestRated("korean"));
    }


}
