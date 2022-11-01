Feature: Search for an Invalid Item
@invalid
Scenario Outline: User need search an invalid item
Given the user is in homepage
When he enters "<product>" name in search bar
Then user will not be able to see the details of the item entered

Examples:

|product|
|abc|
||