package ru.postme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.postme.config.AppConfig;
import ru.postme.database.dao.impl.UserDaoImpl;
import ru.postme.database.model.User;

@SpringBootApplication
public class PostMe {


    public static void main(String[] args) {


       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpringApplication.run(PostMe.class, args);

    }
}