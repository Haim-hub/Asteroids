/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

//import org.openide.util.lookup.ServiceProvider;


//@ServiceProvider(service = IPostEntityProcessingService.class)
public class Collider implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()) {
            for (Entity collisionDetection : world.getEntities()) {
                LifePart entityLife = entity.getPart(LifePart.class);
                LifePart collisionLife = collisionDetection.getPart(LifePart.class);

                if (entity.getID().equals(collisionDetection.getID())) {
                    continue;
                }
                if(entity.getClass().equals(collisionDetection.getClass())){
                    break;
                }
                if (entityLife.getExpiration() <= 0) {
                    world.removeEntity(entity);
                    if (collisionLife.getExpiration() <= 0) {
                        world.removeEntity(collisionDetection);
                    }
                }
                if (this.Collides(entity, collisionDetection)) {
                    if (entityLife.getLife() > 0) {
                        entityLife.setLife(entityLife.getLife() - 1);
                        if (entityLife.getLife() <= 0) {
                            world.removeEntity(entity);
                        }
                    }
                }
            }
        }
    }

    public Boolean Collides(Entity entity, Entity entity2) {
        PositionPart entMov = entity.getPart(PositionPart.class);
        PositionPart entMov2 = entity2.getPart(PositionPart.class);
        float dx = (float) entMov.getX() - (float) entMov2.getX();
        float dy = (float) entMov.getY() - (float) entMov2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance < (entity.getRadius() + entity2.getRadius())) {
            return true;
        }
        return false;
    }

}
