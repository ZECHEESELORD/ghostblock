package sh.harold.mods.utils;

import net.minecraft.client.settings.KeyBinding;
import sh.harold.mods.RMBGhostBlock;

import java.util.HashMap;

public class KeybindRegistration {
    public static HashMap<String, KeyBinding> keyBindings = new HashMap<>();

    public static boolean isPressed(String name) {
        return get(name).isPressed();
    }
    public static void register(String name, int key) {
        keyBindings.put(name, new KeyBinding(name, key, "Harold's QoLs"));
    }
    public static KeyBinding get(String name) {
        return keyBindings.get(name);
    }

    public static void rightClick() {
        if (!ReflectionUtils.invoke(RMBGhostBlock.mc, "func_147121_ag"))
            ReflectionUtils.invoke(RMBGhostBlock.mc, "rightClickMouse");
    }

    public static void leftClick() {
        if (!ReflectionUtils.invoke(RMBGhostBlock.mc, "func_147116_af"))
            ReflectionUtils.invoke(RMBGhostBlock.mc, "clickMouse");
    }

    public static void middleClick() {
        if (!ReflectionUtils.invoke(RMBGhostBlock.mc, "func_147112_ai"))
            ReflectionUtils.invoke(RMBGhostBlock.mc, "middleClickMouse");
    }
}
