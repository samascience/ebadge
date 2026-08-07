package com.fasterxml.jackson.annotation;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectIdGenerators$IntSequenceGenerator extends ObjectIdGenerators$Base<Integer> {
    private static final long serialVersionUID = 1;
    protected transient int _nextValue;

    public ObjectIdGenerators$IntSequenceGenerator() {
        this(Object.class, -1);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerators$Base, com.fasterxml.jackson.annotation.ObjectIdGenerator
    public /* bridge */ /* synthetic */ boolean canUseFor(ObjectIdGenerator objectIdGenerator) {
        return super.canUseFor(objectIdGenerator);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<Integer> forScope(Class<?> cls) {
        return this._scope == cls ? this : new ObjectIdGenerators$IntSequenceGenerator(cls, this._nextValue);
    }

    protected int initialValue() {
        return 1;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator.IdKey key(Object obj) {
        if (obj == null) {
            return null;
        }
        return new ObjectIdGenerator.IdKey(ObjectIdGenerators$IntSequenceGenerator.class, this._scope, obj);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<Integer> newForSerialization(Object obj) {
        return new ObjectIdGenerators$IntSequenceGenerator(this._scope, initialValue());
    }

    public ObjectIdGenerators$IntSequenceGenerator(Class<?> cls, int i) {
        super(cls);
        this._nextValue = i;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerators$Base, com.fasterxml.jackson.annotation.ObjectIdGenerator
    public Integer generateId(Object obj) {
        if (obj == null) {
            return null;
        }
        int i = this._nextValue;
        this._nextValue = i + 1;
        return Integer.valueOf(i);
    }
}
