package eksamen;
import eksamen.Person;
public class Ansatt extends Person {
    private String ansattId;

    public Ansatt(String fornavn, String etternavn, String avdeling, String ansattId) {
        super(fornavn, etternavn, avdeling);
        this.ansattId=ansattId;
    }

    // oppgave 3.2a løses her
// Du kan forutsette at alle private felt har get og set tilgjengelig
}