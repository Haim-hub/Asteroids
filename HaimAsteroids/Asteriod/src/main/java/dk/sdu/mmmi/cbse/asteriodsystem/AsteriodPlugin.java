package dk.sdu.mmmi.cbse.asteriodsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteriodPlugin implements IGamePluginService {

    private Entity asteriod;

    public AsteriodPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        asteriod = createAsteriodShip(gameData);
        world.addEntity(asteriod);
    }

    private Entity createAsteriodShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 1000;
        float maxSpeed = 10;
        float rotationSpeed = 5;
        Random random = new Random();
        float x = gameData.getDisplayWidth() / 4;
        float y = gameData.getDisplayHeight() / 4;
        float radians = 3.1415f / 2;
        
        Entity asteriodShip = new Asteriod(AsteriodSize.LARGE);
        asteriodShip.setRadius(16.0f);
        asteriodShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteriodShip.add(new PositionPart(x, y, radians));
        asteriodShip.add(new LifePart(6,69));
        return asteriodShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteriod);
    }

}
