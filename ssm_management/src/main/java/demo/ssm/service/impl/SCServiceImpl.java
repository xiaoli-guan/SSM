package demo.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.ssm.mapper.SCMapper;
import demo.ssm.pojo.Course;
import demo.ssm.pojo.SC;
import demo.ssm.pojo.SCExample;
import demo.ssm.pojo.SCKey;
import demo.ssm.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCServiceImpl implements SCService {

    @Autowired
    private SCMapper scMapper;

    @Override
    public PageInfo<SC> getSCBySCToPage(Integer pageNum, SC sc) {
        PageHelper.startPage(pageNum,12);

        /*条件查询，支持模糊*/
        List<SC> list = scMapper.selectBySCLike(sc);
        PageInfo<SC> page = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public void saveSC(SC sc) {
        scMapper.insertSelective(sc);
    }

    @Override
    public void deleteSCByKey(Integer sno, Integer cno) {
        scMapper.deleteByPrimaryKey(new SCKey(sno,cno));
    }

    @Override
    public SC getSCByKey(Integer sno, Integer cno) {
        SC sc = scMapper.selectByPrimaryKey(new SCKey(sno, cno));
        return sc;
    }

    @Override
    public void updateSCByKey(SC sc) {
        scMapper.updateByPrimaryKey(sc);
    }

    @Override
    public List<SC> getSCBySnoToList(Integer sno) {

        SCExample scExample = new SCExample();
        scExample.createCriteria().andSnoEqualTo(sno);
        List<SC> list = scMapper.selectByExample(scExample);
        return list;
    }

    @Override
    public PageInfo<SC> getSCByCnoToPage(Integer pageNum, Integer cno) {

        PageHelper.startPage(pageNum,12);

        SCExample scExample = new SCExample();
        scExample.createCriteria().andCnoEqualTo(cno);
        List<SC> list = scMapper.selectByExample(scExample);
        PageInfo<SC> page = new PageInfo<>(list,5);
        return page;
    }
}
