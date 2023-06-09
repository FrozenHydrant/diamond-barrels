package betathunder.diamondbarrels.util.handlers;

import betathunder.diamondbarrels.DiamondBarrels;
import betathunder.diamondbarrels.blocks.containers.ContainerDiamondBarrel;
import betathunder.diamondbarrels.blocks.containers.ContainerIronBarrel;
import betathunder.diamondbarrels.blocks.containers.ContainerObsidianBarrel;
import betathunder.diamondbarrels.blocks.containers.ContainerWoodBarrel;
import betathunder.diamondbarrels.blocks.guis.GuiDiamondBarrel;
import betathunder.diamondbarrels.blocks.guis.GuiIronBarrel;
import betathunder.diamondbarrels.blocks.guis.GuiObsidianBarrel;
import betathunder.diamondbarrels.blocks.guis.GuiWoodBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityDiamondBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityIronBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityObsidianBarrel;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityWoodBarrel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == DiamondBarrels.GUI_WOOD_BARREL) return new ContainerWoodBarrel(player.inventory, (TileEntityWoodBarrel)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == DiamondBarrels.GUI_IRON_BARREL) return new ContainerIronBarrel(player.inventory, (TileEntityIronBarrel)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == DiamondBarrels.GUI_DIAMOND_BARREL) return new ContainerDiamondBarrel(player.inventory, (TileEntityDiamondBarrel)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == DiamondBarrels.GUI_OBSIDIAN_BARREL) return new ContainerObsidianBarrel(player.inventory, (TileEntityObsidianBarrel)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == DiamondBarrels.GUI_WOOD_BARREL) return new GuiWoodBarrel(player.inventory, (TileEntityWoodBarrel)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == DiamondBarrels.GUI_IRON_BARREL) return new GuiIronBarrel(player.inventory, (TileEntityIronBarrel)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == DiamondBarrels.GUI_DIAMOND_BARREL) return new GuiDiamondBarrel(player.inventory, (TileEntityDiamondBarrel)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == DiamondBarrels.GUI_OBSIDIAN_BARREL) return new GuiObsidianBarrel(player.inventory, (TileEntityObsidianBarrel)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
	}
}