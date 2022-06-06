package study.jvm.dto;

/**
 * @ClassName: Student
 * @Author: jiaoxian
 * @Date: 2022/6/1 10:09
 * @Description:
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }

}
