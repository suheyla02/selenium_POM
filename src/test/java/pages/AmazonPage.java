package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//td[@class='navFooterDescItem']")
    public List<WebElement> tumDataWebElementList;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirWebElementi;

    @FindBy(xpath = "(//tr[1]//td[@class='navFooterDescItem'])")
    public List<WebElement> sutunSayisi;



    public String  hucreBul(int satirNo,int sutunNo){
        //   //tbody//tr[1]//td[1]
        String path="//tbody//tr["+satirNo+"]//td["+sutunNo+"]";
        WebElement element=Driver.getDriver().findElement(By.xpath(path));
        return element.getText();
    }

}
