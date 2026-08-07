package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface r71 {
    boolean enabled() default true;

    String prefix() default "";

    String suffix() default "";
}
