package study.jvm.service;

import study.jvm.dto.Student;

/**
 * @ClassName: HelloWorld
 * @Author: jiaoxian
 * @Date: 2022/6/1 10:10
 * @Description:
 */
public class HelloWorld {

    public static void main(String[] args) {
        Student student = new Student("HelloWorld");
        student.print();
    }

}
