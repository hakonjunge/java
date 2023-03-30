package no.hiof.bebricen.oving4.model;

import kotlin.jvm.internal.CollectionToArray;

import java.util.Collections;

public abstract class CelestialBody implements Comparable<CelestialBody>{
    private String name, pictureUrl;
    private double radius, mass;

    public CelestialBody(){}

    public CelestialBody(String name, double radius, double mass, String pictureUrl){
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.pictureUrl = pictureUrl;
    }


    public String getName(){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    public double getRadius(){
        return radius;
    }
    public double getMass(){
        return mass;
    }
    public String getPictureUrl(){
        return pictureUrl;
    }


    public abstract double getMassInKg();

    public abstract double getRadiusInKm();

    public int compareTo(CelestialBody otherBody){
        return this.getName().compareTo(otherBody.getName());
    }



    @Override
    public String toString(){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }


}
