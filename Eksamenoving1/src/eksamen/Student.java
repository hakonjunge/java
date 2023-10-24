package eksamen;

import eksamen.Person;

public class Student extends Person {
    private int studentnummer;

    public Student(String fornavn, String etternavn, String avdeling, int studentnummer) {
        super(fornavn, etternavn, avdeling);
        this.studentnummer = studentnummer;
    }
// konstruktør
// oppgave 3.2a løses her
// Du kan forutsette at alle private felt har get og set tilgjengelig
}
