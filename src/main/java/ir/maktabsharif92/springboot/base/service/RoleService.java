package ir.maktabsharif92.springboot.base.service;

import ir.maktabsharif92.springboot.base.domain.Role;

public interface RoleService {
    void init();

    Role findByName(String name);

    Role createIfNotExistsAndGet(String name);
}
