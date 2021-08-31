package support;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverWait {

    private WebDriver driver;
    private JavascriptExecutor executor;
    private int timeOut = 30;

    public DriverWait(WebDriver driver){
        this.driver = driver;
        executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    private Wait<WebDriver> setWait(){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class);
    }

    public WebElement waitForClickableButton(WebElement element){
        waitForJStoLoad();
        return setWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitButtonPopUp(WebElement element){
        waitForJStoLoad();
        return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisibleElement(WebElement element){
        waitForJStoLoad();
        return setWait().until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForPresentText(WebElement element, String text){
        waitForJStoLoad();
        return setWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public WebDriver waitIframe(WebElement element) throws InterruptedException {
        waitForJStoLoad();
        Thread.sleep(2000);
        return setWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public WebElement waitElementInListByText(List<WebElement> elements, String text){
        waitForJStoLoad();
        waitElementList(elements);
        for(WebElement element : elements){
            setWait(1);
            if(text.equalsIgnoreCase(element.getText())){
                return setWait().until(ExpectedConditions.elementToBeClickable(element));
            }
        }
        throw new RuntimeException(text + "não encontrado");
    }

    public List<WebElement> waitElementList(List<WebElement> elements) {
        return setWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public DriverWait clickJSExecutor(WebElement element){
        setWait(3).waitForJStoLoad();
        executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public DriverWait pageJSExecutor(String coordenate){
        waitForJStoLoad();
        executor.executeScript("window.scrollBy(0,"+coordenate+")");
        return this;
    }

    public DriverWait moveToElementJSExecutor(WebElement element){
        waitForJStoLoad();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public DriverWait setWait(int timeOut){
        try {
            Thread.sleep(timeOut * 1000);
        } catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    private boolean waitForJStoLoad() {
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;    // no jQuery present
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return setWait().until(jQueryLoad) && setWait().until(jsLoad);
    }

    public void switchToIframe(WebElement element){
        waitForJStoLoad();
        driver.switchTo().parentFrame();
        driver.switchTo().frame(element);
    }



}
