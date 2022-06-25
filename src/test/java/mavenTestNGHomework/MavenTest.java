package mavenTestNGHomework;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class MavenTest {
    /*
    TASK - 3
    1. Add an additional dependency to POM.xml from here https://mvnrepository.com/artifact/com.github.lalyos/jfiglet
    2. Under the mavenTestNGHomework package, create a new java class, name it MavenTest and change the method there.
    Call the main method
    3 Using this new library, print your name to the console.
     */

    public static void main(String[] args) throws IOException {
        String asciiArt = FigletFont.convertOneLine("Mārtiņš Rudevics");
        System.out.println(asciiArt);
    }
}
