package com.fasterxml.jackson.databind.annotation;

import defpackage.f40;
import defpackage.f71;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSerialize {

    @Deprecated
    public enum Inclusion {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT,
        NON_EMPTY,
        DEFAULT_INCLUSION
    }

    public enum Typing {
        DYNAMIC,
        STATIC,
        DEFAULT_TYPING
    }

    Class as() default Void.class;

    Class contentAs() default Void.class;

    Class contentConverter() default f40.a.class;

    Class contentUsing() default f71.a.class;

    Class converter() default f40.a.class;

    Inclusion include() default Inclusion.DEFAULT_INCLUSION;

    Class keyAs() default Void.class;

    Class keyUsing() default f71.a.class;

    Class nullsUsing() default f71.a.class;

    Typing typing() default Typing.DEFAULT_TYPING;

    Class using() default f71.a.class;
}
