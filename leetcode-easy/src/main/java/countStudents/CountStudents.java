package countStudents;

/**
 * @ClassName: CountStudents
 * @Description: leetCode-1700: �޷�����͵�ѧ������
 * @Author: jiaoxian
 * @Date: 2022/10/19 11:11
 **/
public class CountStudents {

    public int countStudents(int[] students, int[] sandwiches) {

        // ��������, ���ǿ���֪��ջ�����������ܷ�����ȡ���ڶ�����ʣ���ѧ�����Ƿ���ϲ������. ���ѧ���ڶ��е����λ�ò���Ӱ����������.
        // ����ʹ���������� student0 �� student1 ���ֱ�ϲ����Բ�������ε�ѧ��������ϲ���Է��������ε�ѧ������.
        // ��������������, ���ջ����Ԫ��Ϊ 0 ���� student0 ?> 0, ���Ǿͽ� student0? �� 1;
        // ���ջ����Ԫ��Ϊ 1 ���� student1? > 0, ���Ǿͽ� student1? �� 1.
        // ������ֹ����, ������ student0 + student1 ����.

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
