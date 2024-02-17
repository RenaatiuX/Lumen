package com.ren.lumen.server.core;

import com.ren.lumen.Lumen;
import com.ren.lumen.server.LumenArmorItem;
import com.ren.lumen.server.util.LumenArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Lumen.MOD_ID);

    public static final RegistryObject<Item> LUMEN_HELMET = ITEMS.register("lumen_helmet",
            () -> new LumenArmorItem(LumenArmorMaterials.LUMEN_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> LUMEN_CHESTPLATE = ITEMS.register("lumen_chestplate",
            () -> new LumenArmorItem(LumenArmorMaterials.LUMEN_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LUMEN_LEGGINGS = ITEMS.register("lumen_leggings",
            () -> new LumenArmorItem(LumenArmorMaterials.LUMEN_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> LUMEN_BOOTS = ITEMS.register("lumen_boots",
            () -> new LumenArmorItem(LumenArmorMaterials.LUMEN_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));

}
