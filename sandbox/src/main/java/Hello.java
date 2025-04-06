import java.io.File;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println(2+2);
        System.out.println(3-1);
        System.out.println(3*8);
        System.out.println(6/2);
        System.out.println("Привет"+", мир");

    var configFile = new File("sandbox/build.gradle"); ///создание объекта класса File
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());///метод exists вызывается в объекте configFile
    }
}
