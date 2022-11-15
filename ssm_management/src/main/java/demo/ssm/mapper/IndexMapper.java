package demo.ssm.mapper;

import demo.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IndexMapper {
    User authenticateUser(@Param("userid") Integer userid, @Param("userpassword") String userpassword);
}
