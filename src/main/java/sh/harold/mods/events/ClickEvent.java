package sh.harold.mods.events;

import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ClickEvent extends Event {
    public static class Right extends ClickEvent {}
    public static class Left extends ClickEvent {}
    public static class Middle extends ClickEvent {}
}
