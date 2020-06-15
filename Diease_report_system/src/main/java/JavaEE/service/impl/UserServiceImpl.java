package JavaEE.service.impl;

import JavaEE.dao.UserMapper;
import JavaEE.domain.User;
import JavaEE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired()
    private UserMapper userMapper;
    @Override
    public void register(User user,String role) {
        userMapper.addUser(user);
        //可以在这里用role参数来设置该用户的权限
    }

    @Override
    public int login(String email_addr, String password,User user) {
        User got_user=userMapper.findUser(email_addr);
        if(got_user==null){
            //该账号不存在
            return 2;
        }else{
            if(got_user.getPassword().equals(password)){
                //找到对应用户，登录成功
                user.setEmail_addr(got_user.getEmail_addr());
                user.setPassword(got_user.getPassword());
                user.setUsername(got_user.getUsername());
                user.setUser_id(got_user.getUser_id());
                return 1;
            }else{
                //密码错误
                return 3;
            }
        }
    }


}
