package ir.maktabsharif92.springboot.service;

import ir.maktabsharif92.springboot.base.service.BaseUserService;
import ir.maktabsharif92.springboot.domain.Admin;

public interface AdminService extends BaseUserService<Admin> {

    void init();

}
