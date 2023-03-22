import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteriod {
    requires Common;
    provides IGamePluginService with dk.sdu.mmmi.cbse.asteriodsystem.AsteriodPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.asteriodsystem.AsteriodControlSystem;
}
