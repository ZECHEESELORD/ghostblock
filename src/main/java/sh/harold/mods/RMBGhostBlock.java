package sh.harold.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sh.harold.mods.events.TickEndEvent;
import sh.harold.mods.modules.GhostBlock;
import sh.harold.mods.utils.Utils;

import java.io.File;

import static sh.harold.mods.modules.GhostBlock.GKEY;

@Mod(modid = RMBGhostBlock.MODID, version = RMBGhostBlock.VERSION)
public class RMBGhostBlock
{
    public static final String MODID = "autogg";
    public static final String VERSION = "1.0";

    public static final Minecraft mc = Minecraft.getMinecraft();
    public static final File dir = new File(new File(mc.mcDataDir, "config"), "harold");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if (!dir.exists())
            dir.mkdirs();
        //ClientCommandHandler.instance.registerCommand((ICommand)new MainCommand());
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientRegistry.registerKeyBinding(GKEY);
        MinecraftForge.EVENT_BUS.register(new TickEndEvent());
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Utils());
        MinecraftForge.EVENT_BUS.register(new GhostBlock());

		// some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
