package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Addcustomerpage;
import pageobjects.Loginpage;
import pageobjects.searchcustomerpage;

import java.util.concurrent.TimeUnit;

public class steps extends baseclass{

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sahil\\Documents\\chromedriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        Lp =new Loginpage(driver);
    }
    @When("User open URL {string}")
    public void user_open_URL(String url) {
        driver.get(url);

    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        Lp.setemail(email);
        Lp.setpassword(password);

    }
    @Then("Click omn login")
    public void click_omn_login() {
        Lp.setLoginbutton();

    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertEquals(title,driver.getTitle());
        }
    }
    @When("User click on Log out link")
    public void user_click_on_Log_out_link() throws InterruptedException {
        Lp.setLogoutlink();
        Thread.sleep(3000);
    }
    @Then("Page Title should be {string}")
    public void page_Title_should_be(String title) {
        driver.getTitle();
    }


    // Customres feature step definiitions.....................

    @Then("User can view dashboard")
    public void user_can_view_dashboard() {
        addcustomer=new Addcustomerpage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addcustomer.getpageTitle());
    }
    @When("User click on customer menu")
    public void user_click_on_customer_menu() throws InterruptedException {
        Thread.sleep(3000);
        addcustomer.clickcustomermenu();
    }
    @When("Click on customer menu item")
    public void click_on_customer_menu_item() throws InterruptedException {
        Thread.sleep(2000);
        addcustomer.clickoncustomermenulist();
    }
    @Then("click on add new buttton")
    public void click_on_add_new_buttton() throws InterruptedException {
        addcustomer.clickonaddnew();
        Thread.sleep(2000);
    }
    @Then("User can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addcustomer.getpageTitle());
    }
    @When("User enter customer info")
    public void user_enter_customer_info() {
        addcustomer.setemail("sachin10@gmail.com");
        addcustomer.setpassword("admin");
        addcustomer.setfirstname("vijay");
        addcustomer.setlastname("kumar");
        addcustomer.setmanagerofvendor("Vendor 2");
        addcustomer.setgender("Male");
        addcustomer.setDOB("10/05/1986");
        addcustomer.setcompanyname("busyQA");
        addcustomer.setcustomerroles("Guests");
        addcustomer.setadmincomment("this is for testing");
    }
    @When("Click on save button")
    public void click_on_save_button() throws InterruptedException {
        addcustomer.clickonsave();
        Thread.sleep(2000);
    }
   // @Then("User can view conformation message{string}")
   // public void user_can_view_conformation_message(String msg) {
       // Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
           //     .contains("The new customer has been added successfully."));
   // }


    //Steps for searching a customer using eamilID.......................

    @When("Enter customer Email")
    public void enter_customer_Email() {
        searchcustomer=new searchcustomerpage(driver);
        searchcustomer.setEmail("\tvictoria_victoria@nopCommerce.com");
    }
   @When("Click on search button")
   public void click_on_search_button() throws InterruptedException {
        searchcustomer.clicksearch();
        Thread.sleep(3000);
    }
    @Then("Close browser")
    public void close_browser() {
       driver.quit();
    }
    // Steps for search customer by firstname and lastname......................

    @When("Enter customer firstname")
    public void enter_customer_firstname() {
        searchcustomer=new searchcustomerpage(driver);
        searchcustomer.setfirstname("Victoria");
    }
    @When("Enter customer lastname")
    public void enter_customer_lastname() {
        searchcustomer.setTypelastname("Terces");
    }
    @Then("User should found name in the search table")
    public void user_should_found_name_in_the_search_table() {
  boolean status=searchcustomer.searchcustomerbyname("Victoria Terces");
  Assert.assertEquals(true,status);

    }




    }




