package com.vasiliska.students.QuizSpringBoot.service;

import com.vasiliska.students.QuizSpringBoot.engine.QuizRunner;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ShellServiceImpl implements ShellService {


    private QuizRunner quizRunner;
    private int numQuest = 0;
    private int rightAnswer = 0;
    private List<Question> dataQuiz;
    private final String SEPARATOR_STR = "; ";

    @Autowired
    ShellServiceImpl(QuizRunner quizRunner) {
        this.quizRunner = quizRunner;
        quizRunner.loadQuizData();
        dataQuiz = quizRunner.getDataQuiz();
        System.err.println("\n" + quizRunner.getHelloText() + "\n");
    }

    ShellServiceImpl() {
    }


    @Override
    public String quiz(String start) {
        return quizRunner.getSuranameQuest();
    }

    @Override
    public String surname(String surname) {
        quizRunner.setStudentSurname(surname);
        return quizRunner.getNameQuest();
    }

    @Override
    public String name(String name) {
        quizRunner.setStudentName(name);
        return quizRunner.getStartQuizText() + getQuestion();
    }

    @Override
    public String anser(String value) {

        if (numQuest == 0) {
            return "";
        }
        if (numQuest >= dataQuiz.size()) {
            return quizRunner.getTotalResult(rightAnswer);
        }
        if (value != null &&
                value.equals(dataQuiz.get(numQuest - 1).getCorrectAnswer())) {
            rightAnswer++;
        }
        return getQuestion();
    }

    private String getQuestion() {
        StringBuffer questStr = new StringBuffer();
        questStr.append(dataQuiz.get(numQuest).getNumberQuestion()).append(" ");
        questStr.append(dataQuiz.get(numQuest).getQuestion()).append(" : ");
        dataQuiz.get(numQuest).getAnswers().forEach(v -> {
                    questStr.append(v + SEPARATOR_STR);
                }
        );
        numQuest++;
        return questStr.toString();
    }

}


