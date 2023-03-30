package no.hiof.bebricen.oving4.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class PlanetSystem {
    private  String name;

    private Star centerStar;
    private String pictureUrl;
    private ArrayList<Planet> planets = new ArrayList<>();

    public void addPlanet(Planet planet){
        planets.add(planet);
    }

    public PlanetSystem(String name, Star centerStar, String pictureUrl) {
        this.name = name;
        this.centerStar = centerStar;
        this.pictureUrl = pictureUrl;
    }

    // Sort Arraylist before sending back to controller
    public ArrayList<Planet> getPlanets(String sortBy) {

        // Sorts based on input from view
        switch (sortBy) {

            case "mass" -> planets.sort((planet1, planet2) ->
                    (int) (planet1.getMassInKg() - planet2.getMassInKg()));

            case "radius" -> planets.sort((planet1, planet2) ->
                    (int) (planet1.getRadiusInKm() - planet2.getRadiusInKm()));

            case "num" -> planets.sort((planet1, planet2) ->
                    (int) (planet1.getID() - planet2.getID()));

            default -> Collections.sort(planets);
        }
        return new ArrayList<>(planets);
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public String getPictureUrl(){
        return pictureUrl;
    }


    public Planet findSmallestPlanet(){
        double radius = Double.POSITIVE_INFINITY;
        double mass = Double.POSITIVE_INFINITY;
        Planet planet = null;

        // Search through planets in loop
        for (Planet value : planets) {

            // If planet radius is less than radius
            if (value.getRadius() < radius) {
                radius = value.getRadiusInKm();
                planet = value;

                // Else If planet mass is less than mass and radius == radius
            } else if (value.getRadiusInKm() == radius) {
                if (value.getMassInKg() < mass) {
                    mass = value.getMassInKg();
                    planet = value;
                }
            }
        }
        return planet;
    }
    public Planet findBiggestPlanet(){
        double radius = 0;
        double mass = 0;
        Planet planet = null;

        // Search through planets in loop
        for (Planet value : planets) {

            // If planet radius is more than radius
            if (value.getRadiusInKm() > radius) {
                radius = value.getRadiusInKm();
                planet = value;


                // Else If planet mass is more than mass and radius == radius
            } else if (value.getRadiusInKm() == radius) {
                if (value.getMass() > mass) {
                    mass = value.getMassInKg();
                    planet = value;
                }
            }
        }
        return planet;
    }

    public Planet getPlanet(String name) {
        for (Planet aPlanet : planets ) {
            if (aPlanet.getName().equalsIgnoreCase(name)) {
                return aPlanet;
            }
        }

        return null;
    }


    @Override
    public String toString(){
        return "Name: " + name + ". Star: " + centerStar + " Planets: " + planets;
    }

    public String getName() {
        return name;
    }




}
