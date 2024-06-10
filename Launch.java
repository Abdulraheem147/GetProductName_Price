package com.sample;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {
	public static void main(String[] args) {
		
//ChromeOptions option=new ChromeOptions();
//		
//		option.addArguments("--remote-allow-origins=*");
//		
//	
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver(option);
//		
//		driver.get("https://www.amazon.in/");
//		WebElement itemname = driver.findElement(By.id("twotabsearchtextbox"));
//		itemname.sendKeys("i phone14 pro"+Keys.ENTER);
//		//WebElement search = driver.findElement(By.id("nav-search-submit-button"));
//		//search.click();
//		List<WebElement> products = driver.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])"));
//		System.out.println("Total No Of Products" +products.size()+"\n"+"*****************"+"\n");
//		for(WebElement product :products) {
//			System.out.println(product.getText());
//		}
//		System.out.println("\n");
//		
//		List<WebElement> cost = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
//		System.out.println("Cost Of Product "+cost.size()+"\n"+"******************"+"\n");
//		for(WebElement x:cost) {
//			System.out.println(x.getText());
//			
			
//		}
		// Setup ChromeOptions to handle potential issues with remote origins
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Setup WebDriverManager to manage the ChromeDriver binary
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver with the specified options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Amazon India
            driver.get("https://www.amazon.in/");

            // Find the search box and enter the search term
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("i phone14 pro" + Keys.ENTER);

            // Wait for the results to load and be visible
            Thread.sleep(2000); // Consider using WebDriverWait for better handling

            // Find the product titles on the result page
            List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

            // Ensure the lists of products and prices have the same size
            int count = Math.min(products.size(), prices.size());
            System.out.println("Total No Of Products: " + count + "\n*****************\n");

            // Print each product title and its corresponding price
            for (int i = 0; i < count; i++) {
                WebElement product = products.get(i);
                WebElement price = prices.get(i);
                System.out.println("Product: " + product.getText());
                System.out.println("Price: " + price.getText() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }

		
	}

}
