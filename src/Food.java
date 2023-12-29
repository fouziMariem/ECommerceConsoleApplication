import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Food extends Product{
    private LocalDate expirationDate;
    public Food(int barcode, String productName, String brand, double price, LocalDate expirationDate) {
        super(barcode, productName, brand, price);
        this.expirationDate = expirationDate;
    }
    //display the product use the displayProduct method from the Product class and adding the category
    @Override
    public void displayProduct(){
        super.displayProduct();
        System.out.println("Category : Food");
        System.out.println("Expiration date :"+expirationDate);
    }

    //update product using the updateProduct method from the Product class and adding the attributes of the clothing
    @Override
    public void updateProduct(){
        super.updateProduct();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            try{
                System.out.println("Expiration date :");
                expirationDate = LocalDate.parse(scanner.nextLine());
                flag = false;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input, please enter a valid date");
            }
        }
    }
}
