import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//class order that handels the order of the user
public class Order {
    private static int numberOfOrders=0;//number of orders
    private static List<Order> allOrders=new ArrayList<>();//list of all orders
    private int id;
    private double amount;
    private LocalDate date;
    private Map<Product,Integer> products;
    private PaymentStrategy paymentStrategy;
    private String shipping ;
    //constructor
    public Order(int id,  double amount , Map<Product,Integer> products, PaymentStrategy paymentStrategy,String Shipping){
        this.id=id;
        this.amount=amount;
        this.products=products;
        this.date=LocalDate.now();
        this.paymentStrategy=paymentStrategy;
        numberOfOrders++;
        allOrders.add(this);
        this.shipping=Shipping;

    }
    //set type of payment
    public void setPaymentType(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    //get type of payment
    public PaymentStrategy getPaymentType(){
        return paymentStrategy;
    }
    //display order
    public void displayOrder(){
        System.out.println("Order id :"+id);
        System.out.println("Order date :"+date);
        paymentStrategy.pay(amount);
        System.out.println("Order products :");
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            entry.getKey().displayProduct();
            System.out.println("Quantity :"+entry.getValue());
        }
        System.out.println("Shipping :"+shipping);
    }
    //display all orders
    public static void displayAllOrders(){
        for (Order order : allOrders){
            order.displayOrder();
        }
    }
    //display all orders of a specific user
    public static void displayAllOrders(int userId){
        for (Order order : allOrders){
            if(order.id==userId){
                order.displayOrder();
            }
        }
    }

}
