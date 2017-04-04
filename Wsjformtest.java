/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsjformtest;

import static jdk.nashorn.internal.objects.NativeFunction.function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 *
 * @author meet
 */
public class Wsjformtest {

    /**
     * @param args the command line arguments
     */

          
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://wsj_staging:4%b(q$tm@wsj-staging.developspa.com");
        Thread.sleep(3000);   
        driver.findElement(By.name("w2lsubmit")).click();
        
        //Required_Validation();
        
        driver.findElement(By.name("w2lsubmit")).click();
       
       
        Thread.sleep(3000);

        String text = driver.findElement(By.id("sf_first_name")).findElement(By.xpath("./following-sibling::span[@class='error_message']")).getText();

        Assert.assertTrue(text.equals("This field is required."), "working");

        System.out.print("required field validation works\n");
        
        Thread.sleep(3000);

        driver.findElement(By.id("sf_first_name")).sendKeys("Meet");

        driver.findElement(By.id("sf_email")).sendKeys("meet@2006");
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.name("w2lsubmit"));
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
        
        Thread.sleep(1500);
        
        String Emailtext = driver.findElement(By.id("sf_email")).findElement(By.xpath("./following-sibling::span[@class='error_message']")).getText();

        Assert.assertTrue(Emailtext.equals("The email address you entered is not valid."), "working");

        System.out.print("Email Id validation works\n");

        Thread.sleep(3000);

        driver.findElement(By.id("sf_first_name")).sendKeys("Meet");
        driver.findElement(By.id("sf_email")).clear();
        driver.findElement(By.id("sf_email")).sendKeys("meet2006@gmail.com");
        driver.findElement(By.id("sf_phone")).sendKeys("1111111111");
        driver.findElement(By.id("sf_description")).sendKeys("Test Message");
        
        
        WebElement element1 = driver.findElement(By.name("w2lsubmit"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(element1).click().perform();
        
        Thread.sleep(1500);
        String Formtext = driver.findElement(By.id("salesforce_w2l_lead_1")).findElement(By.xpath("./strong[@class='success_message']")).getText();
    
        Assert.assertTrue(Formtext.equals("Your message has been submitted successfully."), "working");

        System.out.print("Form submit works\n");
        
        
    }
    
     
       

}
