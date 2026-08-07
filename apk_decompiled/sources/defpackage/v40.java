package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class v40 {
    private final Map a = new LinkedHashMap();

    public static final class a extends v40 {
        public static final a b = new a();

        private a() {
        }

        @Override // defpackage.v40
        public Object a(b bVar) {
            p31.f(bVar, "key");
            return null;
        }
    }

    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.a;
    }
}
