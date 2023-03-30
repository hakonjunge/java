package no.hiof.bebricen.oving4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class PlanetSystem {
    private  String name;

    private Star centerStar;
    private String pictureUrl;
    private ArrayList<Planet> planets = new ArrayList<>();

    @JsonIgnore
    public void addPlanet(Planet planet){
        planets.add(planet);
    }

    public void deletePlanet(Planet planet){
        planets.remove(planet);
    }

    public PlanetSystem(){}

    public PlanetSystem(String name, String pictureUrl, Star centerStar) {
        this.name = name;
        this.centerStar = centerStar;
        this.pictureUrl = pictureUrl;
    }


    // Sort Arraylist before sending back to controller

    public ArrayList<Planet> getPlanets() {
        return new ArrayList<>(planets);
    }


    @JsonIgnore
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
    @JsonIgnore
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

    @JsonIgnore
    public Planet getPlanet(String name) {
        for (Planet aPlanet : planets ) {
            if (aPlanet.getName().equalsIgnoreCase(name)) {
                return aPlanet;
            }
        }

        return null;
    }


    @JsonIgnore
    @Override
    public String toString(){
        return "Name: " + name + ". Star: " + centerStar + " Planets: " + planets;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Star getCenterStar() {
        return centerStar;
    }
    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }
    public String getPictureUrl(){
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public void setPlanets(ArrayList<Planet> planets){this.planets = planets;}



}
