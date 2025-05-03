package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        app.groups().CreateGroup(new GroupData("Group1", "Group name", "Group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.groups().CreateGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithTitleOnly() {
        app.groups().CreateGroup(new GroupData().withTitle("some title"));
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.groups().CreateGroup(new GroupData().withName("some name"));
    }

    @Test
    public void CanCreateGroupWithFooterOnly() {
        app.groups().CreateGroup(new GroupData().withFooter("some footer"));
    }
}

