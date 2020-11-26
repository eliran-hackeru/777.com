Feature: Application Change Language


Scenario: Home page default English language
Given User is on 777.com landing page
When User select a different language from dropdown
Then Home page has changed language
And URL has added prefix