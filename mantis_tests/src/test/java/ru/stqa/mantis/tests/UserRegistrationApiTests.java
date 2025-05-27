package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationApiTests extends TestBase {

    @Test
    void canCreateUser() throws InterruptedException {
        var user = (new UserData()
                .withUsername(CommonFunctions.randomString(5))
                .withEmail(String.format("%s@localhost", CommonFunctions.randomString(6))));

        app.jamesApi().addUser(user.email(), "password");

        app.rest().createUser(user);

        var messages = app.mail().receive(user.email(), user.password(), Duration.ofSeconds(120));
        System.out.println(messages);

        //извлекаем ссылку
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);

            //возвращаемся в браузер, проходим по ссылке и завершем регистрацию (браузер)
            app.newaccount().clickUrl(url);
            app.newaccount().editAccount(user.username(), "password");

            //проверяем, что пользователь может залогиниться (HttpSessionHelper)
            app.http().login(user.username(), "password");
            Assertions.assertTrue(app.http().loggedIn());
        } else {
            throw new RuntimeException("The registration confirmation link was not found in the email");
        }
    }
}
