package com.ren.lumen.server.event;

import com.ren.lumen.Lumen;
import com.ren.lumen.server.core.EntityInit;
import com.ren.lumen.server.entity.LumenEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Lumen.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityInit.LUMEN.get(), LumenEntity.setAttributes());
    }
}
