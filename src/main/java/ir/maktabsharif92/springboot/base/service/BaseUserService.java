package ir.maktabsharif92.springboot.base.service;

import ir.maktabsharif92.springboot.base.domain.User;

import java.util.Optional;

public interface BaseUserService<E extends User> {

    Optional<E> findByUsername(String username);

    long count();

}
