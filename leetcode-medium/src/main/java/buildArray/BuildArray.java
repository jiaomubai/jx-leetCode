package buildArray;

import util.ArraysUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BuildArray
 * @Description: leetCode-1441: ��ջ������������
 * @Author: jiaoxian
 * @Date: 2022/10/20 17:34
 **/
public class BuildArray {

    public List<String> buildArray(int[] target, int n) {
        // �����Ķ����� 1 �� n ��˳�����е�����, ÿ�β���һ������ʱ, ������� target ��, ��ֻ��Ҫ���� Push ��ջ����.
        // ������� target ��, ��Ҫ�Ƚ��� Push ��ջ, ������ Pop ��ջ.
        // ��Ҫע�����, �����ǰ������ֵ�Ѿ����� target[] �����е����Ԫ����, ��ô��ֹͣ����, ��������ֹ�������� i <= Math.min(target[target.length - 1], n)

        List<String> resultList = new ArrayList<>();
        int maxTarget = Math.min(target[target.length - 1], n);
        for (int i = 1; i <= maxTarget; i++) {
            // �����ǰֵ���� target[] ������, ����Ҫ "Push" �� "Pop"
            if (!isExist(target, i)) {
                resultList.add("Push");
                resultList.add("Pop");
            } else {
                // ��ǰֵ�� target[] ������, ֻ��Ҫ "Push"
                resultList.add("Push");
            }
        }
        return resultList;
    }


    public boolean isExist(int[] target, int n) {
        for (int value : target) {
            if (value == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] p=new int[]{2,1};
        ArraysUtil.displayIntArray(p);
//        BuildArray buildArray = new BuildArray();
//        int[] target = {1, 3};
//        System.out.println(buildArray.buildArray(target, 3));
    }

}
