package ir.maktabsharif92.springboot.base.service;

import ir.maktabsharif92.springboot.base.domain.Permission;

public interface PermissionService {
    void init();

    long count();

    Permission findByName(String name);
}
