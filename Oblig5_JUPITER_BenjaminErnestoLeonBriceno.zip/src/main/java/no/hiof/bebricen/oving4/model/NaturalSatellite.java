package no.hiof.bebricen.oving4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class NaturalSatellite extends CelestialBody{
    private double semi_major_axis;
    private double eccentricity;
    private double orbitalPeriod;
    private CelestialBody centralCelestialBody;

    private final static long AstronomicalUnits = 149597871;

    private final static double gravitationalConstant = 6.674*Math.pow(10,-11);

    public NaturalSatellite(){}

    public NaturalSatellite(String name, double radius, double mass, double semi_major_axis, double eccentricity,
                            double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl){
        super(name, radius, mass, pictureUrl);
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.semi_major_axis = semi_major_axis;
        this.centralCelestialBody = centralCelestialBody;
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }
    public double getEccentricity() {
        return eccentricity;
    }
    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }
    public double getSemi_major_axis() {
        return semi_major_axis;
    }
    public void setSemiMajorAxis(double semi_major_axis) {
        this.semi_major_axis = semi_major_axis;
    }
    public CelestialBody getCentralCelestialBody() {
        return centralCelestialBody;
    }
    public void setCentralCelestialBody(CelestialBody centralCelestialBody) {
        this.centralCelestialBody = centralCelestialBody;
    }


    @JsonIgnore
    public double distanceToCentralBody(double degrees){
        double o = Math.toRadians(degrees);
        double r = distanceToCentralBodyRadian(o);
        return (int)r;
    }

    @JsonIgnore
    public double distanceToCentralBodyRadian(double radian){
        double r, a , e;
        double o = Math.cos(radian);
        a = getSemi_major_axis();
        e = getEccentricity();
        r = (a * (1- Math.pow(e, 2)))/(1+ (e * o));
        r = r * AstronomicalUnits;
        return r;
    }

    @JsonIgnore
    public double orbitingVelocity(double distance){
        double v = orbitingVelocityInMs(distance);
        return v / 1000;
    }

    @JsonIgnore
    public double orbitingVelocityInMs(double distance){
        double v, G, M, r;
        G = gravitationalConstant;
        M = getCentralCelestialBody().getMassInKg();
        r = distance * 1000;
        v = (Math.sqrt((G*M) / r));
        return v;
    }

    @JsonIgnore
    public double minDistanceToCentralBody(){
        double min;
        min = distanceToCentralBody(0);
        for (double i = 0; i <= 360; i = i + (360 / orbitalPeriod)){
            if (min > distanceToCentralBody(i)){
                min = distanceToCentralBody(i);
            }
        }
        return min;
    }

    @JsonIgnore
    public double maxDistanceToCentralBody(){
        double max;
        max = distanceToCentralBody(0);
        for (double i = 0; i <= 360; i = i + (360 / orbitalPeriod)){
            if (max < distanceToCentralBody(i)){
                max = distanceToCentralBody(i);
            }
        }
        return max;
    }


    @JsonIgnore
    private double degreesAtDayNumber(int day) {
        return (360/ getOrbitalPeriod()) * day;
    }

    @JsonIgnore
    public double distanceToOtherSatelliteAfterDays(NaturalSatellite otherSatellite, int day) {
        double unknown_distance;

        double bDegrees = this.degreesAtDayNumber(day);
        double cDegrees = otherSatellite.degreesAtDayNumber(day);

        double b = this.distanceToCentralBody(bDegrees);
        double c = otherSatellite.distanceToCentralBody(cDegrees);

        double angle_between_planets;
        if (bDegrees > cDegrees){
            angle_between_planets = bDegrees - cDegrees;
        } else {
            angle_between_planets = cDegrees - bDegrees;
        }

        /*Uses the Law og sines in triangles.
        Transforms a/sinA = b/sinB = c/sinC to:
        c = sqrt((a^2 + b^2) - (2 * a * b * cos(theta)))
        Where; "c" is the unknown length, "a" and "b" are the lengths of the planets away from the sun
        and "theta" is the angle between the planets */

        // If the angle is above 180, we rotate the triangle before using the formula

        if (angle_between_planets > 180){
            unknown_distance = (Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2)
                    - (2 * b * c * Math.cos(Math.toRadians(360 - angle_between_planets)))));
        }
        // If the angle between the planets is exact 180, we just add the distances together
        else if (angle_between_planets == 180){
            unknown_distance = b + c;
        }
        // Or just use the formula as normal
        else {
            unknown_distance = (Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2)
                    - (2 * b * c * Math.cos(Math.toRadians(angle_between_planets)))));
        }
        return unknown_distance;
    }

}
