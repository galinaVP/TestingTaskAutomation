package WDM;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class Driver {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal();
    protected static Map<DriverManagerType, WebDriverManager> instanceMap = new EnumMap(DriverManagerType.class);

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (threadDriver.get() == null) {
            initDriver();
        }
        return threadDriver.get();
    }

    private static void initDriver() {
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case "chrome":
                chromedriver().setup();
                threadDriver.set(new ChromeDriver());
                break;
            case "firefox":
                firefoxdriver().setup();
                threadDriver.set(new FirefoxDriver());
                break;
            case "edge":
                edgedriver().setup();
                threadDriver.set(new EdgeDriver());
                break;
            case "IE":
                iedriver().setup();
                threadDriver.set(new InternetExplorerDriver());
                break;
            case "opera":
                operadriver().setup();
                threadDriver.set(new OperaDriver());
                break;
            default:
                throw new IllegalArgumentException("Entered browser value is not recognized");
        }

        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        threadDriver.get().manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        threadDriver.get().manage().timeouts().setScriptTimeout(200, TimeUnit.SECONDS);
    }

    public static void killDriver() {
        if (threadDriver.get() != null) {
            threadDriver.get().close();
            threadDriver.remove();
        }
    }
}
