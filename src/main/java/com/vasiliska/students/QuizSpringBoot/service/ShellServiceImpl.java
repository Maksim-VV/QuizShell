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
    private boolean isStart = false;
    private String messageText;

    @Autowired
    ShellServiceImpl(QuizRunner quizRunner) {
        this.quizRunner = quizRunner;
        quizRunner.loadQuizData();
        dataQuiz = quizRunner.getDataQuiz();
        messageText = quizRunner.getHelloText();
        System.err.println("\n" + messageText + "\n");
    }

    ShellServiceImpl() {
    }

    @Override
    public String getMessage() {
        return messageText;
    }

    @Override
    public String start() {
        messageText = quizRunner.getSuranameQuest();
        return messageText;
    }


    @Override
    public String surname(String surname) {
        quizRunner.setStudentSurname(surname);
        messageText = quizRunner.getNameQuest();
        return messageText;
    }

    @Override
    public String name(String name) {
        quizRunner.setStudentName(name);
        messageText = quizRunner.getStartQuizText() + getQuestion();
        return messageText;
    }

    @Override
    public String anser(String value) {

        if (numQuest == 0) {
            messageText = "";
            return messageText;
        }
        if (numQuest >= dataQuiz.size()) {
            messageText = quizRunner.getTotalResult(rightAnswer);
            return messageText;
        }
        if (value != null &&
                value.equals(dataQuiz.get(numQuest - 1).getCorrectAnswer())) {
            rightAnswer++;
        }
        messageText = getQuestion();
        return messageText;
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


