package com.ren.lumen.client.model;

import com.ren.lumen.Lumen;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class LumenModelLayers {

    public static final ModelLayerLocation LUMEN_ARMOR_INNER = register("lumen_armor", "inner");
    public static final ModelLayerLocation LUMEN_ARMOR_OUTER = register("lumen_armor", "outer");

    private static ModelLayerLocation register(String pPath) {
        return register(pPath, "main");
    }

    private static ModelLayerLocation register(String pPath, String pModel) {
        return new ModelLayerLocation(new ResourceLocation(Lumen.MOD_ID, pPath), pModel);
    }
}
