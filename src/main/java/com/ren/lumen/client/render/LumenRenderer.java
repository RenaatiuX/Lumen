package com.ren.lumen.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.ren.lumen.client.model.entity.LumenModel;
import com.ren.lumen.server.entity.LumenEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.example.client.renderer.entity.GremlinRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.util.RenderUtils;

public class LumenRenderer extends GeoEntityRenderer<LumenEntity> {
    protected ItemStack mainHandItem;
    protected ItemStack offhandItem;
    public LumenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LumenModel());
        this.addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            @Override
            protected ItemStack getStackForBone(GeoBone bone, LumenEntity animatable) {
                return switch (bone.getName()) {
                    case "arm1" ->
                            animatable.isLeftHanded() ? LumenRenderer.this.mainHandItem : LumenRenderer.this.offhandItem;
                    case "arm2" ->
                            animatable.isLeftHanded() ? LumenRenderer.this.offhandItem : LumenRenderer.this.mainHandItem;
                    default -> null;
                };
            }

            @Override
            public void renderForBone(PoseStack poseStack, LumenEntity animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
                ItemStack stack = getStackForBone(bone, animatable);
                BlockState blockState = getBlockForBone(bone, animatable);

                if (stack == null && blockState == null)
                    return;

                poseStack.pushPose();

                //translate to pivot so we can rotate around itself
                //then rotate so it looks good this is just try and error
                //then we translate it to the end of the arm so it looks like it is holding it
                RenderUtils.translateToPivotPoint(poseStack, bone);
                poseStack.mulPose(Axis.XN.rotationDegrees(70));
                poseStack.translate(-0.1f, -0.2f, -1.1f);



                if (stack != null)
                    renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);

                if (blockState != null)
                    renderBlockForBone(poseStack, bone, blockState, animatable, bufferSource, partialTick, packedLight, packedOverlay);

                buffer = bufferSource.getBuffer(renderType);

                poseStack.popPose();
            }

            @Override
            protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, LumenEntity animatable) {
                return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
            }
        });

    }

    @Override
    public ResourceLocation getTextureLocation(LumenEntity animatable) {
        return this.model.getTextureResource(animatable);
    }

    @Override
    protected float getDeathMaxRotation(LumenEntity animatable) {
        return 0.0F;
    }

    @Override
    public float getMotionAnimThreshold(LumenEntity animatable) {
        return 0.005F;
    }

    @Override
    public void preRender(PoseStack poseStack, LumenEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        this.mainHandItem = animatable.getMainHandItem();
        this.offhandItem = animatable.getOffhandItem();
    }
}
