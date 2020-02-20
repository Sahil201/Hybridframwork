package pageobjects;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Addcustomerpage {

    public WebDriver driver;

    public Addcustomerpage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(xpath = "//a[@href='#']//span[contains(text(),'Customers')]") WebElement customermenu;
    @FindBy(xpath = "//span[@class='menu-item-title'][contains(text(),'Customers')]") WebElement customermenulist;
    @FindBy(xpath = "//a[@class='btn bg-blue']") WebElement adddnewcustomer;
    @FindBy(id="Email") WebElement textemail;
    @FindBy(id = "Password") WebElement textpassword;
    @FindBy(id = "FirstName") WebElement txtfirstname;
    @FindBy(id = "LastName") WebElement txtlastname;
    @FindBy(id = "Gender_Male") WebElement malegender;
    @FindBy(id = "Gender_Female") WebElement femalegender;
    @FindBy(id = "DateOfBirth") WebElement DOB;
    @FindBy(id = "Company")WebElement typecompanyname;
    @FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")WebElement listadministrators;
    @FindBy(id = "VendorId")WebElement managerofvender;
    @FindBy(id = "AdminComment")WebElement admincomment;
    @FindBy(name = "save") WebElement savebutton;

    //Actions Methods
    public String getpageTitle(){
        return driver.getTitle();
    }
    public void clickcustomermenu(){
        customermenu.click();
    }
    public void clickoncustomermenulist(){
        customermenulist.click();
    }
    public void clickonaddnew(){
        adddnewcustomer.click();
    }
    public void setemail(String email){
        textemail.sendKeys(email);
    }
    public void setpassword(String password){
        textpassword.sendKeys(password);
    }
    public void setfirstname(String fname){
        txtfirstname.sendKeys(fname);
    }
    public void setlastname(String lname){
        txtlastname.sendKeys(lname);
    }
    public void setmanagerofvendor(String value){
        Select slct=new Select(managerofvender);
        slct.selectByVisibleText(value);
    }
    public void setgender(String gender){
        if(gender.equalsIgnoreCase("Male")){
            malegender.click();
        }
        else if (gender.equalsIgnoreCase("Female")){
            femalegender.click();
        }
    }
    public void setDOB(String dob){
        DOB.sendKeys(dob);
    }
    public void setcompanyname(String compnyname){
        typecompanyname.sendKeys(compnyname);
    }
    public void setcustomerroles(String role){
        if (role.equalsIgnoreCase("Guests"))
        listadministrators.click();


    }
    public void setadmincomment(String comment){
        admincomment.sendKeys(comment);
    }
    public void clickonsave(){
        savebutton.click();
    }





}
