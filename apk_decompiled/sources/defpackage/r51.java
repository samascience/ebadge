package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface r51 {
    Class as() default Void.class;

    Class builder() default Void.class;

    Class contentAs() default Void.class;

    Class contentConverter() default f40.a.class;

    Class contentUsing() default s51.a.class;

    Class converter() default f40.a.class;

    Class keyAs() default Void.class;

    Class keyUsing() default a91.a.class;

    Class using() default s51.a.class;
}
