package com.ren.lumen.client.model.entity;

import com.ren.lumen.Lumen;
import com.ren.lumen.server.entity.LumenEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class LumenModel extends GeoModel<LumenEntity> {
    @Override
    public ResourceLocation getModelResource(LumenEntity lumenEntity) {
        return new ResourceLocation(Lumen.MOD_ID, "geo/lumen.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LumenEntity lumenEntity) {
        return new ResourceLocation(Lumen.MOD_ID, "textures/entity/lumen.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LumenEntity lumenEntity) {
        return new ResourceLocation(Lumen.MOD_ID, "animations/lumen.json");
    }

    @Override
    public void setCustomAnimations(LumenEntity animatable, long instanceId, AnimationState<LumenEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
