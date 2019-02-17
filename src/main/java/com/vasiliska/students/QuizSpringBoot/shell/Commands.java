package com.vasiliska.students.QuizSpringBoot.shell;

import com.vasiliska.students.QuizSpringBoot.service.ShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Commands {

    private final ShellService shellService;

    @Autowired
    public Commands(ShellService shellService) {
        this.shellService = shellService;
    }

    @ShellMethod("Name")
    public String name(@ShellOption String name) {
        return shellService.name(name);
    }

    @ShellMethod("Surname")
    public String surname(@ShellOption String surname) {
        return shellService.surname(surname);
    }

    @ShellMethod("Start")
    public String quiz(@ShellOption String start) {
        return shellService.quiz(start);
    }

    @ShellMethod("Question")
    public String anser(@ShellOption String value) {
        return shellService.anser(value);
    }
}
