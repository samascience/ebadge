package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import defpackage.an2;
import defpackage.f71;
import defpackage.w30;
import defpackage.z63;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArraySerializerBase<T> extends ContainerSerializer<T> implements w30 {
    protected final BeanProperty _property;
    protected final Boolean _unwrapSingle;

    protected ArraySerializerBase(Class<T> cls) {
        super(cls);
        this._property = null;
        this._unwrapSingle = null;
    }

    protected final boolean _shouldUnwrapSingle(an2 an2Var) {
        Boolean bool = this._unwrapSingle;
        return bool == null ? an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : bool.booleanValue();
    }

    public abstract f71 _withResolved(BeanProperty beanProperty, Boolean bool);

    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value valueFindFormatOverrides;
        if (beanProperty != null && (valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType())) != null) {
            Boolean feature = valueFindFormatOverrides.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            if (!Objects.equals(feature, this._unwrapSingle)) {
                return _withResolved(beanProperty, feature);
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(T t, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (_shouldUnwrapSingle(an2Var) && hasSingleElement(t)) {
            serializeContents(t, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.q1(t);
        serializeContents(t, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    protected abstract void serializeContents(T t, JsonGenerator jsonGenerator, an2 an2Var) throws IOException;

    @Override // defpackage.f71
    public final void serializeWithType(T t, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(t, JsonToken.START_ARRAY));
        jsonGenerator.y0(t);
        serializeContents(t, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }

    @Deprecated
    protected ArraySerializerBase(Class<T> cls, BeanProperty beanProperty) {
        super(cls);
        this._property = beanProperty;
        this._unwrapSingle = null;
    }

    protected ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase) {
        super(arraySerializerBase._handledType, false);
        this._property = arraySerializerBase._property;
        this._unwrapSingle = arraySerializerBase._unwrapSingle;
    }

    protected ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, BeanProperty beanProperty, Boolean bool) {
        super(arraySerializerBase._handledType, false);
        this._property = beanProperty;
        this._unwrapSingle = bool;
    }

    @Deprecated
    protected ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, BeanProperty beanProperty) {
        super(arraySerializerBase._handledType, false);
        this._property = beanProperty;
        this._unwrapSingle = arraySerializerBase._unwrapSingle;
    }
}
