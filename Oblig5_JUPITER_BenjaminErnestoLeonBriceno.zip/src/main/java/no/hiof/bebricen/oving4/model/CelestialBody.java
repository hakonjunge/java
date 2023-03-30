package no.hiof.bebricen.oving4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.jvm.internal.CollectionToArray;

import java.util.Collections;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Star.class, name = "star")
})

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
    public void setName(String name) {
        this.name = name;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getMass(){
        return mass;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public String getPictureUrl(){
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }



    @JsonIgnore
    public abstract double getMassInKg();

    @JsonIgnore
    public abstract double getRadiusInKm();

    public int compareTo(CelestialBody otherBody){
        return this.getName().compareTo(otherBody.getName());
    }



    @JsonIgnore
    @Override
    public String toString(){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }


}
