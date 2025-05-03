package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.groups().getCount() == 0 ) {
            app.groups().CreateGroup(new GroupData("Group1", "Group name", "Group footer"));
        }
        app.groups().ModifyGroup(new GroupData().withTitle("modifiedTitle"));
    }
}
