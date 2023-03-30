package no.hiof.bebricen.oving4.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.bebricen.oving4.Application;
import no.hiof.bebricen.oving4.model.Moon;
import no.hiof.bebricen.oving4.model.Planet;
import no.hiof.bebricen.oving4.model.PlanetSystem;
import no.hiof.bebricen.oving4.model.Star;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class UniverseJSONRepository implements UniverseRepository, Runnable{
    private HashMap<String, PlanetSystem> planetSystemsHash = new HashMap<>();

    private File core;

    private Boolean running = false;

    private Thread thread;


    public UniverseJSONRepository(String core){
        this.core = new File(core);
        this.planetSystemsHash = readFromFile(this.core);
        thread = new Thread(this);

        thread.start();


    }

    private HashMap<String, PlanetSystem> readFromFile(File core){
        ArrayList<PlanetSystem> planetSystemsReturn = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            PlanetSystem[] planetSystems = objectMapper.readValue(core, PlanetSystem[].class);

            planetSystemsReturn.addAll(Arrays.asList(planetSystems));

            HashMap<String, PlanetSystem> planetSystemHashMap = new HashMap<>(planetSystems.length);
            for (PlanetSystem planetSystem : planetSystemsReturn) {
                planetSystemHashMap.put(planetSystem.getName(), planetSystem);
            }

            return planetSystemHashMap;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeToJSONFile(HashMap<String, PlanetSystem> planetSystemHashMap, File core){
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<PlanetSystem> planetSystems = new ArrayList<>(planetSystemsHash.values());

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(core, planetSystems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {
        if (planetSystemsHash != null){
            return new ArrayList<>(planetSystemsHash.values());
        }
        return new ArrayList<>();
    }

    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        if(planetSystemsHash.get(planetSystemName) != null){
            return planetSystemsHash.get(planetSystemName);
        }
        return null;
    }

    @Override
    public ArrayList<Planet> getAllPlanets(String planetSystemName) {
        PlanetSystem planetSystem = getPlanetSystem(planetSystemName);

        if (planetSystem != null)
            return planetSystem.getPlanets();

        return new ArrayList<>();

    }

    @Override
    public Planet getPlanet(String planetSystemName, String planetName) {
        PlanetSystem planetSystem = getPlanetSystem(planetSystemName);

        if (planetSystem != null)
            return planetSystem.getPlanet(planetName);

        return null;

        //return getPlanetSystem(planetSystemName).getPlanet(planetName);
    }

    @Override
    public ArrayList<Moon> getMoons(Planet aPlanet) {
        if (aPlanet.getMoons() != null){
            return aPlanet.getMoons();
        }
        return null;
    }

    @Override
    public void CreatePlanet(String planetSystem, Planet newPlanet) {
        PlanetSystem curPlanetSystem = getPlanetSystem(planetSystem);

        curPlanetSystem.addPlanet(newPlanet);



    }

    @Override
    public void UpdatePlanet(String planetSystem, String name, Planet newPlanet) {
        PlanetSystem curPlanetSystem = getPlanetSystem(planetSystem);
        Planet curPlanet = curPlanetSystem.getPlanet(name);
        curPlanetSystem.deletePlanet(curPlanet);

        curPlanetSystem.addPlanet(newPlanet);

    }


    @Override
    public void DeletePlanet(String planetSystem, String name) {
        PlanetSystem curPlanetSystem = getPlanetSystem(planetSystem);
        Planet curPlanet = curPlanetSystem.getPlanet(name);
        curPlanetSystem.deletePlanet(curPlanet);


    }



    @Override
    public void run() {
        // Saves every 5 seconds

        while(true){
        writeToJSONFile(planetSystemsHash, core);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
