import java.util.*;

public class Inventory {
    private Map<Product,Integer> products;
    private User currentUser =null;
    //constructor
    public Inventory() {
        this.products = new HashMap<>();
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // add product to inventory by using the method from the Product class
    public void addProduct(int quantity) {
        Product product = Product.createProduct();

    }

    // remove product from inventory
    public void removeProduct(int barcode) {
        Product product = this.findProduct(barcode);
        if (product != null) {
            products.remove(product);
        }
        else{
            System.out.println("Product not found");
        }
    }
    public Product findProduct(int barcode){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getBarcode()==barcode){
                return entry.getKey();
            }
        }
        return null;
    }
    //get the quantity of a product in the inventory
    public int getQuantity(int barcode){
        Product product = this.findProduct(barcode);
        if (product != null) {
            return products.get(product);
        }
        else{
            System.out.println("Product not found");
            return 0;
        }
    }
    //display all products in the inventory
    public void displayAllProducts(){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            System.out.println("Product : ");
            entry.getKey().displayProduct();
            System.out.println("quantity :"+entry.getValue());
        }
    }
    //display all products in the inventory with a specific category
    public void searchByCategory(){
        //input the category
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(true){
            System.out.println("Choose the category :");
            System.out.println("1.Books");
            System.out.println("2.Clothes");
            System.out.println("3.Food");
            System.out.println("4.Electronics");
            choice = Integer.parseInt(scanner.nextLine());
            if(choice ==1 | choice ==2 | choice ==3 | choice ==4){
                break;
            }
            else{
                System.out.println("Invalid input, please try again");
            }
        }
        switch(choice){
            case 1:
                for (Map.Entry<Product, Integer> entry : products.entrySet()){
                    if(entry.getKey().getClass().getName().equals("Books")){
                        entry.getKey().displayProduct();
                    }
                }
                break;
            case 2:
                for (Map.Entry<Product, Integer> entry : products.entrySet()){
                    if(entry.getKey().getClass().getName().equals("Clothing")){
                        entry.getKey().displayProduct();
                    }
                }
                break;
            case 3:
                for (Map.Entry<Product, Integer> entry : products.entrySet()){
                    if(entry.getKey().getClass().getName().equals("Food")){
                        entry.getKey().displayProduct();
                    }
                }
                break;
            case 4:
                for (Map.Entry<Product, Integer> entry : products.entrySet()){
                    if(entry.getKey().getClass().getName().equals("Electronics")){
                        entry.getKey().displayProduct();
                    }
                }
                break;

        }
    }

    public void setQuantity(int barcode1, int quantity1) {
        Product product = this.findProduct(barcode1);
        if (product != null) {
            products.put(product,quantity1);
        }
        else{
            System.out.println("Product not found");
        }
    }
    public void updateProduct(int barCode){
        Product product = this.findProduct(barCode);
        if (product != null) {
            this.findProduct(barCode).updateProduct();
        }
        else{
            System.out.println("Product not found");
        }
    }
}
