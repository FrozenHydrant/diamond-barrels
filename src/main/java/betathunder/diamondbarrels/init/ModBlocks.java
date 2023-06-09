package betathunder.diamondbarrels.init;

import java.util.List;

import betathunder.diamondbarrels.blocks.BlockDiamondBarrel;
import betathunder.diamondbarrels.blocks.BlockIronBarrel;
import betathunder.diamondbarrels.blocks.BlockObsidianBarrel;
import betathunder.diamondbarrels.blocks.BlockWoodBarrel;

import java.util.ArrayList;

import net.minecraft.block.Block;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block WOOD_BARREL = new BlockWoodBarrel("wood_barrel");
	public static final Block IRON_BARREL = new BlockIronBarrel("iron_barrel");
	public static final Block DIAMOND_BARREL = new BlockDiamondBarrel("diamond_barrel");
	public static final Block OBSIDIAN_BARREL = new BlockObsidianBarrel("obsidian_barrel");
}


