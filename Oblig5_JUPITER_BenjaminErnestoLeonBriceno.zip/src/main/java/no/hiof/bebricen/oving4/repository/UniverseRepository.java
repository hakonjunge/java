package no.hiof.bebricen.oving4.repository;

import no.hiof.bebricen.oving4.model.CelestialBody;
import no.hiof.bebricen.oving4.model.Moon;
import no.hiof.bebricen.oving4.model.Planet;
import no.hiof.bebricen.oving4.model.PlanetSystem;

import java.util.ArrayList;

public interface UniverseRepository {
    ArrayList<PlanetSystem> getAllPlanetSystems();

    PlanetSystem getPlanetSystem(String planetSystemName);

    ArrayList<Planet> getAllPlanets(String planetSystem);

    Planet getPlanet(String planetSystem, String planet);

    ArrayList<Moon> getMoons(Planet aPlanet);

    void CreatePlanet(String planetSystem, Planet newPlanet);

    void UpdatePlanet(String planetSystem, String name, Planet newPlanet);

    void DeletePlanet(String planetSystem, String name);

}
