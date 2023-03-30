public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadCounter threadCounter = new ThreadCounter(100);
        RunnableCounter runnableCounter = new RunnableCounter(100);

        Thread runnableThread = new Thread(runnableCounter);
        Thread anonThread = new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
            }
        });


        runnableThread.start();
        threadCounter.start();
        anonThread.start();

        threadCounter.join();
        runnableThread.join();
        anonThread.join();

        System.out.println("Finished");
    }
    
}
