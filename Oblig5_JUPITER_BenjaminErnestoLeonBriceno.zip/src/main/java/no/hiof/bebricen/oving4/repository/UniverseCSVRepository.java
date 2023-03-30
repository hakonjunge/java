package no.hiof.bebricen.oving4.repository;

import io.javalin.plugin.rendering.FileRenderer;
import no.hiof.bebricen.oving4.model.Moon;
import no.hiof.bebricen.oving4.model.Planet;
import no.hiof.bebricen.oving4.model.PlanetSystem;
import no.hiof.bebricen.oving4.model.Star;

import java.io.*;
import java.util.ArrayList;

public class UniverseCSVRepository implements UniverseRepository{
    private ArrayList<PlanetSystem> planetSystems = new ArrayList<PlanetSystem>();
    private File core;

    public UniverseCSVRepository(String file){
        File core = new File(file);

        this.core = core;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(core))) {
            String line;
            String linePrevious = "";
            PlanetSystem currentPlanetSystem = null;

            while((line = bufferedReader.readLine()) != null){
                String[] values = line.split(";");

                Star star = new Star(values[2],
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),
                        Double.parseDouble(values[5]),
                        values[6]);

                if (!values[0].equals(linePrevious)){

                    PlanetSystem planetSystem = new PlanetSystem(values[0], values[1], star);

                    planetSystem.addPlanet(new Planet(values[7],Double.parseDouble(values[8]),
                            Double.parseDouble(values[9]), Double.parseDouble(values[10]),
                            Double.parseDouble(values[11]), Double.parseDouble(values[12]),
                            star, values[13]));


                    currentPlanetSystem = planetSystem;

                    planetSystems.add(currentPlanetSystem);
                }
                else{

                    assert currentPlanetSystem != null;
                    currentPlanetSystem.addPlanet(new Planet(values[7],Double.parseDouble(values[8]),
                            Double.parseDouble(values[9]), Double.parseDouble(values[10]),
                            Double.parseDouble(values[11]), Double.parseDouble(values[12]),
                            star, values[13]));
                }
                linePrevious = values[0];

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<PlanetSystem> readFromCSV(File core){
        ArrayList<PlanetSystem> planetSystems = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(core))) {
            String line;
            String linePrevious = "";
            PlanetSystem currentPlanetSystem = null;

            while((line = bufferedReader.readLine()) != null){
                String[] values = line.split(";");

                Star star = new Star(values[2],
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),
                        Double.parseDouble(values[5]),
                        values[6]);

                if (!values[0].equals(linePrevious)){

                    PlanetSystem planetSystem = new PlanetSystem(values[0], values[1], star);

                    planetSystem.addPlanet(new Planet(values[7],Double.parseDouble(values[8]),
                            Double.parseDouble(values[9]), Double.parseDouble(values[10]),
                            Double.parseDouble(values[11]), Double.parseDouble(values[12]),
                            star, values[13]));


                    currentPlanetSystem = planetSystem;

                    planetSystems.add(currentPlanetSystem);
                }
                else{

                    assert currentPlanetSystem != null;
                    currentPlanetSystem.addPlanet(new Planet(values[7],Double.parseDouble(values[8]),
                            Double.parseDouble(values[9]), Double.parseDouble(values[10]),
                            Double.parseDouble(values[11]), Double.parseDouble(values[12]),
                            star, values[13]));
                }
                linePrevious = values[0];

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return planetSystems;

    }

    private void writeToCSV(ArrayList<PlanetSystem> planetSystems, File core){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(core, false))){
            for (PlanetSystem currentplanetSystem : planetSystems){
                for (Planet planet : currentplanetSystem.getPlanets()){
                    String planetName = planet.getName();
                    bufferedWriter.write(currentplanetSystem.getName() + ";"
                            + currentplanetSystem.getPictureUrl() + ";"
                            + currentplanetSystem.getCenterStar().getName() + ";"
                            + currentplanetSystem.getCenterStar().getRadius() + ";"
                            + currentplanetSystem.getCenterStar().getMass() + ";"
                            + currentplanetSystem.getCenterStar().getEffectiveTemp() + ";"
                            + currentplanetSystem.getCenterStar().getPictureUrl() + ";"
                            + currentplanetSystem.getPlanet(planetName).getName() + ";"
                            + currentplanetSystem.getPlanet(planetName).getRadius() + ";"
                            + currentplanetSystem.getPlanet(planetName).getMass() + ";"
                            + currentplanetSystem.getPlanet(planetName).getSemi_major_axis() + ";"
                            + currentplanetSystem.getPlanet(planetName).getEccentricity() + ";"
                            + currentplanetSystem.getPlanet(planetName).getOrbitalPeriod() + ";"
                            + currentplanetSystem.getPlanet(planetName).getPictureUrl());

                    bufferedWriter.newLine();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {
        if (planetSystems != null){
            return planetSystems;
        }
        return new ArrayList<>();
    }

    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        for (PlanetSystem system : planetSystems){
            if (system.getName().equals(planetSystemName)) {
                return system;
            }
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

        writeToCSV(planetSystems, core);

        planetSystems = readFromCSV(core);
    }

    @Override
    public void UpdatePlanet(String planetSystem, String name, Planet newPlanet) {
        PlanetSystem curPlanetSystem = getPlanetSystem(planetSystem);
        Planet curPlanet = curPlanetSystem.getPlanet(name);
        curPlanetSystem.deletePlanet(curPlanet);

        curPlanetSystem.addPlanet(newPlanet);

        writeToCSV(planetSystems, core);

        planetSystems = readFromCSV(core);

    }


    @Override
    public void DeletePlanet(String planetSystem, String name) {
        PlanetSystem curPlanetSystem = getPlanetSystem(planetSystem);
        Planet curPlanet = curPlanetSystem.getPlanet(name);
        curPlanetSystem.deletePlanet(curPlanet);

        writeToCSV(planetSystems, core);

        planetSystems = readFromCSV(core);
    }

}
