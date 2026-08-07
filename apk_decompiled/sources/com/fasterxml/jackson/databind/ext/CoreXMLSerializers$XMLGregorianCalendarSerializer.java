package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import defpackage.an2;
import defpackage.f71;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.util.Calendar;
import javax.xml.datatype.XMLGregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public class CoreXMLSerializers$XMLGregorianCalendarSerializer extends StdSerializer<XMLGregorianCalendar> implements w30 {
    static final CoreXMLSerializers$XMLGregorianCalendarSerializer instance = new CoreXMLSerializers$XMLGregorianCalendarSerializer();
    final f71 _delegate;

    public CoreXMLSerializers$XMLGregorianCalendarSerializer() {
        this(CalendarSerializer.instance);
    }

    protected Calendar _convert(XMLGregorianCalendar xMLGregorianCalendar) {
        if (xMLGregorianCalendar == null) {
            return null;
        }
        return xMLGregorianCalendar.toGregorianCalendar();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        this._delegate.acceptJsonFormatVisitor(y51Var, null);
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarHandlePrimaryContextualization = an2Var.handlePrimaryContextualization(this._delegate, beanProperty);
        return f71VarHandlePrimaryContextualization != this._delegate ? new CoreXMLSerializers$XMLGregorianCalendarSerializer(f71VarHandlePrimaryContextualization) : this;
    }

    @Override // defpackage.f71
    public f71 getDelegatee() {
        return this._delegate;
    }

    protected CoreXMLSerializers$XMLGregorianCalendarSerializer(f71 f71Var) {
        super(XMLGregorianCalendar.class);
        this._delegate = f71Var;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, XMLGregorianCalendar xMLGregorianCalendar) {
        return this._delegate.isEmpty(an2Var, _convert(xMLGregorianCalendar));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(XMLGregorianCalendar xMLGregorianCalendar, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        this._delegate.serialize(_convert(xMLGregorianCalendar), jsonGenerator, an2Var);
    }

    @Override // defpackage.f71
    public void serializeWithType(XMLGregorianCalendar xMLGregorianCalendar, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.f(xMLGregorianCalendar, XMLGregorianCalendar.class, JsonToken.VALUE_STRING));
        serialize(xMLGregorianCalendar, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }
}
