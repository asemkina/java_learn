package tests;

import io.qameta.allure.Allure;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        Allure.step("Checking preconditon", step -> {
            if (app.hbm().getGroupCount() == 0 ) {
                app.hbm().CreateGroup(new GroupData("", "Group1", "Group name", "Group footer"));
            }
        });
                var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Allure.step("Validating results", step -> {
            Assertions.assertEquals(newGroups, expectedList);
        });
            }

    @Test
    public void canRemoveAllGroupsAtOnce() {
        if (app.hbm().getGroupCount() == 0 ) {
            app.hbm().CreateGroup(new GroupData("", "Group1", "Group name", "Group footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.hbm().getGroupCount());
    }
}
