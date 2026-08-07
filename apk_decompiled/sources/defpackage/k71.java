package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface k71 {

    public @interface a {
        String name() default "";

        String[] names() default {};

        Class value();
    }

    boolean failOnRepeatedNames() default false;

    a[] value();
}
