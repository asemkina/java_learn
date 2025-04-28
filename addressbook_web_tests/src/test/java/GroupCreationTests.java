import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        openGroupsPage();
        CreateGroup("Group1", "Group name", "Group footer");
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        openGroupsPage();
        CreateGroup("", "", "");
    }
}

