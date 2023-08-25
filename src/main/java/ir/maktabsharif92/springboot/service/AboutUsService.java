package ir.maktabsharif92.springboot.service;

import ir.maktabsharif92.springboot.domain.AboutUs;

public interface AboutUsService {

    void init();

    AboutUs get();

    AboutUs update(String content);

}
