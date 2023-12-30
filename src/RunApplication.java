import java.util.Scanner;

public class RunApplication {
    public static void menu(){
        Inventory inventory = new Inventory();
        System.out.println("set up the inventory as the default admin");
        inventory.getCurrentUser().userMenu(inventory);
        System.out.println("Welcome to our store");
        int mainChoice=0;
        while(mainChoice!=3){
            System.out.println("1- login");
            System.out.println("2- sign in if you don't have an account");
            System.out.println("3- exit");
            Scanner scanner = new Scanner(System.in);
            mainChoice = Integer.parseInt(scanner.nextLine());
            switch(mainChoice){
                case 1:
                    User.loginUser(inventory);
                    User.getCurrentUser().userMenu(inventory);
                    break;
                case 2:
                    Customer.signIn(inventory);
                    User.getCurrentUser().userMenu(inventory);
                    break;
                case 3:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }


    }
}
