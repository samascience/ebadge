package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class m7 {
    protected final BeanProperty a;
    protected final AnnotatedMember b;
    protected f71 c;
    protected MapSerializer d;

    public m7(BeanProperty beanProperty, AnnotatedMember annotatedMember, f71 f71Var) {
        this.b = annotatedMember;
        this.a = beanProperty;
        this.c = f71Var;
        if (f71Var instanceof MapSerializer) {
            this.d = (MapSerializer) f71Var;
        }
    }

    public void a(SerializationConfig serializationConfig) {
        this.b.fixAccess(serializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public void b(Object obj, JsonGenerator jsonGenerator, an2 an2Var, i82 i82Var) {
        Object value = this.b.getValue(obj);
        if (value == null) {
            return;
        }
        if (!(value instanceof Map)) {
            an2Var.reportBadDefinition(this.a.getType(), String.format("Value returned by 'any-getter' (%s()) not java.util.Map but %s", this.b.getName(), value.getClass().getName()));
        }
        MapSerializer mapSerializer = this.d;
        if (mapSerializer != null) {
            mapSerializer.serializeFilteredAnyProperties(an2Var, jsonGenerator, obj, (Map) value, i82Var, null);
        } else {
            this.c.serialize(value, jsonGenerator, an2Var);
        }
    }

    public void c(Object obj, JsonGenerator jsonGenerator, an2 an2Var) {
        Object value = this.b.getValue(obj);
        if (value == null) {
            return;
        }
        if (!(value instanceof Map)) {
            an2Var.reportBadDefinition(this.a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", this.b.getName(), value.getClass().getName()));
        }
        MapSerializer mapSerializer = this.d;
        if (mapSerializer != null) {
            mapSerializer.serializeWithoutTypeInfo((Map) value, jsonGenerator, an2Var);
        } else {
            this.c.serialize(value, jsonGenerator, an2Var);
        }
    }

    public void d(an2 an2Var) {
        f71 f71Var = this.c;
        if (f71Var instanceof w30) {
            f71 f71VarHandlePrimaryContextualization = an2Var.handlePrimaryContextualization(f71Var, this.a);
            this.c = f71VarHandlePrimaryContextualization;
            if (f71VarHandlePrimaryContextualization instanceof MapSerializer) {
                this.d = (MapSerializer) f71VarHandlePrimaryContextualization;
            }
        }
    }
}
