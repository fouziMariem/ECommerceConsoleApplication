import java.util.Scanner;
import java.util.InputMismatchException;
//class Books that extends the product class
public class Books extends Product{
    //attributes specific to the books category
    private String author;
    private String genre;
    //constructor
    public Books(int barcode, String productName, String brand, double price, String author, String genre) {
        super(barcode, productName, brand, price);
        this.author = author;
        this.genre = genre;
    }
    //display the product use the displayProduct method from the Product class and adding the category
    @Override
    public void displayProduct(){
        System.out.println("Category : Books");
        super.displayProduct();
        System.out.println("Author :"+author+" Genre :"+genre);
    }
    //update product using the updateProduct method from the Product class and adding the attributes of the books
    @Override
    public void updateProduct(){
        super.updateProduct();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            try{
                System.out.println("Author :");
                author = scanner.nextLine();
                System.out.println("Genre :");
                genre = scanner.nextLine();
                flag = false;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input, please try again");
            }
        }
    }

}
