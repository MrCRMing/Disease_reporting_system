package JavaEE.dao;

import JavaEE.domain.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> getByUserId(int user_id);
}
