import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumIntoTest {

    private static WebDriver webDriver; //web browser
    private static String baseUrl;  //URL of page we want to test

    @BeforeAll

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\win11\\OneDrive\\Desktop\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        baseUrl = "https://www.ibu.edu.ba";
    }

    @AfterAll

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test

    public void testTitle() throws InterruptedException {
        webDriver.get(baseUrl);
        String actualTitle = webDriver.getTitle();
        System.out.println("Actual title: " + actualTitle);
        assertEquals("International Burch University | IBU", actualTitle, "Title does not match");
        Thread.sleep(1000);
    }

    @Test
    void testRedirect() throws InterruptedException {
        webDriver.get("https://lms.ibu.edu.ba/");
        Thread.sleep(2000);
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("Current URL " + currentUrl);
        assertEquals("https://learning.ibu.edu.ba/", currentUrl, "We redirected you successfully");

    }

    @Test
    void webDriverOptions() {
        //webDriver.get();
        webDriver.getTitle();
        webDriver.getCurrentUrl();
        webDriver.getPageSource();
        webDriver.close();
        webDriver.quit();
    }

    @Test

    /*TASK:  Open the homepage of International Burch University’s IT Department,
    and assert that the page title is “Department of Information Technology | IBU”.
    Moreover, assert that the web page’s source contains the keyword “_next”.
    Lastly, close the browser window.*/

    void navigationTest() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/department-of-information-technologies");
        Thread.sleep(2000);
        assertEquals(webDriver.getTitle(), "Department of Information Technology | IBU");
        Thread.sleep(3000);
        String source = webDriver.getPageSource();
        assertTrue(source.contains("_next"), "Our Web Page don't contains word next");
        Thread.sleep(1000);
        webDriver.close();

    }

    @Test
    void elementsOptions() throws InterruptedException {
        WebElement element = webDriver.findElement(By.name("userName"));

        element.getTagName();
        element.getText();
        element.click();
        element.sendKeys("test1234");
        element.clear();
        element.submit();
        element.isDisplayed();
        element.isEnabled();
        element.isSelected();
    }

    @Test
    public void testContactForm() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/contact-us");
        webDriver.manage().window().maximize();


        Thread.sleep(3000);
        WebElement name = webDriver.findElement(By.name("fullName"));
        name.sendKeys("Jane Doe");


        WebElement email = webDriver.findElement(By.name("email"));
        email.sendKeys("jane.doe@ibu.edu.ba");


        WebElement subject = webDriver.findElement(By.name("subject"));
        subject.sendKeys("Hello from SVVT. :)");


        WebElement message = webDriver.findElement(By.name("message"));
        message.sendKeys("Hi, this is an automated test.");
        Thread.sleep(3000);
    }

   /*
    TASK: Perform UI automation testing based on the following steps:
    Open http://www.uitestingplayground.com/sampleapp
    Find the username input field by name - “UserName”
    Find the password input field by name - “Password”
    Assert that both web elements are inputs
    Clear both web elements
    Enter “test” in the username field
    Enter “pwd” in the password field
    Find the “Login” button by id - “login”
    Assert that the “Login” element is of type “button”
    Perform click of Login web element
    Find login status label by id - “loginstatus”
    Assert that the login status label contains “test” in its text
    Close the browser */

    @Test
    void testingLabTask() throws InterruptedException {
        webDriver.get("http://www.uitestingplayground.com/sampleapp");
        webDriver.manage().window().maximize();

        Thread.sleep(4000);
        WebElement username = webDriver.findElement(By.name("UserName"));


        Thread.sleep(4000);
        WebElement password = webDriver.findElement(By.name("Password"));

        Thread.sleep(4000);
        assertEquals("input", username.getTagName(), "Username is input element");


        Thread.sleep(4000);
        assertEquals("input", password.getTagName(), "Password is input element");

        Thread.sleep(4000);
        username.clear();

        Thread.sleep(4000);
        password.clear();

        Thread.sleep(4000);
        username.sendKeys("test");
        password.sendKeys("psw");

        Thread.sleep(4000);
        WebElement button = webDriver.findElement(By.id("login"));

        Thread.sleep(4000);
        assertEquals("Button", button.getAttribute("type"), "Login is button type");

        button.click();

        WebElement loginStatus = webDriver.findElement(By.id("loginstatus"));
        assertTrue(loginStatus.getText().contains("test"), "Login has been successful");

    }

    @Test
    void testDeanName() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/");
        Thread.sleep(3000);
        webDriver.navigate().to("https://www.ibu.edu.ba/faculty-of-engineering-natural-and-medical-sciences");
        WebElement Dean=webDriver.findElement(By.className("dean__footer"));
        assertTrue(Dean.getText().contains("Jasmin Kevrić"),"Kevrić is the Dean of Faculty");

    }
    /*findElement(By.locator());*/
    /*Task 2 :
    * Perform UI automation testing based on the following steps:
    * Open http://www.uitestingplayground.com/sampleapp in the browser.
    * Select the “Sample App” heading element by using the tag name search
    * strategy and assert that the web element’s text is equal to “Sample App”.
    * Find the paragraph element below the “Sample App” heading by using its absolute xPath and assert that paragraph text length is 101.
    * Find the “user logged out” label by ID selector, and assert that it says “User logged out.”
    * Find the username and password input fields by the name selector
    * Type in “wrong” in the username field, and “credentials” in the password field.
    * Find the Login button by its relative xPath and click it.
    * Assert that the label from step 4 now says “Invalid username/password”.*/

    @Test
    void automationHeadingTesting()throws InterruptedException{
        webDriver.get("http://www.uitestingplayground.com/sampleapp");
        Thread.sleep(2000);
        WebElement heading = webDriver.findElement(By.xpath("//h3"));
        assertEquals("Sample App",heading.getText(),"Title is matching");
        Thread.sleep(4000);
    }

    @Test
    void paragraphLengthText() throws InterruptedException {
        webDriver.get("http://www.uitestingplayground.com/sampleapp");
        Thread.sleep(1000);
        WebElement element = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/p"));
        assertEquals(101, element.getText().length(), "The length of the paragraph should be 101.");
    }

    @Test
    void labelTextTest() throws InterruptedException {
        webDriver.get("http://www.uitestingplayground.com/sampleapp");
        Thread.sleep(1000);
        WebElement element = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/div[@class='row'][1]/div/label[@id='loginstatus']"));
        assertEquals("User logged out.", element.getText());
    }

    @Test
    void wrongLoginTest() throws InterruptedException {
        webDriver.get("http://www.uitestingplayground.com/sampleapp");
        Thread.sleep(1000);
        WebElement userNameInput = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/div[@class='row'][2]/div/input[@name='UserName']"));
        WebElement passwordInput = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/div[@class='row'][3]/div/input[@name='Password']"));
        userNameInput.sendKeys("wrong");
        Thread.sleep(800);
        passwordInput.sendKeys("credentials");
        Thread.sleep(800);
        WebElement loginBtn = webDriver.findElement(By.xpath("//button[@id='login']"));
        loginBtn.click();
        Thread.sleep(2000);
        WebElement element = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/div[@class='row'][1]/div/label[@id='loginstatus']"));
        assertEquals("Invalid username/password", element.getText());
    }

    @Test
    public void testSignupForm() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/offices/it-support-office");
        webDriver.manage().window().maximize();

        WebElement textBelow = webDriver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div[1]/div[4]/div/p[3]"));
        WebElement inputForEmail = webDriver.findElement(RelativeLocator.with(By.tagName("input")).above(textBelow));
        inputForEmail.sendKeys("jane.doe@gmail.com");
        Thread.sleep(5000);
    }

    @Test

    public void searchOptions() throws InterruptedException{
        webDriver.get("https://www.ibu.edu.ba/");
        webDriver.manage().window().maximize();

        WebElement menuButton = webDriver.findElement(By.xpath("/html/body/div[@id='__next']/header/div[@class='menu__wrap']/div[@class='search__elem']"));
        menuButton.click();
        Thread.sleep(2000);
        WebElement searchBar = webDriver.findElement(By.xpath("//input[@placeholder='What are you looking for?']"));
        searchBar.sendKeys("engineering");
        Thread.sleep(1500);
        WebElement firstLink = webDriver.findElement(RelativeLocator.with(By.xpath("//a[1]")).below(searchBar));
        firstLink.click();
        Thread.sleep(1000);
    }

    @Test

    public void checkboxesAndButtonsTesting()throws InterruptedException{
        webDriver.get("https://demoqa.com/checkbox");
        webDriver.manage().window().maximize();

        WebElement homeExpand = webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        homeExpand.click();
        Thread.sleep(3000);

        WebElement documentsExpand = webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
        documentsExpand.click();
        Thread.sleep(1000);

        WebElement documentsCheckBox = webDriver.findElement(By.xpath("//span[text()='Documents']/preceding-sibling::span[@class='rct-checkbox']"));
        documentsCheckBox.click();
        Thread.sleep(1000);
    }

    @Test

    public void travelToBosnia ()throws InterruptedException{
        webDriver.get(" https://www.ebay.com/signin/\n");
        webDriver.manage().window().maximize();

        WebElement createAccount = webDriver.findElement(By.xpath("//*[@id=\"create-account-link\"]"));
        createAccount.click();
        Thread.sleep(3000);

        WebElement businessAccount = webDriver.findElement(By.xpath("//*[@id=\"businessaccount-radio\"]"));
        businessAccount.click();
        Thread.sleep(3000);

        WebElement name = webDriver.findElement(By.xpath("//*[@id=\"lblbusinessName\"]"));
        name.sendKeys("Emy");

        WebElement email = webDriver.findElement(By.xpath("//*[@id=\"lblbusinessEmail\"]"));
        email.sendKeys("emy@gmail.com");

        WebElement password = webDriver.findElement(By.xpath("//*[@id=\"lblbizPassword\"]"));
        password.sendKeys("assdafdfaw");

        WebElement countryDropdown = webDriver.findElement(By.id("businessCountry"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Bosnia and Herzegovina");


        System.out.println("Please solve the CAPTCHA manually...");
        Thread.sleep(30000);

        WebElement registerButton = webDriver.findElement(By.id("BUSINESS_REG_SUBMIT"));
        registerButton.click();

        Thread.sleep(3000);
        System.out.println("Business account registration form submitted.");

    }

    @Test
    public void bookDubaiTour() throws InterruptedException {
        webDriver.get("https://phptravels.net/tours");
        webDriver.manage().window().maximize();

        WebElement dubaiTour = webDriver.findElement(By.xpath("//h4[contains(text(),'Dubai & Desert - Dubai Combo Package')]"));
        dubaiTour.click();
        Thread.sleep(3000);

        WebElement adultsDropdown = webDriver.findElement(By.id("adults"));
        Select adultsSelect = new Select(adultsDropdown);
        adultsSelect.selectByVisibleText("2");

        WebElement childrenDropdown = webDriver.findElement(By.id("child"));
        Select childrenSelect = new Select(childrenDropdown);
        childrenSelect.selectByVisibleText("2");

        WebElement totalPriceElement = webDriver.findElement(By.id("displaytotal"));
        String totalPriceText = totalPriceElement.getText();
        assertEquals("600USD", totalPriceText);
        System.out.println("The total price is correctly displayed as 600USD.");

        WebElement bookNowButton = webDriver.findElement(By.id("book"));
        bookNowButton.click();

        Thread.sleep(3000);
        System.out.println("Booking process initiated successfully.");
    }

    @Test

    public void waitOptions()throws InterruptedException{
        /*
        webDriver.get("");
        webDriver.manage().window();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriverWait wait = new webDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".class-locator")));
        FluentWait<WebDriver>wait = new FluentWait<WebDriver>(webDriver);
        wait.withTimeout(Duration.ofMillis(10));*/

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        options.addArguments("--window-size=1024,768");
        options.addArguments("--headless");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("proxy-server=106.122.8.54:3128");

        webDriver = new ChromeDriver(options);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("alert('Hello , World)");

        WebElement element = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[2]/div/div/div/div/div/button"));
        js.executeScript("arguments[0].click();", element);

        js.executeScript("window.scrollBy(0, 600);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -400);");

        Actions builder = new Actions(webDriver);

        Actions moveOverLink = builder.moveToElement(element);




    }
}