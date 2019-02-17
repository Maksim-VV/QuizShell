package com.vasiliska.students.QuizSpringBoot.engine;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties()
public class AppProp {
    private String url;
}
