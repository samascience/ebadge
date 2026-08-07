package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ae0 {
    protected final Object a;
    protected String b;
    protected String c;
    protected HashSet d;

    private ae0(Object obj) {
        this.a = obj;
    }

    public static ae0 e(JsonGenerator jsonGenerator) {
        return new ae0(jsonGenerator);
    }

    public static ae0 f(JsonParser jsonParser) {
        return new ae0(jsonParser);
    }

    public ae0 a() {
        return new ae0(this.a);
    }

    public Object b() {
        return this.a;
    }

    public boolean c(String str) {
        String str2 = this.b;
        if (str2 == null) {
            this.b = str;
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        String str3 = this.c;
        if (str3 == null) {
            this.c = str;
            return false;
        }
        if (str.equals(str3)) {
            return true;
        }
        if (this.d == null) {
            HashSet hashSet = new HashSet(16);
            this.d = hashSet;
            hashSet.add(this.b);
            this.d.add(this.c);
        }
        return !this.d.add(str);
    }

    public void d() {
        this.b = null;
        this.c = null;
        this.d = null;
    }
}
