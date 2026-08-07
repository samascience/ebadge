package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r61 {
    public static u51 a(a71 a71Var) {
        boolean zK0 = a71Var.k0();
        a71Var.R0(true);
        try {
            try {
                u51 u51VarA = iv2.a(a71Var);
                a71Var.R0(zK0);
                return u51VarA;
            } catch (OutOfMemoryError e) {
                throw new JsonParseException("Failed parsing JSON source: " + a71Var + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + a71Var + " to Json", e2);
            }
        } catch (Throwable th) {
            a71Var.R0(zK0);
            throw th;
        }
    }

    public static u51 b(Reader reader) {
        try {
            a71 a71Var = new a71(reader);
            u51 u51VarA = a(a71Var);
            if (!u51VarA.g() && a71Var.M0() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return u51VarA;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException(e3);
        }
    }

    public static u51 c(String str) {
        return b(new StringReader(str));
    }
}
