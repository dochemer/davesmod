package dochemer.davesmod.handlers;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static dochemer.davesmod.Davesmod.itemTable;

public class FuelHandler implements IFuelHandler {


    @Override
    public int getBurnTime(ItemStack fuel) {
        Item itemFuel = fuel.getItem();
        if (itemFuel == itemTable) {
            return 40000;
        } else {
            return 0;
        }
    }
}
