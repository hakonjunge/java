package no.hiof.bebricen.oving4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Star extends CelestialBody{
    private double effectiveTemp;

    private final static Double Msun = 1.98892E30;
    private final static long Rsun = 695700;

    public Star(){}

    public Star(String name, double radius, double mass, double effectiveTemp, String pictureUrl){
        super(name, radius, mass, pictureUrl);
        this.effectiveTemp = effectiveTemp;
    }

    @JsonIgnore
    @Override
    public double getRadiusInKm(){
        return getRadius() * Rsun;
    }

    @JsonIgnore
    @Override
    public double getMassInKg(){
        return getRadius() * Msun;
    }



    public double getEffectiveTemp(){
        return effectiveTemp;
    }
    public void setEffectiveTemp(double effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }

}
