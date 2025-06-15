package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Page  {

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]")
    WebElement jobDropDown;

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a")
    WebElement jobTitlesOption;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public JobTitlesPage selectJobTitlesTab(){
        jobDropDown.click();
        jobTitlesOption.click();
        return new JobTitlesPage(driver);
    }
}
