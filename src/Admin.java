import java.util.ArrayList;
import java.util.Scanner;
//class Admin extends User
public class Admin extends User{
    //has the same attributes as the User class
    //constructor
    public Admin(int CIN, String userName, String password) {

        super(CIN,userName,password,"Admin");
    }


    //add an admin(you can't sign up as an admin you have to be added by another admin)
    public User addAdmin(){
        User newUser;
        Scanner scanner = new Scanner(System.in);
        System.out.println("CIN :");
        int CIN = Integer.parseInt(scanner.nextLine());
        System.out.println("User name :");
        String userName = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        newUser= new Admin(CIN,userName,password);
        return newUser;
    }
    //admin menu
    // add product to the inventory
    // remove product from the inventory
    // display all products in the inventory
    // search by category in the inventory
    // search by brand in the inventory
    // search by name in the inventory
    // search by price in the inventory
    // set the quantity of a product in the inventory
    // update a product in the inventory
    // add an admin
    // set the discount code
    // display all users
    // display all customers
    // display all admins
    // display orders
    // logout
    public void userMenu(Inventory inventory){
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean test = true;
        while(test){
            System.out.println("1-Add a product");
            System.out.println("2-Remove a product");
            System.out.println("3-Display all products");
            System.out.println("4-search by category");
            System.out.println("5-search by brand");
            System.out.println("6-search by name");
            System.out.println("7-search by price");
            System.out.println("8-Set the quantity of a product");
            System.out.println("9-Update a product");
            System.out.println("10-Add an admin");
            System.out.println("11-Set the discount code");
            System.out.println("12-Display all users");
            System.out.println("13-Display all customers");
            System.out.println("14-Display all admins");
            System.out.println("15-Display orders");
            System.out.println("16-Log out");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    inventory.addProduct();
                    break;
                case 2:
                    while(true){
                        try{
                            System.out.println("Enter the barcode of the product you want to remove");
                            int barcode = scanner.nextInt();
                            scanner.nextLine();
                            inventory.removeProduct(barcode);
                            break;
                        }
                        catch (Exception e){
                            System.out.println("Invalid barcode");
                            scanner.nextLine();
                        }

                    }
                    break;
                case 3:
                    inventory.displayAllProducts();
                    break;
                case 4:
                    inventory.searchByCategory();
                    break;
                case 5:
                    inventory.searchByBrand();
                    break;
                case 6:
                    inventory.searchByName();
                    break;
                case 7:
                    inventory.searchByPrice();
                    break;
                case 8:
                    while(true){
                        try{
                            System.out.println("Enter the barcode of the product you want to set the quantity of");
                            int barcode1 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter the quantity");
                            int quantity1 = scanner.nextInt();
                            scanner.nextLine();
                            inventory.setQuantity(barcode1,quantity1);
                            break;
                        }
                        catch (Exception e){
                            System.out.println("Invalid barcode");
                            scanner.nextLine();
                        }

                    }
                    break;

                case 9:
                    while(true){
                        try{
                            System.out.println("Enter the barcode of the product you want to update");
                            int barcode2 = scanner.nextInt();
                            scanner.nextLine();
                            inventory.updateProduct(barcode2);
                            break;
                        }
                        catch (Exception e){
                            System.out.println("Invalid barcode");
                            scanner.nextLine();
                        }

                    }
                    break;
                case 10:
                    User newUser=this.addAdmin();
                    break;
                case 11:
                    System.out.println("Enter the discount code");
                    String code = scanner.nextLine();
                    ShoppingCart.setDiscountCode(code);
                    break;
                case 12:
                    User.displayAllUsers();
                    break;
                case 13:
                    User.displayAllCustomers();
                    break;
                case 14:
                    User.displayAllAdmins();
                    break;
                case 15:
                    Order.displayAllOrders();
                    break;
                case 16:
                    test = false;
                    this.logout(inventory);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
