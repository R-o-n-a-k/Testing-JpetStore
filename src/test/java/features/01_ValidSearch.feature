Feature: Search for an Item
@valid
Scenario Outline: User need to search a valid item
Given the user is in the homepage
When he enters product name in search bar from "<SheetName>" and <RowNumber>
Then user should be able to see the details of the item entered

Examples:

|SheetName|RowNumber|
|Search|0|
|Search|1|
|Search|2|
|Search|3|
