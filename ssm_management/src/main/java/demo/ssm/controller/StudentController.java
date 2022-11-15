package demo.ssm.controller;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.Student;
import demo.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*查询学生信息*/
    @RequestMapping(value = "/student/update/{Sno}",method = RequestMethod.GET)
    public String toUpdateStudent(@PathVariable("Sno") Integer Sno,Model model){
        //根据Sno查询学生信息
        Student student = studentService.getStudentBySno(Sno);
        //共享到请求域中
        model.addAttribute("student",student);
        return "student_update";
    }

    /*添加学生信息*/
    @RequestMapping(value = "/student/add",method = RequestMethod.POST)
    public String addStudent(Student student) {
        //保存学生信息
        studentService.saveStudent(student);
        return "redirect:/student/1";
    }

    /*修改学生信息*/
    @RequestMapping(value = "/student/update",method = RequestMethod.PUT)
    public String updateStudent(Student student){
        //修改学生信息
        studentService.updateStudent(student);
        return "redirect:/student/1";
    }

    /*删除学生信息*/
    @RequestMapping(value = "/student/delete/{Sno}",method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("Sno") Integer Sno){
        studentService.deleteStudent(Sno);
        return "redirect:/student/1";
    }

    /*筛选学生信息*/
    @RequestMapping(value = "/student/{pageNum}",method = RequestMethod.GET)
    public String selectStudent(@PathVariable("pageNum") Integer pageNum, Student student,Model model){
        PageInfo<Student> page = studentService.getStudentByStudentToPage(pageNum,student);
        model.addAttribute("page",page);
        return "student_list";
    }

    /*查看我的信息*/
    @RequestMapping(value = "/student/personal/{sno}",method = RequestMethod.GET)
    public String getstudentByKey(@PathVariable("sno") Integer sno,Model model){
        Student student = studentService.getStudentBySno(sno);
        model.addAttribute("student",student);
        return "student_personal";
    }

    /*修改数据时查询我的信息*/
    @RequestMapping(value = "/student/personal/update/{Sno}",method = RequestMethod.GET)
    public String toUpdateStudentPersonal(@PathVariable("Sno") Integer Sno,Model model){
        //根据Sno查询学生信息
        Student student = studentService.getStudentBySno(Sno);
        //共享到请求域中
        model.addAttribute("student",student);
        return "student_personal_update";
    }

    /*修改我的信息*/
    @RequestMapping(value = "/student/personal/update",method = RequestMethod.PUT)
    public String updateStudentPersonal(Student student){
        studentService.updateStudent(student);
        return "redirect:/student/personal/"+student.getSno();
    }
}
