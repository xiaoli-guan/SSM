package demo.ssm.service.impl;

import demo.ssm.mapper.IndexMapper;
import demo.ssm.pojo.User;
import demo.ssm.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Override
    public User authenticateUser(Integer userid, String userpassword) {
        return indexMapper.authenticateUser(userid,userpassword);
    }
}
