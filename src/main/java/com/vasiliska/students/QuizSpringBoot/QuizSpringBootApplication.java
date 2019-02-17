package com.vasiliska.students.QuizSpringBoot;


import com.vasiliska.students.QuizSpringBoot.engine.AppProp;
import com.vasiliska.students.QuizSpringBoot.engine.QuizRunner;
import com.vasiliska.students.QuizSpringBoot.service.ShellService;
import com.vasiliska.students.QuizSpringBoot.service.ShellServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableConfigurationProperties(AppProp.class)
public class QuizSpringBootApplication {
                                             

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(QuizSpringBootApplication.class, args);

        QuizRunner quiz = configurableApplicationContext.getBean(QuizRunner.class);

        ShellService service = configurableApplicationContext.getBean(ShellServiceImpl.class);
        ((ShellServiceImpl) service).setQuizRunner(quiz);


        //System.out.println("Test!!!");

        //quiz.loadQuizData();

        //quiz.fillProfileStudent();
        //quiz.quizRun();
        //quiz.writeTotal();
    }

}
