package fr.aluny.gameapi.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {

    String name();

    String permission() default "";

    String[] aliases() default { };

}
