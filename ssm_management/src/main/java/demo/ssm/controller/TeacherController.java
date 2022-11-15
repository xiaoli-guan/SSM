package demo.ssm.controller;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.Student;
import demo.ssm.pojo.Teacher;
import demo.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacher/personal/{teaId}",method = RequestMethod.GET)
    public String toMyInfo(@PathVariable("teaId") Integer teaId, Model model){
        Teacher teacher = teacherService.getMyInfoByTeaIdToTeacher(teaId);
        model.addAttribute("teacher",teacher);
        return "my_info_teacher";
    }

    @RequestMapping(value = "/teacher/personal/update/{teaId}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("teaId") Integer teaId,Model model){
        Teacher teacher = teacherService.getMyInfoByTeaIdToTeacher(teaId);
        model.addAttribute("teacher",teacher);
        return "update_teacher_personal";
    }

    @RequestMapping(value = "/teacher/personal/update",method = RequestMethod.PUT)
    public String update(Teacher teacher){
        teacherService.saveInfoByTeacher(teacher);
        return "redirect:/teacher/personal/"+teacher.getTeaId();
    }

    @RequestMapping(value = "/teacher/{pageNum}",method = RequestMethod.GET)
    public String getAllTeacherInfoPage(@PathVariable("pageNum") Integer pageNum,Teacher teacher,Model model){
        PageInfo<Teacher> page = teacherService.getTeacherByTeacherLikeToPage(pageNum,teacher);
        model.addAttribute("page",page);
        return "all_teacher_info";
    }

    @RequestMapping(value = "/teacher/add",method = RequestMethod.POST)
    public String addTeacherInfo(Teacher teacher){
        teacherService.insertTeacher(teacher);
        return "redirect:/teacher/1";
    }

    @RequestMapping(value = "/teacher/delete/{teaId}",method = RequestMethod.GET)
    public String deleteTeacherInfo(@PathVariable("teaId") Integer teaId){
        teacherService.deleteTeacherInfo(teaId);
        return "redirect:/teacher/1";
    }

    @RequestMapping(value = "/teacher/update/{teaId}",method = RequestMethod.GET)
    public String toUpdateAdmin(@PathVariable("teaId") Integer teaId,Model model){
        Teacher teacher = teacherService.getMyInfoByTeaIdToTeacher(teaId);
        model.addAttribute("teacher",teacher);
        return "teacher_update";
    }

    @RequestMapping(value = "teacher/update",method = RequestMethod.PUT)
    public String updateAdmin(Teacher teacher){
        teacherService.saveInfoByTeacher(teacher);
        return "redirect:/teacher/1";
    }
}
