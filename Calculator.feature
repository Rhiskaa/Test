Feature: Calculator Online

Scenario: Calculator Online subtraction
	Given User Home Page Online Calculator
	When user Have Number 89
	And Want To subtraction
	And user Have Number 1
	Then User Should be have 88, Numb 89 subtraction 1
	
Scenario: Calculator Online Division
	Given User Home Page Online Calculator
	When user Have Number 99
	And Want To Division
	And user Have Number 3
	Then Result is 33, division between 99 and 3

Scenario: Calculator Online Clear
	Given User Home Page Online Calculator
	When user Have Number 99
	And user clear it
	
	

