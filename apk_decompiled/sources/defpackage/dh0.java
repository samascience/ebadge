package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface dh0 {
    public static final dh0 a = new a();
    public static final List b = Collections.unmodifiableList(Arrays.asList(13, 10, 8, 11, 6, 5, 4, 9, 3, 7, 2));

    class a implements dh0 {
        a() {
        }

        @Override // defpackage.dh0
        public boolean a(int i) {
            return false;
        }

        @Override // defpackage.dh0
        public eh0 b(int i) {
            return null;
        }
    }

    boolean a(int i);

    eh0 b(int i);
}
