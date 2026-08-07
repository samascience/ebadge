package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import defpackage.a91;
import defpackage.f71;
import defpackage.mh;
import defpackage.oh;
import defpackage.s51;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class SimpleModule extends c implements Serializable {
    private static final AtomicInteger MODULE_ID_SEQ = new AtomicInteger(1);
    private static final long serialVersionUID = 1;
    protected SimpleAbstractTypeResolver _abstractTypes;
    protected mh _deserializerModifier;
    protected SimpleDeserializers _deserializers;
    protected final boolean _hasExplicitName;
    protected SimpleKeyDeserializers _keyDeserializers;
    protected SimpleSerializers _keySerializers;
    protected HashMap<Class<?>, Class<?>> _mixins;
    protected final String _name;
    protected PropertyNamingStrategy _namingStrategy;
    protected oh _serializerModifier;
    protected SimpleSerializers _serializers;
    protected LinkedHashSet<NamedType> _subtypes;
    protected SimpleValueInstantiators _valueInstantiators;
    protected final Version _version;

    public SimpleModule() {
        String name;
        this._serializers = null;
        this._deserializers = null;
        this._keySerializers = null;
        this._keyDeserializers = null;
        this._abstractTypes = null;
        this._valueInstantiators = null;
        this._mixins = null;
        this._subtypes = null;
        this._namingStrategy = null;
        if (getClass() == SimpleModule.class) {
            name = "SimpleModule-" + MODULE_ID_SEQ.getAndIncrement();
        } else {
            name = getClass().getName();
        }
        this._name = name;
        this._version = Version.unknownVersion();
        this._hasExplicitName = false;
    }

    protected void _checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("Cannot pass `null` as %s", str));
        }
    }

    public <T> SimpleModule addAbstractTypeMapping(Class<T> cls, Class<? extends T> cls2) {
        _checkNotNull(cls, "abstract type to map");
        _checkNotNull(cls2, "concrete type to map to");
        if (this._abstractTypes == null) {
            this._abstractTypes = new SimpleAbstractTypeResolver();
        }
        this._abstractTypes = this._abstractTypes.addMapping(cls, cls2);
        return this;
    }

    public <T> SimpleModule addDeserializer(Class<T> cls, s51 s51Var) {
        _checkNotNull(cls, "type to register deserializer for");
        _checkNotNull(s51Var, "deserializer");
        if (this._deserializers == null) {
            this._deserializers = new SimpleDeserializers();
        }
        this._deserializers.addDeserializer(cls, s51Var);
        return this;
    }

    public SimpleModule addKeyDeserializer(Class<?> cls, a91 a91Var) {
        _checkNotNull(cls, "type to register key deserializer for");
        _checkNotNull(a91Var, "key deserializer");
        if (this._keyDeserializers == null) {
            this._keyDeserializers = new SimpleKeyDeserializers();
        }
        this._keyDeserializers.addDeserializer(cls, a91Var);
        return this;
    }

    public <T> SimpleModule addKeySerializer(Class<? extends T> cls, f71 f71Var) {
        _checkNotNull(cls, "type to register key serializer for");
        _checkNotNull(f71Var, "key serializer");
        if (this._keySerializers == null) {
            this._keySerializers = new SimpleSerializers();
        }
        this._keySerializers.addSerializer(cls, f71Var);
        return this;
    }

    public SimpleModule addSerializer(f71 f71Var) {
        _checkNotNull(f71Var, "serializer");
        if (this._serializers == null) {
            this._serializers = new SimpleSerializers();
        }
        this._serializers.addSerializer(f71Var);
        return this;
    }

    public SimpleModule addValueInstantiator(Class<?> cls, ValueInstantiator valueInstantiator) {
        _checkNotNull(cls, "class to register value instantiator for");
        _checkNotNull(valueInstantiator, "value instantiator");
        if (this._valueInstantiators == null) {
            this._valueInstantiators = new SimpleValueInstantiators();
        }
        this._valueInstantiators = this._valueInstantiators.addValueInstantiator(cls, valueInstantiator);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.c
    public String getModuleName() {
        return this._name;
    }

    @Override // com.fasterxml.jackson.databind.c
    public Object getTypeId() {
        if (!this._hasExplicitName && getClass() != SimpleModule.class) {
            return super.getTypeId();
        }
        return this._name;
    }

    public SimpleModule registerSubtypes(Class<?>... clsArr) {
        if (this._subtypes == null) {
            this._subtypes = new LinkedHashSet<>();
        }
        for (Class<?> cls : clsArr) {
            _checkNotNull(cls, "subtype to register");
            this._subtypes.add(new NamedType(cls));
        }
        return this;
    }

    public void setAbstractTypes(SimpleAbstractTypeResolver simpleAbstractTypeResolver) {
        this._abstractTypes = simpleAbstractTypeResolver;
    }

    public SimpleModule setDeserializerModifier(mh mhVar) {
        return this;
    }

    public void setDeserializers(SimpleDeserializers simpleDeserializers) {
        this._deserializers = simpleDeserializers;
    }

    public void setKeyDeserializers(SimpleKeyDeserializers simpleKeyDeserializers) {
        this._keyDeserializers = simpleKeyDeserializers;
    }

    public void setKeySerializers(SimpleSerializers simpleSerializers) {
        this._keySerializers = simpleSerializers;
    }

    public SimpleModule setMixInAnnotation(Class<?> cls, Class<?> cls2) {
        _checkNotNull(cls, "target type");
        _checkNotNull(cls2, "mixin class");
        if (this._mixins == null) {
            this._mixins = new HashMap<>();
        }
        this._mixins.put(cls, cls2);
        return this;
    }

    protected SimpleModule setNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        this._namingStrategy = propertyNamingStrategy;
        return this;
    }

    public SimpleModule setSerializerModifier(oh ohVar) {
        return this;
    }

    public void setSerializers(SimpleSerializers simpleSerializers) {
        this._serializers = simpleSerializers;
    }

    public void setValueInstantiators(SimpleValueInstantiators simpleValueInstantiators) {
        this._valueInstantiators = simpleValueInstantiators;
    }

    @Override // com.fasterxml.jackson.databind.c
    public void setupModule(c.a aVar) {
        SimpleSerializers simpleSerializers = this._serializers;
        if (simpleSerializers != null) {
            aVar.d(simpleSerializers);
        }
        SimpleDeserializers simpleDeserializers = this._deserializers;
        if (simpleDeserializers != null) {
            aVar.g(simpleDeserializers);
        }
        SimpleSerializers simpleSerializers2 = this._keySerializers;
        if (simpleSerializers2 != null) {
            aVar.f(simpleSerializers2);
        }
        SimpleKeyDeserializers simpleKeyDeserializers = this._keyDeserializers;
        if (simpleKeyDeserializers != null) {
            aVar.a(simpleKeyDeserializers);
        }
        SimpleAbstractTypeResolver simpleAbstractTypeResolver = this._abstractTypes;
        if (simpleAbstractTypeResolver != null) {
            aVar.e(simpleAbstractTypeResolver);
        }
        SimpleValueInstantiators simpleValueInstantiators = this._valueInstantiators;
        if (simpleValueInstantiators != null) {
            aVar.b(simpleValueInstantiators);
        }
        LinkedHashSet<NamedType> linkedHashSet = this._subtypes;
        if (linkedHashSet != null && linkedHashSet.size() > 0) {
            LinkedHashSet<NamedType> linkedHashSet2 = this._subtypes;
            aVar.c((NamedType[]) linkedHashSet2.toArray(new NamedType[linkedHashSet2.size()]));
        }
        PropertyNamingStrategy propertyNamingStrategy = this._namingStrategy;
        if (propertyNamingStrategy != null) {
            aVar.h(propertyNamingStrategy);
        }
        HashMap<Class<?>, Class<?>> map = this._mixins;
        if (map != null) {
            for (Map.Entry<Class<?>, Class<?>> entry : map.entrySet()) {
                aVar.i(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.c
    public Version version() {
        return this._version;
    }

    public <T> SimpleModule addSerializer(Class<? extends T> cls, f71 f71Var) {
        _checkNotNull(cls, "type to register serializer for");
        _checkNotNull(f71Var, "serializer");
        if (this._serializers == null) {
            this._serializers = new SimpleSerializers();
        }
        this._serializers.addSerializer(cls, f71Var);
        return this;
    }

    public SimpleModule registerSubtypes(NamedType... namedTypeArr) {
        if (this._subtypes == null) {
            this._subtypes = new LinkedHashSet<>();
        }
        for (NamedType namedType : namedTypeArr) {
            _checkNotNull(namedType, "subtype to register");
            this._subtypes.add(namedType);
        }
        return this;
    }

    public SimpleModule registerSubtypes(Collection<Class<?>> collection) {
        if (this._subtypes == null) {
            this._subtypes = new LinkedHashSet<>();
        }
        for (Class<?> cls : collection) {
            _checkNotNull(cls, "subtype to register");
            this._subtypes.add(new NamedType(cls));
        }
        return this;
    }

    public SimpleModule(String str) {
        this(str, Version.unknownVersion());
    }

    public SimpleModule(Version version) {
        this(version.getArtifactId(), version);
    }

    public SimpleModule(String str, Version version) {
        this._serializers = null;
        this._deserializers = null;
        this._keySerializers = null;
        this._keyDeserializers = null;
        this._abstractTypes = null;
        this._valueInstantiators = null;
        this._mixins = null;
        this._subtypes = null;
        this._namingStrategy = null;
        this._name = str;
        this._version = version;
        this._hasExplicitName = true;
    }

    public SimpleModule(String str, Version version, Map<Class<?>, s51> map) {
        this(str, version, map, null);
    }

    public SimpleModule(String str, Version version, List<f71> list) {
        this(str, version, null, list);
    }

    public SimpleModule(String str, Version version, Map<Class<?>, s51> map, List<f71> list) {
        this._serializers = null;
        this._deserializers = null;
        this._keySerializers = null;
        this._keyDeserializers = null;
        this._abstractTypes = null;
        this._valueInstantiators = null;
        this._mixins = null;
        this._subtypes = null;
        this._namingStrategy = null;
        this._name = str;
        this._hasExplicitName = true;
        this._version = version;
        if (map != null) {
            this._deserializers = new SimpleDeserializers(map);
        }
        if (list != null) {
            this._serializers = new SimpleSerializers(list);
        }
    }
}
