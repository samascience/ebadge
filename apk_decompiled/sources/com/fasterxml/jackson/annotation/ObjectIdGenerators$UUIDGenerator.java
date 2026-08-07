package com.fasterxml.jackson.annotation;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectIdGenerators$UUIDGenerator extends ObjectIdGenerators$Base<UUID> {
    private static final long serialVersionUID = 1;

    public ObjectIdGenerators$UUIDGenerator() {
        this(Object.class);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerators$Base, com.fasterxml.jackson.annotation.ObjectIdGenerator
    public boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator) {
        return objectIdGenerator.getClass() == ObjectIdGenerators$UUIDGenerator.class;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<UUID> forScope(Class<?> cls) {
        return this;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator.IdKey key(Object obj) {
        if (obj == null) {
            return null;
        }
        return new ObjectIdGenerator.IdKey(ObjectIdGenerators$UUIDGenerator.class, null, obj);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<UUID> newForSerialization(Object obj) {
        return this;
    }

    private ObjectIdGenerators$UUIDGenerator(Class<?> cls) {
        super(Object.class);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerators$Base, com.fasterxml.jackson.annotation.ObjectIdGenerator
    public UUID generateId(Object obj) {
        return UUID.randomUUID();
    }
}
