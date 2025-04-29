import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        openGroupsPage();
        CreateGroup(new GroupData("Group1", "Group name", "Group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        openGroupsPage();
        CreateGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithTitle = emptyGroup.withTitle("some title");
        CreateGroup(groupWithTitle);
    }
}

