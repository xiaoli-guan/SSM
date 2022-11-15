package demo.ssm.service;

import demo.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface IndexService {
    User authenticateUser(Integer userid, String userpassword);
}
