package seleniump;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sakshi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sakshimathur\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		
		//Test Automation Training Obstacle Course
		driver.findElement(By.linkText("Basic Course")).click();
		
		//Grid Gate
		driver.findElement(By.className("greenbox")).click();
		
		//Frame Dungeon
	
		driver.switchTo().frame(0);
		WebElement box1= driver.findElement(By.id("answer"));
		String box1color=box1.getAttribute("class");
		String box2color=("");
		
		
		
		while(!box1color.equals(box2color))
		{		
			 driver.switchTo().defaultContent();
			    driver.switchTo().frame(0);
			    driver.findElement(By.cssSelector("a")).click();
			    driver.switchTo().frame(0);
			    box2color=driver.findElement(By.id("answer")).getAttribute("class");
		   
		}
		 driver.switchTo().defaultContent();
		   driver.switchTo().frame(0).findElement(By.linkText("Proceed")).click();
		   
		   
		   /******************************************Drag Around***********************************************/
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   WebElement dragbox = driver.findElement(By.id("dragbox"));
		   js.executeScript("arguments[0].setAttribute('style','position: relative; left: 30px; top: -71px;')",dragbox);	   
		    driver.findElement(By.linkText("Proceed")).click();
			
			/***************************************Pop up Windows**********************************************/
		    driver.findElement(By.linkText("Launch Popup Window")).click();
		    
		    String parentwindow = driver.getWindowHandle();
		    String subWindow = null;
		    Set<String> windows = driver.getWindowHandles();
		    Iterator itr = windows.iterator();
		    while(itr.hasNext()){
		    	subWindow = (String) itr.next();
		    }
		    driver.switchTo().window(subWindow);
		    driver.findElement(By.id("name")).sendKeys("Aditya");
		    driver.findElement(By.id("submit")).click();
		    driver.switchTo().window(parentwindow);
		    driver.findElement(By.linkText("Proceed")).click();
		    
		    
		    /********************************************Cookie Handling****************************************/
		    driver.findElement(By.linkText("Generate Token")).click();
		    String token_text = driver.findElement(By.id("token")).getText();
		    String token = token_text.substring(token_text.indexOf(":")+2);
		    Cookie cookie = new Cookie("Token",token);
		    driver.manage().addCookie(cookie);
		    driver.findElement(By.linkText("Proceed")).click();
	}

}
