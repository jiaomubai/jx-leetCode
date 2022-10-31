package countStudents;

/**
 * @ClassName: CountStudents
 * @Description: leetCode-1700: 无法吃午餐的学生数量
 * @Author: jiaoxian
 * @Date: 2022/10/19 11:11
 **/
public class CountStudents {

    public int countStudents(int[] students, int[] sandwiches) {

        // 根据题意, 我们可以知道栈顶的三明治能否被拿走取决于队列中剩余的学生中是否有喜欢它的. 因此学生在队列的相对位置并不影响整个过程.
        // 我们使用两个变量 student0 和 student1 来分别喜欢吃圆形三明治的学生数量和喜欢吃方形三明治的学生数量.
        // 遍历三明治数组, 如果栈顶的元素为 0 并且 student0 ?> 0, 我们就将 student0? 减 1;
        // 如果栈顶的元素为 1 并且 student1? > 0, 我们就将 student1? 减 1.
        // 否则终止过程, 并返回 student0 + student1 即可.

        int student0 = 0;
        int student1 = 0;
        for (int student : students) {
            if (student == 0) {
                student0++;
            } else {
                student1++;
            }
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && student0 > 0) {
                student0--;
            } else if (sandwich == 1 && student1 > 0) {
                student1--;
            } else {
                break;
            }
        }
        return student0 + student1;
    }

    public static void main(String[] args) {
//        CountStudents countStudents = new CountStudents();
//        int[] students = {1,1,1,0,0,1};
//        int[] sandwiches = {1,0,0,0,1,1};
//        System.out.println(countStudents.countStudents(students, sandwiches));
//
        int a = 2;
        int b = -2;
        System.out.println(Math.pow(a, b));

    }

}
