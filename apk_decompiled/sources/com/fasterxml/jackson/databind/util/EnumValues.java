package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import defpackage.ay;
import defpackage.vm2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class EnumValues implements Serializable {
    private static final long serialVersionUID = 1;
    private transient EnumMap<?, vm2> _asMap;
    private final Class<Enum<?>> _enumClass;
    private final vm2[] _textual;
    private final Enum<?>[] _values;

    private EnumValues(Class<Enum<?>> cls, vm2[] vm2VarArr) {
        this._enumClass = cls;
        this._values = cls.getEnumConstants();
        this._textual = vm2VarArr;
    }

    public static EnumValues construct(SerializationConfig serializationConfig, Class<Enum<?>> cls) {
        return serializationConfig.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING) ? constructFromToString(serializationConfig, cls) : constructFromName(serializationConfig, cls);
    }

    public static EnumValues constructFromName(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Class<?> clsR = ay.r(cls);
        Enum<?>[] enumArr = (Enum[]) clsR.getEnumConstants();
        if (enumArr == null) {
            throw new IllegalArgumentException("Cannot determine enum constants for Class " + cls.getName());
        }
        String[] strArrFindEnumValues = mapperConfig.getAnnotationIntrospector().findEnumValues(clsR, enumArr, new String[enumArr.length]);
        vm2[] vm2VarArr = new vm2[enumArr.length];
        int length = enumArr.length;
        for (int i = 0; i < length; i++) {
            Enum<?> r5 = enumArr[i];
            String strName = strArrFindEnumValues[i];
            if (strName == null) {
                strName = r5.name();
            }
            vm2VarArr[r5.ordinal()] = mapperConfig.compileString(strName);
        }
        return construct(cls, vm2VarArr);
    }

    public static EnumValues constructFromToString(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Enum[] enumArr = (Enum[]) ay.r(cls).getEnumConstants();
        if (enumArr == null) {
            throw new IllegalArgumentException("Cannot determine enum constants for Class " + cls.getName());
        }
        ArrayList arrayList = new ArrayList(enumArr.length);
        for (Enum r0 : enumArr) {
            arrayList.add(r0.toString());
        }
        return construct(mapperConfig, cls, arrayList);
    }

    public List<Enum<?>> enums() {
        return Arrays.asList(this._values);
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }

    public EnumMap<?, vm2> internalMap() {
        EnumMap<?, vm2> enumMap = this._asMap;
        if (enumMap != null) {
            return enumMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Enum<?> r4 : this._values) {
            linkedHashMap.put(r4, this._textual[r4.ordinal()]);
        }
        return new EnumMap<>(linkedHashMap);
    }

    public vm2 serializedValueFor(Enum<?> r2) {
        return this._textual[r2.ordinal()];
    }

    public Collection<vm2> values() {
        return Arrays.asList(this._textual);
    }

    public static EnumValues construct(MapperConfig<?> mapperConfig, Class<Enum<?>> cls, List<String> list) {
        int size = list.size();
        vm2[] vm2VarArr = new vm2[size];
        for (int i = 0; i < size; i++) {
            vm2VarArr[i] = mapperConfig.compileString(list.get(i));
        }
        return construct(cls, vm2VarArr);
    }

    public static EnumValues construct(Class<Enum<?>> cls, vm2[] vm2VarArr) {
        return new EnumValues(cls, vm2VarArr);
    }
}
