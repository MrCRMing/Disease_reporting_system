package JavaEE.dao;

import JavaEE.BaseTest;
import JavaEE.domain.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleMapperTest extends BaseTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testGet(){
        List<Role> byUserId = roleMapper.getByUserId(1);
        System.out.println(byUserId);
    }
}
