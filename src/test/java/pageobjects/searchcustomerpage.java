package pageobjects;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class searchcustomerpage {
    public WebDriver driver;

    public searchcustomerpage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "SearchEmail")
    WebElement typeEmail;
    @FindBy(id = "SearchFirstName")
    WebElement typefirstname;
    @FindBy(id = "SearchLastName")
    WebElement typelastname;
    @FindBy(id = "SearchMonthOfBirth")
    WebElement searchDOBMONTH;
    @FindBy(id = "SearchDayOfBirth")
    WebElement searchDOBday;
    @FindBy(id = "SearchCompany")
    WebElement searchcompany;
    @FindBy(id = "SearchIpAddress")
    WebElement searchIPaddress;
    @FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
    WebElement typecustomerrole;
    @FindBy(id = "search-customers")
    WebElement clicksearchbtn;
    @FindBy(xpath = "//table[@id='customers-grid']")
    WebElement table;
    @FindBy(xpath = "//table[@id='customers-grid']//tbody//tr")
    List<WebElement> tableRows;

    public void setEmail(String email) {
        typeEmail.clear();
        typeEmail.sendKeys(email);
    }

    public void setfirstname(String firstname) {
        typefirstname.sendKeys(firstname);
    }

    public void setTypelastname(String lastname) {
        typelastname.sendKeys(lastname);
    }

    public void clicksearch() {
        clicksearchbtn.click();
    }

    public int getNOofRows() {
        return (tableRows.size());

    }

    public boolean searchcustomerbyname(String Name) {
        boolean flag = false;
        for (int i = 1; i <= getNOofRows(); i++) {
            String name = table.findElement(By.xpath("table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
            String names[] = name.split(" ");//seperating firstname and lastname
            if (names[0].equals("Victoria") && names[1].equals("Terces"))
            {
                flag = true;
            }
        }
        return flag;
    }
}



