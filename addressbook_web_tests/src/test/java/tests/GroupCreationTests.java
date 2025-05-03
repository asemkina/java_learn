package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        int groupCount = app.groups().getCount();
        app.groups().CreateGroup(new GroupData("Group1", "Group name", "Group footer"));
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
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

