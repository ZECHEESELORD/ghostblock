package sh.harold.mods.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static boolean invoke(Object object, String methodName) {
        try {
            Method method = object.getClass().getDeclaredMethod(methodName, new Class[0]);
            method.setAccessible(true);
            method.invoke(object, new Object[0]);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static Object field(Object object, String name) {
        try {
            Field field = object.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception exception) {
            return null;
        }
    }

}
