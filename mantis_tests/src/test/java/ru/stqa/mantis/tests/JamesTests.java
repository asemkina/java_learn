package ru.stqa.mantis.tests;
//java -Dworking.directory=. -jar james-server-jpa-app.jar  запуск сервера
//java -cp "james-server-jpa-app.lib/*" org.apache.james.cli.ServerCmd

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.io.IOException;

public class JamesTests extends TestBase {

    @Test
    void canCreateUser() throws IOException {
        app.jamesCli().addUser(
                String.format("%s@localhost", CommonFunctions.randomString(5)), ("password"));
    }

}
