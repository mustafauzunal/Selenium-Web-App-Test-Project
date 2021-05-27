import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class GittiGidiyor {

    private WebDriver webDriver;
    //Email field
    private final By email = By.id("L-UserNameField");
    //Passwoerd field
    private  final By password = By.id("L-PasswordField");
    //Login button
    private final By submitSpace = By.id("gg-login-enter");
    //Search Bar
    private final By searchSpace  = new By.ByXPath("//*[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    //Search Button
    private final By buttonSpace  = new By.ByXPath("//*[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[2]/button");
    //Second Page Button
    private final By secondPage = new By.ByXPath("//*[@id='best-match-right']/div[5]/ul/li[2]/a");
    //Random number for Random product index
    Random r = new Random();
    int a = r.nextInt(49);
    //Random Product
    private final By randomProduct = new By.ByXPath("//*[@product-index=" + a + " ]");
    //Random Product Page Price
    private final By randomProductPrice = new By.ByXPath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[5]/div[1]");
    //Add to Basket Button
    private final By addToBasket = new By.ByXPath("//*[@id='add-to-basket']");
    //Go to Basket Button
    private final By goToBasket = new By.ByXPath("//*[@class='header-cart-hidden-link']");
    //Random Product Basket Price
    private final By randomProductPrice2 = new By.ByXPath("//*[@id='submit-cart']/div/div[2]/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[2]");
    //Amount Field
    private final By amount = By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select");
    //Delete Button
    private final By delete = By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a[1]");




    public GittiGidiyor(WebDriver webDriver) {
        this.webDriver = webDriver;
    }



    public void setEmail(String emailText) throws InterruptedException {
        WebElement emailSpace = webDriver.findElement(email);
        emailSpace.click();
        Thread.sleep(1000);
        emailSpace.sendKeys(emailText);
    }

    public  void setPassword(String passwordText) throws InterruptedException {
        WebElement passwordSpace = webDriver.findElement(password);
        passwordSpace.click();
        Thread.sleep(1000);
        passwordSpace.sendKeys(passwordText);
    }

    public void submitClick() throws InterruptedException {
        WebElement submit = webDriver.findElement(submitSpace);
        Thread.sleep(1000);
        submit.click();
    }

    public String getEmail(){
        WebElement emailSpace = webDriver.findElement(email);
        return emailSpace.getAttribute("value");
    }

    public String getPassword(){
        WebElement passwordSpace = webDriver.findElement(password);
        return  passwordSpace.getAttribute("value");
    }

    public void setSearch(String searchText) throws InterruptedException {
        WebElement searchInput = webDriver.findElement(searchSpace);
        searchInput.click();
        Thread.sleep(3000);
        searchInput.sendKeys(searchText);
    }

    public void buttonFind() throws InterruptedException{
        WebElement button = webDriver.findElement(buttonSpace);
        Thread.sleep(3000);
        button.click();

    }

    public void secondPage() throws InterruptedException{
        WebElement pageSecond = webDriver.findElement(secondPage);
        Thread.sleep(3000);
        pageSecond.click();
    }

    public void chooseRandomProduct() throws  InterruptedException{
        WebElement product = webDriver.findElement(randomProduct);
        product.click();
    }

    public void addToBasket() throws  InterruptedException{
        WebElement basket = webDriver.findElement(addToBasket);
        Thread.sleep(2000);
        basket.click();
    }
    public void getToBasket() throws  InterruptedException{
        WebElement basketGo = webDriver.findElement(goToBasket);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].click();", basketGo);
    }

    public String getFirstPrice() throws  InterruptedException{
        WebElement price = webDriver.findElement(randomProductPrice);
        String priceText = price.getText();
        return priceText;
    }

    public String getSecondPrice() throws  InterruptedException{
        WebElement price2 = webDriver.findElement(randomProductPrice2);
        String priceText2 = price2.getText();
        return priceText2;
    }


    public void increaseAmount() throws InterruptedException{
        Select dropdown = new Select(webDriver.findElement(amount));
        dropdown.selectByValue("2");
    }

    public void deleteItem() throws InterruptedException{
        WebElement deleteElement = webDriver.findElement(delete);
        deleteElement.click();
    }

    public void equality() throws InterruptedException {
        if(getFirstPrice().equalsIgnoreCase(getSecondPrice())){
            System.out.println("Fiyatlar eşit");
        }
    }
}
