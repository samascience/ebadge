package retrofit2.converter.gson;

import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import defpackage.a71;
import defpackage.e63;
import defpackage.fh2;
import defpackage.qv0;
import java.io.IOException;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes4.dex */
final class GsonResponseBodyConverter<T> implements Converter<fh2, T> {
    private final e63 adapter;
    private final qv0 gson;

    GsonResponseBodyConverter(qv0 qv0Var, e63 e63Var) {
        this.gson = qv0Var;
        this.adapter = e63Var;
    }

    @Override // retrofit2.Converter
    public T convert(fh2 fh2Var) throws IOException {
        a71 a71VarK = this.gson.k(fh2Var.charStream());
        try {
            T t = (T) this.adapter.b(a71VarK);
            if (a71VarK.M0() != JsonToken.END_DOCUMENT) {
                throw new JsonIOException("JSON document was not fully consumed.");
            }
            fh2Var.close();
            return t;
        } catch (Throwable th) {
            fh2Var.close();
            throw th;
        }
    }
}
