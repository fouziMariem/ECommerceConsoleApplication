import java.util.Scanner;

public class Customer extends User{
    public Customer(int CIN, String userName, String password) {

        super(CIN,userName,password,"Customer");
    }
    public static void signIn(Inventory inventory){
        Scanner scanner = new Scanner(System.in);
        System.out.println("CIN :");
        int CIN = Integer.parseInt(scanner.nextLine());
        System.out.println("Customer name :");
        String userName = scanner.next();
        System.out.println("Password:");
        String password = scanner.next();
        User newUser= new Customer(CIN,userName,password);
        currentUser=newUser;
        inventory.setCurrentUser(currentUser);
    }
    //customer menu
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
                    System.out.println("Enter the barcode of the product");
                    int barcode = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the quantity of the product");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    this.addProduct(barcode,quantity,inventory);
                    break;
                case 2:
                    System.out.println("Enter the barcode of the product");
                    barcode = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the quantity of the product");
                    quantity = Integer.parseInt(scanner.nextLine());
                    this.removeProduct(barcode,quantity,inventory);
                    break;
                case 3:
                    System.out.println("Enter the barcode of the product");
                    barcode = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the quantity of the product");
                    quantity = Integer.parseInt(scanner.nextLine());
                    this.setQuantity(barcode,quantity,inventory);
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
