package com.vasiliska.students.QuizSpringBoot.engine;


import com.vasiliska.students.QuizSpringBoot.dao.DataReaderImp;
import com.vasiliska.students.QuizSpringBoot.dao.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = com.vasiliska.students.QuizSpringBoot.service.QuizTestConfig.class)
public class QuizRunnerTest {

    @Autowired
    QuizRunner quizRunner;

    @Autowired
    Student student;

    @Autowired
    DataReaderImp dataReader;

    @Test
    public void getTotalResultTest() {
        quizRunner.setStudent(student);
        quizRunner.setDataQuiz(null);
        assertEquals(quizRunner.getTotalResult(6), "");
    }

}