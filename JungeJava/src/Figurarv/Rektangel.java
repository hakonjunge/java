package Figurarv;

//Arve fra figur

public class Rektangel extends Figur implements Tegnbar {
    private double side1;
    private double side2;

    public Rektangel(double side1, double side2, String farge) {
        super(farge);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double areal() {
        return side1 * side2;
    }

    @Override
    public double omkrets() {
        return (side1 + side2) * 2;
    }

    @Override
    public String toString() {
        return "Rektangel med sidene: " + side1 + ", " + side2;
    }
    @Override
    public void tegn(){
        System.out.println("-----------");
        System.out.println("|         |");
        System.out.println("|         |");
        System.out.println("-----------");
    }

}
