package defpackage;

import com.fasterxml.jackson.core.JsonLocation;

/* JADX INFO: loaded from: classes.dex */
public class s83 {
    private final Object a;
    private final JsonLocation b;
    private final Class c;

    public s83(Object obj, Class cls, JsonLocation jsonLocation) {
        this.a = obj;
        this.c = cls;
        this.b = jsonLocation;
    }

    public String toString() {
        return String.format("Object id [%s] (for %s) at %s", this.a, ay.X(this.c), this.b);
    }
}
