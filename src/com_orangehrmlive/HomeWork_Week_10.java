package com_orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project - 2
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class HomeWork_Week_10 {

    static String baseurl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    static String browser = "Chrome";

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String title = driver.getTitle();
        System.out.println(title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        Thread.sleep(5000);

        WebElement forgotPassword = driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']"));
        forgotPassword.click();
        Thread.sleep(5000);

        String currentUrl1 = driver.getCurrentUrl();
        System.out.println(currentUrl1);

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(5000);

        // Find Email Field element and type the Email
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");
        Thread.sleep(2500);

        // Find Password Field Element and type the password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        Thread.sleep(2500);

        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();
        Thread.sleep(5000);

        System.out.println("finito");
        //WebElement element =

        driver.quit();

    }
}
