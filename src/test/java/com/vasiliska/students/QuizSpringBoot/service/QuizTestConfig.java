package com.vasiliska.students.QuizSpringBoot.service;

import com.vasiliska.students.QuizSpringBoot.dao.DataReaderImp;
import com.vasiliska.students.QuizSpringBoot.dao.Student;
import com.vasiliska.students.QuizSpringBoot.engine.QuizRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class QuizTestConfig {


    @Bean
    public ShellServiceImpl shellServiceImpl() {
        return new ShellServiceImpl();

    }

    @Bean
    public DataReaderImp dataReaderImp() {
        return new DataReaderImp();
    }

    @Bean
    public QuizRunner quizRunner() {
        return new QuizRunner();
    }

    @Bean
    public Student student() {
        return new Student();
    }


}
