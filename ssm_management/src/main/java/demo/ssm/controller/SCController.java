package demo.ssm.controller;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.SC;
import demo.ssm.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SCController {

    @Autowired
    private SCService scService;

    @RequestMapping(value = "/sc/{pageNum}",method = RequestMethod.GET)
    public String getSCPage(@PathVariable("pageNum") Integer pageNum, SC sc, Model model){
        PageInfo<SC> page = scService.getSCBySCToPage(pageNum,sc);
        model.addAttribute("page",page);
        return "sc";
    }

    @RequestMapping(value = "/sc/add",method = RequestMethod.POST)
    public String addSC(SC sc){
        scService.saveSC(sc);
        return "redirect:/sc/1";
    }

    @RequestMapping(value = "/sc/delete/{sno}/{cno}",method = RequestMethod.GET)
    public String deleteSCByKey(@PathVariable("sno") Integer sno,@PathVariable("cno") Integer cno){
        scService.deleteSCByKey(sno,cno);
        return "redirect:/sc/1";
    }

    /*修改选课信息时的写回*/
    @RequestMapping(value = "/sc/update/{sno}/{cno}",method = RequestMethod.GET)
    public String toUpdateSCPage(@PathVariable("sno") Integer sno,@PathVariable("cno") Integer cno,Model model){
        SC sc = scService.getSCByKey(sno,cno);
        model.addAttribute("sc",sc);
        return "sc_update";
    }

    @RequestMapping(value = "/sc/update",method = RequestMethod.PUT)
    public String updateupdateSCGradeByKey(SC sc){
        scService.updateSCByKey(sc);
        return "redirect:/sc/1";
    }

    /*查看我的成绩*/
    @RequestMapping(value = "/sc/personal/{sno}",method = RequestMethod.GET)
    public String getSCPersonalBySno(@PathVariable("sno") Integer sno,Model model){
        List<SC> list = scService.getSCBySnoToList(sno);
        model.addAttribute("list",list);
        model.addAttribute("sno",sno);
        return "sc_personal";
    }

    /*老师查看课程里的学生*/
    @RequestMapping(value = "/teacher/course/{cno}/{pageNum}",method = RequestMethod.GET)
    public String toSCByCno(@PathVariable("cno") Integer cno,@PathVariable("pageNum") Integer pageNum, Model model){
        PageInfo<SC> page = scService.getSCByCnoToPage(pageNum,cno);
        model.addAttribute("page",page);
        model.addAttribute("cno",cno);
        return "my_student";
    }

    /*学生添加课程*/
    @RequestMapping(value = "/sc/student/add",method = RequestMethod.POST)
    public String addTCStudent(SC sc){
        scService.saveSC(sc);
        return "redirect:/sc/personal/"+sc.getSno();
    }
}
