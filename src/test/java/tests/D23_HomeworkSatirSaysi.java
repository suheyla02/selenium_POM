package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class D23_HomeworkSatirSaysi {
    /*

➢ Amazon anasayfaya gidebilecek sekilde bir page sayfasi olusturun : AmazonPage

➢ Amazon ana sayfasinda en altta bulunan Webtable’i inceleyebilmek icin AmazonPage
clasinda en altta gitme isini yapacak bir method olusturun

➢ Tests paketi altinda yeni bir class olusturun: D26_AmazonSatirSutunSayisi

➢ Bu class’in altinda bir test method olusturun : satirSayisi() ve webtable’da 10 satir
oldugunu test edin

➢ Yeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7oldugunu test
edin
     */

    @Test
    public void satirSayisi(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
        List<WebElement> satir=amazonPage.satirWebElementi;
        int satirSayisi=ReusableMethods.getElementsText(satir).size();
        Assert.assertEquals(satirSayisi,9);

    }
    @Test
    public void sutunSayisi(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
        int sutun=amazonPage.sutunSayisi.size();
        Assert.assertEquals(sutun,7);
        Driver.closeDriver();
    }


}
