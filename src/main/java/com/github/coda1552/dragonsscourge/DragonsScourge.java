package com.github.coda1552.dragonsscourge;

import com.github.coda1552.dragonsscourge.common.entity.DragonArrowEntity;
import com.github.coda1552.dragonsscourge.registry.DSEntities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DragonsScourge.MOD_ID)
public class DragonsScourge {
    public static final String MOD_ID = "dragonsscourge";

    public DragonsScourge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        forgeBus.addListener(this::arrowLoose);
        DSEntities.ENTITIES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void arrowLoose(ArrowLooseEvent event) {
        Player player = event.getEntity();
        ItemStack bow = event.getBow();
        ItemStack ammo = player.getProjectile(bow);

        if (ammo.is(Items.ARROW)) {
            DragonArrowEntity dragonArrow = new DragonArrowEntity(DSEntities.DRAGON_ARROW.get(), player.level);
            player.level.addFreshEntity(dragonArrow);

            float f = event.getCharge();

            dragonArrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.5F, 1.0F);
        }
    }
}