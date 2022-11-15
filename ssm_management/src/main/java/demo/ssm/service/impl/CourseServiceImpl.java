package demo.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.ssm.mapper.CourseMapper;
import demo.ssm.pojo.Course;
import demo.ssm.pojo.CourseExample;
import demo.ssm.pojo.Student;
import demo.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageInfo<Course> getCourseByStudentToPage(Integer pageNum, Course course) {
        PageHelper.startPage(pageNum,12);

        /*条件查询，支持模糊*/
        List<Course> list = courseMapper.selectByCourseLike(course);
        PageInfo<Course> page = new PageInfo<>(list,5);
        return page;

    }

    @Override
    public void saveCourse(Course course) {
        courseMapper.insertSelective(course);
    }

    @Override
    public Course getCourseBySno(Integer cno) {
        Course course = courseMapper.selectByPrimaryKey(cno);
        return course;
    }

    @Override
    public void updateCourseByCourse(Course course) {
        courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public void deleteCourseByCno(Integer cno) {
        courseMapper.deleteByPrimaryKey(cno);
    }
}
