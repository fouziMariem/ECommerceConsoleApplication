import java.util.*;
//class ShoppingCart
public class ShoppingCart {
    // Attributes
    private int userId;
    private Map<Product, Integer> cart;
    private double totalPrice;
    private static String discountCode;
    private String shipping;

    //constructor
    public ShoppingCart() {
        this.userId = 0;
        this.cart = new HashMap<>();
        this.totalPrice = 0;
    }
    //get the total price
    public double getTotalPrice() {
        return totalPrice;
    }
    //set the discount code
    public static void setDiscountCode(String discountCode) {
        ShoppingCart.discountCode = discountCode;
    }
    //find a product in the cart using the product barcode
    public Product findProductInCart(int barcode) {
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            if (entry.getKey().getBarcode() == barcode) {
                return entry.getKey();
            }
        }
        return null;
    }

    // add one product to cart using the product barcode
    public void addProduct(int barcode, Inventory inventory) {
        Product product = inventory.findProduct(barcode);
        if (product != null & inventory.getQuantity(barcode) > 0) {
            if (findProductInCart(barcode) != null) {
                cart.put(product, cart.get(product) + 1);
                inventory.setQuantity(barcode, inventory.getQuantity(barcode) - 1);
            } else {
                cart.put(product, 1);
            }
            totalPrice += product.getPrice();
        } else if (product != null & inventory.getQuantity(barcode) == 0) {
            System.out.println("Product out of stock");
        } else {
            System.out.println("Product not found");
        }
    }
    //add a quantity of a product to the cart using the product barcode
    public void addProduct(int barcode, int quantity, Inventory inventory) {
        if (inventory.findProduct(barcode) == null) {
            System.out.println("Product not found");

        } else if (inventory.getQuantity(barcode) < quantity) {
            System.out.println("Not enough quantity");

        }
        for (int i = 0; i < quantity; i++) {
            this.addProduct(barcode, inventory);
        }

    }

    // remove product from cart using the product barcode
    public void removeProduct(int barcode, Inventory inventory) {
        Product product = this.findProductInCart(barcode);
        if (product != null) {
            cart.put(product, cart.get(product) - 1);
            inventory.setQuantity(barcode, inventory.getQuantity(barcode) + 1);
            totalPrice -= product.getPrice();
        } else {
            System.out.println("Product not found");
        }
    }
    //remove a quantity of a product from the cart using the product barcode
    public void removeProduct(int barcode, int quantity, Inventory inventory) {
        if (this.getQuantity(barcode) < quantity) {
            System.out.println("Not enough quantity");
            return;
        }
        for (int i = 0; i < quantity; i++) {
            this.removeProduct(barcode, inventory);
        }
    }

    //get the quantity of a product in the cart
    public int getQuantity(int barcode) {
        Product product = this.findProductInCart(barcode);
        if (product != null) {
            return cart.get(product);
        } else {
            System.out.println("Product not found");
            return 0;
        }
    }

    //set the quantity of a product in the cart
    public void setQuantity(int barcode, int quantity, Inventory inventory) {
        Product product = this.findProductInCart(barcode);
        if (product != null) {
            //if the quantity is less than the current quantity we use the remove method else we use the add method if the quantity is equal to the current quantity we do nothing and if the product is not found we do nothing
            if (quantity < cart.get(product)) {
                this.removeProduct(barcode, cart.get(product) - quantity, inventory);
            } else if (quantity > cart.get(product)) {
                this.addProduct(barcode, quantity - cart.get(product), inventory);
            }
        } else {
            System.out.println("Product not found");
        }
    }
    //display the product in the cart with their quantities and the total price
    public void displayCart() {
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            entry.getKey().displayProduct();
            System.out.println("Quantity : " + entry.getValue());
        }
        System.out.println("Total price : " + totalPrice);
    }
    //checkout the cart
    public void checkout() {
        //choose payment method
        Scanner scanner = new Scanner(System.in);
        PaymentStrategy paymentStrategy=null;
        int choice=0;
        while(true){
            try{
                System.out.println("Choose payment method :");
                System.out.println("1-Cash");
                System.out.println("2-Credit card");
                System.out.println("3-Paypal");
                System.out.println("4-Check");
                choice = Integer.parseInt(scanner.nextLine());
                while (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice please try again");
                    choice = Integer.parseInt(scanner.nextLine());
                }
                break;
            }
            catch(Exception e){
                System.out.println("Invalid input please try again");
            }
        }

        switch(choice){
            case 1:
                CashPayment cashPayment = new CashPayment();
                cashPayment.pay(totalPrice);
                break;
            case 2:
                while(true){
                    try{
                        System.out.println("Enter the credit card number");
                        String creditCardNumber = scanner.nextLine();
                        System.out.println("Enter the name on the card");
                        String creditCardName = scanner.nextLine();
                        System.out.println("Enter the expiration date");
                        String expirationDate = scanner.nextLine();
                        System.out.println("Enter the CVV");
                        String CVV = scanner.nextLine();
                        paymentStrategy = new CreditCardPayment(creditCardName,creditCardNumber,expirationDate,CVV);
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Invalid input please try again");
                    }
                }
                break;
            case 3:
                System.out.println("Enter the email");
                String email = scanner.nextLine();
                System.out.println("Enter the password");
                String password = scanner.nextLine();
                paymentStrategy = new PayPalPayment(email,password);
                break;
            case 4:
                System.out.println("Enter the name on the check");
                String checkName = scanner.nextLine();
                System.out.println("Enter the bank ID");
                String bankId = scanner.nextLine();
                System.out.println("Enter the routing number");
                String routingNumber = scanner.nextLine();
                System.out.println("Enter the account number");
                String accountNumber = scanner.nextLine();
                paymentStrategy = new CheckPayment(checkName,bankId,routingNumber,accountNumber);
                break;
        }
        //ask if there is a discount code and apply it repeat if the discount code is invalid
        while(true){
            while(true){
                try{
                    System.out.println("Do you have a discount code ?");
                    System.out.println("1-Yes");
                    System.out.println("2-No");
                    choice = Integer.parseInt(scanner.nextLine());
                    while (choice < 1 || choice > 2) {
                        System.out.println("Invalid choice please try again");
                        choice = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                }
                catch(Exception e){
                    System.out.println("Invalid input please try again");

                }

            }
            if(choice==1){
                System.out.println("Enter the discount code");
                String discountCode = scanner.nextLine();
                if(discountCode.equals(ShoppingCart.discountCode)){
                    totalPrice*=0.9;
                    break;
                }
                else{
                    System.out.println("Invalid discount code");
                }
            }
            else{
                break;
            }

        }

        //choose shipping method
        while(true){
            try{
                System.out.println("Choose shipping method :");
                System.out.println("1-Standard shipping");
                System.out.println("2-Express shipping");
                choice = Integer.parseInt(scanner.nextLine());
                while (choice < 1 || choice > 2) {
                    System.out.println("Invalid choice please try again");
                    choice = Integer.parseInt(scanner.nextLine());
                }
                if(choice==1){
                    shipping="Standard shipping";
                    totalPrice+=10;
                    break;
                }
                else{
                    shipping="Express shipping";
                    totalPrice+=20;
                    break;
                }
            }
            catch(Exception e){
                System.out.println("Invalid input please try again");
            }

        }
        //create the order
        Order newOrder = new Order(this.userId,this.totalPrice, this.cart, paymentStrategy , shipping);
        cart.clear();//clear the cart
        totalPrice = 0;
    }
}