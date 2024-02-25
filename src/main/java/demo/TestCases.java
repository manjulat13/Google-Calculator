package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v116.indexeddb.model.Key;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import com.google.common.base.Verify;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com/");
        String currUrl=driver.getCurrentUrl();
        if(currUrl.contains("google"))
        {
            System.out.println("currUrl contains google");
        }
        //Type "calculator" in the Google search bar and press Enter.

        WebElement searchBar=driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("calculator");
        searchBar.sendKeys(Keys.ENTER);

        //Verify that the Google Calculator loads.
        WebElement calculator=driver.findElement(By.xpath("//div[@class='MjjYud']//div[@jscontroller='qxNryb']"));
        String text=calculator.getText();
        if(text.contains("Calculator")){
            System.out.println("Google Calculator loaded");
        }else{
            System.out.println("Google Calculator not loaded");

        }

        //Confirm that the initial display shows zero(0)
        WebElement zero=driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span"));
        String zeroText=zero.getText();
        if(zeroText.contains("0")){
            System.out.println("initial display is zero(0)");
        }else{
            System.out.println("initial display is not zero(0)");

        }
        System.out.println("end Test case: testCase02");
    }
    public void textCase02(){
        
        driver.get("https://www.google.com/");

        //Type "calculator" in the Google search bar and press Enter.

        WebElement searchBar=driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("calculator");
        searchBar.sendKeys(Keys.ENTER);
        //Perform an addition operation, 5 + 7.
        driver.findElement(By.xpath("//div[@jsname='Ax5wH']")).click();
        driver.findElement(By.xpath("//div[@aria-label='plus']")).click();
        driver.findElement(By.xpath("//div[@jsname='rk7bOd']")).click();

        //Confirm that the displayed result is correct (in this case, 12).
        driver.findElement(By.xpath("//div[@aria-label='equals']")).click();
        String add=driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText();
        if(add.equals("12")){
            System.out.println("Addition Result is correct");
        }
        else{
            System.out.println("Addition Result is not correct");

        }

        //Perform a subtraction operation, 15 - 8.
        driver.findElement(By.xpath("//div[@jsname='N10B9']")).click();
        driver.findElement(By.xpath("//div[@jsname='Ax5wH']")).click();

        driver.findElement(By.xpath("//div[@aria-label='minus']")).click();
        driver.findElement(By.xpath("//div[@jsname='T7PMFe']")).click();
        driver.findElement(By.xpath("//div[@aria-label='equals']")).click();
        
        //Confirm that the displayed result is correct (in this case, 7).
        String sub=driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText();
        if(sub.equals("7")){
            System.out.println("Substraction Result is correct");
        }
        else{
            System.out.println("Substraction Result is not correct");

        }
    }
    public void testCase03(){
        driver.get("https://www.google.com/");

        //Type "calculator" in the Google search bar and press Enter.

        WebElement searchBar=driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("calculator");
        searchBar.sendKeys(Keys.ENTER);
        // Perform a multiplication operation, 10 * 3.
         
         driver.findElement(By.xpath("//div[@jsname='N10B9']")).click();
         driver.findElement(By.xpath("//div[@jsname='bkEvMb']")).click();
 
         driver.findElement(By.xpath("//div[@aria-label='multiply']")).click();
         driver.findElement(By.xpath("//div[@jsname='KN1kY']")).click();
         driver.findElement(By.xpath("//div[@aria-label='equals']")).click();
        
        // Confirm that the displayed result is correct (in this case, 30).
        String mul=driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText();
        if(mul.equals("30")){
            System.out.println("Multiplication Result is correct");
        }
        else{
            System.out.println("Multiplication Result is not correct");

        }
        // Click the "AC" (All Clear) button on the calculator.
        driver.findElement(By.xpath("//div[@aria-label='all clear']")).click();
        String clear=driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText();

        // Verify that the display clears.
        if(clear.equals("0")){
            System.out.println("Ac Button Cleared Display");
        }
        else{
            System.out.println("Ac Button not Cleared Display");

        }
    }
    public void testCase04(){
        driver.get("https://www.google.com/");

        //Type "calculator" in the Google search bar and press Enter.

        WebElement searchBar=driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("calculator");
        searchBar.sendKeys(Keys.ENTER);

        //Perform a division operation, 20 / 4.
        driver.findElement(By.xpath("//div[@jsname='lVjWed']")).click();
         driver.findElement(By.xpath("//div[@jsname='bkEvMb']")).click();
 
         driver.findElement(By.xpath("//div[@aria-label='divide']")).click();
         driver.findElement(By.xpath("//div[@jsname='xAP7E']")).click();
         driver.findElement(By.xpath("//div[@aria-label='equals']")).click();
         String div=driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span")).getText();

        //Confirm that the displayed result is correct (in this case, 5).
    
        if(div.equals("5")){
            System.out.println("Division Result is Correct");
        }
        else{
            System.out.println("Division Result is Correct");

        }
    }

}
