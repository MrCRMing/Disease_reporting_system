package JavaEE.dao;

import JavaEE.domain.Permission;
import JavaEE.domain.Role;

import java.util.List;

public interface PermissionMapper {
    List<Permission> getByUserId(int user_id);
}
