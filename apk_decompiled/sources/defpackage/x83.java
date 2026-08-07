package defpackage;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class x83 {
    protected final List a;

    public x83() {
        this.a = new ArrayList();
    }

    public void a(SettableBeanProperty settableBeanProperty) {
        this.a.add(settableBeanProperty);
    }

    public Object b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, q33 q33Var) throws IOException {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            SettableBeanProperty settableBeanProperty = (SettableBeanProperty) this.a.get(i);
            JsonParser jsonParserN1 = q33Var.N1();
            jsonParserN1.n1();
            settableBeanProperty.deserializeAndSet(jsonParserN1, deserializationContext, obj);
        }
        return obj;
    }

    public x83 c(NameTransformer nameTransformer) {
        s51 s51VarUnwrappingDeserializer;
        ArrayList arrayList = new ArrayList(this.a.size());
        for (SettableBeanProperty settableBeanProperty : this.a) {
            SettableBeanProperty settableBeanPropertyWithSimpleName = settableBeanProperty.withSimpleName(nameTransformer.transform(settableBeanProperty.getName()));
            s51 valueDeserializer = settableBeanPropertyWithSimpleName.getValueDeserializer();
            if (valueDeserializer != null && (s51VarUnwrappingDeserializer = valueDeserializer.unwrappingDeserializer(nameTransformer)) != valueDeserializer) {
                settableBeanPropertyWithSimpleName = settableBeanPropertyWithSimpleName.withValueDeserializer(s51VarUnwrappingDeserializer);
            }
            arrayList.add(settableBeanPropertyWithSimpleName);
        }
        return new x83(arrayList);
    }

    protected x83(List list) {
        this.a = list;
    }
}
