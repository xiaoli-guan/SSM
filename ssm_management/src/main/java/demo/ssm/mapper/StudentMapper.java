package demo.ssm.mapper;

import demo.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {


    List<Student> getAllStudent();

    void saveStudent(Student student);

    Student getStudentBySno(@Param("Sno") Integer Sno);

    void updateStudent(Student student);

    void deleteStudent(@Param("Sno") Integer sno);

    List<Student> getStudentByStudentLike(Student student);
}
