package specialArray;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @ClassName: SpecialArray
 * @Description: leetCode-1608: �������������ֵ
 * @Author: jiaoxian
 * @Date: 2022/9/13 10:10
 **/
@Slf4j
public class SpecialArray {

    // ��������н�������;
    // ��������ֵ x �Ķ���, xһ������ [1,n] ��Χ�ڵ�һ������, ���� n ������ nums�ĳ���, ��ˣ����ǿ��Ա��� [1,n]  ���ж�ĳ������ i �Ƿ�Ϊ����ֵ;
    // �� i Ϊ����ֵ����ô nums ��ǡ���� i ��Ԫ�ش��ڵ��� i.���������Ѿ���������˵�� nums[i - 1] ������ڵ��� i, ���� nums[i](�������)����С�� i.
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= i && (i == nums.length || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SpecialArray specialArray = new SpecialArray();
        int[] nums = {3, 5};
        int result = specialArray.specialArray(nums);
        //log.info("result = {}", result);
    }
}
