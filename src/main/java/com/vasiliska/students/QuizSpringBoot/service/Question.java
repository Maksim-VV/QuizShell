package com.vasiliska.students.QuizSpringBoot.service;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Question
{
       private String numberQuestion;
       private String correctAnswer;
       private String question;
       public List<String> answers;
       public  Question()
       {
              answers = new LinkedList<String>();
       }
}
