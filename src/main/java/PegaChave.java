import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PegaChave {

    public static String chaveFilmes() throws IOException {

        String configFilePath = "src/main/resources/config.properties";
        FileInputStream propsInput = new FileInputStream(configFilePath);
        Properties prop = new Properties();
        prop.load(propsInput);

        return prop.getProperty("keyMovies");
    }

    public static String chaveNasa() throws IOException {

        String configFilePath = "src/main/resources/config.properties";
        FileInputStream propsInput = new FileInputStream(configFilePath);
        Properties prop = new Properties();
        prop.load(propsInput);

        return prop.getProperty("keyNasa");
    }

}
