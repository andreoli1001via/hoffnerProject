package hoffnerProject.support;

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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DriverWait {

    private WebDriver driver;
    private JavascriptExecutor executor;
    private int timeOut = 30;

    public DriverWait(final WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    private Wait<WebDriver> setWait(){
        return new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(this.timeOut))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class);
    }

    public WebElement waitForClickableButton(final WebElement element){
        return this.setWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitButtonPopUp(final WebElement element){
        return new WebDriverWait(this.driver, 5).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisibleElement(final WebElement element){
        return this.setWait().until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForPresentText(final WebElement element, final String text){
        return this.setWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public WebDriver waitIframe(final WebElement element){
        return this.setWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public WebElement waitElementInListByText(final List<WebElement> elements, final String text){
        this.waitElementList(elements);
        for(final WebElement element : elements){
            this.setWait(1);
            if(text.equalsIgnoreCase(element.getText())){
                return this.setWait().until(ExpectedConditions.elementToBeClickable(element));
            }
        }
        throw new RuntimeException(text + " não encontrado");
    }

    public List<WebElement> waitElementList(final List<WebElement> elements) {
        return this.setWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public DriverWait clickJSExecutor(final WebElement element){
        this.setWait(3);//.waitForJStoLoad();
        this.executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public DriverWait pageJSExecutor(final String coordenate){
        this.executor.executeScript("window.scrollBy(0,"+coordenate+")");
        return this;
    }

    public DriverWait moveToElementJSExecutor(final WebElement element){
        this.executor.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public DriverWait setWait(final int timeOut){
        try {
            Thread.sleep(timeOut * 1000);
        } catch (final Exception e){
            e.printStackTrace();
        }
        return this;
    }
    private boolean waitForJStoLoad() {
        // wait for jQuery to load
        final ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (final Exception e) {
                    return true;    // no jQuery present
                }
            }
        };
        // wait for Javascript to load
        final ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return this.setWait().until(jQueryLoad) && this.setWait().until(jsLoad);
    }
    public void switchToIframe(WebElement element){
        waitForJStoLoad();
        driver.switchTo().parentFrame();
        driver.switchTo().frame(element);
    }


    public void switchTab(){
        List<String> abas = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(abas.get(1));
    }

}
