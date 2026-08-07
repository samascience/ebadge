package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import defpackage.b91;
import defpackage.cb3;
import defpackage.mh;
import defpackage.p9;
import defpackage.q90;
import defpackage.r1;
import defpackage.s9;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class DeserializerFactoryConfig implements Serializable {
    private static final long serialVersionUID = 1;
    protected final r1[] _abstractTypeResolvers;
    protected final q90[] _additionalDeserializers;
    protected final b91[] _additionalKeyDeserializers;
    protected final mh[] _modifiers;
    protected final cb3[] _valueInstantiators;
    protected static final q90[] NO_DESERIALIZERS = new q90[0];
    protected static final mh[] NO_MODIFIERS = new mh[0];
    protected static final r1[] NO_ABSTRACT_TYPE_RESOLVERS = new r1[0];
    protected static final cb3[] NO_VALUE_INSTANTIATORS = new cb3[0];
    protected static final b91[] DEFAULT_KEY_DESERIALIZERS = {new StdKeyDeserializers()};

    public DeserializerFactoryConfig() {
        this(null, null, null, null, null);
    }

    public Iterable<r1> abstractTypeResolvers() {
        return new s9(this._abstractTypeResolvers);
    }

    public Iterable<mh> deserializerModifiers() {
        return new s9(this._modifiers);
    }

    public Iterable<q90> deserializers() {
        return new s9(this._additionalDeserializers);
    }

    public boolean hasAbstractTypeResolvers() {
        return this._abstractTypeResolvers.length > 0;
    }

    public boolean hasDeserializerModifiers() {
        return this._modifiers.length > 0;
    }

    public boolean hasDeserializers() {
        return this._additionalDeserializers.length > 0;
    }

    public boolean hasKeyDeserializers() {
        return this._additionalKeyDeserializers.length > 0;
    }

    public boolean hasValueInstantiators() {
        return this._valueInstantiators.length > 0;
    }

    public Iterable<b91> keyDeserializers() {
        return new s9(this._additionalKeyDeserializers);
    }

    public Iterable<cb3> valueInstantiators() {
        return new s9(this._valueInstantiators);
    }

    public DeserializerFactoryConfig withAbstractTypeResolver(r1 r1Var) {
        if (r1Var == null) {
            throw new IllegalArgumentException("Cannot pass null resolver");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, (r1[]) p9.j(this._abstractTypeResolvers, r1Var), this._valueInstantiators);
    }

    public DeserializerFactoryConfig withAdditionalDeserializers(q90 q90Var) {
        if (q90Var != null) {
            return new DeserializerFactoryConfig((q90[]) p9.j(this._additionalDeserializers, q90Var), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
        }
        throw new IllegalArgumentException("Cannot pass null Deserializers");
    }

    public DeserializerFactoryConfig withAdditionalKeyDeserializers(b91 b91Var) {
        if (b91Var == null) {
            throw new IllegalArgumentException("Cannot pass null KeyDeserializers");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, (b91[]) p9.j(this._additionalKeyDeserializers, b91Var), this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
    }

    public DeserializerFactoryConfig withDeserializerModifier(mh mhVar) {
        throw new IllegalArgumentException("Cannot pass null modifier");
    }

    public DeserializerFactoryConfig withValueInstantiators(cb3 cb3Var) {
        if (cb3Var == null) {
            throw new IllegalArgumentException("Cannot pass null resolver");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, (cb3[]) p9.j(this._valueInstantiators, cb3Var));
    }

    protected DeserializerFactoryConfig(q90[] q90VarArr, b91[] b91VarArr, mh[] mhVarArr, r1[] r1VarArr, cb3[] cb3VarArr) {
        this._additionalDeserializers = q90VarArr == null ? NO_DESERIALIZERS : q90VarArr;
        this._additionalKeyDeserializers = b91VarArr == null ? DEFAULT_KEY_DESERIALIZERS : b91VarArr;
        this._modifiers = mhVarArr == null ? NO_MODIFIERS : mhVarArr;
        this._abstractTypeResolvers = r1VarArr == null ? NO_ABSTRACT_TYPE_RESOLVERS : r1VarArr;
        this._valueInstantiators = cb3VarArr == null ? NO_VALUE_INSTANTIATORS : cb3VarArr;
    }
}
