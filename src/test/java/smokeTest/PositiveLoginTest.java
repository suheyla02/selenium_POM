package smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {
    /*
        http://qa-environment.koalaresorthotels.com adresine git
        login butonuna bas
    test data username: manager ,
    test data password : Manager1!
    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */

    @Test
    public void positiveLoginTest(){
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        //login butonuna bas
        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.ilkLoginButonu.click();
        //test data username: manager ,
        koalaResortPage.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        //test data password : Manager1!
        koalaResortPage.passWord.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortPage.loginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("kr_basarili_giris_url"));

        Driver.closeDriver();

    }
}
