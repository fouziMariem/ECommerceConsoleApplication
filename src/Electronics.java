import java.util.Scanner;
import java.util.InputMismatchException;
//class Electronics that extends the product class
public class Electronics extends Product{
    //constructor
    public Electronics(int barcode, String productName, String brand, double price) {
        super(barcode, productName, brand , price);
    }
    //display the product use the displayProduct method from the Product class and adding the category
    @Override
    public void displayProduct(){
        System.out.println("Category : Electronics");
        super.displayProduct();

    }
    //update product using the updateProduct method from the Product class and adding the attributes of the clothing
    @Override
    public void updateProduct(){
        super.updateProduct();
    }
}
