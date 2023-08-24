package ir.maktabsharif92.springboot.base.service;

import ir.maktabsharif92.springboot.base.domain.User;

public interface UserService extends BaseUserService<User> {

    void init();

}
