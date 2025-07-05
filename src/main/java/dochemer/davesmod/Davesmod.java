package dochemer.davesmod;

import dochemer.davesmod.blocks.BlockPorridge;
import dochemer.davesmod.generators.PorridgeGenerator;
import dochemer.davesmod.handlers.FuelHandler;
import dochemer.davesmod.items.ItemKey;
import dochemer.davesmod.items.ItemRacquet;
import dochemer.davesmod.items.ItemTable;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import static scala.Console.print;


@Mod(modid = "DM", version = "1.0")
public class Davesmod {

    public static Item itemTable;
    public static Item itemKey;
    public static Item itemPorridge;
    public static Item itemRacquet;
    public static Block blockPorridge;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        itemTable = new ItemTable().setUnlocalizedName("ItemTable").setTextureName("davesmod:itemtable");
        GameRegistry.registerItem(itemTable, itemTable.getUnlocalizedName().substring(5));
        itemRacquet = new ItemRacquet().setUnlocalizedName("ItemRacquet").setTextureName("davesmod:itemracquet");
        GameRegistry.registerItem(itemRacquet, itemRacquet.getUnlocalizedName().substring(5));
        itemKey = new ItemKey().setUnlocalizedName("ItemKey").setTextureName("davesmod:itemkey");
        GameRegistry.registerItem(itemKey, itemKey.getUnlocalizedName().substring(5));
        itemPorridge = new ItemFood(4, 0.1F, true).setUnlocalizedName("ItemPorridge").setTextureName("davesmod:itemporridge");
        GameRegistry.registerItem(itemPorridge, itemPorridge.getUnlocalizedName().substring(5));
        blockPorridge = new BlockPorridge(Material.cake).setBlockName("BlockPorridge").setBlockTextureName("davesmod:blockporridge");
        GameRegistry.registerBlock(blockPorridge, blockPorridge.getUnlocalizedName().substring(5));
        GameRegistry.registerFuelHandler(new FuelHandler());

        GameRegistry.registerWorldGenerator(new PorridgeGenerator(), 0);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        if(Loader.isModLoaded("ProjectE")) {
            print("WWWWWWWWWWWWWWWWWWWW");
        } else {
            print("EEEEEEEEEEEEEEEEEEEEEEE");
        }

        GameRegistry.addRecipe(new ItemStack(itemTable, 5), new Object[] {
                "XXX",
                " Z ",
                " Z ",
                'X', Items.iron_ingot, 'Z', Items.stick});

        GameRegistry.addRecipe(new ItemStack(itemPorridge, 16), new Object[] {
                "   ",
                "PPP",
                "SSS",
                'P', blockPorridge, 'S', Items.stick});
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }
}
