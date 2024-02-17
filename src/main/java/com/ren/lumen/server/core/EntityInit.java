package com.ren.lumen.server.core;

import com.ren.lumen.Lumen;
import com.ren.lumen.server.entity.LumenEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Lumen.MOD_ID);

    public static final RegistryObject<EntityType<LumenEntity>> LUMEN = ENTITIES.register("lumen",
            () -> EntityType.Builder.<LumenEntity>of(LumenEntity::new, MobCategory.CREATURE).sized(0.9F, 2.5F)
                    .build(new ResourceLocation(Lumen.MOD_ID, "lumen").toString()));
}
