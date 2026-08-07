package com.google.gson;

import defpackage.l61;
import defpackage.u51;
import defpackage.v61;

/* JADX INFO: loaded from: classes3.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public u51 serialize(Long l) {
            return l == null ? l61.a : new v61(l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public u51 serialize(Long l) {
            return l == null ? l61.a : new v61(l.toString());
        }
    };

    public abstract u51 serialize(Long l);
}
