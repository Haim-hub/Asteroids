package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

/**
 *
 * @author jcs
 */
public class BulletControlSystem implements IEntityProcessingService {
    private final Random rand = new Random();

    @Override
    public void process(GameData gameData, World world) {
        if (world.getEntities(Bullet.class).isEmpty())
            return;
        for (Entity bullet : world.getEntities(Bullet.class)) {
            PositionPart positionPart = bullet.getPart(PositionPart.class);
            MovingPart movingPart = bullet.getPart(MovingPart.class);

            movingPart.setUp(true);
            if(positionPart.getY() == gameData.getDisplayHeight() || positionPart.getY() == 0)
                world.removeEntity(bullet);
            if(positionPart.getX() == gameData.getDisplayWidth() || positionPart.getX() == 0)
                world.removeEntity(bullet);
            
            
            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);

            updateShape(bullet);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians + 1 * 3.1415f / 5) * entity.getRadius());
        shapey[0] = (float) (y + Math.sin(radians + 1 * 3.1145f / 5) * entity.getRadius());

        shapex[1] = (float) (x + Math.cos(radians - 1 * 3.1415f / 5) * entity.getRadius());
        shapey[1] = (float) (y + Math.sin(radians - 1 * 3.1145f / 5) * entity.getRadius());

        shapex[2] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * entity.getRadius());
        shapey[2] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * entity.getRadius());

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * entity.getRadius());
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * entity.getRadius());

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
