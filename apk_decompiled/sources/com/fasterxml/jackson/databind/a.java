package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import defpackage.an2;
import defpackage.z63;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0067a implements a {
        public boolean isEmpty(an2 an2Var) {
            return false;
        }
    }

    void serialize(JsonGenerator jsonGenerator, an2 an2Var);

    void serializeWithType(JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var);
}
