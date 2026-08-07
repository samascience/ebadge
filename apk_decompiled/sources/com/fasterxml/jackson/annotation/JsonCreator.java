package com.fasterxml.jackson.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonCreator {

    public enum Mode {
        DEFAULT,
        DELEGATING,
        PROPERTIES,
        DISABLED
    }

    Mode mode() default Mode.DEFAULT;
}
