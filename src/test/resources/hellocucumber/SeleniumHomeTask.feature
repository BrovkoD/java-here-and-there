Feature: Manage a job title

  Scenario: Add and delete a job

    Given user is on the login page

    When user logs in
      And user goes to the Admin page
      And user selects Job -> Job Titles tab
      And user clicks on the Add button
      And user adds new job title "Student/Intern" with description "test description" and note "note description"
    Then user sees the new job title "Student/Intern" on the Job Title page

    When user selects and deletes the new title "Student/Intern"
      And user clicks 'Yes, Delete' button
    Then the field "Student/Intern" is removed

