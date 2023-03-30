package no.hiof.bebricen.oving4.controller;

import no.hiof.bebricen.oving4.model.Moon;
import no.hiof.bebricen.oving4.model.Planet;
import no.hiof.bebricen.oving4.model.PlanetSystem;
import no.hiof.bebricen.oving4.repository.UniverseRepository;

import io.javalin.http.Context;

import java.util.ArrayList;

public class PlanetSystemController {
    private UniverseRepository universeRepository;

    public PlanetSystemController(UniverseRepository universeRepository){
        this.universeRepository = universeRepository;
    }
    public void getAllPlanetSystems(Context context){

        ArrayList<PlanetSystem> allPlanetSystems = universeRepository.getAllPlanetSystems();

        context.json(allPlanetSystems);
    }

    public void getPlanetSystem(Context context){
        String planetSystem = context.pathParam(":planet-system-id");

        PlanetSystem planetSystem1 = universeRepository.getPlanetSystem(planetSystem);

        context.json(planetSystem1);
    }

    public void getAllPlanets(Context context){
        String planetSystem = context.pathParam(":planet-system-id");
        String sortBy = context.queryParam("sort_by");
        PlanetSystem planetSystem1 = universeRepository.getPlanetSystem(planetSystem);
        ArrayList<Planet> planets = universeRepository.getAllPlanets(planetSystem1, sortBy);

        context.json(planets);
    }

    public void getPlanet(Context context){
        String planetSystem = context.pathParam(":planet-system-id");
        PlanetSystem planetSystem1 = universeRepository.getPlanetSystem(planetSystem);
        String planetName = context.pathParam(":planet-id");
        Planet planet = universeRepository.getPlanet(planetSystem1, planetName);

        context.json(planet);

    }

    public void getMoons(Context context){
        String planetSystem = context.pathParam(":planet-system-id");
        PlanetSystem planetSystem1 = universeRepository.getPlanetSystem(planetSystem);
        String planetName = context.pathParam(":planet-id");
        Planet planet = universeRepository.getPlanet(planetSystem1, planetName);
        ArrayList<Moon> moons = universeRepository.getMoons(planet);

        context.json(moons);
    }

}
