package tests;

import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.hbm().getGroupCount() == 0 ) {
            app.hbm().CreateGroup(new GroupData("", "Group1", "Group name", "Group footer"));
        }
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withTitle(CommonFunctions.randomString(10));
        app.groups().ModifyGroup(oldGroups.get(index), testData);
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index,testData.withId(oldGroups.get(index).id()));
        Comparator<GroupData> compareById = getGroupDataComparator();
        newGroups.sort(compareById);
        expectedList.sort((compareById));
        Assertions.assertEquals(expectedList, newGroups);
//        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(expectedList));
    }

}
