import java.util.Scanner;
//the main class that run the application
public class RunApplication {
    public static void menu(){
        //create an inventory
        Inventory inventory = new Inventory();
        //login as the default admin to set up the inventory add the admin and the discount code and the products before the customers can use the application
        System.out.println("set up the inventory as the default admin");
        inventory.getCurrentUser().userMenu(inventory);
        //display the menu to the user
        System.out.println("Welcome to our store");
        int mainChoice=0;
        while(mainChoice!=3){
            //login or signin if you don't have an account or exit the application
            System.out.println("1- login");
            System.out.println("2- sign in if you don't have an account");
            System.out.println("3- exit");
            Scanner scanner = new Scanner(System.in);
            mainChoice = Integer.parseInt(scanner.nextLine());
            switch(mainChoice){
                case 1://login either as a user or as an admin and display the menu of the user
                    User.loginUser(inventory);
                    User.getCurrentUser().userMenu(inventory);
                    break;
                case 2://sign in as a customer and display the menu of the customer
                    Customer.signIn(inventory);
                    User.getCurrentUser().userMenu(inventory);
                    break;
                case 3://exit the application
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }


    }
}
