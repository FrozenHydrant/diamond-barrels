package betathunder.diamondbarrels.blocks.guis;

import betathunder.diamondbarrels.DiamondBarrels;
import betathunder.diamondbarrels.blocks.containers.ContainerIronBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityIronBarrel;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiIronBarrel extends GuiContainer
{
	private static final ResourceLocation GUI_IRON_BARREL = new ResourceLocation(DiamondBarrels.MODID + ":textures/gui/iron_barrel.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityIronBarrel te;
	
	public GuiIronBarrel(InventoryPlayer playerInventory, TileEntityIronBarrel tileEntityIronBarrel, EntityPlayer player) 
	{
		super(new ContainerIronBarrel(playerInventory, tileEntityIronBarrel, player));
		this.playerInventory = playerInventory;
		this.te = tileEntityIronBarrel;
		
		this.xSize = 175;
		this.ySize = 221;
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
		this.mc.getTextureManager().bindTexture(GUI_IRON_BARREL);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}