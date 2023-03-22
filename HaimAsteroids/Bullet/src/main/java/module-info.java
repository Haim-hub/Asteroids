import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.bullet.BulletControlSystem;
    provides IGamePluginService with dk.sdu.mmmi.cbse.bullet.BulletPlugin;
    exports dk.sdu.mmmi.cbse.bullet;
}