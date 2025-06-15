package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddJobTitlePage extends Page{

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
    WebElement jobTitleField;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")
    WebElement jobDescriptionField;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea")
    WebElement noteField;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]")
    WebElement saveButton;

    public AddJobTitlePage(WebDriver driver) {
        super(driver);
    }

    public void enterNewJobTitleInfo(String title, String description, String note){
        jobTitleField.sendKeys(title);
        jobDescriptionField.sendKeys(description);
        noteField.sendKeys(note);
    }

    public JobTitlesPage saveJobTitle(){
        saveButton.click();
        return new JobTitlesPage(driver);
    }
}
