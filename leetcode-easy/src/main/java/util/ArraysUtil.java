package util;

/**
 * @ClassName: ArraysUtil
 * @Description: ���鹤����
 * @Author: jiaoxian
 * @Date: 2022/9/6 17:51
 **/
public class ArraysUtil {

    /**
     * @Author jiaoxian
     * @Description displayIntArray ��ӡint��������
     * @Date 2022/9/6 17:52
     * @param nums: ����ӡ����
     * @return void
     **/
    public static void displayIntArray(int[] nums) {
        if (nums.length < 1) {
            return;
        }
        Object[] objectNums = new Object[nums.length];
        for (int i = 0; i < nums.length; i++) {
            objectNums[i] = nums[i];
        }
        commonDisplay(objectNums);
    }

    /**
     * @Author jiaoxian
     * @Description commonDisplay �����������ӡ����
     * @Date 2022/9/6 18:22
     * @param objectNums:
     * @return void
     **/
    public static void commonDisplay(Object[] objectNums) {
        if (objectNums.length == 0) {
            return;
        }
        for (int i = 0; i < objectNums.length - 1; i++) {
            System.out.print(objectNums[i] + " -> ");
        }
        System.out.println(objectNums[objectNums.length - 1]);
    }

    /**
     * @Author jiaoxian
     * @Description arrayToString ����ת�����ַ���
     * @Date 2022/9/6 18:11
     * @param nums:
     * @return java.lang.String
     **/
    public static String intArrayToString(int[] nums) {
        if (nums.length < 1) {
            return "";
        }
        Object[] objectNums = new Object[nums.length];
        for (int i = 0; i < nums.length; i++) {
            objectNums[i] = nums[i];
        }
        return objectArrayToString(objectNums);
    }

    /**
     * @Author jiaoxian
     * @Description objectArrayToString ����ת����������
     * @Date 2022/9/6 18:42
     * @param nums:
     * @return java.lang.String
     **/
    public static String objectArrayToString(Object[] nums) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (nums.length < 1) {
            return stringBuffer.toString();
        }
        for (int i = 0; i < nums.length; i++) {
            stringBuffer.append(nums[i]);
        }
        return stringBuffer.toString();
    }


}
