package com.example.examplemod.UI;

import com.example.examplemod.Client;
import com.example.examplemod.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Objects;

import static com.example.examplemod.Module.PLAYER.Panic.isPanic;

public class ui {
    public static boolean allowShow = true;
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post e) {
        if (Objects.requireNonNull(e.getType()) == RenderGameOverlayEvent.ElementType.TEXT) {
            int y = 10;
            int counter = 1;

            Minecraft mc = Minecraft.getMinecraft();
            FontRenderer fr = mc.fontRenderer;
            ScaledResolution sr = new ScaledResolution(mc);

            if (allowShow && !isPanic) {
                fr.drawStringWithShadow("FPS: " + Minecraft.getDebugFPS(), 5, 15, rainbow(counter * 300));
                fr.drawStringWithShadow(Client.name, 5, 5, rainbow(counter * 300));
            }

            for (Module module : Client.modules) {
                if (module.toggled) {
                    if (Objects.equals(module.name, "Panic")) {
                        continue;
                    }
                    Gui.drawRect(sr.getScaledWidth(), y, sr.getScaledWidth() - 2,
                            y + 10, rainbow(counter * 300));

                    fr.drawStringWithShadow(module.name, sr.getScaledWidth() - 4 - fr.getStringWidth(module.name),
                            y, rainbow(counter * 300));
                    y += 10;
                    counter++;
                }
            }
        }
    }

    public static int rainbow(int delay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}
