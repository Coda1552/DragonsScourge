package com.github.coda1552.dragonsscourge.client.render;

import com.github.coda1552.dragonsscourge.DragonsScourge;
import com.github.coda1552.dragonsscourge.common.entity.DragonArrowEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DragonArrowRenderer extends EntityRenderer<DragonArrowEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(DragonsScourge.MOD_ID, "textures/entity/dragon_arrow.png");

    public DragonArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(DragonArrowEntity entity, float p_114486_, float p_114487_, PoseStack stack, MultiBufferSource p_114489_, int p_114490_) {
        super.render(entity, p_114486_, p_114487_, stack, p_114489_, p_114490_);
        stack.pushPose();
        stack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(p_114487_, entity.yRotO, entity.getYRot()) - 90.0F));
        stack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(p_114487_, entity.xRotO, entity.getXRot())));
        float f9 = (float)entity.shakeTime - p_114487_;
        if (f9 > 0.0F) {
            float f10 = -Mth.sin(f9 * 3.0F) * f9;
            stack.mulPose(Vector3f.ZP.rotationDegrees(f10));
        }
        stack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(DragonArrowEntity p_114482_) {
        return TEXTURE;
    }
}
