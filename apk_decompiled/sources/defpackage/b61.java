package defpackage;

import com.fasterxml.jackson.annotation.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface b61 {
    Class generator();

    String property() default "@id";

    Class resolver() default b.class;

    Class scope() default Object.class;
}
