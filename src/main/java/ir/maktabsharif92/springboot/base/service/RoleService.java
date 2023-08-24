package ir.maktabsharif92.springboot.base.service;

import ir.maktabsharif92.springboot.base.domain.Permission;
import ir.maktabsharif92.springboot.base.domain.Role;

import java.util.Set;

public interface RoleService {

    Role findByName(String name);

    Role createIfNotExistsAndGet(String name);

    void saveOrUpdate(String roleName, Set<Permission> permissionSet);
}
