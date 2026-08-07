package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import defpackage.bn2;
import defpackage.f71;
import defpackage.kh;
import defpackage.z63;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SimpleSerializers extends bn2.a implements Serializable {
    private static final long serialVersionUID = 3;
    protected HashMap<ClassKey, f71> _classMappings = null;
    protected HashMap<ClassKey, f71> _interfaceMappings = null;
    protected boolean _hasEnumSerializer = false;

    public SimpleSerializers() {
    }

    protected void _addSerializer(Class<?> cls, f71 f71Var) {
        ClassKey classKey = new ClassKey(cls);
        if (cls.isInterface()) {
            if (this._interfaceMappings == null) {
                this._interfaceMappings = new HashMap<>();
            }
            this._interfaceMappings.put(classKey, f71Var);
        } else {
            if (this._classMappings == null) {
                this._classMappings = new HashMap<>();
            }
            this._classMappings.put(classKey, f71Var);
            if (cls == Enum.class) {
                this._hasEnumSerializer = true;
            }
        }
    }

    protected f71 _findInterfaceMapping(Class<?> cls, ClassKey classKey) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            classKey.reset(cls2);
            f71 f71Var = this._interfaceMappings.get(classKey);
            if (f71Var != null) {
                return f71Var;
            }
            f71 f71Var_findInterfaceMapping = _findInterfaceMapping(cls2, classKey);
            if (f71Var_findInterfaceMapping != null) {
                return f71Var_findInterfaceMapping;
            }
        }
        return null;
    }

    public void addSerializer(f71 f71Var) {
        Class clsHandledType = f71Var.handledType();
        if (clsHandledType != null && clsHandledType != Object.class) {
            _addSerializer(clsHandledType, f71Var);
            return;
        }
        throw new IllegalArgumentException("JsonSerializer of type " + f71Var.getClass().getName() + " does not define valid handledType() -- must either register with method that takes type argument  or make serializer extend 'com.fasterxml.jackson.databind.ser.std.StdSerializer'");
    }

    public void addSerializers(List<f71> list) {
        Iterator<f71> it = list.iterator();
        while (it.hasNext()) {
            addSerializer(it.next());
        }
    }

    @Override // defpackage.bn2
    public f71 findArraySerializer(SerializationConfig serializationConfig, ArrayType arrayType, kh khVar, z63 z63Var, f71 f71Var) {
        return findSerializer(serializationConfig, arrayType, khVar);
    }

    @Override // defpackage.bn2
    public f71 findCollectionLikeSerializer(SerializationConfig serializationConfig, CollectionLikeType collectionLikeType, kh khVar, z63 z63Var, f71 f71Var) {
        return findSerializer(serializationConfig, collectionLikeType, khVar);
    }

    @Override // defpackage.bn2
    public f71 findCollectionSerializer(SerializationConfig serializationConfig, CollectionType collectionType, kh khVar, z63 z63Var, f71 f71Var) {
        return findSerializer(serializationConfig, collectionType, khVar);
    }

    @Override // defpackage.bn2
    public f71 findMapLikeSerializer(SerializationConfig serializationConfig, MapLikeType mapLikeType, kh khVar, f71 f71Var, z63 z63Var, f71 f71Var2) {
        return findSerializer(serializationConfig, mapLikeType, khVar);
    }

    @Override // defpackage.bn2
    public f71 findMapSerializer(SerializationConfig serializationConfig, MapType mapType, kh khVar, f71 f71Var, z63 z63Var, f71 f71Var2) {
        return findSerializer(serializationConfig, mapType, khVar);
    }

    @Override // bn2.a, defpackage.bn2
    public f71 findSerializer(SerializationConfig serializationConfig, JavaType javaType, kh khVar) {
        f71 f71Var_findInterfaceMapping;
        f71 f71Var;
        Class<?> rawClass = javaType.getRawClass();
        ClassKey classKey = new ClassKey(rawClass);
        if (rawClass.isInterface()) {
            HashMap<ClassKey, f71> map = this._interfaceMappings;
            if (map != null && (f71Var = map.get(classKey)) != null) {
                return f71Var;
            }
        } else {
            HashMap<ClassKey, f71> map2 = this._classMappings;
            if (map2 != null) {
                f71 f71Var2 = map2.get(classKey);
                if (f71Var2 != null) {
                    return f71Var2;
                }
                if (this._hasEnumSerializer && javaType.isEnumType()) {
                    classKey.reset(Enum.class);
                    f71 f71Var3 = this._classMappings.get(classKey);
                    if (f71Var3 != null) {
                        return f71Var3;
                    }
                }
                for (Class<?> superclass = rawClass; superclass != null; superclass = superclass.getSuperclass()) {
                    classKey.reset(superclass);
                    f71 f71Var4 = this._classMappings.get(classKey);
                    if (f71Var4 != null) {
                        return f71Var4;
                    }
                }
            }
        }
        if (this._interfaceMappings == null) {
            return null;
        }
        f71 f71Var_findInterfaceMapping2 = _findInterfaceMapping(rawClass, classKey);
        if (f71Var_findInterfaceMapping2 != null) {
            return f71Var_findInterfaceMapping2;
        }
        if (rawClass.isInterface()) {
            return null;
        }
        do {
            rawClass = rawClass.getSuperclass();
            if (rawClass == null) {
                return null;
            }
            f71Var_findInterfaceMapping = _findInterfaceMapping(rawClass, classKey);
        } while (f71Var_findInterfaceMapping == null);
        return f71Var_findInterfaceMapping;
    }

    public SimpleSerializers(List<f71> list) {
        addSerializers(list);
    }

    public <T> void addSerializer(Class<? extends T> cls, f71 f71Var) {
        _addSerializer(cls, f71Var);
    }
}
