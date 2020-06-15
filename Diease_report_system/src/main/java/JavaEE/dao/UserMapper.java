package JavaEE.dao;

import JavaEE.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //新增用户
    public void addUser(User user);

    //查找用户--用于登录
    public User findUser(String email_addr);

    //查询所有用户接口
    public List<User> findAll();
}
