package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.io.IOException;
import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase {

    @Test
    void canRegistrateUser() throws IOException, InterruptedException {
        var username = String.format("%s", CommonFunctions.randomString(6));
        var email = String.format("%s@localhost", CommonFunctions.randomString(6), username);
        var password = String.format("%s", CommonFunctions.randomString(10));

        //создать пользователя (адрес на почтовом сервере)(JamesHelper)
        app.jamesApi().addUser(email, password);

        //открываем браузер, заполняем форму создания и отправляем (браузер)

        app.newaccount().loginNewAccount(username, email);

        //получаем (ждем) письмо (Mailhelper)
        var messages = app.mail().receive(email, password, Duration.ofSeconds(180));
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
            app.newaccount().editAccount(username, password);

            //проверяем, что пользователь может залогиниться (HttpSessionHelper)
            app.http().login(username, password);
            Assertions.assertTrue(app.http().loggedIn());
        }
    }
}
