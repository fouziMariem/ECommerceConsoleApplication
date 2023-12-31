# Java E-Commerce Console Application 
___
This Java-based console application simulates an e-commerce system, demonstrating fundamental Object-Oriented Programming (OOP) concepts. Users can authenticate, manage products, handle shopping cart interactions, process orders, and more.
## Features
___
* User authentication System
* Product management
* Shopping cart
* Order management
* Discounts and coupons management
* Payment system
* Dynamic product filtering
* shipping options
* **Admins** :
    * Log in as an admin
    * Add an admin
    * Add a new product to the inventory
    * Add an existing product by adding to its existing quantity in the inventory
    * Remove a product from the inventory by earasing it
    * Remove a product from the inventory by decreasing its quantity
    * Update an existing product(by entering its attributes depending of the category)
    * Display all the products in the inventory and their quantity 
    * Set the quantity of a product
    * Set the discount code(10% on all products)
    * Search for a product :
        * By category
        * By name 
        * By price range
        * By brand
    * Log out 

* **Customers** :
    * Sign in as a new user
    * Log in as a user
    * Add a product to the shopping cart
    * Remove a product from the shopping cart
    * Set the quantity of a product already existing in the shopping cart
    * Display all products in the shopping cart
    * Set the information of the user(name and password)
    * Get the total price of the shopping cart
    * Display all products in the inventory
    * Search for a product in the inventory  :
        * By category
        * By name 
        * By price range
        * By brand
    * View previous orders
    * Check out the shopping cart (choose the type of payment /choose type of delivery/apply a discount code)
    * Log out 
## Design Decisions
___
* We used the abstract class User as a parent class to the Admin class and Customer class .
* We added the sign in method to the customer to allow a new customer to use the application but an admin can be added only by another admin(that’s why we used the default admin when we first run the application).
* The user menu is an abstract method in user seeing that each type of users has its own features.
* To manage all the users we added a static attribute which is an array in which we store all users of the application.
* The inventory class manages all products in the inventory (add/remove etc).
* The class product is an abstract class and is parent to the classes : food/clothing/books/electronics.
* The shoppingCart class is used to manage the shopping cart of each user and do the checkout .
* The Order class is used to manage the orders and store the information of all orders in a static array.
* The paymentStategy interface is used to enforce a contract to all the classes that implements it (paypal payment/cash payment/ check payment/ credit card payment)
* The runApplication class is used run the whole application by creating an inventory and display the main menu then depending on the user displaying its menu .

## Optional features
___
* The coupons and discounts system.
* Shipping options.
1. The coupons and discounts system:
   * The discount code is set at first by the default admin .
   * Any admin can change it after.
   * The code apply to the shopping cart a discount of 10%.
2. Shipping options:
    * At the check out the user chooses the type of shipping.
    * The standard shipping adds 10 to the total price .
    * The Express shipping adds 20 to the total price.

## the design patterns
___
The Strategy design pattern is used in the PaymentSystem .
   * The PaymentStrategy class is an interface that has a method to pay .
   * The PayPalPayment class has a method to pay with paypal .
   * The CashPayment class has a method to pay with cash .
   * The CreditCardPayment class has a method to pay withthe credit card.
   * The CheckPayment class has a method to pay with a check .
   
