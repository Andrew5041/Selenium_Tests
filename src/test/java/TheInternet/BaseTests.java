package TheInternet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseTests {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setDriver() {

        ChromeOptions options = new ChromeOptions();

        // 1. Tryb Incognito - to powinno ostatecznie ubić popupy haseł
        options.addArguments("--incognito");

        // 2. Pozostałe argumenty optymalizacyjne
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");


        // Opcjonalnie wyłączamy całkowicie automatyzację jako flagę (niektóre strony to wykrywają)
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // 3. Preferencje (zostawiamy te, które miałeś)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void quitDriver(){
        driver.quit();
    }
}
