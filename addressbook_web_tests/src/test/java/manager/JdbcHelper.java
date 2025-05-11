package manager;

import model.GroupData;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase {
    public JdbcHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<GroupData> getGroupList() {
        var groups = new ArrayList<GroupData>(); ///создаем пустой список
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");///устанавливаем соединение с БД
             var statement = conn.createStatement(); /// закрываем соединение с БД
             var result = statement.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list")) ///выполняем запрос всех записей в таблице групп
                         /// анализ результатов запроса
        {  while (result.next()) { ///пока результаты не кончились
                groups.add(new GroupData()//добавляем новый объект в список GroupData с данными из таблицы group_list
                        .withId(result.getString("group_id")) ///
                        .withTitle(result.getString("group_name"))
                        .withName(result.getString("group_header"))
                        .withFooter(result.getString("group_footer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups; ///возвращаем список

    }
}
