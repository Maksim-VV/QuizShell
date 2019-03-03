package com.vasiliska.students.QuizSpringBoot.shell;


import com.vasiliska.students.QuizSpringBoot.service.ShellServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})

public class CommandsTest {

    @Autowired
    ShellServiceImpl shellService;

    @Autowired
    private Shell shell;

    @Autowired
    Commands commands;

    @Test
    public void runTest() {
        shellService.setMessageText("ShellCommandsTest");
        commands.setCurrentPoint(1);
        Object textTest = shell.evaluate(() -> "name Bob");
        assertTrue(textTest.toString().contains("ShellCommandsTest"));
    }

}