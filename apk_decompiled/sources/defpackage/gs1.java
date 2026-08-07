package defpackage;

import com.fasterxml.jackson.databind.DeserializationContext;

/* JADX INFO: loaded from: classes.dex */
public interface gs1 {
    default Object getAbsentValue(DeserializationContext deserializationContext) {
        return getNullValue(deserializationContext);
    }

    Object getNullValue(DeserializationContext deserializationContext);
}
