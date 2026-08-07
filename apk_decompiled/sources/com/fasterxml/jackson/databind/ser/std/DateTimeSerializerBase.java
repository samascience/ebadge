package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import defpackage.an2;
import defpackage.f71;
import defpackage.p62;
import defpackage.w30;
import defpackage.y51;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements w30 {
    protected final DateFormat _customFormat;
    protected final AtomicReference<DateFormat> _reusedCustomFormat;
    protected final Boolean _useTimestamp;

    protected DateTimeSerializerBase(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this._useTimestamp = bool;
        this._customFormat = dateFormat;
        this._reusedCustomFormat = dateFormat == null ? null : new AtomicReference<>();
    }

    protected void _acceptJsonFormatVisitor(y51 y51Var, JavaType javaType, boolean z) throws JsonMappingException {
        if (z) {
            visitIntFormat(y51Var, javaType, JsonParser.NumberType.LONG, JsonValueFormat.UTC_MILLISEC);
        } else {
            visitStringFormat(y51Var, javaType, JsonValueFormat.DATE_TIME);
        }
    }

    protected boolean _asTimestamp(an2 an2Var) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (an2Var != null) {
            return an2Var.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        throw new IllegalArgumentException("Null SerializerProvider passed for " + handledType().getName());
    }

    protected void _serializeAsString(Date date, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (this._customFormat == null) {
            an2Var.defaultSerializeDateValue(date, jsonGenerator);
            return;
        }
        DateFormat andSet = this._reusedCustomFormat.getAndSet(null);
        if (andSet == null) {
            andSet = (DateFormat) this._customFormat.clone();
        }
        jsonGenerator.w1(andSet.format(date));
        p62.a(this._reusedCustomFormat, null, andSet);
    }

    protected abstract long _timestamp(T t);

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        _acceptJsonFormatVisitor(y51Var, javaType, _asTimestamp(y51Var.b()));
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
        if (valueFindFormatOverrides == null) {
            return this;
        }
        JsonFormat.Shape shape = valueFindFormatOverrides.getShape();
        if (shape.isNumeric()) {
            return withFormat2(Boolean.TRUE, null);
        }
        if (valueFindFormatOverrides.hasPattern()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(valueFindFormatOverrides.getPattern(), valueFindFormatOverrides.hasLocale() ? valueFindFormatOverrides.getLocale() : an2Var.getLocale());
            simpleDateFormat.setTimeZone(valueFindFormatOverrides.hasTimeZone() ? valueFindFormatOverrides.getTimeZone() : an2Var.getTimeZone());
            return withFormat2(Boolean.FALSE, simpleDateFormat);
        }
        boolean zHasLocale = valueFindFormatOverrides.hasLocale();
        boolean zHasTimeZone = valueFindFormatOverrides.hasTimeZone();
        boolean z = shape == JsonFormat.Shape.STRING;
        if (!zHasLocale && !zHasTimeZone && !z) {
            return this;
        }
        DateFormat dateFormat = an2Var.getConfig().getDateFormat();
        if (dateFormat instanceof StdDateFormat) {
            StdDateFormat stdDateFormatWithTimeZone = (StdDateFormat) dateFormat;
            if (valueFindFormatOverrides.hasLocale()) {
                stdDateFormatWithTimeZone = stdDateFormatWithTimeZone.withLocale(valueFindFormatOverrides.getLocale());
            }
            if (valueFindFormatOverrides.hasTimeZone()) {
                stdDateFormatWithTimeZone = stdDateFormatWithTimeZone.withTimeZone(valueFindFormatOverrides.getTimeZone());
            }
            return withFormat2(Boolean.FALSE, stdDateFormatWithTimeZone);
        }
        if (!(dateFormat instanceof SimpleDateFormat)) {
            an2Var.reportBadDefinition((Class<?>) handledType(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", dateFormat.getClass().getName()));
        }
        SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) dateFormat;
        SimpleDateFormat simpleDateFormat3 = zHasLocale ? new SimpleDateFormat(simpleDateFormat2.toPattern(), valueFindFormatOverrides.getLocale()) : (SimpleDateFormat) simpleDateFormat2.clone();
        TimeZone timeZone = valueFindFormatOverrides.getTimeZone();
        if (timeZone != null && !timeZone.equals(simpleDateFormat3.getTimeZone())) {
            simpleDateFormat3.setTimeZone(timeZone);
        }
        return withFormat2(Boolean.FALSE, simpleDateFormat3);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode(_asTimestamp(an2Var) ? "number" : "string", true);
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, T t) {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public abstract void serialize(T t, JsonGenerator jsonGenerator, an2 an2Var) throws IOException;

    /* JADX INFO: renamed from: withFormat */
    public abstract DateTimeSerializerBase<T> withFormat2(Boolean bool, DateFormat dateFormat);
}
