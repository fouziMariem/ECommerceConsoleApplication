//class CashPayment implements PaymentStrategy
public class CashPayment implements PaymentStrategy{
    //default constructor
    //overrides method from PaymentStrategy
    @Override
    public void pay(double amount) {
        System.out.println(amount +" paid with cash");
    }

}
