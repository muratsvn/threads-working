package EnumType;

public class MaintTest {
    public static void main(String[] args) {
        useConstantMethod(1);
        useConstantMethod(2);
        useConstantMethod(3);
        useConstantMethod(4);
        useConstantMethod(100);
        useConstantMethod(5); // CTE vermedi hataya açık bir yapı oldu

        useEnumMethod(TransactionType.DEPOSIT);
        useEnumMethod(TransactionType.WITHDRAW);
        useEnumMethod(TransactionType.PAYMENT);
        useEnumMethod(TransactionType.OTHER);
        //useEnumMethod(TransactionType.A..); //CTE verdi kabul edmedi
    }

    //eski tarz
    private static void useConstantMethod(int i){
        if (i==TransactionTypeConstant.DEPOSIT){
            System.out.println("Money is depositing");
        } else if (i==TransactionTypeConstant.WITHDRAW) {
            System.out.println("Money is withdrawing");
        } else if (i==TransactionTypeConstant.TRANSFER) {
            System.out.println("Money is transfering");
        } else if (i==TransactionTypeConstant.PAYMENT) {
            System.out.println("Money is being made");
        } else if (i==TransactionTypeConstant.OTHER) {
            System.out.println("Other transaction");
        }
    }
    // enum yapıyla
    private static void useEnumMethod(TransactionType transactionType){
        if (transactionType==TransactionType.DEPOSIT){
            System.out.println("Money is depositing");
        }else if (transactionType==TransactionType.WITHDRAW){
            System.out.println("Money is withdrawing");
        } else if (transactionType==TransactionType.TRANSFER) {
            System.out.println("Money is transfering");
        } else if (transactionType==TransactionType.PAYMENT) {
            System.out.println("Money is being made");
        } else if (transactionType==TransactionType.OTHER) {
            System.out.println("Other transaction");
        }

    }
}
