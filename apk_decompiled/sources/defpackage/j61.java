package defpackage;

import com.fasterxml.jackson.annotation.OptBoolean;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface j61 {
    OptBoolean value() default OptBoolean.TRUE;
}
