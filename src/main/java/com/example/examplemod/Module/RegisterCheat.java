package com.example.examplemod.Module;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class RegisterCheat {
    public static ArrayList<Map.Entry<Module, String>> mods = new ArrayList<>();

    public static void registerCheat(Module module, String description) {
        Map.Entry<Module, String> entry = new AbstractMap.SimpleEntry<>(module, description);
        mods.add(entry);
    }
}