package defpackage;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;

/* JADX INFO: loaded from: classes.dex */
public interface cb3 {

    public static class a implements cb3 {
    }

    ValueInstantiator findValueInstantiator(DeserializationConfig deserializationConfig, kh khVar, ValueInstantiator valueInstantiator);
}
