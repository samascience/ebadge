package defpackage;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* JADX INFO: loaded from: classes.dex */
public class bi0 extends s51 {
    private final Error a;

    public bi0(NoClassDefFoundError noClassDefFoundError) {
        this.a = noClassDefFoundError;
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        throw this.a;
    }
}
