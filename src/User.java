import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
//class user class parent for admin and customer
public abstract class User {
    protected static List<User> allUsers = new ArrayList<>();//static attribute to store all users
    protected static User currentUser=null;//static attribute to store the current user
    protected ShoppingCart cart;//attribute to store the shopping cart of the user

    // Instance variables for user details
    protected int userId;
    protected int CIN;
    protected String userName;
    protected String password;
    protected String role;
    // Constructor to initialize user details
    public User(int CIN, String userName, String password, String role) {
        this.CIN = CIN;
        this.userName = userName;
        this.password = password;
        this.role = role;
        allUsers.add(this);
        this.userId= allUsers.size();
        this.cart= new ShoppingCart();//initialize an empty shopping cart
    }

    public static User getCurrentUser() {
        return currentUser;
    }//get the current user
    //login a user by entering his id and password
    public static void loginUser(Inventory inventory){
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
    //logout the current user
    public void logout(Inventory inventory){
        inventory.setCurrentUser(null);
        currentUser=null;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }//set the CIN of the user

    public void setUserName(String userName) {
        this.userName = userName;
    }//set the name of the user

    public void setPassword(String password) {
        this.password = password;
    }//set the password of the user

    public String getPassword() {
        return password;
    }//get the password of the user
    public abstract void userMenu(Inventory inventory);//abstract method to display the menu of the user either admin or customer
    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }//set the current user
    //get the total price of the shopping cart
    public double getTotalPrice(){
        return cart.getTotalPrice();
    }//get the total price of the shopping cart
    //checkout the shopping cart
    public void checkout(){
        cart.checkout();
    }//checkout the shopping cart to make an order
    //add product to the shopping cart
    public void addProduct(int barcode ,int quantity, Inventory inventory){
        cart.addProduct(barcode,quantity,inventory);
    }
    //remove a product from the shopping cart
    public void removeProduct(int barcode,int quantity, Inventory inventory){
        cart.removeProduct(barcode,quantity,inventory);
    }
    //set quantity of a product in the shopping cart
    public void setQuantity(int barcode, int quantity, Inventory inventory){
        cart.setQuantity(barcode,quantity,inventory);
    }
    //display all products in the shopping cart
    public void displayCart(){
        cart.displayCart();
    }
    //display a user
    public void displayUser(){
        System.out.println("User Id : "+userId);
        System.out.println("User name : "+userName);
        System.out.println("CIN : "+CIN);
        System.out.println("Role : "+role);//admin or customer
    }
    //display all users
    public static void displayAllUsers(){
        for (User user: allUsers) {
            user.displayUser();
        }
    }
    //display all admins
    public static void displayAllAdmins(){
        for (User user: allUsers) {
            if(user instanceof Admin){
                user.displayUser();
            }
        }
    }
    //display all customers
    public static void displayAllCustomers(){
        for (User user: allUsers) {
            if(user instanceof Customer){
                user.displayUser();
            }
        }
    }

}
