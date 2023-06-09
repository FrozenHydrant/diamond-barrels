package betathunder.diamondbarrels.blocks;

import betathunder.diamondbarrels.DiamondBarrels;
import betathunder.diamondbarrels.blocks.tileentities.TileEntityWoodBarrel;
import betathunder.diamondbarrels.init.ModBlocks;
import betathunder.diamondbarrels.init.ModItems;
import betathunder.diamondbarrels.util.IHasModel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWoodBarrel extends BlockContainer implements IHasModel {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockWoodBarrel(String name) {
        super(Material.WOOD);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.DECORATIONS);

        setSoundType(SoundType.WOOD);
        setHardness(2.5F);
        setResistance(12.5F);
        setHarvestLevel("axe", -1);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(DiamondBarrels.instance, DiamondBarrels.GUI_WOOD_BARREL, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntityWoodBarrel tileentity = (TileEntityWoodBarrel) worldIn.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        this.setDefaultDirection(worldIn, pos, state);
    }

    private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            EnumFacing enumfacing = state.getValue(FACING);
            //boolean flag = worldIn.getBlockState(pos.north()).isFullBlock();
            //boolean flag1 = worldIn.getBlockState(pos.south()).isFullBlock();

            if (enumfacing == EnumFacing.NORTH) {
                enumfacing = EnumFacing.SOUTH;
            } else if (enumfacing == EnumFacing.SOUTH) {
                enumfacing = EnumFacing.NORTH;
            } else if (enumfacing == EnumFacing.WEST) {
                enumfacing = EnumFacing.EAST;
            } else if (enumfacing == EnumFacing.EAST) {
                enumfacing = EnumFacing.WEST;
            }


            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing));
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()));

        if (stack.hasDisplayName()) {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityWoodBarrel) {
                ((TileEntityWoodBarrel) tileentity).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityWoodBarrel();
    }


    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void registerModels() {
        DiamondBarrels.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }


    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

}
	
	
