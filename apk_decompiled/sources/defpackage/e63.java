package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e63 {

    class a extends e63 {
        a() {
        }

        @Override // defpackage.e63
        public Object b(a71 a71Var) throws IOException {
            if (a71Var.M0() != JsonToken.NULL) {
                return e63.this.b(a71Var);
            }
            a71Var.I0();
            return null;
        }

        @Override // defpackage.e63
        public void e(a81 a81Var, Object obj) throws IOException {
            if (obj == null) {
                a81Var.t0();
            } else {
                e63.this.e(a81Var, obj);
            }
        }
    }

    public final e63 a() {
        return new a();
    }

    public abstract Object b(a71 a71Var);

    public final void c(Writer writer, Object obj) {
        e(new a81(writer), obj);
    }

    public final u51 d(Object obj) {
        try {
            m71 m71Var = new m71();
            e(m71Var, obj);
            return m71Var.S0();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public abstract void e(a81 a81Var, Object obj);

    public final Object fromJson(Reader reader) throws IOException {
        return b(new a71(reader));
    }

    public final String toJson(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            c(stringWriter, obj);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final Object fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }
}
