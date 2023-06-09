package betathunder.diamondbarrels.blocks.guis;

import betathunder.diamondbarrels.DiamondBarrels;
import betathunder.diamondbarrels.blocks.containers.ContainerWoodBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityWoodBarrel;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiWoodBarrel extends GuiContainer
{
	private static final ResourceLocation GUI_WOOD_BARREL = new ResourceLocation(DiamondBarrels.MODID + ":textures/gui/wood_barrel.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityWoodBarrel te;
	
	public GuiWoodBarrel(InventoryPlayer playerInventory, TileEntityWoodBarrel chestInventory, EntityPlayer player) 
	{
		super(new ContainerWoodBarrel(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 175;
		this.ySize = 165;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 0);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 0);
		this.renderHoveredToolTip(mouseX - guiLeft, mouseY - guiTop);

	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{	
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_WOOD_BARREL);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}