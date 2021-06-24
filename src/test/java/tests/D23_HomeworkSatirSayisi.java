package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class D23_HomeworkSatirSayisi {
    /*
    ➢ AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana
hucredeki yaziyi getirecek bir method olusturun

➢ Tests paketi altinda yeni bir class olusturun: D26_AmazonHucreTesti

➢ Bu class’in altinda bir test method olusturun : hucretesti() ve webtable’da 3. satir
2.sutundaki yazinin “Home Services” yazisi icerdigini test edin

➢ Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede “Amazon” yazisi
bulundugunu test edin
     */

    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage = new AmazonPage();
        ReusableMethods.waitFor(5);
        String actualHome = amazonPage.hucreBul(3, 7);
        Assert.assertTrue(actualHome.contains("Home Services"));
    }
    @Test
    public void amazonYazisi(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
       List<WebElement> tumData= amazonPage.tumDataWebElementList;
       int count=0;
        for(WebElement w:tumData){
          if(  w.getText().contains("Amazon")){
              count++;
          }
        }
        System.out.println(count);
        Assert.assertEquals(count,10);


 Driver.closeDriver();
    }

}
