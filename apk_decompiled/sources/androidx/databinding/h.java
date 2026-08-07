package androidx.databinding;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface h extends List {

    public static abstract class a {
        public abstract void b(h hVar);

        public abstract void c(h hVar, int i, int i2);

        public abstract void d(h hVar, int i, int i2);

        public abstract void e(h hVar, int i, int i2, int i3);

        public abstract void f(h hVar, int i, int i2);
    }

    void addOnListChangedCallback(a aVar);

    void removeOnListChangedCallback(a aVar);
}
