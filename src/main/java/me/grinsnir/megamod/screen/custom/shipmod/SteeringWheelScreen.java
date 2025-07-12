package me.grinsnir.megamod.screen.custom.shipmod;

import com.mojang.blaze3d.systems.RenderSystem;
import me.grinsnir.megamod.MegaMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SteeringWheelScreen extends AbstractContainerScreen<SteeringWheelMenu> {

    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(MegaMod.MOD_ID, "textures/gui/steering_wheel/steering_wheel_gui.png");

    public SteeringWheelScreen(SteeringWheelMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        //Shader & int always the same
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) /2;

        //if texture-.png bigger than 256x256, like 512x512:
        //guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 512, 512);
        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);
    }
}
