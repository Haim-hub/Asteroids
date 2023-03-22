package dk.sdu.mmmi.cbse.asteriodsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;

import java.util.Random;

/**
 *
 * @author corfixen
 */
public class Asteriod extends Entity {
    private AsteriodSize asteriodSize;
    private Random rnd = new Random();

    public Asteriod(AsteriodSize asteriodSize) {
        this.setShapeX(new float[6]);
        this.setShapeY(new float[6]);
        this.asteriodSize = asteriodSize;
    }

    public AsteriodSize getAsteriodSize() {
        return asteriodSize;
    }

    @Override
    public void remove(World world) {
        LifePart asteriodLife = this.getPart(LifePart.class);
        PositionPart posPart = this.getPart(PositionPart.class);
        if(asteriodLife.getLife() <= 0){
            if(this.getAsteriodSize() == AsteriodSize.LARGE) {
                Asteriod mediumAsteriodOne = createMediumAsteriod(posPart.getX(), posPart.getY());
                Asteriod mediumAsteriodTwo = createMediumAsteriod(posPart.getX() , posPart.getY());
                world.addEntity(mediumAsteriodOne);
                world.addEntity(mediumAsteriodTwo);
            }
            if(this.getAsteriodSize() == AsteriodSize.MEDIUM){
                Asteriod mediumAsteriodOne = createSmallAsteriod(posPart.getX(), posPart.getY());
                Asteriod mediumAsteriodTwo = createSmallAsteriod(posPart.getX(), posPart.getY());
                world.addEntity(mediumAsteriodOne);
                world.addEntity(mediumAsteriodTwo);
            }
        }
        super.remove(world);
    }

    private Asteriod createSmallAsteriod(float x, float y) {
        float speed = (float) Math.random() * 10f + 13f;
        float radians = 3.1415f / 2 + (float) Math.random();

        Entity asteriod = new Asteriod(AsteriodSize.SMALL);
        asteriod.add(new MovingPart(0, speed, speed, 0));
        asteriod.add(new PositionPart(x + rnd.nextInt(50), y+rnd.nextInt(50), radians));
        asteriod.add(new LifePart(2, 69f));
        asteriod.setRadius(5);

        return (Asteriod) asteriod;
    }

    private Asteriod createMediumAsteriod(float x, float y) {
        float speed = (float) Math.random() * 10f + 40f;
        float radians = 3.1415f / 2 + (float) Math.random();

        Entity asteriod = new Asteriod(AsteriodSize.MEDIUM);

        asteriod.add(new MovingPart(0, speed, speed, 0));
        asteriod.add(new PositionPart(x + rnd.nextInt(50), y + rnd.nextInt(50), radians));
        asteriod.add(new LifePart(4, 69f));
        asteriod.setRadius(10);

        return (Asteriod) asteriod;
    }
}
