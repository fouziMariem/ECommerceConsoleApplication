import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class Product {
    //categories
    //create
    //read
    //update
    //delete
    protected int barcode;
    protected String productName;
    protected String brand ;
    protected double price;
    //protected static List<Product> allProducts = new ArrayList<>();

    public Product(int barcode, String productName, String brand, double price) {
        this.barcode = barcode;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
    }
    //get the price of the product
    public double getPrice() {
        return price;
    }
    //get the barcode of the product
    public int getBarcode() {
        return barcode;
    }

    // display product in the same line with the category
    public void displayProduct(){
        System.out.println("Barcode :"+barcode+" Product name :"+productName+" Brand :"+brand+" Price :"+price);
    }


    //update product and deal with the exceptions like the barcode is not an integer or the price is not a double or the product name is empty and retry if an exception is thrown

    //get brand of the product
    public String getBrand() {
        return brand;
    }
    //get product name
    public String getProductName() {
        return productName;
    }
    //setters
    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public static Product createProduct(int barcode){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String productName = "";
        String brand = "";
        double price = 0;
        int size = 0;
        String color = "";
        String material = "";
        LocalDate expirationDate=null;
        String author="";
        String genre="";


        while(flag){
            try{
                System.out.println("Choose category :");
                System.out.println("1-Books");
                System.out.println("2-Clothing");
                System.out.println("3-Food");
                System.out.println("4-Electronics");
                int choice = Integer.parseInt(scanner.nextLine());

                if(choice!=1 && choice!=2 && choice!=3 && choice!=4){
                    throw new IllegalArgumentException("Invalid choice");
                }

                System.out.println("Product name :");
                productName = scanner.nextLine();
                if(productName.isEmpty()){
                    throw new IllegalArgumentException("Product name cannot be empty");
                }
                System.out.println("Brand :");
                brand = scanner.nextLine();
                System.out.println("Price :");
                price = Double.parseDouble(scanner.nextLine());
                if(price<0){
                    throw new IllegalArgumentException("Price cannot be negative");
                }
                switch(choice){
                    case 1:
                        System.out.println("Author :");
                        author = scanner.nextLine();
                        System.out.println("Genre :");
                        genre = scanner.nextLine();
                        Product newBookProduct= new Books(barcode,productName,brand,price,author,genre);
                        return newBookProduct;

                    case 2:
                        System.out.println("Size :");
                        size = Integer.parseInt(scanner.nextLine());
                        if(size<0){
                            throw new IllegalArgumentException("size cannot be negative");
                        }
                        System.out.println("Color :");
                        color = scanner.nextLine();
                        System.out.println("Material :");
                        material = scanner.nextLine();
                        Product newClothingProduct= new Clothing(barcode,productName,brand,price,size,color,material);
                        return newClothingProduct;

                    case 3:
                        System.out.println("Expiration date :");
                        expirationDate = LocalDate.parse(scanner.nextLine());
                        Product newFoodProduct= new Food(barcode,productName,brand,price,expirationDate);
                        return newFoodProduct;
                    case 4:
                        Product newElectronicsProduct= new Electronics(barcode,productName,brand,price);
                        return newElectronicsProduct;
                }

                flag = false;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input, please try again");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return null;
    }
    public void updateProduct(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            try{
                System.out.println("Barcode :");
                barcode = Integer.parseInt(scanner.nextLine());
                if(barcode<0){
                    throw new IllegalArgumentException("Barcode cannot be negative");
                }
                System.out.println("Product name :");
                productName = scanner.nextLine();
                if(productName.isEmpty()){
                    throw new IllegalArgumentException("Product name cannot be empty");
                }
                System.out.println("Brand :");
                brand = scanner.next();
                System.out.println("Price :");
                price = Double.parseDouble(scanner.nextLine());
                if(price<0){
                    throw new IllegalArgumentException("Price cannot be negative");
                }
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
