package duplicateZeros;

/**
 * @ClassName: DuplicateZeros
 * @Author: jiaoxian
 * @Date: 2022/6/17 09:26
 * @Description: leetCode-1089: 复写零
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        // 虚拟数组, 找出会出现在虚拟数组中的最后一个元素, 即 i
        int i = 0;
        int j = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == 0) {
                j += 2;
            } else {
                j++;
            }
            if (j >= arr.length) {
                break;
            }
        }
        // 处理原数组中最后一个元素等于 0 且复写之后越界的特殊情况
        if (j > arr.length) {
            if (arr[i] == 0) {
                j = j - 2;
                arr[j] = 0;
                j--;
                i--;
            }
        } else {
            j--;
        }
        //System.out.println("i = " + i + ", j = " + j);
        // 从右到左, 进行复写操作
        while (j >= 0) {
            arr[j] = arr[i];
            if (arr[i] == 0) {
                arr[j - 1] = arr[i];
                j--;
            }
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        new DuplicateZeros().duplicateZeros(arr);
    }

}
