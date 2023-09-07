package com.mindtree.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.mindtree.reusable.ReusableMethod;

public class Screenshot {

	

	public static void screenshot(WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + PropertyFileReader.loadFile().getProperty("screenshot")
				+ PropertyFileReader.loadFile().getProperty("className") + "_" + ReusableMethod.setDateTime() + ".png";
		File destFile = new File(path);
		try {
			Files.copy(srcFile, destFile);
			Reporter.addScreenCaptureFromPath(destFile.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
