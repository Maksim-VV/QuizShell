package com.vasiliska.students.QuizSpringBoot.shell;

import com.vasiliska.students.QuizSpringBoot.service.ShellService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class Commands {

    private final ShellService shellService;
    @Setter
    private int currentPoint = 0;

    @Autowired
    public Commands(ShellService shellService) {
        this.shellService = shellService;
    }


    @ShellMethod("Surname")
    @ShellMethodAvailability("availabilityCheckSurname")
    public String surname(@ShellOption String surname) {
        currentPoint = 2;
        return shellService.surname(surname);
    }

    public Availability availabilityCheckSurname() {
        if (currentPoint == 1) {
            return Availability.available();
        }
        return Availability.unavailable(shellService.getMessage());
    }

    @ShellMethod("Name")
    @ShellMethodAvailability("availabilityCheckName")
    public String name(@ShellOption String name) {
        currentPoint = 3;
        return shellService.name(name);
    }
    public Availability availabilityCheckName() {
        if (currentPoint == 2) {
            return Availability.available();
        }
        return Availability.unavailable(shellService.getMessage());
    }


    @ShellMethod("Start")
    @ShellMethodAvailability("availabilityCheckStart")
    public String start() {
        currentPoint = 1;
        return shellService.start();
    }

    public Availability availabilityCheckStart() {
        if (currentPoint == 0) {
            return Availability.available();
        }
        return Availability.unavailable(shellService.getMessage());
    }

    @ShellMethod("Question")
    @ShellMethodAvailability("availabilityCheckQuestion")
    public String anser(@ShellOption String value) {
        return shellService.anser(value);
    }

    public Availability availabilityCheckQuestion() {
        if (currentPoint == 3) {
            return Availability.available();
        }
        return Availability.unavailable(shellService.getMessage());
    }

    


}
