
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class CommonTest extends BaseTest{



    @Test(priority = 0)
    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void getLoginPage() throws InterruptedException {
        Thread.sleep(2500);
        webDriver.get("https://www.gittigidiyor.com/uye-girisi?s=1");
    }

    @Test(priority=2)
    public void setEmail() throws InterruptedException {
        gittiGidiyor.setEmail("Your Email");
        Assertions.assertEquals("Your Email",gittiGidiyor.getEmail(),"Email is not correct");
        System.out.println("Email girildi");

    }



    @Test(priority = 3)
    public void setPassword() throws InterruptedException {
        gittiGidiyor.setPassword("Your Password");
        Assertions.assertEquals("Your Password",gittiGidiyor.getPassword(),"Password is not correct");
        System.out.println("Şifre girildi");
    }

    @Test(priority = 4)
    public void submit() throws Exception {
        try {
            gittiGidiyor.submitClick();
            System.out.println("Hesaba giriş yapıldı");
        }catch (Exception e) {
            System.out.println("Hesaba giriş başarılı değil");

        }

    }
    @Test(priority = 5)
    public void setSearch() throws InterruptedException {
        gittiGidiyor.setSearch("bilgisayar");
        System.out.println("Arama kutucuğuna bilgisayar yazıldı");
    }

    @Test(priority = 6)
    public void buttonClick() throws InterruptedException {
        gittiGidiyor.buttonFind();
        System.out.println("Arama butonuna tıklandı.");
    }

    @Test(priority = 7)
    public void secondPage() throws  InterruptedException{
        Thread.sleep(2000);
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        gittiGidiyor.secondPage();
        System.out.println("Sayfa en aşağıya kaydırılıp, 2. sayfaya tıklandı");
    }

    @Test(priority = 8)
    public void randomProduct() throws InterruptedException{
        Thread.sleep(2000);
        gittiGidiyor.chooseRandomProduct();
        System.out.println("Rastgele bir ürün seçildi");
    }



    @Test(priority = 9)
    public void addToBasket () throws InterruptedException{
        Thread.sleep(2000);
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(0, 150)");
        gittiGidiyor.addToBasket();
        System.out.println("Seçilen ürün sepete eklendi");

    }


    @Test(priority = 10)
    public void goToBasket() throws InterruptedException{
        Thread.sleep(2000);
        gittiGidiyor.getToBasket();
        System.out.println("Sepete gidildi");
    }


    @Test(priority = 11)
    public void comparison() throws InterruptedException{
        gittiGidiyor.equality();
        System.out.println("Ürünün sayfasındaki fiyatla sepetteki fiyat karşılaştırıldı");
    }


    @Test(priority = 12)
    public void increaseAmountOfBasket() throws InterruptedException{
        Thread.sleep(2000);
        gittiGidiyor.increaseAmount();
        System.out.println("Ürünün müktarı bir arttırıldı");
    }

    @Test(priority = 13)
    public void deleteElementFromBasket () throws InterruptedException{
        Thread.sleep(2000);
        gittiGidiyor.deleteItem();
        System.out.println("Sepetteki ürün silindi");
    }


}
