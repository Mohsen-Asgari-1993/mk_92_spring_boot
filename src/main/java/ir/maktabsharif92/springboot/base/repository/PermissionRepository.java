package ir.maktabsharif92.springboot.base.repository;

import ir.maktabsharif92.springboot.base.domain.Permission;

public interface PermissionRepository extends BaseEntityRepository<Permission, Long> {

    Permission findByName(String name);
}
