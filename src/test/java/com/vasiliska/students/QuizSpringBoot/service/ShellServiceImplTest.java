package com.vasiliska.students.QuizSpringBoot.service;

import com.vasiliska.students.QuizSpringBoot.dao.Student;
import com.vasiliska.students.QuizSpringBoot.engine.QuizRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = com.vasiliska.students.QuizSpringBoot.service.QuizTestConfig.class)
public class ShellServiceImplTest {

    @Autowired
    ShellServiceImpl shellService;

    @Autowired
    QuizRunner quizRunner;

    @Autowired
    Student student;

    @Test
    public void dataTest() {
        String testEmpty = shellService.anser("");
        assertEquals(testEmpty, "");
    }

    @Test
    public void anserDataQuiz() {
        shellService.setDataQuiz(Arrays.asList(new Question()));
        shellService.setNumQuest(6);
        quizRunner.setStudent(student);
        shellService.setQuizRunner(quizRunner);
        shellService.setRightAnswer(4);

        String testEmpty = shellService.anser("2");
        assertEquals(testEmpty, "");
    }
}