package sh.harold.mods.utils;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.scoreboard.ScoreObjective;
import sh.harold.mods.RMBGhostBlock;
import sh.harold.mods.events.TickEndEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    public static boolean inSkyblock = false;
    public static boolean inDungeon = false;

    private int ticks = 0;

    public static String getSkyBlockID(ItemStack item) {
        if (item != null) {
            NBTTagCompound extraAttributes = item.getSubCompound("ExtraAttributes", false);
            if (extraAttributes != null && extraAttributes.hasKey("id"))
                return extraAttributes.getString("id");
        }
        return "";
    }

    public static String removeFormatting(String input) {
        return input.replaceAll("§[0-9a-fk-or]", "");
    }

    public static boolean isInteractable(Block block) {
        return (new ArrayList(Arrays.asList((Object[]) new Block[] { (Block) Blocks.chest, Blocks.lever, Blocks.trapped_chest, Blocks.wooden_button, Blocks.stone_button, (Block)Blocks.skull }))).contains(block);
    }

    @SubscribeEvent
    public void onTick(TickEndEvent event) {
        if (this.ticks % 20 == 0) {
            if (RMBGhostBlock.mc.thePlayer != null && RMBGhostBlock.mc.theWorld != null) {
                ScoreObjective scoreboardObj = RMBGhostBlock.mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
                if (scoreboardObj != null)
                    inSkyblock = removeFormatting(scoreboardObj.getDisplayName()).contains("SKYBLOCK");
                inDungeon = ((inSkyblock && ScoreboardUtils.scoreboardContains("The Catacombs") && !ScoreboardUtils.scoreboardContains("Queue")) || ScoreboardUtils.scoreboardContains("Dungeon Cleared"));
            }
            this.ticks = 0;
        }
        this.ticks++;
    }
}
