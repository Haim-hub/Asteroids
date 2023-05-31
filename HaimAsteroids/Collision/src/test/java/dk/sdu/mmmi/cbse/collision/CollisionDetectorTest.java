/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.collision.Collider;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CollisionDetectorTest {

    public CollisionDetectorTest() {
    }


    @Test
    public void testCollides() {
        System.out.println("collides");
        Entity entity = new Entity();
        entity.add(new PositionPart(0.0f, 0.0f, 0.0f));
        entity.setRadius(10f);

        Entity entity2 = new Entity();
        entity2.add(new PositionPart(0.0f, 0.0f, 0.0f));
        entity2.setRadius(10f);

        Collider instance = new Collider();
        Boolean expResult = true;
        Boolean result = instance.Collides(entity, entity2);
        assertEquals(expResult, result);
    }
    
}

