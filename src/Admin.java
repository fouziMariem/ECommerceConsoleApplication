import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User{
    public Admin(int CIN, String userName, String password) {
        super(CIN,userName,password,"Admin");
    }

    public  void signIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("CIN :");
        CIN = Integer.parseInt(scanner.nextLine());
        System.out.println("Customer name :");
        userName = scanner.nextLine();
        System.out.println("Password:");
        password = scanner.nextLine();
        User newUser= new Admin(CIN,userName,password);
        currentUser=newUser;
    }

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
    //admin menu add admin add a product remove a product display all products set the quantity of a product update a product
    public void adminMenu(Inventory inventory){
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean test = true;
        while(test){
            System.out.println("1-Add a product");
            System.out.println("2-Remove a product");
            System.out.println("3-Display all products");
            System.out.println("4-Set the quantity of a product");
            System.out.println("5-Update a product");
            System.out.println("6-Add an admin");
            System.out.println("7-Log out");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the quantity of the product you want to add");
                    int quantity = scanner.nextInt();
                    inventory.addProduct(quantity);
                    break;
                case 2:
                    System.out.println("Enter the barcode of the product you want to remove");
                    int barcode = scanner.nextInt();
                    inventory.removeProduct(barcode);
                    break;
                case 3:
                    inventory.displayAllProducts();
                    break;
                case 4:
                    System.out.println("Enter the barcode of the product you want to set the quantity of");
                    int barcode1 = scanner.nextInt();
                    System.out.println("Enter the quantity");
                    int quantity1 = scanner.nextInt();
                    inventory.setQuantity(barcode1,quantity1);
                    break;
                case 5:
                    System.out.println("Enter the barcode of the product you want to update");
                    int barcode2 = scanner.nextInt();
                    inventory.updateProduct(barcode2);
                    break;
                case 6:
                    inventory.addAdmin();
                    break;
                case 7:
                    test = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
