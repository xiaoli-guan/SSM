package demo.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.ssm.mapper.StudentMapper;
import demo.ssm.pojo.Student;
import demo.ssm.service.StudentService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public PageInfo<Student> getAllStudentPage(Integer pageNum) {

        PageHelper.startPage(pageNum,12);
        List<Student> list = studentMapper.getAllStudent();
        PageInfo<Student> page = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public void saveStudent(Student student) {
        studentMapper.saveStudent(student);
    }

    @Override
    public Student getStudentBySno(Integer Sno) {
        return studentMapper.getStudentBySno(Sno);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudent(Integer Sno) {
        studentMapper.deleteStudent(Sno);
    }

    @Override
    public PageInfo<Student> getStudentByStudentToPage(Integer pageNum, Student student) {
        PageHelper.startPage(pageNum,12);
        List<Student> list = studentMapper.getStudentByStudentLike(student);
        PageInfo<Student> page = new PageInfo<>(list,5);
        return page;
    }

}
