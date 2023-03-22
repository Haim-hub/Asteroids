package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        asteroid = createAsteroidShip(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroidShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 1000;
        float maxSpeed = 10;
        float rotationSpeed = 5;
        Random random = new Random();
        float x = gameData.getDisplayWidth() / 4;
        float y = gameData.getDisplayHeight() / 4;
        float radians = 3.1415f / 2;
        
        Entity asteroidShip = new Asteroid(AsteroidSize.LARGE);
        asteroidShip.setRadius(16.0f);
        asteroidShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteroidShip.add(new PositionPart(x, y, radians));
        asteroidShip.add(new LifePart(6,69));
        return asteroidShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

}
