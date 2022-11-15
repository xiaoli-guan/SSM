package demo.ssm.service;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.Student;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudent();


    PageInfo<Student> getAllStudentPage(Integer pageNum);

    void saveStudent(Student student);

    Student getStudentBySno(Integer Sno);

    void updateStudent(Student student);

    void deleteStudent(Integer sno);

    PageInfo<Student> getStudentByStudentToPage(Integer pageNum, Student student);
}
