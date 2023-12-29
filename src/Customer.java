import java.util.Scanner;

public class Customer extends User{
    public Customer(int CIN, String userName, String password) {
        super(CIN,userName,password,"Customer");
    }
    public  void signIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("CIN :");
        CIN = Integer.parseInt(scanner.nextLine());
        System.out.println("Customer name :");
        userName = scanner.next();
        System.out.println("Password:");
        password = scanner.next();
        User newUser= new Customer(CIN,userName,password);
        currentUser=newUser;

    }
}
