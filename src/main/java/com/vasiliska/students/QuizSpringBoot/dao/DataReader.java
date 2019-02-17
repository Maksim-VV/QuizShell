package com.vasiliska.students.QuizSpringBoot.dao;

import com.vasiliska.students.QuizSpringBoot.service.Question;
import java.util.List;


public interface DataReader
{
       List<Question> readData();
}
