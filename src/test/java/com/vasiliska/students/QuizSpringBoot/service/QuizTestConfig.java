package com.vasiliska.students.QuizSpringBoot.service;

import com.vasiliska.students.QuizSpringBoot.dao.DataReader;
import com.vasiliska.students.QuizSpringBoot.dao.DataReaderImp;
import com.vasiliska.students.QuizSpringBoot.dao.Student;
import com.vasiliska.students.QuizSpringBoot.engine.AppProp;
import com.vasiliska.students.QuizSpringBoot.engine.QuizRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
@ComponentScan
public class QuizTestConfig {

    @Bean
    public ShellServiceImpl shellServiceImpl() {
        return new ShellServiceImpl();

    }

    @Bean
    public DataReaderImp dataReaderImp(){
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
