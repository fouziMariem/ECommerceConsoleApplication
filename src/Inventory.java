import java.util.*;
//class Inventory that contains all the products and manages them
public class Inventory {
    //attributes
    private Map<Product,Integer> products;//the products in the inventory the key is the product and the value is the quantity
    private final Admin defaultAdmin = new Admin(0,"admin","0000");//the default admin that set up the inventory
    private User currentUser =null;//the current user that is using the application
    //constructor
    public Inventory() {
        this.currentUser = defaultAdmin;
        this.products = new HashMap<>();
    }
    //getters and setters

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }//set the current user

    public User getCurrentUser() {
        return currentUser;
    }//get the current user

    // add product to inventory
    public void addProduct() {
        //if the product is already in the inventory we add the quantiy to the existing quantity else we create a new product and set the quantity
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                System.out.println("Enter the barcode of the product");
                int barcode = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the quantity of the product");
                int quantity = Integer.parseInt(scanner.nextLine());
                Product product = this.findProduct(barcode);
                if (product != null) {
                    products.put(product,products.get(product)+quantity);
                }
                else{
                    Product newProduct = Product.createProduct(barcode);
                    products.put(newProduct,quantity);
                }
                break;
            }
            catch (Exception e){
                System.out.println("Invalid input");
            }
        }


    }

    // remove product from inventory by barcode
    public void removeProduct(int barcode) {
        Product product = this.findProduct(barcode);
        if (product != null) {
            products.remove(product);
        }
        else{
            System.out.println("Product not found");
        }
    }
    //reduce the quantity of a product in the inventory by 1
    public void reduceQuantity(int barcode){
        Product product = this.findProduct(barcode);
        if (product != null) {
            products.put(product,products.get(product)-1);
        }
        else{
            System.out.println("Product not found");
        }
    }
    //find a product in the inventory by barcode
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
        boolean admin= false;
        if(currentUser.getClass().getName().equals("Admin")){
            admin=true;
        }
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            System.out.println("Product : ");
            entry.getKey().displayProduct();
            if(admin){
                System.out.println("Quantity :"+entry.getValue());
            }
            else{
                if(entry.getValue()==0){
                    System.out.println("Out of stock");
                }
                else{
                    System.out.println("Product available");
                }
            }
        }
    }
    //display all products in the inventory with a specific category
    public void searchByCategory(){
        //input the category
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean admin= false;
        if(currentUser.getClass().getName().equals("Admin")){
            admin=true;
        }
        while(true){
            try{
                System.out.println("Choose the category :");
                System.out.println("1.Books");
                System.out.println("2.Clothes");
                System.out.println("3.Food");
                System.out.println("4.Electronics");
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e){
                System.out.println("Invalid input, please try again");
            }
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
                        if(admin){
                            System.out.println("Quantity :"+entry.getValue());
                        }
                    }
                }
                break;
            case 2:
                for (Map.Entry<Product, Integer> entry : products.entrySet()){
                    if(entry.getKey().getClass().getName().equals("Clothing")){
                        entry.getKey().displayProduct();
                        if(admin){
                            System.out.println("Quantity :"+entry.getValue());
                        }
                    }
                }
                break;
            case 3:
                for (Map.Entry<Product, Integer> entry : products.entrySet()){
                    if(entry.getKey().getClass().getName().equals("Food")){
                        entry.getKey().displayProduct();
                        if(admin){
                            System.out.println("Quantity :"+entry.getValue());
                        }
                    }
                }
                break;
            case 4:
                for (Map.Entry<Product, Integer> entry : products.entrySet()){
                    if(entry.getKey().getClass().getName().equals("Electronics")){
                        entry.getKey().displayProduct();
                        if(admin){
                            System.out.println("Quantity :"+entry.getValue());
                        }
                    }
                }
                break;
        }
    }
    //set the quantity of a product in the inventory

    public void setQuantity(int barcode1, int quantity1) {
        Product product = this.findProduct(barcode1);
        if (product != null) {
            products.put(product,quantity1);
        }
        else{
            System.out.println("Product not found");
        }
    }
    //update a product in the inventory
    public void updateProduct(int barCode){
        Product product = this.findProduct(barCode);
        if (product != null) {
            this.findProduct(barCode).updateProduct();
        }
        else{
            System.out.println("Product not found");
        }
    }
    //display all products in the inventory with a specific brand
    public void searchByBrand(){
        //input the brand
        Scanner scanner = new Scanner(System.in);
        String brand = "";
        boolean admin= false;
        if(currentUser.getClass().getName().equals("Admin")){
            admin=true;
        }
        System.out.println("Enter the brand");
        brand = scanner.nextLine();
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            if(entry.getKey().getBrand().equals(brand)){
                entry.getKey().displayProduct();
                if(admin){
                    System.out.println("Quantity :"+entry.getValue());
                }
            }
        }
    }
    //display all products in the inventory with a price between a min and a max
    public void searchByPrice(){
        //input the min and the max
        Scanner scanner = new Scanner(System.in);
        double min = 0;
        double max = 0;
        boolean admin= false;
        if(currentUser.getClass().getName().equals("Admin")){
            admin=true;
        }
        while(true){
            try{
                System.out.println("Enter the min price");
                min = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the max price");
                max = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Invalid input, please try again");
            }
        }
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            if(entry.getKey().getPrice()>=min & entry.getKey().getPrice()<=max){
                entry.getKey().displayProduct();
                if(admin){
                    System.out.println("Quantity :"+entry.getValue());
                }
            }
        }
    }
    //display all products in the inventory with a specific name
    public void searchByName(){
        //input the name
        Scanner scanner = new Scanner(System.in);
        String name = "";
        boolean admin= false;
        if(currentUser.getClass().getName().equals("Admin")){
            admin=true;
        }
        System.out.println("Enter the name");
        name = scanner.nextLine();
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            if(entry.getKey().getProductName().equals(name)){
                entry.getKey().displayProduct();
                if(admin){
                    System.out.println("Quantity :"+entry.getValue());
                }
            }
        }
    }

}
