package net.mcreator.youtubersmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.youtubersmod.entity.DreamEntity;
import net.mcreator.youtubersmod.YoutubersmodModElements;
import net.mcreator.youtubersmod.YoutubersmodMod;

import java.util.Map;

@YoutubersmodModElements.ModElement.Tag
public class SpawnDreamProcedure extends YoutubersmodModElements.ModElement {
	public SpawnDreamProcedure(YoutubersmodModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				YoutubersmodMod.LOGGER.warn("Failed to load dependency x for procedure SpawnDream!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				YoutubersmodMod.LOGGER.warn("Failed to load dependency y for procedure SpawnDream!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				YoutubersmodMod.LOGGER.warn("Failed to load dependency z for procedure SpawnDream!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				YoutubersmodMod.LOGGER.warn("Failed to load dependency world for procedure SpawnDream!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new DreamEntity.CustomEntity(DreamEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
			entityToSpawn.setRenderYawOffset((float) 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
	}
}
