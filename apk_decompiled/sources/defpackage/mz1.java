package defpackage;

import android.util.JsonReader;
import android.util.JsonToken;

/* JADX INFO: loaded from: classes.dex */
abstract class mz1 {
    static kz1 a(JsonReader jsonReader, fe1 fe1Var) {
        return new kz1(fe1Var, m91.b(jsonReader, fe1Var, ya3.e(), pz1.a, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
