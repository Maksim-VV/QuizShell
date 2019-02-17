package com.vasiliska.students.QuizSpringBoot.engine;

import com.vasiliska.students.QuizSpringBoot.service.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizRunnerTest {

    @Autowired
    QuizRunner quizRunner;

    @Test
    public void quizRunTest() {
        quizRunner.setDataQuiz(null);
        assertFalse(quizRunner.quizRun());
    }

    @Test
    public void quizRunTestScore() {
        List<Question> listQuest = new ArrayList<>();
        quizRunner.setDataQuiz(listQuest);
        assertTrue(quizRunner.quizRun());
        assertEquals(quizRunner.getRightAnswer(), 0);
    }

}