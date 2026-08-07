package defpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;

/* JADX INFO: loaded from: classes.dex */
public class ja extends a73 {
    private static final ja c = new ja();

    protected ja() {
        super(null, null);
    }

    public static ja n() {
        return c;
    }

    @Override // defpackage.z63
    public JsonTypeInfo.As c() {
        return JsonTypeInfo.As.EXISTING_PROPERTY;
    }

    @Override // defpackage.a73, defpackage.z63
    public WritableTypeId g(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        if (!writableTypeId.f.isStructStart() || jsonGenerator.a0()) {
            return null;
        }
        return jsonGenerator.A1(writableTypeId);
    }

    @Override // defpackage.a73, defpackage.z63
    public WritableTypeId h(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        if (writableTypeId == null) {
            return null;
        }
        return jsonGenerator.B1(writableTypeId);
    }

    @Override // defpackage.z63
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ja a(BeanProperty beanProperty) {
        return this;
    }
}
