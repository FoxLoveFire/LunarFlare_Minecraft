package com.example.examplemod;

import com.example.examplemod.Module.COMBAT.TriggerBot;
import com.example.examplemod.Module.COMBAT.Velocity;
import com.example.examplemod.Module.EXPLOITS.FakeCreative;
import com.example.examplemod.Module.MOVEMENT.*;
import com.example.examplemod.Module.Module;
import com.example.examplemod.Module.PLAYER.BlockReach;
import com.example.examplemod.Module.PLAYER.Panic;
import com.example.examplemod.Module.RENDER.Fullbright;
import com.example.examplemod.Module.RENDER.GlowESP;
import me.bushroot.clickgui.ClickGuiScreen;
import org.lwjgl.opengl.Display;

import java.util.concurrent.CopyOnWriteArrayList;

public class Client {
    public static String name = "LunarFlare 1.12.2";
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();

    public static ClickGuiScreen clickGui;

    public static void startup() {
        Display.setTitle(name);

        modules.add(new BlockReach());
        modules.add(new TriggerBot());
        modules.add(new GlowESP());
        modules.add(new Sprint());
        modules.add(new Fly());
        modules.add(new Panic());
        modules.add(new FakeCreative());
        modules.add(new Fullbright());
        modules.add(new Velocity());
        modules.add(new Spider());
        modules.add(new Speed());
        modules.add(new Jesus());
        modules.add(new AirJump());

        clickGui = new ClickGuiScreen();
    }

    public static void keyPress(int key) {
        for (Module m : modules) {
            if (m.getKey() == key) {
                m.toggle();
            }
        }
    }
}
