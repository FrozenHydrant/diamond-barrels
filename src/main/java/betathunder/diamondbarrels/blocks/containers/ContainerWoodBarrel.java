package betathunder.diamondbarrels.blocks.containers;

import betathunder.diamondbarrels.blocks.tileentities.TileEntityWoodBarrel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerWoodBarrel extends Container {
    private final int numRows;
    private final int numCols = 9;
    private final TileEntityWoodBarrel chestInventory;

    public ContainerWoodBarrel(InventoryPlayer playerInv, TileEntityWoodBarrel tileEntityWoodBarrel, EntityPlayer player) {
        this.chestInventory = tileEntityWoodBarrel;
        this.numRows = tileEntityWoodBarrel.getSizeInventory() / this.numCols;
        tileEntityWoodBarrel.openInventory(player);

        //CHEST
        for (int i = 0; i < this.numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                this.addSlotToContainer(new Slot(tileEntityWoodBarrel, j + i * numCols, 8 + j * 18, 18 + i * 18));
            }
        }

        //INVENTORY
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        //HOTBAR
        for (int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.chestInventory.isUsableByPlayer(playerIn);
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        chestInventory.closeInventory(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        Slot slot = this.inventorySlots.get(index);

        if (slot == null || !slot.getHasStack()) {
            return ItemStack.EMPTY;
        }

        ItemStack itemstack1 = slot.getStack();

        // CLICKED ITEM IN CHEST
        if (index < this.numRows * numCols) {
            if (!this.mergeItemStack(itemstack1, this.numRows * numCols, this.inventorySlots.size(), true)) {
                return ItemStack.EMPTY;
            }
        }

        // CLICKED ITEM IN INVENTORY
        else {
            if (!this.mergeItemStack(itemstack1, 0, this.numRows * numCols, false)) {
                return ItemStack.EMPTY;
            }
        }

        // IF ITEM ACTUALLY MOVED, CALL ONSLOTCHANGED
        if (!itemstack1.isEmpty()) {
            slot.onSlotChanged();
        } else {
            slot.putStack(ItemStack.EMPTY);
        }

        return itemstack1;
    }

    public TileEntityWoodBarrel getChestInventory() {
        return this.chestInventory;
    }
}