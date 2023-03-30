public class Main {
    public static void main(String[] args) {
        BankAccount yourAccount = new BankAccount("1337", 1000);

        TransactionHandler transactionHandler = new TransactionHandler(yourAccount);

        Thread thread0 = new Thread(transactionHandler);
        Thread thread1 = new Thread(transactionHandler);
        Thread thread2 = new Thread(transactionHandler);

        thread0.start();
        thread1.start();
        thread2.start();
    }
}