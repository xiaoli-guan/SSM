package demo.ssm.service;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.Teacher;

public interface TeacherService {
    Teacher getMyInfoByTeaIdToTeacher(Integer teaId);

    void saveInfoByTeacher(Teacher teacher);

    PageInfo<Teacher> getTeacherByTeacherLikeToPage(Integer pageNum, Teacher teacher);

    void insertTeacher(Teacher teacher);

    void deleteTeacherInfo(Integer teaId);
}
