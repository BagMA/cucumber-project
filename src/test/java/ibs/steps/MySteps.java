package ibs.steps;

import ibs.ConfProperties;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MySteps {

    public static WebDriver driver;
    public static WebDriverWait wait;

    By btnPesochnisa = By.id("navbarDropdown");
    By fldName = By.id("name");
    By btnSave = By.id("save");
    By fldType = By.id("type");
    By cbExotic = By.id("exotic");
    By title = By.id(ConfProperties.getProperty("title"));

    By btnDownList1 = By.xpath("//div[@class='dropdown-menu show']");
    By btnDownList2 = By.cssSelector("div.dropdown-menu.show");
    By btnFood1 = By.xpath("//a[@href='/food']");
    By btnFood2 = By.cssSelector(".dropdown-item[href='/food']");
    By btnAdd1 = By.xpath("//button[@data-toggle='modal']");
    By btnAdd2 = By.cssSelector("button.btn.btn-primary");
    By strPotato = By.xpath("//tr[5]/child::*[2]");
    By strVegetable = By.xpath("//tr[5]/child::*[3]");
    By strFalse = By.xpath("//tr[5]/child::*[4]");
    By typeFruit = By.cssSelector("[value='FRUIT']");
    By strPineapple = By.cssSelector("tbody > tr:last-of-type > td:first-of-type");
    By strFruit = By.cssSelector("tbody > tr:last-of-type > td:nth-of-type(2)");
    By strTrue = By.cssSelector("tbody > tr:last-of-type > td:nth-of-type(3)");

    @Допустим("открыть страницу  в брузере")
    public void открытьСтраницуВБрузере() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.navigate().to(ConfProperties.getProperty("url"));

    }

    @И("нажать на раскрывающийся список {string}")
    public void нажатьНаРаскрывающийсяСписок(String arg0) {
        driver.findElement(btnPesochnisa).click();
        Assertions.assertTrue(driver.findElement(btnDownList1).isDisplayed(),
                ConfProperties.getProperty("msgDownList"));
    }

    @И("нажать {string} в раскрывшемся списке")
    public void нажатьВРаскрывшемсяСписке(String arg0) {
        driver.findElement(btnFood1).click();
        Assertions.assertEquals(ConfProperties.getProperty("urlFood"),
                driver.getCurrentUrl(), ConfProperties.getProperty("msgNotFood"));
    }

    @И("нажать кнопку {string}")
    public void нажатьКнопку(String arg0) {
        driver.findElement(btnAdd1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        Assertions.assertTrue(driver.findElement(title).isDisplayed(), ConfProperties.getProperty("msgNoTitle"));
    }

    @И("поле {string} заполняется значением {string}")
    public void полеЗаполняетсяЗначением(String arg0, String arg1) {
        driver.findElement(fldName).sendKeys(arg1);
    }

    @И("поле2 {string} заполняется значением {string}")
    public void полеЗаполняетсяЗначением2(String arg0, String arg1){
        driver.findElement(typeFruit).click();
    }

    @И("чек-бокс {string} значение {string}")
    public void чекбоксЗначение(String arg0, String arg1){
        driver.findElement(cbExotic).click();
    }

    @И("нажать кнопку2 {string}")
    public void нажатьКнопку2(String arg0) {
        driver.findElement(btnSave).click();
    }

    @То("в таблицу {string} добавилась строка с наименованием {string}, типом {string}, значением Экзотический {string}")
    public void результатЭкзотическийFalse(String arg0, String arg1, String arg2, String arg3){
        wait.until(ExpectedConditions.visibilityOfElementLocated(strPotato));
        Assertions.assertTrue(driver.findElement(strPotato).isDisplayed(), "картофель не найден");
        Assertions.assertEquals( "Картофель", driver.findElement(strPotato).getText(), "не картофель");
        Assertions.assertEquals("Овощ", driver.findElement(strVegetable).getText(), "не овощ");
        Assertions.assertEquals("false", driver.findElement(strFalse).getText(), "не false");

    }

    @То("в таблицу {string} добавилась строка с наименованием {string}, типом {string}, значением не Экзотический {string}")
    public void результатЭкзотическийTrue(String arg0, String arg1, String arg2, String arg3){
        wait.until(ExpectedConditions.visibilityOfElementLocated(strPineapple));
        Assertions.assertTrue(driver.findElement(strPineapple).isDisplayed(), "ананас не найден");
        Assertions.assertEquals("Ананас", driver.findElement(strPineapple).getText(), "не ананас");
        Assertions.assertEquals("Фрукт", driver.findElement(strFruit).getText(), "не фрукт");
        Assertions.assertEquals("true", driver.findElement(strTrue).getText(), "не true");

    }
}
