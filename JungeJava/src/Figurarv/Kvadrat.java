package Figurarv;

//arve fra rektangel
public class Kvadrat extends Rektangel {
    private double side;

    public Kvadrat(double side) {
        // Kaller konstruktøren til superklassen (Rektangel)
        super(side, side);

        this.side = side;
    }

    @Override
    public String toString() {
        return "Kvadrat med side " + side;
    }
}