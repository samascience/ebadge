package defpackage;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface k61 {
    Class value() default PropertyNamingStrategy.class;
}
