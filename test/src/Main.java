import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args)  {
        ArrayBlockingQueue<String> dyreNavn = new ArrayBlockingQueue<>(5);

        dyreNavn.offer("Sjimpanse Arne");
        dyreNavn.offer("HonningGrevling Nils");
        dyreNavn.offer("Katt Løk");
        dyreNavn.offer("Hund Balder");
        dyreNavn.offer("Fisk Anders");

        System.out.println(dyreNavn);

        System.out.println("Har fått mat: " + dyreNavn.poll());
        System.out.println(dyreNavn);

        System.out.println(dyreNavn.peek());
        System.out.println(dyreNavn);


    }
}