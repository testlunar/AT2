import java.io.*;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties(){
        System.setProperty("environment", "application");
        try {
            InputStream inStream = new FileInputStream("C:\\Users\\diana\\IdeaProjects\\AT2\\environment.properties");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));//


            properties.load(new FileInputStream(new File("C:\\Users\\diana\\IdeaProjects\\AT2\\environment.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public static TestProperties getInstance() {
            if (INSTANCE == null){
                INSTANCE = new TestProperties();
            }
            return INSTANCE;
        }

        public Properties getProperties() {
            return properties;
        }
    }

