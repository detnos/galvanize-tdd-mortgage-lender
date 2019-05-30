##Mortgage Lender App
Every day, potential buyers are looking for a lender to finance their new home.
Let's build an app to simulate a potential (and grossly  over-simplified) process for lenders to qualify and approve loan applicants.

####Background info:
	- https://www.moneyunder30.com/how-your-credit-scores-affect-mortgage-rates 	- https://blog.mint.com/housing/how-lenders-determine-how-much-house-you-can-afford-1013/
	- https://www.wikihow.com/Calculate-Mortgage-Payments

### Objectives:

- Give and receive feedback on pairing behaviors - see Pairing Rubric below
- Practice writing tests first
- Practice writing good tests - SEAT pattern
- Practice the `refactor` phase of red, green, refactor, commit
- Practice frequent commits with good messages

### Instructions

1. This exercise is meant to be completed with pair programming.  Discuss when you will change driver/navigator roles.
1. `fork` this repository.
1. `clone` your fork of this repository.
1. Import the `build.gradle` file into idea.
1. Use the acceptance criteria for the first story to write a failing test.
1. Write the **simplest** code needed to make the test pass. 
1. Refactor. 
    - Are any methods more than 5 or 10 lines of code?
    - Is it obvious what each section of code does? If not, how could you make it obvious?
1. Commit with an informative message
1. Move on to the next user story and continue until all stories are completed.


### User Stories

As a lender, I want to be able to add funds so that I have money to offer loans to potential home buyers
- Given that I am a lender with a means to store funds,
- when I add funds to my account
- then I should see my total available funds increase according to how much I added


As a lender, I want to deny applicants who request higher loan amounts than I have available in my funds so that I don't go bankrupt
- Given that an applicant requests a loan,
- when the requested amount is greater than the amount of funds I have available
- then I should deny them


As a lender, I want to calculate a monthly mortgage payment so that I can assess whether or not an applicant is a good candidate to offer a loan to
- Given that I have an equation to calculate monthly mortgage payments:
	``` 			
	M = P * (r * (1+r)^n) / ((1 + r)^n - 1)
			M = monthly payment
			P = Principal amount
			r = monthly interest rate (annual interest rate  / 12)
			n = number of payments (# of months you will be paying the loan
- when I am requested of a loan for a given principal amount, monthly interest rate, and # of payments,
- then I can calculate the minimum monthly mortgage payment for a LoanApplicant
- `lender.calculateMonthlyMortgage(principal: 200000, annualRate: .04, numPayments: 360)` should return `1193.54`


As a lender, I want to determine whether or not an applicant is a good candidate to offer a loan to so that I can qualify or deny them for a requested loan amount
- Given that a loanApplicant has a good debt-to-income ratio (DTI < 36%), a credit score above 620, and an amountSaved >= 25% of the requested loanAmount,
- When they apply for a loan
- then I should qualify them
- For the loanApplicant above, `lender.qualifyLoanApplication(loanApplicant, loanAmount: 250000 )` should return `true`
- For the loanApplicant above, `lender.qualifyLoanApplication(loanApplicant, loanAmount: 1000000 )` should return `false`


As a lender, I want to offer a loan contract to a qualified applicant if I have enough available funds so that they can choose to review and accept a loan from me
- Given that I have enough available funds to offer a loan,
- when an applicant is deemed to be qualified,
- then I should offer them a loan.


As a lender, I want to approve a qualified applicant who accepts a loan offer so that I can make more money
- Given that I have sent a loan offer to a qualified applicant,
- When the applicant accepts my loan offer,
- Then I should approve them for a loan


As a lender, I want to send requested loan amounts to borrowers upon approving their applications so that they can buy a home
- Given that I have approved a borrower for a loan,
- when I send them the amount requested
- then I should update my own available/pending funds accordingly.


As a lender, I want to set an expiration date of 3 days on all loan contracts so that I can manage my time and money wisely
- Given that I have a good candidate to offer a loan to,
- when I offer them a loan
- then I should set an expiration date of 3 days on the offer.


As a lender, I want to keep funds for pending loan contracts in a secondary account so that I don't extend too many offers at once and bankrupt myself
- Given that I have a good candidate to offer a loan to,
- when I offer them a loan
- then I should move the requested loan amount from my available funds to my pending funds


As a lender, I want to reclaim funds set aside for pending loan contracts back into my available funds once the offer expires so that I have more funds readily available to offer to other applicants.
- Given that I sent a loan contract to a qualified applicant,
- when the loan contract expires with no response,
- then I want to reclaim the pending funds back into my available funds


As a lender, I want to approve all qualified applicants for a loan as long as I have enough available funds so that I can make more money
- Given that an applicant is applying for a home loan,
- When they are qualified AND I have enough loanableFunds to loan the amount requested,
- Then I should approve them for a loan
- For a `new Lender(loanableFunds: 500000, currentLoans: [])`
- And the loanApplicant above, `lender.approveLoan(loanApplicant, loanAmount: 250000 )` should return `true`