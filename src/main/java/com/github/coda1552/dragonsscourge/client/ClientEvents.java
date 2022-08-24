package com.github.coda1552.dragonsscourge.client;

import com.github.coda1552.dragonsscourge.DragonsScourge;
import com.github.coda1552.dragonsscourge.client.model.DragonArrowModel;
import com.github.coda1552.dragonsscourge.client.render.DragonArrowRenderer;
import com.github.coda1552.dragonsscourge.registry.DSEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DragonsScourge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    public static final ModelLayerLocation DRAGON_ARROW = new ModelLayerLocation(new ResourceLocation(DragonsScourge.MOD_ID, "dragon_arrow"), "main");

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        ForgeHooksClient.registerLayerDefinition(DRAGON_ARROW, DragonArrowModel::createLayer);
        EntityRenderers.register(DSEntities.DRAGON_ARROW.get(), DragonArrowRenderer::new);
    }
}
