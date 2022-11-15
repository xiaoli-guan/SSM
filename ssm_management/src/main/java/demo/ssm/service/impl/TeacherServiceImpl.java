package demo.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.ssm.mapper.TeacherMapper;
import demo.ssm.pojo.Student;
import demo.ssm.pojo.Teacher;
import demo.ssm.pojo.TeacherExample;
import demo.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getMyInfoByTeaIdToTeacher(Integer teaId) {

        Teacher teacher = teacherMapper.selectByPrimaryKey(teaId);
        return teacher;
    }

    @Override
    public void saveInfoByTeacher(Teacher teacher) {
        teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public PageInfo<Teacher> getTeacherByTeacherLikeToPage(Integer pageNum, Teacher teacher) {
        PageHelper.startPage(pageNum,12);
        List<Teacher> list = teacherMapper.getTeacherByLikeToList(teacher);
        PageInfo<Teacher> page = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public void deleteTeacherInfo(Integer teaId) {
        teacherMapper.deleteByPrimaryKey(teaId);
    }

}
