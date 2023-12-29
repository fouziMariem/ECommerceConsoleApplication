import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class User {
    //login logout
    //define roles access levels (customer , admin)
    protected static List<User> allUsers = new ArrayList<>();
    protected static User currentUser=null;
    protected ShoppingCart cart;

    // Instance variables for user details
    protected int userId;
    protected int CIN;
    protected String userName;
    protected String password;
    protected String role;

    public User(int CIN, String userName, String password, String role) {
        this.CIN = CIN;
        this.userName = userName;
        this.password = password;
        this.role = role;
        allUsers.add(this);
        this.userId= allUsers.size();
        this.cart= new ShoppingCart();
    }

    public abstract void signIn();
    public void loginUser(Inventory inventory){
        boolean test = false;
        int userId = -1;
        String password;
        int retry = -1;

        // Continuously prompt for user login until successful or user chooses not to retry
        while(!test){
            retry = -1;
            Scanner scanner = new Scanner(System.in);
            System.out.println("User Id:");
            userId = Integer.parseInt(scanner.nextLine());
            System.out.println("Password:");
            password = scanner.nextLine();

            // Check if the entered user ID is valid
            if(userId <= allUsers.size()){
                test = Objects.equals(allUsers.get(userId - 1).getPassword(), password);
                if(test){
                    System.out.println(userId + " successfully connected");
                    currentUser= allUsers.get(userId - 1);
                    inventory.setCurrentUser(currentUser);
                    break;
                }
            }

            // Prompt for retry if login fails
            System.out.println("You may have entered a wrong password or ID. Try again?");
            System.out.println("Enter 0 if no / Enter 1 if yes");
            retry = scanner.nextInt();
            if(retry == 0){
                break;
            }
        }

    }
    public void logout(Inventory inventory){
        inventory.setCurrentUser(null);
        currentUser=null;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public abstract void userMenu(Inventory inventory);

}
