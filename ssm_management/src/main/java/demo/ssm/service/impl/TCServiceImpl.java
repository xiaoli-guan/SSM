package demo.ssm.service.impl;

import com.github.pagehelper.PageInfo;
import demo.ssm.mapper.TCMapper;
import demo.ssm.mapper.TCMapper;
import demo.ssm.pojo.TC;
import demo.ssm.pojo.TCExample;
import demo.ssm.pojo.TCKey;
import demo.ssm.service.TCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TCServiceImpl implements TCService {

    @Autowired
    private TCMapper tcMapper;

    @Override
    public List<TC> getAllMyCoursePageByTeaId(Integer teaId) {
        TCExample tcExample = new TCExample();
        tcExample.createCriteria().andTeaIdEqualTo(teaId);
        List<TC> list = tcMapper.selectByExample(tcExample);
        return list;
    }

    @Override
    public void insertTCByTC(TC tc) {
        tcMapper.insert(tc);
    }

    @Override
    public List<TC> getTCAdmin() {
        TCExample tcExample = new TCExample();
        tcExample.createCriteria().andProgressEqualTo("未处理");
        List<TC> list = tcMapper.selectByExample(tcExample);
        return list;
    }

    @Override
    public void updateTCByKey(TC tc) {
        tcMapper.updateByPrimaryKey(tc);
    }


}
