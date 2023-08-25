package ir.maktabsharif92.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Mk92SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mk92SpringBootApplication.class, args);
    }

}
