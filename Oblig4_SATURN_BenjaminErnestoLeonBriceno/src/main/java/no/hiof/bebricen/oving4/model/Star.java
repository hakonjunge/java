package no.hiof.bebricen.oving4.model;

public class Star extends CelestialBody{
    private double effectiveTemp;

    private final static Double Msun = 1.98892E30;
    private final static long Rsun = 695700;

    public Star(){}

    public Star(String name, double radius, double mass, double effectiveTemp, String pictureUrl){
        super(name, radius, mass, pictureUrl);
        this.effectiveTemp = effectiveTemp;
    }

    @Override
    public double getRadiusInKm(){
        return getRadius() * Rsun;
    }

    @Override
    public double getMassInKg(){
        return getRadius() * Msun;
    }



    public double getEffectiveTemp(){
        return effectiveTemp;
    }

}
