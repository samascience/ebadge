package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/* JADX INFO: loaded from: classes.dex */
public abstract class jt1 extends x53 {
    protected jt1() {
    }

    public abstract JsonFactory getFactory();

    @Deprecated
    public JsonFactory getJsonFactory() {
        return getFactory();
    }

    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj);
}
