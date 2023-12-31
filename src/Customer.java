import java.util.Scanner;
//class customer that extends the user class
public class Customer extends User{
    //have the same attributes as the user class
    //constructor
    public Customer(int CIN, String userName, String password) {

        super(CIN,userName,password,"Customer");
    }
    //sign in method that takes the inventory as a parameter
    public static void signIn(Inventory inventory){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.println("CIN :");
                int CIN = Integer.parseInt(scanner.nextLine());
                System.out.println("Customer name :");
                String userName = scanner.next();
                System.out.println("Password:");
                String password = scanner.next();
                User newUser= new Customer(CIN,userName,password);
                currentUser=newUser;
                inventory.setCurrentUser(currentUser);
                break;
            }
            catch(Exception e){
                System.out.println("Invalid input please try again");
            }
        }
    }
    //customer menu
    // add product to the shopping cart
    // remove product from the shopping cart
    // set quantity of a product in the shopping cart
    // display all products in the shopping cart
    // set the name of the user
    // set the password of the user
    // get the total price of the shopping cart
    // display all products
    // search by category in the inventory
    // search by brand in the inventory
    // search by name in the inventory
    // search by price in the inventory
    // view all orders
    // checkout the shopping cart
    // logout
    public void userMenu(Inventory inventory){
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        boolean test = true;
        while(test){
            System.out.println("1-Add product to the shopping cart");
            System.out.println("2-Remove product from the shopping cart");
            System.out.println("3-Set quantity of a product in the shopping cart");
            System.out.println("4-Display all products in the shopping cart");
            System.out.println("5-Set the name of the user");
            System.out.println("6-Set the password of the user");
            System.out.println("7-Get the total price of the shopping cart");
            System.out.println("8-Display all products");
            System.out.println("9-search by category in the inventory");
            System.out.println("10-search by brand in the inventory");
            System.out.println("11-search by name in the inventory");
            System.out.println("12-search by price in the inventory");
            System.out.println("13-View all orders");
            System.out.println("14-Checkout the shopping cart");
            System.out.println("15-Logout");
            choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    while(true){
                        try{
                            System.out.println("Enter the barcode of the product");
                            int barcode = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter the quantity of the product");
                            int quantity = Integer.parseInt(scanner.nextLine());
                            this.addProduct(barcode,quantity,inventory);
                            break;
                        }
                        catch(Exception e){
                            System.out.println("Invalid input please try again");
                        }
                    }

                    break;
                case 2:
                    while(true){
                        try{
                            System.out.println("Enter the barcode of the product");
                            int barcode = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter the quantity of the product");
                            int quantity = Integer.parseInt(scanner.nextLine());
                            this.removeProduct(barcode,quantity,inventory);
                            break;
                        }
                        catch(Exception e){
                            System.out.println("Invalid input please try again");
                        }
                    }
                    break;
                case 3:
                    while(true){
                        try{
                            System.out.println("Enter the barcode of the product");
                            int barcode = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter the quantity of the product");
                            int quantity = Integer.parseInt(scanner.nextLine());
                            this.setQuantity(barcode,quantity,inventory);
                            break;
                        }
                        catch(Exception e){
                            System.out.println("Invalid input please try again");
                        }
                    }
                    break;
                case 4:
                    this.displayCart();
                    break;
                case 5:
                    System.out.println("Enter the new name");
                    String name = scanner.nextLine();
                    this.setUserName(name);
                    break;
                case 6:
                    System.out.println("Enter the new password");
                    String password = scanner.nextLine();
                    this.setPassword(password);
                    break;
                case 7:
                    System.out.println("Total price : "+this.getTotalPrice());
                    break;
                case 8 :
                    inventory.displayAllProducts();
                    break;
                case 9:
                    inventory.searchByCategory();
                    break;
                case 10:
                    inventory.searchByBrand();
                    break;
                case 11:
                    inventory.searchByName();
                    break;
                case 12:
                    inventory.searchByPrice();
                    break;
                case 13:
                    Order.displayAllOrders(userId);
                    break;
                case 14:
                    this.checkout();
                    break;
                case 15:
                    test=false;
                    this.logout(inventory);
                    break;
                default:
                    System.out.println("Invalid choice please try again");
                    break;
            }
        }
    }


}
