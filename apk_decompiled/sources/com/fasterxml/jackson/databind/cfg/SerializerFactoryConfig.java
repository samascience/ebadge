package com.fasterxml.jackson.databind.cfg;

import defpackage.bn2;
import defpackage.oh;
import defpackage.p9;
import defpackage.s9;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class SerializerFactoryConfig implements Serializable {
    private static final long serialVersionUID = 1;
    protected final bn2[] _additionalKeySerializers;
    protected final bn2[] _additionalSerializers;
    protected final oh[] _modifiers;
    protected static final bn2[] NO_SERIALIZERS = new bn2[0];
    protected static final oh[] NO_MODIFIERS = new oh[0];

    public SerializerFactoryConfig() {
        this(null, null, null);
    }

    public boolean hasKeySerializers() {
        return this._additionalKeySerializers.length > 0;
    }

    public boolean hasSerializerModifiers() {
        return this._modifiers.length > 0;
    }

    public boolean hasSerializers() {
        return this._additionalSerializers.length > 0;
    }

    public Iterable<bn2> keySerializers() {
        return new s9(this._additionalKeySerializers);
    }

    public Iterable<oh> serializerModifiers() {
        return new s9(this._modifiers);
    }

    public Iterable<bn2> serializers() {
        return new s9(this._additionalSerializers);
    }

    public SerializerFactoryConfig withAdditionalKeySerializers(bn2 bn2Var) {
        if (bn2Var == null) {
            throw new IllegalArgumentException("Cannot pass null Serializers");
        }
        return new SerializerFactoryConfig(this._additionalSerializers, (bn2[]) p9.j(this._additionalKeySerializers, bn2Var), this._modifiers);
    }

    public SerializerFactoryConfig withAdditionalSerializers(bn2 bn2Var) {
        if (bn2Var != null) {
            return new SerializerFactoryConfig((bn2[]) p9.j(this._additionalSerializers, bn2Var), this._additionalKeySerializers, this._modifiers);
        }
        throw new IllegalArgumentException("Cannot pass null Serializers");
    }

    public SerializerFactoryConfig withSerializerModifier(oh ohVar) {
        throw new IllegalArgumentException("Cannot pass null modifier");
    }

    protected SerializerFactoryConfig(bn2[] bn2VarArr, bn2[] bn2VarArr2, oh[] ohVarArr) {
        this._additionalSerializers = bn2VarArr == null ? NO_SERIALIZERS : bn2VarArr;
        this._additionalKeySerializers = bn2VarArr2 == null ? NO_SERIALIZERS : bn2VarArr2;
        this._modifiers = ohVarArr == null ? NO_MODIFIERS : ohVarArr;
    }
}
