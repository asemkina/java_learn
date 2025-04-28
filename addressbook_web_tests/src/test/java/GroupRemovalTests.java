import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()) {
            CreateGroup("Group1", "Group name", "Group footer");
        }
        removeGroup();
    }
}
