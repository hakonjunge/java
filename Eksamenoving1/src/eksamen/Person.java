package eksamen;

import java.util.ArrayList;

public abstract class Person {
    private String fornavn;
    private String etternavn;
    private String avdeling;
    private static ArrayList<Person> personer = new ArrayList<Person>();

    public Person(String fornavn, String etternavn, String avdeling) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.avdeling = avdeling;
        personer.add(this);
    }
// Du kan forutsette at alle private felt har get og set tilgjengelig
}
