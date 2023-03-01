package sh.harold.mods.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited

public @interface Property {
    Type type();

    String name() default "";

    String parent() default "";

    String note() default "";

    boolean warning() default false;

    boolean beta() default false;

    String button() default "";

    int step() default 1;

    String prefix() default "";

    String suffix() default "";

    int min() default 0;

    int max() default 2147483647;

    String[] options() default {};

    public enum Type {
        BOOLEAN, FOLDER, NUMBER, SELECT, CHECKBOX, BUTTON, SPACER;
    }
}
