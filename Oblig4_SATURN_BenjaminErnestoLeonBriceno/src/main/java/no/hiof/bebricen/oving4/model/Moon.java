package no.hiof.bebricen.oving4.model;

// Extend natural satellite considering a moon is a natural satellite
public class Moon extends NaturalSatellite {
    private Planet centerPlanet;

    public Moon(String name, double radius, double mass, double semi_major_axis, double eccentricity,
                double orbitalPeriod, Star centralCelestialBody, String pictureUrl, Planet centerPlanet) {
        super(name, radius, mass, semi_major_axis,
                eccentricity, orbitalPeriod, centralCelestialBody, pictureUrl);
        this.centerPlanet = centerPlanet;
    }

    @Override
    public double getMassInKg() {
        return getMass();
    }

    @Override
    public double getRadiusInKm() {
        return getRadius();
    }
}
