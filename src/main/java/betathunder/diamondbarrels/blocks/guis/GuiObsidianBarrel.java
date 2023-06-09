package betathunder.diamondbarrels.blocks.guis;

import betathunder.diamondbarrels.DiamondBarrels;
import betathunder.diamondbarrels.blocks.containers.ContainerObsidianBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityObsidianBarrel;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiObsidianBarrel extends GuiContainer
{
	private static final ResourceLocation GUI_OBSIDIAN_BARREL = new ResourceLocation(DiamondBarrels.MODID + ":textures/gui/diamond_barrel.png");
	//private final InventoryPlayer playerInventory;
	public GuiObsidianBarrel(InventoryPlayer playerInventory, TileEntityObsidianBarrel chestInventory, EntityPlayer player) 
	{
		super(new ContainerObsidianBarrel(playerInventory, chestInventory, player));
		//this.playerInventory = playerInventory;
		this.xSize = 237;
		this.ySize = 256;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		//this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 0);
		this.renderHoveredToolTip(mouseX - guiLeft, mouseY - guiTop);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{	
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_OBSIDIAN_BARREL);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}