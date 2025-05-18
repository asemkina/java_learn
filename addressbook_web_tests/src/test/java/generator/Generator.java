package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//--type contacts --output contacts.xml --format xml --count 4

public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--count", "-n"})
    Integer count;

    public static void main(String[] args) throws IOException {
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContactsWithPhoto();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }

    private Object generateData(Supplier<Object> dataSupplier) {
        return Stream.generate(dataSupplier).limit(count).collect(Collectors.toList());
    }

    private Object generateGroups() {
//        return generateData(() -> new GroupData()
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withTitle(CommonFunctions.randomString( 5))
                    .withName(CommonFunctions.randomString(5))
                    .withFooter(CommonFunctions.randomString(5)));
    }
        return result;
    }

//    private Object generateContacts() {
//        return generateData(() -> new ContactData()
//                .withFirstName(CommonFunctions.randomString(4))
//                .withLastName(CommonFunctions.randomString(4)));
//    }

    private Object generateContactsWithPhoto() {
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            result.add(new ContactData()
                    .withFirstName(CommonFunctions.randomString(i * 4))
                    .withLastName(CommonFunctions.randomString(i * 4))
                    .withAddress(CommonFunctions.randomString(i * 4))
                    .withHomePhone(CommonFunctions.randomString(i * 4))
                    .withEmail(CommonFunctions.randomString(i * 4))
                    .withPhoto(CommonFunctions.randomFile("src/test/resources/images"))
                    .withMobilePhone(CommonFunctions.randomString(i * 4))
                    .withWorkPhone(CommonFunctions.randomString(i * 4))
                    .withEmail2(CommonFunctions.randomString(i * 4))
                    .withEmail3(CommonFunctions.randomString(i * 4))
                    .withPhone2Phone(CommonFunctions.randomString(i * 4)));
        }
        return result;
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);
            try (var writer = new FileWriter(output)) {
                writer.write(json);
            }
        } else if ("yaml".equals(format)) {
            var mapper = new YAMLMapper();
            mapper.writeValue(new File(output), data);
        } else if ("xml".equals(format)) {
            var mapper = new XmlMapper();
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("Неверный формат данных " + format);
        }

    }
}



