package net.sqdmc.murderousmobs.utils;

import org.bukkit.Material;

/**
 * Created by Matt on 11/22/2014.
 */
public class UtilTools {

    public static boolean isAPick(Material mat){
        switch (mat) {
            case WOOD_PICKAXE:
            case STONE_PICKAXE:
            case IRON_PICKAXE:
            case GOLD_PICKAXE:
            case DIAMOND_PICKAXE:
                return true;
            default:
                return false;
        }
    }

    public static boolean isASpade(Material mat){
        switch (mat) {
            case WOOD_SPADE:
            case STONE_SPADE:
            case IRON_SPADE:
            case GOLD_SPADE:
            case DIAMOND_SPADE:
                return true;
            default:
                return false;
        }
    }

    public static boolean isAnAxe(Material mat) {
        switch (mat) {
            case WOOD_AXE:
            case STONE_AXE:
            case IRON_AXE:
            case GOLD_AXE:
            case DIAMOND_AXE:
                return true;
            default:
                return false;
        }
    }

    public static boolean isASword(Material mat) {
        switch (mat) {
            case WOOD_SWORD:
            case STONE_SWORD:
            case IRON_SWORD:
            case GOLD_SWORD:
            case DIAMOND_SWORD:
                return true;
            default:
                return false;
        }
    }
}
