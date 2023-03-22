package dk.sdu.mmmi.cbse.asteriodsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.EntityPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jcs
 */
public class AsteriodControlSystem implements IEntityProcessingService {
    private final Random rand = new Random();

    public AsteriodControlSystem() {
    }

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteriod : world.getEntities(Asteriod.class)) {

            //Movement
            PositionPart positionPart = asteriod.getPart(PositionPart.class);
            MovingPart movingPart = asteriod.getPart(MovingPart.class);
            int i = rand.nextInt(7);
            switch (i){
                case 0:
                    movingPart.setLeft(false);
                    movingPart.setRight(true);
                    movingPart.setUp(false);
                    break;
                case 1:
                case 2:
                case 3:
                    movingPart.setLeft(false);
                    movingPart.setRight(false);
                    movingPart.setUp(true);
                    break;
                default:
                    movingPart.setLeft(false);
                    movingPart.setRight(false);
                    movingPart.setUp(false);
                    break;
            }
            movingPart.process(gameData, asteriod);
            positionPart.process(gameData, asteriod);

            updateShape(asteriod);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians + 0.2 * 3.1145f) * entity.getRadius());
        shapey[0] = (float) (y + Math.sin(radians + 0.2 * 3.1145f) * entity.getRadius());

        shapex[1] = (float) (x + Math.cos(radians - 0.2 * 3.1145f) * entity.getRadius());
        shapey[1] = (float) (y + Math.sin(radians - 0.2 * 3.1145f) * entity.getRadius());

        shapex[3] = (float) (x + Math.cos(radians + 0.4 * 3.1145f) * entity.getRadius());
        shapey[3] = (float) (y + Math.sin(radians + 0.4 * 3.1145f) * entity.getRadius());

        shapex[2] = (float) (x + Math.cos(radians - 0.6 * 3.1145f) * entity.getRadius());
        shapey[2] = (float) (y + Math.sin(radians - 0.6 * 3.1145f) * entity.getRadius());

        shapex[4] = (float) (x + Math.cos(radians + 0.8 * 3.1145f) * entity.getRadius());
        shapey[4] = (float) (y + Math.sin(radians + 0.8 * 3.1145f) * entity.getRadius());

        shapex[5] = (float) (x + Math.cos(radians - 0.8 * 3.1145f) * entity.getRadius());
        shapey[5] = (float) (y + Math.sin(radians - 0.8 * 3.1145f) * entity.getRadius());

        /*
        shapex[0] = (float) (x + Math.cos(radians + 1 * 3.1415f / 5) * entity.getRadius());
        shapey[0] = (float) (y + Math.sin(radians + 1 * 3.1145f / 5) * entity.getRadius());

        shapex[1] = (float) (x + Math.cos(radians - 1 * 3.1415f / 5) * entity.getRadius());
        shapey[1] = (float) (y + Math.sin(radians - 1 * 3.1145f / 5) * entity.getRadius());

        shapex[2] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * entity.getRadius());
        shapey[2] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * entity.getRadius());

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * entity.getRadius());
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * entity.getRadius());
        */

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}