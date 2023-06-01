package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;

import java.util.Random;

public class Asteroid extends Entity {
    private AsteroidSize asteroidSize;
    private Random rnd = new Random();

    public Asteroid(AsteroidSize asteroidSize) {
        this.setShapeX(new float[6]);
        this.setShapeY(new float[6]);
        this.asteroidSize = asteroidSize;
    }

    public AsteroidSize getAsteroidSize() {
        return asteroidSize;
    }

    @Override
    public void remove(World world) {
        LifePart asteroidLife = this.getPart(LifePart.class);
        PositionPart posPart = this.getPart(PositionPart.class);
        if(asteroidLife.getLife() <= 0){
            if(this.getAsteroidSize() == AsteroidSize.LARGE) {
                Asteroid mediumAsteroidOne = createMediumAsteroid(posPart.getX(), posPart.getY());
                Asteroid mediumAsteroidTwo = createMediumAsteroid(posPart.getX() , posPart.getY());
                world.addEntity(mediumAsteroidOne);
                world.addEntity(mediumAsteroidTwo);
            }
            if(this.getAsteroidSize() == AsteroidSize.MEDIUM){
                Asteroid mediumAsteroidOne = createSmallAsteroid(posPart.getX(), posPart.getY());
                Asteroid mediumAsteroidTwo = createSmallAsteroid(posPart.getX(), posPart.getY());
                world.addEntity(mediumAsteroidOne);
                world.addEntity(mediumAsteroidTwo);
            }
        }
        super.remove(world);
    }

    private Asteroid createSmallAsteroid(float x, float y) {
        float speed = (float) Math.random() * 10f + 13f;
        float radians = 3.1415f / 2 + (float) Math.random();

        Entity asteroid = new Asteroid(AsteroidSize.SMALL);
        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(x + rnd.nextInt(50), y+rnd.nextInt(50), radians));
        asteroid.add(new LifePart(2, 69f));
        asteroid.setRadius(5);

        return (Asteroid) asteroid;
    }

    private Asteroid createMediumAsteroid(float x, float y) {
        float speed = (float) Math.random() * 10f + 40f;
        float radians = 3.1415f / 2 + (float) Math.random();

        Entity asteroid = new Asteroid(AsteroidSize.MEDIUM);

        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(x + rnd.nextInt(50), y + rnd.nextInt(50), radians));
        asteroid.add(new LifePart(4, 69f));
        asteroid.setRadius(10);

        return (Asteroid) asteroid;
    }
}
