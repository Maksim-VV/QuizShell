package com.vasiliska.students.QuizSpringBoot;


import com.vasiliska.students.QuizSpringBoot.engine.AppProp;
import com.vasiliska.students.QuizSpringBoot.engine.QuizRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(AppProp.class)
public class QuizSpringBootApplication {

    private static String url;
    private static QuizRunner quiz;

    @Autowired
    QuizSpringBootApplication(AppProp prop, QuizRunner quiz) {
        this.url = prop.getUrl();
        this.quiz = quiz;
    }

    public static void main(String[] args) {
        SpringApplication.run(QuizSpringBootApplication.class, args);

        quiz.loadQuizData();
        quiz.fillProfileStudent();
        quiz.quizRun();
        quiz.writeTotal();
    }

}

