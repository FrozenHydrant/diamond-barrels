package betathunder.diamondbarrels.blocks.tileentities;

import betathunder.diamondbarrels.DiamondBarrels;
import betathunder.diamondbarrels.blocks.containers.ContainerObsidianBarrel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityObsidianBarrel extends TileEntityLockableLoot implements ITickable
{
	private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>withSize(108, ItemStack.EMPTY);
	
	@Override
	public int getSizeInventory()
	{
		return 108;
	}
	
	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	@Override
	public boolean isEmpty()
	{
		for(ItemStack stack : this.chestContents)
		{
			if(!stack.isEmpty()) return false;
		}
		
		return true;
	}
	
	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.customName : "container.obsidian_barrel";
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.chestContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		
		if(!this.checkLootAndRead(compound)) ItemStackHelper.loadAllItems(compound, chestContents);
		if(compound.hasKey("CustomName", 8)) this.customName = compound.getString("CustomName");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		if(!this.checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, chestContents);
		if(compound.hasKey("CustomName", 8)) compound.setString("CustomName", this.customName);
		
		return compound;
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) 
	{
		return new ContainerObsidianBarrel(playerInventory, this, playerIn);
	}
	
	@Override
	public String getGuiID() 
	{
		return DiamondBarrels.MODID + ":diamond_barrel";
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() 
	{
		return this.chestContents;
	}
	
	@Override
	public void update()
	{

	}
	
	@Override
	public void openInventory(EntityPlayer player)
	{
		this.world.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
	}
	
	@Override
	public void closeInventory(EntityPlayer player) 
	{
		this.world.playSound(null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
	}	
}