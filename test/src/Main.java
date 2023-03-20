import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args)  {
        /*ArrayBlockingQueue<String> dyreNavn = new ArrayBlockingQueue<>(5);

        dyreNavn.offer("Sjimpanse Arne");
        dyreNavn.offer("HonningGrevling Nils");
        dyreNavn.offer("Katt Løk");
        dyreNavn.offer("Hund Balder");
        dyreNavn.offer("Fisk Anders");

        System.out.println(dyreNavn);

        System.out.println("Har fått mat: " + dyreNavn.poll());
        System.out.println(dyreNavn);

        System.out.println(dyreNavn.peek());
        System.out.println(dyreNavn);*/


        Stack<String> dyreNavn = new Stack<>();

        dyreNavn.push("Hund Balder");
        dyreNavn.push("HonningGrevling Nils");
        dyreNavn.push("Sjimpanse Arne");
        dyreNavn.push("Fisk Anders");

        System.out.println(dyreNavn.push("Katt Løk"));

        System.out.println(dyreNavn);
        System.out.println("Popper av stacken: " + dyreNavn.pop());

        System.out.println("Ser på toppen av stacken: " + dyreNavn.peek());
        System.out.println(dyreNavn);





    }
}

