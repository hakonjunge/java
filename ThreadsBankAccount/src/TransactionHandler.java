public class TransactionHandler implements Runnable{
    private BankAccount bankAccount;

    public TransactionHandler(BankAccount bankAccount)  {
        this.bankAccount = bankAccount;
    }


    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            synchronized (bankAccount) {
                int startBalance = bankAccount.getBalance();

                bankAccount.deposit(100);

                pauseThread(100);

                int endBalance = bankAccount.getBalance();


                System.out.printf("\nStart balance: %d - 100 - End balance: %d - %s",
                        startBalance, endBalance, Thread.currentThread().getName());
            }
        }
    }

    private void pauseThread(int timeMs) {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
