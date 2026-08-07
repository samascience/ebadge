package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class f71 {

    public static abstract class a extends f71 {
    }

    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) {
        y51Var.e(javaType);
    }

    public f71 getDelegatee() {
        return null;
    }

    public abstract Class handledType();

    @Deprecated
    public boolean isEmpty(Object obj) {
        return isEmpty(null, obj);
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    public Iterator<PropertyWriter> properties() {
        return ay.n();
    }

    public f71 replaceDelegatee(f71 f71Var) {
        throw new UnsupportedOperationException();
    }

    public abstract void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var);

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        Class<?> clsHandledType = handledType();
        if (clsHandledType == null) {
            clsHandledType = obj.getClass();
        }
        an2Var.reportBadDefinition(clsHandledType, String.format("Type id handling not implemented for type %s (by serializer of type %s)", clsHandledType.getName(), getClass().getName()));
    }

    public f71 unwrappingSerializer(NameTransformer nameTransformer) {
        return this;
    }

    public boolean usesObjectId() {
        return false;
    }

    public f71 withFilterId(Object obj) {
        return this;
    }

    public boolean isEmpty(an2 an2Var, Object obj) {
        return obj == null;
    }
}
