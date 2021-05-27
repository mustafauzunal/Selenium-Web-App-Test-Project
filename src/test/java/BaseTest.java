import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver webDriver;
    GittiGidiyor gittiGidiyor;

    @Test(priority = 0)
    public void setUp(){

        //Chrome WebDriver
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.gittigidiyor.com");
        System.out.println("Başarılı bir şekilde www.gittigidiyor.com sitesine ulaşıldı.");
        gittiGidiyor = new GittiGidiyor(webDriver);
    }



    @Test(priority = 14)
    public void tearDown(){
     webDriver.quit();
    }
}
