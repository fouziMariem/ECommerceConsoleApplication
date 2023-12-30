public class CheckPayment implements PaymentStrategy{
    private String name;
    private String bankId;
    private String routingNumber;
    private String accountNumber;
    public CheckPayment(String nm, String bankId, String routingNumber, String accountNumber){
        this.name=nm;
        this.bankId=bankId;
        this.routingNumber=routingNumber;
        this.accountNumber=accountNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println(amount +" paid with check");
    }

}
