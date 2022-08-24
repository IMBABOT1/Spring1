package ru.geekbrains.spring1.lesson4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.spring1.lesson4.Entities.Product;
import ru.geekbrains.spring1.lesson4.Repository.MySqlRepository;
import ru.geekbrains.spring1.lesson4.Repository.ProductDao;
import ru.geekbrains.spring1.lesson4.Utils.SessionFactoryUtils;

import java.util.List;

@SpringBootApplication
public class SpringBootLesson4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLesson4Application.class, args);


        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

    }
}