public class ThreadCounter extends Thread {
    private int countTo;

    public ThreadCounter(int countingTo) {
        this.countTo = countingTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < countTo; i++) {
            System.out.println(i + " - " + Thread.currentThread().getName());
        }
    }
}