package EnumType;

public enum TransactionType {
    DEPOSIT(5),
    WITHDRAW(10),
    TRANSFER(15),
    PAYMENT(20),
    OTHER(100);

    private final int transactionCode;

    private TransactionType(int code){
        this.transactionCode=code;
    }

}
