import java.util.Scanner;
import java.util.InputMismatchException;
public class Clothing extends Product{
    private int size;
    private String color;
    private String material;

    //constructor

    public Clothing(int barcode, String productName, String brand,int price, int size, String color, String material) {
        super(barcode, productName, brand, price);
        this.size = size;
        this.color = color;
        this.material = material;

    }
    //display the product use the displayProduct method from the Product class and adding the category
    @Override
    public void displayProduct(){
        super.displayProduct();
        System.out.println("Category : Clothing");
        System.out.println("Size :"+size+" Color :"+color+" Material :"+material);
    }

    //update product using the updateProduct method from the Product class and adding the attributes of the clothing and deal with the exception like the size is not an integer or is negative and retry if an exception is thrown
    @Override
    public void updateProduct(){
        super.updateProduct();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            try{
                System.out.println("Size :");
                size = Integer.parseInt(scanner.nextLine());
                if(size<0){
                    throw new IllegalArgumentException("size cannot be negative");
                }

                System.out.println("Color :");
                color = scanner.nextLine();
                System.out.println("Material :");
                material = scanner.nextLine();
                flag = false;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input, please try again");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
