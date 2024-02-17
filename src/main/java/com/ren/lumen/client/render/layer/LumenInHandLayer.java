package com.ren.lumen.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.ren.lumen.server.entity.LumenEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.RenderUtils;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class LumenInHandLayer extends GeoRenderLayer<LumenEntity> {
    private final ItemInHandRenderer itemInHandRenderer;

    public LumenInHandLayer(GeoRenderer<LumenEntity> entityRendererIn, ItemInHandRenderer inHandRenderer) {
        super(entityRendererIn);
        this.itemInHandRenderer = inHandRenderer;

    }

    /*@Override
    public void renderForBone(PoseStack poseStack, LumenEntity animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        ItemStack itemStack = animatable.getMainHandItem();
        if (!itemStack.isEmpty()) {
            poseStack.pushPose();
            if (bone.getName().equals("arm1")) {
                poseStack.translate(0.15F, 1.15F, 0.0F);
                poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
                this.itemInHandRenderer.renderItem(animatable, itemStack, ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, false, poseStack, bufferSource, packedLight);
            }
            poseStack.popPose();
        }
    }*/
}

