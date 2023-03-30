package no.hiof.bebricen.oving4.repository;

import no.hiof.bebricen.oving4.model.Moon;
import no.hiof.bebricen.oving4.model.Planet;
import no.hiof.bebricen.oving4.model.PlanetSystem;

import java.util.ArrayList;

public interface UniverseRepository {
    ArrayList<PlanetSystem> getAllPlanetSystems();

    PlanetSystem getPlanetSystem(String planetSystemName);

    ArrayList<Planet> getAllPlanets(PlanetSystem planetSystem, String sortBy);

    Planet getPlanet(PlanetSystem planetSystem, String planet);

    ArrayList<Moon> getMoons(Planet aPlanet);
}
