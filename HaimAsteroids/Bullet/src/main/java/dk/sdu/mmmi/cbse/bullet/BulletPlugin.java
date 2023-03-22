package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {

    private Entity bullet;

    public BulletPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
    }

    public void createBulletShip(World world, float x, float y, float radians) {

        float maxSpeed = 500;
        float acceleration = 100000;
        float deacceleration = 10;
        float rotationSpeed = 5;
        
        bullet = new Bullet();
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(x, y, radians));
        bullet.add(new LifePart(6,69));
        bullet.setRadius(1f);
        world.addEntity(bullet);
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(bullet);
    }

}
