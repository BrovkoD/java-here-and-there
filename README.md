1. Install:
- JDK 17: https://www.oracle.com/java/technologies/downloads/
- Maven: https://maven.apache.org/index.html
- Allure: https://docs.qameta.io/allure/#_installing_a_commandline
2. Make sure that those are added to the PATH variable
3. Add your DropboxAPI ACCESS_TOKEN to src/test/resources/config.properties. To get the token:
- open "App Console" from https://www.dropbox.com/developers/
- create new app
- provide read/write access for file content and metadata
- generate new access token in the OAuth 2 tab
4. Open terminal in project folder
5. Launch tests by executing the command: mvn test
6. Check allure report by executing the command: allure serve allure-results