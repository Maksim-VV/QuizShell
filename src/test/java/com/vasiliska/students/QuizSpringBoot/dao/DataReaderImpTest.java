package com.vasiliska.students.QuizSpringBoot.dao;


import com.vasiliska.students.QuizSpringBoot.service.Question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;



@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = com.vasiliska.students.QuizSpringBoot.service.QuizTestConfig.class)
public class DataReaderImpTest {

    @Autowired
    DataReaderImp dataReaderImp;

    @Test
        public void dataTest() {
        dataReaderImp.setQuestList(new ArrayList<Question>());
        dataReaderImp.setFileName("quizTesten_US.csv");
        int sizeTest =  dataReaderImp.readData().size();
        Assert.assertEquals(sizeTest, 6);
        }

}