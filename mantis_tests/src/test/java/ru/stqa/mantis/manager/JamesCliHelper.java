package ru.stqa.mantis.manager;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.openqa.selenium.io.CircularOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class JamesCliHelper extends HelperBase {

    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addUser(String email, String password) throws IOException {
        CommandLine cmd = new CommandLine("java");
        cmd.addArgument("-cp");
        cmd.addArgument("james-server-jpa-app.lib/*");
        cmd.addArgument("org.apache.james.cli.ServerCmd");
        cmd.addArgument("AddUser");
        cmd.addArgument(email);
        cmd.addArgument(password);

//        cmd.setWorkingDirectory();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

//        CircularOutputStream out = new CircularOutputStream();
//        cmd.copyOutputTo(out);

        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(streamHandler);
        executor.setWorkingDirectory(new File(manager.property("james.workingDir")));
        int exitCode = executor.execute(cmd);

        String commandOutput = outputStream.toString();
        System.out.println("Output: " + commandOutput);
    }


}

