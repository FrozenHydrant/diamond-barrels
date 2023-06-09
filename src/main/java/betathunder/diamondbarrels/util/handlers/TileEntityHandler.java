package betathunder.diamondbarrels.util.handlers;

import betathunder.diamondbarrels.DiamondBarrels;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityDiamondBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityIronBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityObsidianBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityWoodBarrel;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityWoodBarrel.class, new ResourceLocation(DiamondBarrels.MODID + ":wood_barrel"));
		GameRegistry.registerTileEntity(TileEntityIronBarrel.class, new ResourceLocation(DiamondBarrels.MODID + ":iron_barrel"));
		GameRegistry.registerTileEntity(TileEntityDiamondBarrel.class, new ResourceLocation(DiamondBarrels.MODID + ":diamond_barrel"));
		GameRegistry.registerTileEntity(TileEntityObsidianBarrel.class, new ResourceLocation(DiamondBarrels.MODID + ":obsidian_barrel"));
	}
}