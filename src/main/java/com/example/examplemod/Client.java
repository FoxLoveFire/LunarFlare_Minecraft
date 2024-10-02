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
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

import java.util.Map;

import static com.example.examplemod.Module.RegisterCheat.mods;
import static com.example.examplemod.Module.RegisterCheat.registerCheat;

public class Client {
    public static String name = "LunarFlare 1.12.2";

    public static ClickGuiScreen clickGui;

    public static void startup() {
        Display.setTitle(name + " Player name: " + Minecraft.getMinecraft().getSession().getUsername());

        registerCheat(new BlockReach(), "Block Reach");
        registerCheat(new TriggerBot(), "Trigger Bot");
        registerCheat(new GlowESP(), "Glow ESP");
        registerCheat(new Sprint(), "Sprint");
        registerCheat(new Fly(), "Fly");
        registerCheat(new Panic(), "Panic");
        registerCheat(new FakeCreative(), "Fake Creative");
        registerCheat(new Fullbright(), "Fullbright");
        registerCheat(new Velocity(), "Velocity");
        registerCheat(new Spider(), "Spider");
        registerCheat(new Speed(), "Speed");
        registerCheat(new Jesus(), "Jesus");
        registerCheat(new AirJump(), "Air jump");

        clickGui = new ClickGuiScreen();
    }

    public static void keyPress(int key) {
        for (Map.Entry<Module, String> entry : mods) {
            if (entry.getKey().getKey() == key) {
                entry.getKey().toggle();
            }
        }
    }
}
