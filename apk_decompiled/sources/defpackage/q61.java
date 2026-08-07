package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface q61 {

    public static class a {
        public final String a;
        public final String b;

        public a(q61 q61Var) {
            this(q61Var.buildMethodName(), q61Var.withPrefix());
        }

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    String buildMethodName() default "build";

    String withPrefix() default "with";
}
