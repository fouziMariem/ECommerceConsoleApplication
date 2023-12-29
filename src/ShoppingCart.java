import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // Attributes
    private int userId;
    private List<Product> cart;
    private double totalPrice;
    //constructor
    public ShoppingCart() {
        this.userId = 0;
        this.cart = new ArrayList<>();
        this.totalPrice = 0;
    }

    public Product findProductInCart(int barcode){
        for(int i=0;i<cart.size();i++){
            if(barcode==cart.get(i).getBarcode()){
                return cart.get(i);
            }
        }
        return null;
    }
    // add product to cart using the product barcode
    public void addProduct(int barcode,Inventory inventory) {
        Product product = inventory.findProduct(barcode);
        if (product != null) {
            cart.add(product);
            totalPrice += product.getPrice();
        }
        else{
            System.out.println("Product not found");
        }
    }
    public void addProduct(int barcode,int quantity,Inventory inventory) {
        if(inventory.getQuantity(barcode)<quantity){
            System.out.println("Not enough quantity");
            return;
        }
        for(int i=0;i<quantity;i++){
            this.addProduct(barcode,inventory);
        }

    }
    // remove product from cart using the product barcode
    public void removeProduct(int barcode) {
        Product product = this.findProductInCart(barcode);
        if (product != null) {
            cart.remove(product);
            totalPrice -= product.getPrice();
        }
        else{
            System.out.println("Product not found");
        }
    }
    public void removeProduct(int barcode,int quantity) {
        if(this.getQuantity(barcode)<quantity){
            System.out.println("Not enough quantity");
            return;
        }
        for(int i=0;i<quantity;i++){
            this.removeProduct(barcode);
        }
    }
    //get the quantity of a product in the cart
    public int getQuantity(int barcode){
        Product product = this.findProductInCart(barcode);
        if (product != null) {
            int quantity = 0;
            for(int i=0;i<cart.size();i++){
                if(barcode==cart.get(i).getBarcode()){
                    quantity++;
                }
            }
            return quantity;
        }
        else{
            return 0;
        }
    }
    //set the quantity of a product in the cart
    public void setQuantity(int barcode,int quantity,Inventory inventory){
        Product product = this.findProductInCart(barcode);
        if (product != null) {
            int oldQuantity = this.getQuantity(barcode);
            if(oldQuantity>quantity){
                this.removeProduct(barcode,oldQuantity-quantity);
            }
            else if(oldQuantity<quantity){
                this.addProduct(barcode,quantity-oldQuantity,inventory);
            }
        }
        else{
            System.out.println("Product not found");

        }
    }
}
