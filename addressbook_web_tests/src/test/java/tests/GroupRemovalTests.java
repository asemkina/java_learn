package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.CreateGroup(new GroupData("Group1", "Group name", "Group footer"));
        }
        app.removeGroup();
    }
}
