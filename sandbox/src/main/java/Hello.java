import java.io.File;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println(2+2);
        System.out.println(3-1);
        System.out.println(3*8);
        System.out.println(6/2);
        System.out.println("Привет"+", мир");

    var configFile = new File("sandbox/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());
    }
}
