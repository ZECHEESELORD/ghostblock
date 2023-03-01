package sh.harold.mods.modules;

import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import sh.harold.mods.RMBGhostBlock;
import sh.harold.mods.events.ClickEvent;
import sh.harold.mods.utils.KeybindRegistration;
import sh.harold.mods.utils.Utils;

public class GhostBlock {
    public static final KeyBinding GKEY = new KeyBinding("Ghost Block", Keyboard.KEY_G, "Harold's QoLs");

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent event) {
        if (!GKEY.isKeyDown()) {
            return;
        }
        MovingObjectPosition object = RMBGhostBlock.mc.thePlayer.rayTrace(RMBGhostBlock.mc.playerController.getBlockReachDistance(), 1.0F);
        if (object != null && object.getBlockPos() != null) {
            Block lookingAtblock = RMBGhostBlock.mc.theWorld.getBlockState(object.getBlockPos()).getBlock();
            if (!Utils.isInteractable(lookingAtblock) && lookingAtblock != Blocks.air) {
                RMBGhostBlock.mc.theWorld.setBlockToAir(object.getBlockPos());
            }
        }

    }

    @SubscribeEvent
    public void onRightClick(ClickEvent.Right event) {
        if (Utils.inSkyblock && Config.stonkGhostBlock && RMBGhostBlock.mc.objectMouseOver != null && RMBGhostBlock.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && !Utils.isInteractable(RMBGhostBlock.mc.theWorld.getBlockState(RMBGhostBlock.mc.objectMouseOver.getBlockPos()).getBlock())) {
            String itemId = Utils.getSkyBlockID(RMBGhostBlock.mc.thePlayer.getHeldItem());
            if (itemId.equals("STONK_PICKAXE") || itemId.equals("GOLD_PICKAXE")) {
                RMBGhostBlock.mc.theWorld.setBlockToAir(RMBGhostBlock.mc.objectMouseOver.getBlockPos());
                event.setCanceled(true);
            }
        }
    }
}
