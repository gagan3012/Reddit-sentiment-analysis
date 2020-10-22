package is.equinox.cloudflow.source.reddit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    public Properties readPropertiesFile(String fileName) throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);
        Properties p = new Properties();
        p.load(input);
        return p;
    }
}
