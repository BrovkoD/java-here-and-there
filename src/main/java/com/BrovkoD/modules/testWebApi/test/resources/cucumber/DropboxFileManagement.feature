Feature: DropboxAPI file management

  Scenario: Upload file
    Given there is a file
      When user uploads the file
      Then the file is uploaded to the Dropbox

  Scenario: Get file's metadata
    Given there is a file
      When user uploads the file
        And user requests file's metadata
      Then file's metadata is received

  Scenario: Delete file
    Given there is a file
      When user uploads the file
        And user deletes the file
      Then the file is deleted
