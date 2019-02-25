package com.vasiliska.students.QuizSpringBoot;


import com.vasiliska.students.QuizSpringBoot.engine.AppProp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProp.class)
public class QuizSpringBootApplication {
                                             

    public static void main(String[] args) {
                SpringApplication.run(QuizSpringBootApplication.class, args);
    }

}
