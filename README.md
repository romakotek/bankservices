#That is a microservice that allows to provide common bank operations. 
The App realizes following business cases: 
- Creating a customer with full name, day of birth, address and a rating class which defaults to ‚2‘.
- Query names and addresses of all customers by their last name and allow to sort the result. 
- Transfer money from one account to another resulting in a posting. 
- Creating a new account for a given customer. 
- Creating a new credit for a given customer. 
- Listing all accounts of one customer with their current balance. 
- Listing all credits of one customer with their original term, remaining term, original credit amount and the current credit amount. 
- Listing all postings of the financial institution for a given booking date.
- Listing all postings with the account id and customer name of source and destination of one customer and make the result sortable and page-able.
- Payoff a part of a credit by transferring money from an account.
- The application should be secured with a login backed with only one hardcoded user and password combination. If a user is not logged he should not have access to the system. 
- Showing the balance for one customers.
- Showing the balance for the financial institution.
- The API should have an online documentation.
- The first booking should be configurable in the properties of the application.
- Process to the next booking date. A booking date should be every weekday regardless of holidays.
- Listing all credits with original credit amount, current credit amount and customer name which are exceeded their original terms.
- If a customer paid off a credit he will be awarded to a better rating class but at maximum to ‚1‘. 
- If a customer didn‘t paid off a credit before the remaining term is below zero his rating class will be set to ‚4‘. 
- Listing all customers with name grouped by their current rating class.