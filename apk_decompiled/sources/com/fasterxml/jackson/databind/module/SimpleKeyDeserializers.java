package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ClassKey;
import defpackage.a91;
import defpackage.b91;
import defpackage.kh;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SimpleKeyDeserializers implements b91, Serializable {
    private static final long serialVersionUID = 1;
    protected HashMap<ClassKey, a91> _classMappings = null;

    public SimpleKeyDeserializers addDeserializer(Class<?> cls, a91 a91Var) {
        if (this._classMappings == null) {
            this._classMappings = new HashMap<>();
        }
        this._classMappings.put(new ClassKey(cls), a91Var);
        return this;
    }

    @Override // defpackage.b91
    public a91 findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, kh khVar) {
        HashMap<ClassKey, a91> map = this._classMappings;
        if (map == null) {
            return null;
        }
        return map.get(new ClassKey(javaType.getRawClass()));
    }
}
