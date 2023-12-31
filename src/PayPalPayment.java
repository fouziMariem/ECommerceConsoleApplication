//class to implement payment using paypal
public class PayPalPayment implements PaymentStrategy{
    private String emailId;
    private String password;
    //constructor
    public PayPalPayment(String email, String pwd){
        this.emailId=email;
        this.password=pwd;
    }
    //overrides method from PaymentStrategy
    @Override
    public void pay(double amount) {
        System.out.println(amount +" paid using Paypal.");
    }
}
