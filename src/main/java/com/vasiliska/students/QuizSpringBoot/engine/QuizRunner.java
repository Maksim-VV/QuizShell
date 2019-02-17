package com.vasiliska.students.QuizSpringBoot.engine;

import com.vasiliska.students.QuizSpringBoot.dao.DataReader;
import com.vasiliska.students.QuizSpringBoot.dao.DataReaderImp;
import com.vasiliska.students.QuizSpringBoot.dao.Student;
import com.vasiliska.students.QuizSpringBoot.service.Question;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Slf4j
@Getter
@Setter
@Service
public class QuizRunner {
    private int rightAnswer = 0;
    private List<Question> dataQuiz;
    private DataReader data;
    private String suranameQuest;
    private String nameQuest;
    private String startQuizText;
    private Student student;

    private MessageSource messageSource;
    private Locale locale;


    @Autowired
    public QuizRunner(DataReaderImp data, MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
        this.data = data;
        student = new Student();
        setStudentPersonalData();
        startQuizText = messageSource.getMessage("startQuiz", null, locale);
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public void setStudentSurname(String surname) {
        student.setName(surname);
    }

    private void setStudentPersonalData() {
        suranameQuest = messageSource.getMessage("enterSurname", null, locale);
        nameQuest = messageSource.getMessage("enterName", null, locale);
    }

    public String getTotalResult(int rightAnswer) {
        int countQuest = 0;
        student.setScore(rightAnswer);

        if (dataQuiz != null) {
            countQuest = dataQuiz.size();
        }

        return (messageSource.getMessage("finishQuiz", new String[]{student.getName(),
                String.valueOf(student.getScore()), String.valueOf(countQuest)}, locale));
    }

    public void loadQuizData() {
        try {
            dataQuiz = data.readData();
        } catch (Exception ex) {
            System.out.println(messageSource.getMessage("errorLoadQuiz", null, locale));
            log.error("Error loading the list of questions {}", ex);
        }

    }
}
