package ir.maktabsharif92.springboot.base.service;

import ir.maktabsharif92.springboot.base.domain.Permission;

import java.util.Set;

public interface PermissionService {

    Permission findByName(String name);

    Set<Permission> saveAll(Set<String> permissions);
}
