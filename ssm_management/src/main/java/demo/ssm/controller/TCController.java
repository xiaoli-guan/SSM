package demo.ssm.controller;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.TC;
import demo.ssm.pojo.TCKey;
import demo.ssm.pojo.Teacher;
import demo.ssm.service.TCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TCController {

    @Autowired
    private TCService tcService;

    /*教师查看已申请的课程*/
    @RequestMapping(value = "/tc/teacher/{teaId}",method = RequestMethod.GET)
    public String toTCTeacherByTeaId(@PathVariable("teaId") Integer teaId, Model model){
        List<TC> list = tcService.getAllMyCoursePageByTeaId(teaId);
        model.addAttribute("list",list);
        model.addAttribute("teaId",teaId);
        return "my_course_teacher";
    }

    /*申请新的课程*/
    @RequestMapping(value = "/tc/to/add/{teaId}",method = RequestMethod.GET)
    public String toAddTC(@PathVariable("teaId") Integer teaId,Model model){
        model.addAttribute("teaId",teaId);
        return "tc_add";
    }

    @RequestMapping(value = "/tc/add",method = RequestMethod.PUT)
    public String addTC(TC tc){
        tcService.insertTCByTC(tc);
        return "redirect:/tc/teacher/"+tc.getTeaId();
    }

    @RequestMapping(value = "/tc/admin",method = RequestMethod.GET)
    public String toTCAdminPage(Model model){
        /*获取未处理的课程申请*/
        List<TC> list = tcService.getTCAdmin();
        model.addAttribute("list",list);
        return "tc_admin";
    }

    @RequestMapping(value = "/tc/admin/{progress}/{teaId}/{cno}",method = RequestMethod.GET)
    public String tCAdmin(@PathVariable("progress") String progress,@PathVariable("teaId") Integer teaId,@PathVariable("cno") Integer cno){
        tcService.updateTCByKey(new TC(cno,teaId,progress));
        return "redirect:/tc/admin";
    }
}
