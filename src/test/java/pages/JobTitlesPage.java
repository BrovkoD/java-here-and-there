package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

public class JobTitlesPage extends Page {

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
    WebElement addJobTitleButton;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div/button")
    WebElement deleteJobTitleButton;

    public JobTitlesPage(WebDriver driver) {
        super(driver);
    }

    public AddJobTitlePage getAddJobTitlePage() {
        addJobTitleButton.click();
        return new AddJobTitlePage(driver);
    }

    public void checkNewJobTitle(String jobTitle) throws Exception {
        if (driver.findElements(By.xpath("//div[.='" + jobTitle + "']")).isEmpty()) {
            throw new Exception(format("No new job title '%s' found", jobTitle));
        }
    }

    public DeletePopup selectAndDeleteJobTitle(String jobTitle){
        driver.findElement(By.xpath("//div[.='" + jobTitle + "']/ancestor::div[2]/div/div[1]/div/div/label/span/i"))
                .click();
        deleteJobTitleButton.click();

        return new DeletePopup(driver);
    }

    public void checkDeletion(String jobTitle) throws Exception {
        if (!driver.findElements(By.xpath("//div[.='" + jobTitle + "']")).isEmpty()) {
            throw new Exception(format("The job title '%s' was not deleted", jobTitle));
        }
    }
}
