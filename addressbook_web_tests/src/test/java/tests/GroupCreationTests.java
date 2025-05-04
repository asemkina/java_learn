package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for (var title : List.of("","group title")) {
            for (var name : List.of("","group name")){
                for (var footer : List.of("", "group footer")){
                    result.add(new GroupData().withTitle(title).withName(name).withFooter(footer));
                }
            }
        }
        for (int i=0; i<5; i++) { ///переменная i является счетчиком, на каждой итерации к i прибавляется 1(инкремент)
            result.add(new GroupData()
                    .withTitle(randomString(i * 5))
                    .withName(randomString(i * 5))
                    .withFooter(randomString(i * 5)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void CanCreateMultipleGroups(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().CreateGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData ("", "group title '", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void CanNotCreateGroup(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().CreateGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
}

