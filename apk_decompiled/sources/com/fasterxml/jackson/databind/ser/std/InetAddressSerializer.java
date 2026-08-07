package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import defpackage.an2;
import defpackage.f71;
import defpackage.w30;
import defpackage.z63;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
public class InetAddressSerializer extends StdScalarSerializer<InetAddress> implements w30 {
    protected final boolean _asNumeric;

    public InetAddressSerializer() {
        this(false);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        boolean z;
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
        if (valueFindFormatOverrides != null) {
            JsonFormat.Shape shape = valueFindFormatOverrides.getShape();
            if (shape.isNumeric() || shape == JsonFormat.Shape.ARRAY) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return z != this._asNumeric ? new InetAddressSerializer(z) : this;
    }

    public InetAddressSerializer(boolean z) {
        super(InetAddress.class);
        this._asNumeric = z;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(InetAddress inetAddress, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        String strTrim;
        if (this._asNumeric) {
            strTrim = inetAddress.getHostAddress();
        } else {
            strTrim = inetAddress.toString().trim();
            int iIndexOf = strTrim.indexOf(47);
            if (iIndexOf >= 0) {
                strTrim = iIndexOf == 0 ? strTrim.substring(1) : strTrim.substring(0, iIndexOf);
            }
        }
        jsonGenerator.w1(strTrim);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, defpackage.f71
    public void serializeWithType(InetAddress inetAddress, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.f(inetAddress, InetAddress.class, JsonToken.VALUE_STRING));
        serialize(inetAddress, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }
}
