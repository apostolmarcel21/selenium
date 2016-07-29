package com.endava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mapostol on 7/29/2016.
 */


public class GmailTest {
    static WebDriver webDriver;
    @BeforeClass
    public static void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://gmail.com");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @Test
    public void testGmail() {
        WebElement emailField = webDriver.findElement(By.xpath("//input[@id=\"Email\"]"));
        emailField.sendKeys("endavaselenium");
        WebElement nextButton = webDriver.findElement(By.xpath("//input[@id='next']"));
        nextButton.click();
        WebElement passwordField = webDriver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField.sendKeys("endavaqa");
        WebElement signInButton =webDriver.findElement(By.xpath("//input[@id='signIn']"));
        signInButton.click();
        WebElement composeButton = webDriver.findElement(By.xpath("//div[text()=\"COMPOSE\"]"));
        composeButton.click();
        WebElement toFielf =webDriver.findElement(By.xpath("//textarea[@name=\"to\"]"));
        toFielf.sendKeys("endavaselenium@gmail.com");
        toFielf.sendKeys(Keys.RETURN);
        WebElement subjectField = webDriver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectField.sendKeys("Test");
        WebElement messageBox = webDriver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        messageBox.sendKeys("Testeasfsdfs");
        WebElement sendButton =webDriver.findElement(By.xpath("//div[@aria-label='Send \u202A(Ctrl-Enter)\u202C']"));
        sendButton.click();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.close();
    }
}
