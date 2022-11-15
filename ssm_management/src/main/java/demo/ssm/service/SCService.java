package demo.ssm.service;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.SC;

import java.util.List;

public interface SCService {
    PageInfo<SC> getSCBySCToPage(Integer pageNum, SC sc);

    void saveSC(SC sc);

    void deleteSCByKey(Integer sno, Integer cno);

    SC getSCByKey(Integer sno, Integer cno);

    void updateSCByKey(SC sc);

    List<SC> getSCBySnoToList(Integer sno);

    PageInfo<SC> getSCByCnoToPage(Integer pageNum, Integer cno);
}
