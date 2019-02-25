package com.vasiliska.students.QuizSpringBoot.engine;

import com.vasiliska.students.QuizSpringBoot.dao.DataReader;
import com.vasiliska.students.QuizSpringBoot.dao.Student;
import com.vasiliska.students.QuizSpringBoot.service.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = com.vasiliska.students.QuizSpringBoot.service.QuizTestConfig.class)
public class QuizRunnerTest {

    @Autowired
    QuizRunner quizRunner;

    @Autowired
    Student student;

    @Autowired
    DataReader dataReader;

    @Test
    public void getTotalResultTest() {
        quizRunner.setStudent(student);
        quizRunner.setDataQuiz(null);
        assertEquals(quizRunner.getTotalResult(6),"");
    }

    @Test
    public void loadQuizDataTest() {
        quizRunner.setData(dataReader);
        quizRunner.loadQuizData();
        assertEquals(quizRunner.getDataQuiz().size(), 1);
    }

}