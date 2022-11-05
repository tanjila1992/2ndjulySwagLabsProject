package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static void takeScreenshot(WebDriver driver, String name) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\Admin\\new_workspace\\NewSwaglabs\\screenshot//" + name + ".png");
		FileHandler.copy(source, destination);
	}

}
