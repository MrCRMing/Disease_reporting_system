package JavaEE.dao;

import JavaEE.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testGetUserByEmailAddr(){
        User userByEmailAddr = userMapper.getUserByEmailAddr("729788221@qq.com");
        System.out.println(userByEmailAddr);
    }
}
