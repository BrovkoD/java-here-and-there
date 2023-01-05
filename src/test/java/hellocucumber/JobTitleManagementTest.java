package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import static java.lang.String.format;

import java.time.Duration;

public class JobTitleManagementTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;
    JobTitlesPage jobTitlesPage;
    AddJobTitlePage addJobTitlePage;
    DeletePopup deletePopup;

    @Before
    public void setup(){
//        System.setProperty("webdriver.gecko.driver", "path");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user is on the login page")
    public void getLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.loadPage();
    }

    @When("user logs in")
    public void logIn() {
        String username = loginPage.getUsername();
        String password = loginPage.getPassword();
        homePage = loginPage.loginWithCredentials(username, password);
    }

    @When("user goes to the Admin page")
    public void getAdminPage() {
        adminPage = homePage.getAdminPage();
    }

    @And("user selects Job -> Job Titles tab")
    public void getJobTitlesPage() {
        jobTitlesPage = adminPage.selectJobTitlesTab();
    }

    @And("user clicks on the Add button")
    public void getAddJobTitlePage() {
        addJobTitlePage = jobTitlesPage.getAddJobTitlePage();
    }

    @And("user adds new job title {string} with description {string} and note {string}")
    public void addJobTitle(String jobTitle, String description, String note) {
        addJobTitlePage.enterNewJobTitleInfo(jobTitle, description, note);
        jobTitlesPage = addJobTitlePage.saveJobTitle();
    }

    @Then("user sees the new job title {string} on the Job Title page")
    public void checkNewJobTitle(String jobTitle) throws Exception {
        jobTitlesPage.checkNewJobTitle(jobTitle);
    }

    @When("user selects and deletes the new title {string}")
    public void selectAndDeleteJobTitle(String jobTitle) {
        deletePopup = jobTitlesPage.selectAndDeleteJobTitle(jobTitle);
    }

    @And("user clicks 'Yes, Delete' button")
    public void approveDeletion() {
        jobTitlesPage = deletePopup.clickDeleteButton();
    }

    @Then("the field {string} is removed")
    public void checkDeletion(String jobTitle) throws Exception {
        jobTitlesPage.checkDeletion(jobTitle);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
