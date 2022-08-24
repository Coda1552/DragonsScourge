package com.github.coda1552.dragonsscourge.registry;

import com.github.coda1552.dragonsscourge.DragonsScourge;
import com.github.coda1552.dragonsscourge.common.entity.DragonArrowEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DSEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DragonsScourge.MOD_ID);

    public static final RegistryObject<EntityType<DragonArrowEntity>> DRAGON_ARROW = ENTITIES.register("dragon_arrow", () -> EntityType.Builder.of(DragonArrowEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).updateInterval(1).build("dragon_arrow"));
}
