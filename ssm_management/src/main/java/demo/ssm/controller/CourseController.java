package demo.ssm.controller;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.Course;
import demo.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course/{pageNum}",method = RequestMethod.GET)
    public String getCoursePage(@PathVariable("pageNum") Integer pageNum, Course course, Model model){
        PageInfo<Course> page = courseService.getCourseByStudentToPage(pageNum,course);
        model.addAttribute("page",page);
        return "course";
    }

    /*添加学课程信息*/
    @RequestMapping(value = "/course/add",method = RequestMethod.POST)
    public String addCourse(Course course) {
        //保存学生信息
        courseService.saveCourse(course);
        return "redirect:/course/1";
    }

    /*修改课程信息时查询课程信息*/
    @RequestMapping(value = "/course/update/{cno}",method = RequestMethod.GET)
    public String toUpdateCourse(@PathVariable("cno") Integer cno,Model model){
        //根据Sno查询学生信息
        Course course = courseService.getCourseBySno(cno);
        //共享到请求域中
        model.addAttribute("course",course);
        return "course_update";
    }

    /*修改课程信息*/
    @RequestMapping(value = "/course/update",method = RequestMethod.PUT)
    public String updateCourse(Course course){
        courseService.updateCourseByCourse(course);
        return "redirect:/course/1";
    }

    /*删除课程*/
    @RequestMapping(value = "/course/delete/{cno}",method = RequestMethod.GET)
    public String deleteCourseByCno(@PathVariable("cno") Integer cno){
        courseService.deleteCourseByCno(cno);
        return "redirect:/course/1";
    }

    /*查看课程，非管理员*/
    @RequestMapping(value = "/course/personal/{pageNum}",method = RequestMethod.GET)
    public String toCoursePersonalPage(@PathVariable("pageNum") Integer pageNum, Course course, Model model){
        PageInfo<Course> page = courseService.getCourseByStudentToPage(pageNum,course);
        model.addAttribute("page",page);
        return "course_personal";
    }

}
