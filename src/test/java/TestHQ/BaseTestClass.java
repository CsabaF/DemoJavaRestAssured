package TestHQ;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class BaseTestClass {

    @BeforeSuite
    public static void testSetUp(){

        // Checking if feature instance is provided, and changing the base URI, if not, defaults to "sprint".
        if(System.getProperty("runEnv.featureInstance") != null){
            BaseURL.replace("sprint", System.getProperty("runEnv.featureInstance"));
        }
    }

    @AfterSuite
    public static void tearDown(){
    }

    @Test(priority = 1)
    public static void testSuiteInit(){
    }

    // Static Variables
    public static String BaseURL = "https://admin.highwest-sprint.entwinemedia.com/api";
    public static String ProjectRootDir = System.getProperty("user.dir");

    // Credentials from OS ENV
    protected static String ENTWINE_BASIC_AUTHORIZATION_KEY = "Basic " + System.getenv("ENTWINE_BASIC_AUTHORIZATION_KEY");

    protected static String ENTWINE_BROWSERSTACK_USERNAME = System.getenv("ENTWINE_BROWSERSTACK_USERNAME");
    protected static String ENTWINE_BROWSERSTACK_ACCESS_KEY = System.getenv("ENTWINE_BROWSERSTACK_ACCESS_KEY");

    protected static String ENTWINE_STAGING_USER = System.getenv("ENTWINE_STAGING_USER");
    protected static String ENTWINE_STAGING_PASSWORD = System.getenv("ENTWINE_STAGING_PASSWORD");

    protected static String ENTWINE_NIGHTLY_USER = System.getenv("ENTWINE_NIGHTLY_USER");
    protected static String ENTWINE_NIGHTLY_PASSWORD = System.getenv("ENTWINE_NIGHTLY_PASSWORD");

    protected static String ENTWINE_SPRINT_USER = System.getenv("ENTWINE_SPRINT_USER");
    protected static String ENTWINE_SPRINT_PASSWORD = System.getenv("ENTWINE_SPRINT_PASSWORD");

    protected static String ENTWINE_FI_USER = System.getenv("ENTWINE_FI_USER");
    protected static String ENTWINE_FI_PASSWORD = System.getenv("ENTWINE_FI_PASSWORD");

    protected static String ENTWINE_DIGEST_USER = System.getenv("ENTWINE_DIGEST_USER");
    protected static String ENTWINE_DIGEST_PASSWORD = System.getenv("ENTWINE_DIGEST_PASSWORD");


    // UTILS
    public static String readJsonFileToString(String filename) {
        String data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            data = sb.toString();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return data;
    }
}
