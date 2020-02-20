package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    public WebDriver driver;

    public Loginpage (WebDriver rdriver){
        driver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(id = "Email")
    WebElement typeemail;

    @FindBy(id = "Password")
    WebElement typepassword;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginbutton;

    @FindBy(linkText = "Logout")
    WebElement logoutlink;

    public void setemail(String username){
        typeemail.sendKeys(username);
    }
    public void setpassword(String password){
        typepassword.sendKeys(password);
    }
    public void setLoginbutton(){
        loginbutton.click();
    }
    public void setLogoutlink(){
        logoutlink.click();
    }



}
