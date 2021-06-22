package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KoalaResortPage {

    public KoalaResortPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(linkText = "Log in")
    public WebElement ilkLoginButonu;

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement passWord;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;


}
