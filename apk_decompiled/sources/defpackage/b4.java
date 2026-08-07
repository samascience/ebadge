package defpackage;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class b4 {

    public static final class a {
        private final Object a;

        public a(Object obj) {
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public a b(Context context, Object obj) {
        p31.f(context, "context");
        return null;
    }

    public abstract Object c(int i, Intent intent);
}
