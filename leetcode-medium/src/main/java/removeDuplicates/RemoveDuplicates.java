package removeDuplicates;

/**
 * @ClassName: RemoveDuplicates
 * @Description: leetCode-80: ɾ�����������е��ظ���
 * @Author: jiaoxian
 * @Date: 2022/9/27 11:32
 **/
public class RemoveDuplicates {

    // ����ָ��
    public int removeDuplicates(int[] nums) {
        // ����ظ���������
        int maxRepeat = 2;
        // ��ָ��slowָ������Ϊ1��λ��
        int slow = maxRepeat - 1;
        for(int fast = maxRepeat; fast < nums.length; fast++) {
            // ��֤������[slow - 1, fast]��Ԫ����಻�ᳬ��2��
            if (nums[fast] != nums[slow - maxRepeat + 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 7, 7, 8, 10};
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }

}
