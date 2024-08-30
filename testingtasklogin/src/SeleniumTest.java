import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    @Test
    public void tesTValidlogin() throws Exception {
        System.setProperty("webdriver.chrom.driver","D:\\CS\\Third Year\\Term 2\\Testing\\Selenium\\chromedriver_win32\\chromedriver");
        WebDriver webDriver = new ChromeDriver();
        // go to website
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        Thread.sleep(500);
        // enter username & password
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
        // click login
        webDriver.findElement(By.id("login-button")).click();
        Thread.sleep(500);

        // validate login
        String actualvalue =  webDriver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/div")).getText();

        String expected = "Products";
        Assert.assertEquals(expected,actualvalue);
        Thread.sleep(500);
        webDriver.close();
    }

    @Test
    public void tesTInValidlogin() throws Exception {
        System.setProperty("webdriver.chrom.driver","D:\\CS\\Third Year\\Term 2\\Testing\\Selenium\\chromedriver_win32\\chromedriver");
        WebDriver webDriver = new ChromeDriver();
        // go to website
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        Thread.sleep(500);
        // enter username & password
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.name("password")).sendKeys("invalid_passwrod");
        Thread.sleep(500);
        // click login
        webDriver.findElement(By.id("login-button")).click();
        Thread.sleep(500);

        // validate login
        String actualvalue =  webDriver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3")).getText();

        String expected = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expected,actualvalue);
        Thread.sleep(500);
        webDriver.close();
    }




}