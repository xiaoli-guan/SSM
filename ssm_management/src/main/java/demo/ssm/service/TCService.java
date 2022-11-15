package demo.ssm.service;

import com.github.pagehelper.PageInfo;
import demo.ssm.pojo.TC;
import demo.ssm.pojo.TCKey;

import java.util.List;

public interface TCService {
    List<TC> getAllMyCoursePageByTeaId(Integer teaId);

    void insertTCByTC(TC tc);

    List<TC> getTCAdmin();


    void updateTCByKey(TC tc);
}
