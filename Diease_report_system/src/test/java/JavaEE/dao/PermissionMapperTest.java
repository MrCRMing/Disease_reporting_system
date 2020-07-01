package JavaEE.dao;

import JavaEE.BaseTest;
import JavaEE.domain.Permission;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermissionMapperTest extends BaseTest {
    @Autowired
    PermissionMapper permissionMapper;
    @Test
    public void testGet(){
        List<Permission> byUserId = permissionMapper.getByUserId(1);
        for (Permission p: byUserId){
            System.out.println(p);
        }
    }
}
