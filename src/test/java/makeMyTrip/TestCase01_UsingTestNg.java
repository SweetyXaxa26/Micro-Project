package makeMyTrip;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


import ch.qos.logback.core.util.Duration;

public class TestCase01_UsingTestNg {

	
	@Test
	public  void Run() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get("https://www.makemytrip.com/");
        System.out.println("Url hit ! ");

        String tab1 = driver.getWindowHandle();

        Actions ac = new Actions(driver);

        WebElement cross = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        cross.click();
        System.out.println("Pop up disaper ! ");
        
        WebElement flight = driver.findElement(By.xpath("//span[@class='headerIconTextAlignment chNavText darkGreyText' and text()='Flights']"));
        flight.click();
        System.out.println("Click flight ");

        WebElement optionOneWay = driver.findElement(By.xpath("//*[@data-cy='oneWayTrip']"));
        ac.moveToElement(optionOneWay).click().perform();
        System.out.println("Click flight - > One way ");
        
        WebElement from = driver.findElement(By.xpath("//*[@id='fromCity']"));
        ac.click(from).perform();
        
        ac.sendKeys(" Delhi").perform();
        System.out.println("From : Data enter ");
        
        WebElement to = driver.findElement(By.xpath("  //*[@id='toCity']"));
        ac.click(to).perform();
        
        ac.sendKeys(" Mumbai ").perform();
        System.out.println("To : Data enter ");
        
     
        WebElement departure = driver.findElement(By.xpath("//*[@class='lbl_input appendBottom10'and text()='Departure']"));
        ac.click(departure).perform();
       
		WebElement date = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]/div[3]/div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[@class='dateInnerCell']/p[text()='29']"));
		ac.moveToElement(date).click().perform();
		
		
		 WebElement Search = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
	     ac.click(Search).perform();
		
        Thread.sleep(3000);
        driver.quit();

	}

}
