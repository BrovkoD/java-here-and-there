package api.dropbox;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Properties;

import static java.lang.String.format;

public class DropboxFileManagementTest {

    private static final DropboxAPI dropboxAPI;
    private static final Path MAIN_FILE_PATH = Path.of("importantData.txt");
    private static final Path DUPLICATE_FILE_PATH = Path.of("duplicate.txt");

    Optional<String> fileMetadata;

    static {
        try (InputStream config = Files.newInputStream(Path.of("src/test/resources/config.properties"))){
            Properties properties = new Properties();
            properties.load(config);
            dropboxAPI = new DropboxAPI(properties.getProperty("ACCESS_TOKEN"));
        } catch (IOException e) {
            throw new RuntimeException(format("Could not read the properties file: %s", e));
        }
    }

    @Given("there is a file")
    public void createFile() {
        try {
            Files.write(MAIN_FILE_PATH, "Some important info".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(String.format("Could not create the file: %s", e));
        }
    }

    @When("user uploads the file")
    public void uploadFile() {
        dropboxAPI.uploadFile(MAIN_FILE_PATH);
    }

    @Then("the file is uploaded to the Dropbox")
    public void checkFileUpload() {
        Optional<Path> dropboxFile = dropboxAPI.downloadFile(MAIN_FILE_PATH, DUPLICATE_FILE_PATH);
        if (dropboxFile.isEmpty()){
            throw new RuntimeException("Could not get the file");
        }
    }

    @And("user requests file's metadata")
    public void getFileMetadata() {
        fileMetadata = dropboxAPI.getFileMetadata(MAIN_FILE_PATH);
    }

    @Then("file's metadata is received")
    public void checkFileMetadata(){
        if (fileMetadata.isEmpty()) {
            throw new RuntimeException("Could not get the file metadata");
        }
    }

    @And("user deletes the file")
    public void deleteFile() {
        dropboxAPI.deleteFile(MAIN_FILE_PATH);
    }

    @Then("the file is deleted")
    public void checkFileDeletion() {
        Optional<Path> fileToDelete = dropboxAPI.downloadFile(MAIN_FILE_PATH, DUPLICATE_FILE_PATH);
        if (fileToDelete.isPresent()){
            throw new RuntimeException("Could not delete the file");
        }
    }

    @After
    public void cleanUp(){
        dropboxAPI.deleteFile(MAIN_FILE_PATH);
        try {
            Files.delete(MAIN_FILE_PATH);
            Files.delete(DUPLICATE_FILE_PATH);
        } catch (IOException e) {
//            throw new RuntimeException(String.format("Could not delete the file: %s", e));
        }
    }
}
