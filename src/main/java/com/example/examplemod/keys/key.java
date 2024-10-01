package com.example.examplemod.keys;

import com.example.examplemod.Client;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import com.example.examplemod.UI.ui;

public class key {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (Keyboard.isKeyDown(Keyboard.getEventKey())) {
            if (Keyboard.getEventKey() != Keyboard.KEY_NONE) {
                Client.keyPress(Keyboard.getEventKey());
                if (Keyboard.getEventKey() == Keyboard.KEY_RSHIFT) {
                    Minecraft.getMinecraft().displayGuiScreen(Client.clickGui);
                }
                if (Keyboard.getEventKey() == Keyboard.KEY_F3) {ui.allowShow = false;} else { ui.allowShow = true; }
            }
        }
    }
}
