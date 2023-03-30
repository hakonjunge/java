package no.hiof.bebricen.oving4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Extend natural satellite considering a moon is a natural satellite
public class Moon extends NaturalSatellite {
    private Planet centerPlanet;
    public Moon(){}

    public Moon(String name, double radius, double mass, double semi_major_axis, double eccentricity,
                double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl, Planet centerPlanet) {
        super(name, radius, mass, semi_major_axis,
                eccentricity, orbitalPeriod, centralCelestialBody, pictureUrl);
        this.centerPlanet = centerPlanet;
    }

    @JsonIgnore
    @Override
    public double getMassInKg() {
        return getMass();
    }

    @JsonIgnore
    @Override
    public double getRadiusInKm() {
        return getRadius();
    }
}
