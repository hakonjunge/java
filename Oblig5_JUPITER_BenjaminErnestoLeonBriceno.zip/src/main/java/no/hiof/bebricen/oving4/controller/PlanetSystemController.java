package no.hiof.bebricen.oving4.controller;

import no.hiof.bebricen.oving4.model.Moon;
import no.hiof.bebricen.oving4.model.Planet;
import no.hiof.bebricen.oving4.model.PlanetSystem;
import no.hiof.bebricen.oving4.model.Star;
import no.hiof.bebricen.oving4.repository.UniverseRepository;

import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

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
        ArrayList<Planet> planets = universeRepository.getAllPlanets(planetSystem);

        switch (sortBy) {

            case "mass" -> planets.sort((planet1, planet2) ->
                    (int) (planet1.getMassInKg() - planet2.getMassInKg()));

            case "radius" -> planets.sort((planet1, planet2) ->
                    (int) (planet1.getRadiusInKm() - planet2.getRadiusInKm()));

            case "num" -> planets.sort((planet1, planet2) ->
                    (int) (planet1.getID() - planet2.getID()));

            default -> Collections.sort(planets);
        }

        context.json(planets);
    }

    public void getPlanet(Context context){
        String planetSystem = context.pathParam(":planet-system-id");
        String planetName = context.pathParam(":planet-id");
        Planet planet = universeRepository.getPlanet(planetSystem, planetName);

        context.json(planet);

    }

    public void createPlanet(Context context){
        String planetSystem = context.pathParam(":planet-system-id");
        Planet planet = planetCreator(context);
        universeRepository.CreatePlanet(planetSystem, planet);

    }

    public void updatePlanet(Context context){
        String planetSystem = context.pathParam(":planet-system-id");
        Planet planet = planetCreator(context);
        String previousPlanet = context.pathParam(":planet-id");
        universeRepository.UpdatePlanet(planetSystem, previousPlanet, planet);

    }

    public void deletePlanet(Context context){
        String planetSystem = context.pathParam(":planet-system-id");
        String planetName = context.pathParam(":planet-id");
        universeRepository.DeletePlanet(planetSystem, planetName);


    }

    public void getMoons(Context context) {
        String planetSystem = context.pathParam(":planet-system-id");
        String planetName = context.pathParam(":planet-id");
        Planet planet = universeRepository.getPlanet(planetSystem, planetName);
        ArrayList<Moon> moons = universeRepository.getMoons(planet);

        context.json(moons);
    }

    private Planet planetCreator(Context context){
        String planetSystem = context.pathParam(":planet-system-id");

        Star star = universeRepository.getPlanetSystem(planetSystem).getCenterStar();
        String name = context.formParam("name");
        double mass = Double.parseDouble(Objects.requireNonNull(context.formParam("mass")));
        double radius = Double.parseDouble(Objects.requireNonNull(context.formParam("radius")));
        double semiMajorAxis = Double.parseDouble(Objects.requireNonNull(context.formParam("semiMajorAxis")));
        double eccentricity= Double.parseDouble(Objects.requireNonNull(context.formParam("eccentricity")));
        double orbitalPeriod = Double.parseDouble(Objects.requireNonNull(context.formParam("orbitalPeriod")));
        String pictureUrl = context.formParam("pictureUrl");

        return new Planet( name,  radius, mass, semiMajorAxis,
                eccentricity,orbitalPeriod,  star,  pictureUrl);
    }

}
