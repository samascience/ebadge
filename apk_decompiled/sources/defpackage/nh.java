package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

/* JADX INFO: loaded from: classes.dex */
public interface nh {
    void depositSchemaProperty(BeanPropertyWriter beanPropertyWriter, ObjectNode objectNode, an2 an2Var);

    void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var, BeanPropertyWriter beanPropertyWriter);
}
