package generate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Generate
 * @Author: jiaoxian
 * @Date: 2021/11/5 12:05
 * @Description: 生成杨辉三角
 */
public class Generate {

    public static List<List<Integer>> generate(int numRows) {
        System.out.println("使用 List<> 开辟空间:");
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        // 第一行只有一个元素 [1]
        if (numRows == 1) {
            list1.add(1);
            resultList.add(list1);
        }
        // 从第二行开始使用杨辉三角的公式，即每个数是它左上方和右上方的数之和
        if (numRows >= 2) {
            // 第一行的值需要首先 add 到 resultList 中
            list1.add(1);
            resultList.add(list1);
            // System.out.println(resultList);
            // i 用来循环需要输出多少行,因为 i = 0 (即第一行)已经计算,所以此处的循环范围是 [1, numRows - 1]
            for (int i = 1; i < numRows; i++) {
                // 内层循环用变量 j 来控制每行需要输出多少个
                List<Integer> tempList = new ArrayList<>(numRows);
                // 设置第一个元素(即 j = 0 时) = 1
                tempList.add(1);
                // 因为已经设置了 j = 0 时的值,所以此处 j 的循环范围是 [1, i - 2]
                for (int j = 1; j < i; j++) {
                    // 使用公式进行计算
                    // 当 i == 1(即第二行) 时,其实是没有用到此公式的
                    tempList.add(resultList.get(i - 1).get(j - 1) + resultList.get(i - 1).get(j));
                }
                // 最后一个元素(即 j = i - 1 时) = 1
                tempList.add(1);
                resultList.add(tempList);
                // 输出每一行的值
                // System.out.println(resultList);
            }
        }
        System.out.println(resultList);
        return resultList;
    }

    public static List<List<Integer>> generate2(int numRows) {
        System.out.println("使用 int[][] 开辟空间:");
        List<List<Integer>> resultList = new ArrayList<>();
        // 二维数组
        int[][] array = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            // 以二维数组的对角线为界,为其下半部分赋值
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    // 将对角线和第一列初始化为 1
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
                tempList.add(array[i][j]);
            }
            System.out.println(tempList);
            resultList.add(tempList);
        }
        return resultList;
    }

    public static List<List<Integer>> generate3(int numRows) {
        System.out.println("递归:");
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tempList = everyRows(i);
            System.out.println(tempList);
            resultList.add(tempList);
        }
        return resultList;
    }

    public static List<Integer> everyRows(int rows) {
        List<Integer> tempList = new ArrayList<>();
        if (rows == 1) {
            tempList.add(1);
            return tempList;
        }
        if (rows == 2){
            tempList.add(1);
            tempList.add(1);
            return tempList;
        }
        for (int i = 0; i < rows; i++) {
            if (i == 0 || i == rows - 1) {
                tempList.add(1);
            } else {
                tempList.add(everyRows(rows - 1).get(i - 1) + everyRows(rows - 1).get(i));
            }
        }
        return tempList;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<List<Integer>> resultList = generate3(10);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}
