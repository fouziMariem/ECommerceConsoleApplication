//class to implement credit card payment
public class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
    //constructor
    public CreditCardPayment(String nm, String ccNum, String cvv, String expiryDate){
        this.name=nm;
        this.cardNumber=ccNum;
        this.cvv=cvv;
        this.dateOfExpiry=expiryDate;
    }
    //overrides method from PaymentStrategy
    @Override
    public void pay(double amount) {
        System.out.println(amount +" paid with credit/debit card");
    }
}
