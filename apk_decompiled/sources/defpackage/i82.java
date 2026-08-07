package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.PropertyWriter;

/* JADX INFO: loaded from: classes.dex */
public interface i82 {
    void depositSchemaProperty(PropertyWriter propertyWriter, ObjectNode objectNode, an2 an2Var);

    void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var, PropertyWriter propertyWriter);
}
