package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.Separators;

/* JADX INFO: loaded from: classes.dex */
public interface k52 {
    public static final Separators A = Separators.createDefaultInstance();
    public static final SerializedString B = new SerializedString(" ");

    void beforeArrayValues(JsonGenerator jsonGenerator);

    void beforeObjectEntries(JsonGenerator jsonGenerator);

    void writeArrayValueSeparator(JsonGenerator jsonGenerator);

    void writeEndArray(JsonGenerator jsonGenerator, int i);

    void writeEndObject(JsonGenerator jsonGenerator, int i);

    void writeObjectEntrySeparator(JsonGenerator jsonGenerator);

    void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator);

    void writeRootValueSeparator(JsonGenerator jsonGenerator);

    void writeStartArray(JsonGenerator jsonGenerator);

    void writeStartObject(JsonGenerator jsonGenerator);
}
