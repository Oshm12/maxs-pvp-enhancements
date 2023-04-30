package minmaximilian.pvp_enhancements.forge;

import minmaximilian.pvp_enhancements.PvPEnhancementsCommonEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class PvPEnhancementsCommonForgeEvents {
	public static void register(IEventBus forgeEventBus) {
		forgeEventBus.addListener(PvPEnhancementsCommonForgeEvents::onExplosion);
		forgeEventBus.addListener(PvPEnhancementsCommonForgeEvents::onWorldTick);
		forgeEventBus.addListener(PvPEnhancementsCommonForgeEvents::onChunkLoad);
		forgeEventBus.addListener(PvPEnhancementsCommonForgeEvents::onChunkUnload);
	}
	public static void onExplosion(ExplosionEvent.Detonate explosionEvent) {
		PvPEnhancementsCommonEvents.onExplosion(explosionEvent.getLevel(), explosionEvent.getAffectedBlocks(), explosionEvent.getExplosion().getExploder());
	}
	public static void onChunkLoad(ChunkEvent.Load event) {
		PvPEnhancementsCommonEvents.onChunkLoad(event.getLevel(), event.getChunk());
	}
	public static void onChunkUnload(ChunkEvent.Unload event) {
		PvPEnhancementsCommonEvents.onChunkUnload(event.getLevel(), event.getChunk());
	}
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		PvPEnhancementsCommonEvents.onLevelTick(event.level);
	}
	public static void onPenetration() {
		PvPEnhancementsCommonEvents.handlePenetration(new BlockPos(0,0,0), new BlockState(null, null, null));
	}
}
