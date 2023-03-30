package no.hiof.bebricen.oving4.model;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Collections;

public class Planet extends NaturalSatellite{

    // ID for planet sorting
    private final int ID;

    private static int planetCounter;

    // New moon Arraylist
    private ArrayList<Moon> moons= new ArrayList<>();

    private final static Double Mjup = 1.898E27;
    private final static long Rjup = 71492;

    private final static Double Mearth = 5.972E24;
    private final static long Rearth = 6371;


    public Planet(String name, double radius, double mass, double semi_major_axis, double eccentricity,
                  double orbitalPeriod, Star centralCelestialBody, String pictureUrl) {
        super(name, radius, mass, semi_major_axis,
                eccentricity, orbitalPeriod, centralCelestialBody, pictureUrl);
        this.ID = planetCounter++;
    }

    @Override
    public double getRadiusInKm(){
        return getRadius() * Rjup;
    }


    @Override
    public double getMassInKg(){
        return getMass() * Mjup;
    }


    public double getSurfaceGravity(){
        double m, r, g;
        m = getMass() * Mjup;
        r = getRadius() * Rjup;
        g = ((0.0000000000667408 * m) / (Math.pow(r, 2)));

        return g;
    }

    public void addMoon(Moon amoon){
        moons.add(amoon);
    }

    public Moon getMoon(String name) {
        for (Moon aMoon : moons ) {
            if (aMoon.getName().equalsIgnoreCase(name)) {
                return aMoon;
            }
        }

        return null;
    }

    public ArrayList<Moon> getMoons() {
        return new ArrayList<>(moons);
    }


    public double getMearth(){
        return getRadius() * Mearth;
    }

    public double getRearth(){
        return getRadius() * Rearth;
    }

    public int getID() {
        return ID;
    }
}