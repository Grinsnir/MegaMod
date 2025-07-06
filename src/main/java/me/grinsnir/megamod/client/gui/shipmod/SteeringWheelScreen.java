package me.grinsnir.megamod.client.gui.shipmod;


import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;


public class SteeringWheelScreen extends Screen {

    // Pfad zu deinem GUI Hintergrund (falls du einen Hintergrund möchtest)
    //private static final ResourceLocation TEXTURE = new ResourceLocation("megamod", "textures/gui/steering_wheel_gui.png");

    public SteeringWheelScreen() {
        super(Component.literal("Steering Wheel"));
    }

    @Override
    protected void init() {
        super.init();

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Button: Activate Ship
        this.addRenderableWidget(
                Button.builder(Component.literal("Activate Ship"), button -> {
                    // TODO: Send ActivateShipPacket
                }).pos(centerX - 50, centerY - 30).size(100, 20).build()
        );

        // Button: Deactivate Ship
        this.addRenderableWidget(
                Button.builder(Component.literal("Deactivate Ship"), button -> {
                    // TODO: Send DeactivateShipPacket
                }).pos(centerX - 50, centerY).size(100, 20).build()
        );

        // Button: Align to Grid
        this.addRenderableWidget(
                Button.builder(Component.literal("Align to Grid"), button -> {
                    // TODO: Send AlignShipPacket
                }).pos(centerX - 50, centerY + 30).size(100, 20).build()
        );
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        // Hintergrund zeichnen, falls du eine Textur nutzt
        //RenderSystem.setShaderTexture(0, TEXTURE);
        // guiGraphics.blit(TEXTURE, ...); // implementiere bei Bedarf

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
