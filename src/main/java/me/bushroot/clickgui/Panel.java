package me.bushroot.clickgui;


import com.example.examplemod.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.examplemod.Module.RegisterCheat;

public class Panel {
    public Minecraft mc = Minecraft.getMinecraft();

    public int x, y, width, height, dragY, dragX;
    public boolean extended, dragging;
    public Module.Category category;

    public List<me.bushroot.clickgui.Button> buttons = new ArrayList<>();

    public Panel(int x, int y, int width, int height, Module.Category category) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.category = category;

        int y1 = y + height;

        for (Map.Entry<Module, String> module : RegisterCheat.mods) {
            if (module.getKey().category == category) {
                buttons.add(new me.bushroot.clickgui.Button(x, y1, width, height, module.getKey()));
                y1 += height;
            }
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks, int size) {
        if (dragging) {
            x = mouseX - dragX;
            y = mouseY - dragY;
        }

        Gui.drawRect(x, y, x + width, y + height, new Color(0, 0, 0, 155).getRGB());
        drawOutline(x, y, x + width, y + height, 1, 0xFF000000);

        mc.fontRenderer.drawStringWithShadow(category.name(), x + width / 2 - mc.fontRenderer.getStringWidth(category.name()) / 2, y + height / 2 - 9 / 2, -1);

        if (extended) {
            int y1 = y + height;
            for (me.bushroot.clickgui.Button button : buttons) {
                button.x = x;
                button.y = y1;

                y1 += height;

                button.drawScreen(mouseX, mouseY, partialTicks);
                button.drawTooltip(mouseX, mouseY);
            }
        }
    }

    // Helper method to draw an outline around a rectangle
    private void drawOutline(int x1, int y1, int x2, int y2, int thickness, int color) {
        Gui.drawRect(x1 - thickness, y1 - thickness, x2 + thickness, y1, color);
        Gui.drawRect(x1 - thickness, y2, x2 + thickness, y2 + thickness, color);
        Gui.drawRect(x1 - thickness, y1, x1, y2, color);
        Gui.drawRect(x2, y1, x2 + thickness, y2, color);
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (extended) {
            for (me.bushroot.clickgui.Button button : buttons) {
                button.keyTyped(typedChar, keyCode);
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (HoverUtils.hovered(mouseX, mouseY, x, y, x + width, y + height)) {
            if (mouseButton == 0) {
                dragX = mouseX - x;
                dragY = mouseY - y;
                dragging = true;
            } else if (mouseButton == 1) {
                extended = !extended;
            }
        }

        if (extended) {
            for (me.bushroot.clickgui.Button button : buttons) {
                button.mouseClicked(mouseX, mouseY, mouseButton);
            }
        }
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        dragging = false;

        if (extended) {
            for (me.bushroot.clickgui.Button button : buttons) {
                button.mouseReleased(mouseX, mouseY, state);
            }
        }
    }
}
