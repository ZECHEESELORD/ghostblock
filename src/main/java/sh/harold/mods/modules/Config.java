package sh.harold.mods.modules;

import sh.harold.mods.utils.Property;

public class Config {

    @Property(type = Property.Type.FOLDER, name = "Keybinds")
    public static boolean keybinds = false;

    @Property(type = Property.Type.BOOLEAN, name = "Ghost Blocks", parent = "Keybinds")
    public static boolean ghostBlockKeybind = false;

    @Property(type = Property.Type.BOOLEAN, name = "Right-Click w/ Stonk", parent = "Ghost Blocks")
    public static boolean stonkGhostBlock = false;
}
