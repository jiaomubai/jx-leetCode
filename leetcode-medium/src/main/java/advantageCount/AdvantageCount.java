package advantageCount;

import util.ArraysUtil;

import java.util.Arrays;

/**
 * @ClassName: AdvantageCount
 * @Description: leetCode-870: ����ϴ��(�������)
 * @Author: jiaoxian
 * @Date: 2022/10/8 16:15
 **/
public class AdvantageCount {

    // �������̰�ķ������
    // �� nums1[]? ��������ɵ���, nums2[] ����������������
    // ÿ���� nums1[] �е��µ���ȥ�� nums2[] �е��µ��� pk
    // ��� pk �Ĺ�����һ������ pk; ��� pk �������� nums1[] �е��µ���ȥ���ڻ�, ȥ pk nums2[] �е��ϵ���
    // �ڱ�����, ��� pk �Ĺ�, ���� nums2[] �е��µ�����±굱�� nums1[] �е��µ�����±�
    // pk ����, ���� nums2[] �е��ϵ�����±굱�� nums1[] �е��µ�����±�
    // �����ȷֱ����� nums1[]? �� nums2[]? ��������, ��������µ�����ϵ���, ���ֻ��Ҫ���Ͽ���������������׸�Ԫ�أ����µ���
    // ��� nums1[]? ���׸�Ԫ�ش��� nums2[]? ���׸�Ԫ��, ����ɵ��µ��� pk Ӯ�����������µ���, ��ô�ͽ������ڴ��ж�Ӧ����, ͬʱ���������Ƴ�������Ԫ��, �����ظ�ʹ��, ������һ������;
    // ��� nums1[]? ���׸�Ԫ��С�ڵ��� nums2[]? ���׸�Ԫ��, ��ô�Ƴ� nums1[] ���׸�Ԫ�ء�
    // �� nums1[]? ��û��Ԫ��ʱ, ��������.
    // ����������ȷ������: ���ڵ�һ�����, ���� nums1[] �������, ��ô nums1[] ������Ԫ�ش��� nums2[] ���׸�Ԫ��;
    // ������ǲ��� nums2[] ���׸�Ԫ�����, ���� nums2[] �������, ֮���Ԫ�ػ����, ������������;
    // ��������� nums2[] ���׸�Ԫ�����, ����ʹ�� nums1[]���׸�Ԫ��, ����ʹ��ʣ���Ԫ�ؾ����ܴ�, ֮����Ի�ø�������.
    // ���ڵڶ������, ���� nums2[]�������, ��ô nums1[] ���׸�Ԫ��С�ڵ��� nums2[] �е�����Ԫ��, ��� nums1[] ���׸�Ԫ���޷������κ�����, ����ֱ���Ƴ�.
    // �ڱ�����, ���� nums1[] �е�ÿһ��Ԫ�ض�Ҫ�� nums2[]? �е�Ԫ�����, �������ǰ���˳���� nums2[] �е�Ԫ�ص�, ����ڱ���������, nums2[] ��ʣ���Ԫ��ʵ������ԭ�� nums2[] ��һ����׺.
    // ��˵� nums1[] ���׸�Ԫ���޷����ʱ, ���Ǹ������һ�� nums2[] ��βԪ�ؼ���, ������βԪ���Ƴ�.
    // ��ʵ�ʵĴ����д��, ���������������Ƴ�Ԫ��. ���� nums1[], ����ʹ��һ��ѭ�����α������е�ÿ��Ԫ��;
    // ���� nums2[], ���ǿ���ʹ��˫ָ�� left �� right. ��� nums1[] ���׸�Ԫ�ؿ�����������, ����� left ��Ӧ��Ԫ�ز������ƶ�һ��λ��;
    // ����޷����, ����� right ��Ӧ��Ԫ�ز������ƶ�һ��λ��.

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        // �� nums1[] �� nums2[] �е�ֵ����Ӧ���±갴����ֵ��С����
        // �������� idx1[] �е�һ��Ԫ���� nums1[] ��ֵ��С��Ԫ�ص��±�, ���һ��Ԫ���� nums1[] ��ֵ����Ԫ�ص��±�
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                // ��� nums1[] ����Ԫ�ش��� nums2[] ����Ԫ��, ����ɵ��µ������Ӯ���������µ���, ������ɵ��µ��������������µ���Ķ�Ӧ��ϵ, ����ɵ��µ�����ӵ������������µ���Ķ�Ӧλ����
                result[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                // ��� nums1[] ����Ԫ��С�ڵ��� nums2[] ����Ԫ��, ����ɵ��µ����޷�Ӯ���������µ���, ������ɵ��µ��������������ϵ���Ķ�Ӧ��ϵ, ����ɵ��µ�����ӵ������������ϵ���Ķ�Ӧλ����
                result[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AdvantageCount advantageCount = new AdvantageCount();
        int[] nums1 = new int[]{12, 24, 8, 32};
        int[] nums2 = new int[]{12, 25, 32, 11};
        int[] result = advantageCount.advantageCount(nums1, nums2);
        ArraysUtil.displayIntArray(result);
    }

}
