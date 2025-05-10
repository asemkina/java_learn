package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
//        for (var title : List.of("","group title")) {
//            for (var name : List.of("","group name")){
//                for (var footer : List.of("", "group footer")){
//                    result.add(new GroupData().withTitle(title).withName(name).withFooter(footer));
//                }
//            }
//        }
//        for (int i=0; i<5; i++) { ///переменная i является счетчиком, на каждой итерации к i прибавляется 1(инкремент)
//            result.add(new GroupData()
//                    .withTitle(CommonFunctions.randomString(i * 5))
//                    .withName(CommonFunctions.randomString(i * 5))
//                    .withFooter(CommonFunctions.randomString(i * 5)));
//        }
        var json = "";  ///чтение файла по строчке
        try (var reader = new FileReader("groups.json");
             var breader = new BufferedReader(reader)) {
            var line = breader.readLine();
            while (line !=null){
                json = json + line;
                line = breader.readLine();
            }
        }
      // var json = Files.readString(Paths.get("groups.json")); ...чтение файла целиком
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<GroupData>>() {
        });
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void CanCreateMultipleGroups(GroupData group) {
        var oldGroups = app.groups().getList();
        app.groups().CreateGroup(group);
        var newGroups = app.groups().getList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size() - 1).id()).withName("").withFooter(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group title '", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void CanNotCreateGroup(GroupData group) {
        var oldGroups = app.groups().getList();
        app.groups().CreateGroup(group);
        var newGroups = app.groups().getList();
        Assertions.assertEquals(newGroups, oldGroups);
    }
}

