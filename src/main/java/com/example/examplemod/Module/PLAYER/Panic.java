package com.example.examplemod.Module.PLAYER;

import com.example.examplemod.Client;
import com.example.examplemod.Module.Module;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Panic extends Module {
    public static boolean isPanic = false;
    public Panic()
    {
        super("Panic", Keyboard.KEY_NONE, Category.PLAYER);
    }

    @Override
    public void onEnable() {
        Display.setTitle("Minecraft 1.12.2");
        isPanic = true;
        for (Module m: Client.modules)
        {
            if (m != this)
            {
                m.setToggled(false);
            }
        }
    }

    @Override
    public void onDisable() {
        Display.setTitle(Client.name);
        isPanic = false;
    }
}
