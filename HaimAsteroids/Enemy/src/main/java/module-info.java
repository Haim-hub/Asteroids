import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Enemy {
    exports dk.sdu.mmmi.cbse.enemysystem;
    requires Common;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.enemysystem.EnemyControlSystem;
    provides IGamePluginService with dk.sdu.mmmi.cbse.enemysystem.EnemyPlugin;
}