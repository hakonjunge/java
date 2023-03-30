package no.hiof.bebricen.oving4.repository;

import no.hiof.bebricen.oving4.model.Moon;
import no.hiof.bebricen.oving4.model.Planet;
import no.hiof.bebricen.oving4.model.PlanetSystem;
import no.hiof.bebricen.oving4.model.Star;

import java.util.ArrayList;

public class UniverseDataRepository implements UniverseRepository{
    private ArrayList<PlanetSystem> planetSystems = new ArrayList<PlanetSystem>();

    public UniverseDataRepository() {



        // Creating the Star and then the Planetsystem
        Star sun = new Star("Sun", 1.0, 1.0, 5777, "http://bit.ly/333CTus");
        PlanetSystem solarSystem = new PlanetSystem("Solar system", "http://bit.ly/3cVhuZc", sun);


        // Create the Planets
        solarSystem.addPlanet(new Planet("Mercury", 0.03412549655905556,
                1.7297154899894627E-4, 0.387, 0.206, 88,
                sun, "http://bit.ly/2TB2Heo"));
        solarSystem.addPlanet(new Planet("Venus", 0.08465003077267387,
                0.002564278187565859, 0.723, 0.007, 225,
                sun, "https://bit.ly/2OXyaYw"));
        solarSystem.addPlanet(new Planet("Earth", 0.08911486599899289,
                0.003146469968387777, 1, 0.017, 365,
                sun, "http://bit.ly/33bvXLZ"));
        solarSystem.addPlanet(new Planet("Mars", 0.04741089912158004,
                3.3667017913593256E-4, 1.524, 0.093, 687,
                sun, "http://bit.ly/3aGyFvr"));
        solarSystem.addPlanet(new Planet("Jupiter", 1.0, 1.0,
                5.20440, 0.049, 4380,
                sun, "http://bit.ly/2Q0fjK3"));
        solarSystem.addPlanet(new Planet("Saturn", 0.8145247020645666,
                0.2994204425711275, 9.5826, 0.057, 10585,
                sun, "http://bit.ly/2W0sqic"));
        solarSystem.addPlanet(new Planet("Uranus", 0.35475297935433336,
                0.04573761854583773, 19.2184, 0.046, 30660,
                sun, "http://bit.ly/335pbHy"));
        solarSystem.addPlanet(new Planet("Neptune", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "http://bit.ly/38AyEba"));

        // Id the planets
        Planet mercury = solarSystem.getPlanet("Mercury");
        Planet venus = solarSystem.getPlanet("Venus");
        Planet earth = solarSystem.getPlanet("Earth");
        Planet mars = solarSystem.getPlanet("Mars");
        Planet jupiter = solarSystem.getPlanet("Jupiter");
        Planet saturn = solarSystem.getPlanet("Saturn");
        Planet uranus = solarSystem.getPlanet("Uranus");
        Planet neptune = solarSystem.getPlanet("Neptune");


        // Creating example moons, variables dont matter.
        earth.addMoon(new Moon("Moon", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/3rSAfDt", earth));

        jupiter.addMoon(new Moon("Lo", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/2OR9Hnz", jupiter));
        jupiter.addMoon(new Moon("Europa", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/38Iz2Hz", jupiter));
        jupiter.addMoon(new Moon("Ganymede", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/30JCgGj", jupiter));
        jupiter.addMoon(new Moon("Callisto", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/3vsVD4w", jupiter));

        mars.addMoon(new Moon("Phobos", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/2OWcUCi", mars));
        mars.addMoon(new Moon("Deimos", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/3lr7CuL", mars));

        neptune.addMoon(new Moon("Triton", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/3cuoLzG", neptune));

        saturn.addMoon(new Moon("Titan", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/3lrnQUH", saturn));
        saturn.addMoon(new Moon("Rhea", 0.34440217087226543,
                0.05395152792413066, 30.11, 0.010, 60225,
                sun, "https://bit.ly/3rQyB5p", saturn));

        // Adding the planet system to the Arraylist of planet systems.
        planetSystems.add(solarSystem);






        // Creating the kepler system in the same way.
        Star kepler11 = new Star("Kepler-11", 1.889E30,710310,5680,
                "http://bit.ly/336nzNZ");
        PlanetSystem kepler11System  =
                new PlanetSystem("Kepler-11 System", "http://bit.ly/2Iz4jPB", kepler11);

        kepler11System.addPlanet(new Planet("Kepler-11b", 0.01352982086406744,
                0.17554411682426005,1.36134E7,
                0.045,10.0, kepler11, null));
        kepler11System.addPlanet(new Planet("Kepler-11c",
                0.04247734457323498,0.28070273597045825,1.5857E7,
                0.026,13.0, kepler11, null));
        kepler11System.addPlanet(new Planet("Kepler-11d",
                0.019193466807165438,0.3056565769596598,2.3786E7,
                0.004,22.0, kepler11, null));
        kepler11System.addPlanet(new Planet("Kepler-11e",
                0.026430347734457325,0.4027863257427404,2.9021E7,
                0.012,31.0, kepler11, null));
        kepler11System.addPlanet(new Planet("Kepler-11f",
                0.007236880927291886,0.2325854641078722,3.7399E7,
                0.013,36.0, kepler11, null));
        kepler11System.addPlanet(new Planet("Kepler-11g",
                0.9439409905163331,0.32614838023834836,6.9114E7,
                0.015,118.0, kepler11, null));

        planetSystems.add(kepler11System);


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

    }

    @Override
    public void UpdatePlanet(String planetSystem, String name, Planet newPlanet) {

    }


    @Override
    public void DeletePlanet(String planetSystem, String name) {

    }



}
