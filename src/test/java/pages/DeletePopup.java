package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePopup extends Page {

    @FindBy(xpath = "//button[.=' Yes, Delete ']")
    WebElement deleteButton;

    public DeletePopup(WebDriver driver) {
        super(driver);
    }

    public JobTitlesPage clickDeleteButton(){
        deleteButton.click();
        return new JobTitlesPage(driver);
    }
}
