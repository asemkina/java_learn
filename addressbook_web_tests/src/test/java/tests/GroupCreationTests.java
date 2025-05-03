package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        app.openGroupsPage();
        app.CreateGroup(new GroupData("Group1", "Group name", "Group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.openGroupsPage();
        app.CreateGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithTitleOnly() {
        app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithTitle = emptyGroup.withTitle("some title");
        app.CreateGroup(groupWithTitle);
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.CreateGroup(groupWithName);
    }

    @Test
    public void CanCreateGroupWithFooterOnly() {
        app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithFooter = emptyGroup.withFooter("some footer");
        app.CreateGroup(groupWithFooter);
    }
}

