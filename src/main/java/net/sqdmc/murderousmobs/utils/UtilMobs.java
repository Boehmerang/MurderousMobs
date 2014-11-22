package net.sqdmc.murderousmobs.utils;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

/**
 * Created by Matt on 11/22/2014.
 */
public class UtilMobs {


    public static ItemStack getRandomWeapon(Random ran) {
        int a = ran.nextInt(4);
        int b = ran.nextInt(4);
        switch(a){
            case 0: //Bows
                return new ItemStack(Material.BOW);
            case 1:  //Swords
                switch(b){
                    case 0:
                        return new ItemStack(Material.WOOD_SWORD);
                    case 1:
                        return new ItemStack(Material.STONE_SWORD);
                    case 2:
                        return new ItemStack(Material.IRON_SWORD);
                    case 3:
                        return new ItemStack(Material.GOLD_SWORD);
                    case 4:
                        return new ItemStack(Material.DIAMOND_SWORD);
                    default:
                        return new ItemStack(Material.WOOD_SWORD);
                }
            case 2: // Axes
                switch(b){
                    case 0:
                        return new ItemStack(Material.WOOD_AXE);
                    case 1:
                        return new ItemStack(Material.STONE_AXE);
                    case 2:
                        return new ItemStack(Material.IRON_AXE);
                    case 3:
                        return new ItemStack(Material.GOLD_AXE);
                    case 4:
                        return new ItemStack(Material.DIAMOND_AXE);
                    default:
                        return new ItemStack(Material.WOOD_AXE);
                }
            case 3: // Picks
                switch(b){
                    case 0:
                        return new ItemStack(Material.WOOD_PICKAXE);
                    case 1:
                        return new ItemStack(Material.STONE_PICKAXE);
                    case 2:
                        return new ItemStack(Material.IRON_PICKAXE);
                    case 3:
                        return new ItemStack(Material.GOLD_PICKAXE);
                    case 4:
                        return new ItemStack(Material.DIAMOND_PICKAXE);
                    default:
                        return new ItemStack(Material.WOOD_PICKAXE);
                }
            case 4: // Spades
                switch(b){
                    case 0:
                        return new ItemStack(Material.WOOD_SPADE);
                    case 1:
                        return new ItemStack(Material.STONE_SPADE);
                    case 2:
                        return new ItemStack(Material.IRON_SPADE);
                    case 3:
                        return new ItemStack(Material.GOLD_SPADE);
                    case 4:
                        return new ItemStack(Material.DIAMOND_SPADE);
                    default:
                        return new ItemStack(Material.WOOD_SPADE);
                }
            default:
                return new ItemStack(Material.WOOD_SWORD);
        }
    }
}
