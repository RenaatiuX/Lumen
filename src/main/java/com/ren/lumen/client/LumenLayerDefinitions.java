package com.ren.lumen.client;

import com.ren.lumen.Lumen;
import com.ren.lumen.client.model.LumenModelLayers;
import com.ren.lumen.client.model.armor.LumenArmorModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Lumen.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LumenLayerDefinitions {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LumenModelLayers.LUMEN_ARMOR_INNER, () -> LayerDefinition.create(LumenArmorModel.
                createMesh(LayerDefinitions.INNER_ARMOR_DEFORMATION, 0), 64, 32));
        event.registerLayerDefinition(LumenModelLayers.LUMEN_ARMOR_OUTER, () -> LayerDefinition.create(LumenArmorModel.
                createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0), 64, 32));
    }
}
