package smallestDistancePair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: SmallestDistancePair
 * @Author: jiaoxian
 * @Date: 2022/6/15 17:54
 * @Description:
 */
public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        int[] arr = new int[(int)1e6+1];
        for(int i=0 ; i<nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int diff = Math.abs(nums[i]-nums[j]);
                arr[diff]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                list.add(i);
                arr[i]--;
            }
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,6,1};
        System.out.println(new SmallestDistancePair().smallestDistancePair(nums, 3));
    }

}
