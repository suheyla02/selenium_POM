package smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
//    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
//3 Farkli test Methodunda 3 senaryoyu test et
//- yanlisSifre
//- yanlisKulllanici
//- yanlisSifreKullanici
//    test data dogru username: manager , dogru password : Manager2!
//    2)// http://qa-environment.koalaresorthotels.com adresine git
//   3) Login butonuna bas
//4) Verilen senaryolar ile giris yapilamadigini test et

    @Test
    public void yanlisSifre(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginButonu.click();
        koalaResortPage.userName.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortPage.passWord.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        koalaResortPage.loginButonu.click();
        Assert.assertTrue(koalaResortPage.girisYapilamadi.isDisplayed());

    }
    @Test
    public void yanlisKullanici(){
       Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
       KoalaResortPage koalaResortPage=new KoalaResortPage();
       koalaResortPage.ilkLoginButonu.click();
       koalaResortPage.userName.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
       koalaResortPage.passWord.sendKeys(ConfigReader.getProperty("kr_valid_password"));
       koalaResortPage.loginButonu.click();
       Assert.assertTrue(koalaResortPage.girisYapilamadi.isDisplayed());

    }
    @Test
    public void yanlsiSifreVeKullanici(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginButonu.click();
        koalaResortPage.userName.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
        koalaResortPage.passWord.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        koalaResortPage.loginButonu.click();
        Assert.assertTrue(koalaResortPage.girisYapilamadi.isDisplayed());
    }
}
