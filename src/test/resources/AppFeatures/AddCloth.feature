Feature: Add Dress to Cart

#Backgroud will be executed before all other scenarios  
Background:
Given user has logged in to application
|username|password|
|divyanklf@gmail.com|Test@1234|


Scenario: Accounts page title
Given user is on Account page
When user clicks the Women Button 
And the Women page open
Then page title of women Page should be "Women - My Shop"

Scenario: Add white blouse to cart
Given user is on the Women page
When user clicks on blouse
And change the color to white
And Press add to cart button
And Press Proceed to checkout
Then the message "Product successfully added to your shopping cart" is displayed

 @ShoppingCartSummaryValidation
Scenario: Shopping cart summary validation
Given user has already added a white blouse to the cart
When page title of summary page is "Order - My Shop"
Then the following product information should be correct


