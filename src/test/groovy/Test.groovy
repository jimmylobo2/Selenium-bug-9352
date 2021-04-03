import org.junit.AfterClass
import org.junit.BeforeClass
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import java.util.logging.Level

class Test {
    static WebDriver driver

    @BeforeClass
    static void prepare() {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver_win32/chromedriver.exe")
        ChromeOptions chromeOptions = new ChromeOptions()
        chromeOptions.setBinary("bin/chrome/chrome.exe")
        driver = new ChromeDriver(chromeOptions)
        driver.setLogLevel(Level.OFF)
    }

    @AfterClass
    static void closeAll() {
        if (driver) {
            driver.close()
            driver.quit()
        }
    }

    @org.junit.Test
    void testAll() {
        driver.get("http://www.google.com")
        WebElement element = driver.findElement(By.cssSelector('button'))
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur()", element)
    }
}
