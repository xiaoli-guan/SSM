package demo.ssm.service;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.Course;

public interface CourseService {
    PageInfo<Course> getCourseByStudentToPage(Integer pageNum, Course course);

    void saveCourse(Course course);

    Course getCourseBySno(Integer cno);

    void updateCourseByCourse(Course course);

    void deleteCourseByCno(Integer cno);
}
