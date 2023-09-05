@test
Feature: Schedule interview
  Scenario:  Schedule an interview with a candidate successfully
    Given the user accesses the website
    When the user introduces the "valid credentials"
    And the user presses on Login button
    And the user clicks on Recruitment link from the menu which will redirect me to the viewCandidates page
    And the user clicks on the view icon located in the Actions section to see a candidate's application in Status Shortlisted
    And the user clicks the 'Schedule Interview' button for that candidate
    And the user introduces the title of the interview
    And the user adds two interviewers in the 'Interviewer' field
    And the user selects a date and hour
    And the user presses the 'Save' button to schedule the interview
    Then the user should see the confirmation message for this scheduled interview