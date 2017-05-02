package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by son.nguyen on 4/30/17.
 */
public class ChromeBrowser {

    private static WebDriver webDriver;

    static {
        System.setProperty("webdriver.chrome.driver", "/Users/son.nguyen/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.apple.com/");
        webDriver.manage().window().maximize();
    }

    public static void main(String[] args) {
//        testXPath();
//        testButtonClick();
        testClassName();

    }

    private static void testXPath() {
        sleepUtil(1000);
        webDriver.findElement(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[4]/a")).click();
        sleepUtil(1000);
        webDriver.quit();
    }

    private static void testButtonClick() {
        sleepUtil(1000);
        webDriver.findElement(By.cssSelector("#ac-globalnav > div > ul.ac-gn-list > li.ac-gn-item.ac-gn-item-menu.ac-gn-search > a")).click();
        sleepUtil(1000);
        WebElement searchElem = webDriver.findElement(By.id("ac-gn-searchform-input"));
        searchElem.sendKeys("macbook pro 2016");
        sleepUtil(1000);
        searchElem.sendKeys(Keys.RETURN);
        sleepUtil(2000);
        webDriver.quit();
    }

    private static void testClassName() {
        sleepUtil(1000);
        List<WebElement> webElements = webDriver.findElements(By.className("ac-gn-item"));
        System.out.println(webElements.size());
        webDriver.quit();
    }

    private static void sleepUtil(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
