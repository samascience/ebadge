package androidx.camera.video;

import android.util.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static final s a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final s e;
    public static final s f;
    static final s g;
    private static final Set h;
    private static final List i;

    public static abstract class b extends s {
        public b() {
            super();
        }

        static b f(int i, String str, List list) {
            return new i(i, str, list);
        }

        public abstract String c();

        public abstract List d();

        public abstract int e();
    }

    static {
        b bVarF = b.f(4, "SD", Collections.unmodifiableList(Arrays.asList(new Size(720, 480), new Size(640, 480))));
        a = bVarF;
        b bVarF2 = b.f(5, "HD", Collections.singletonList(new Size(1280, 720)));
        b = bVarF2;
        b bVarF3 = b.f(6, "FHD", Collections.singletonList(new Size(1920, 1080)));
        c = bVarF3;
        b bVarF4 = b.f(8, "UHD", Collections.singletonList(new Size(3840, 2160)));
        d = bVarF4;
        b bVarF5 = b.f(0, "LOWEST", Collections.emptyList());
        e = bVarF5;
        b bVarF6 = b.f(1, "HIGHEST", Collections.emptyList());
        f = bVarF6;
        g = b.f(-1, "NONE", Collections.emptyList());
        h = new HashSet(Arrays.asList(bVarF5, bVarF6, bVarF, bVarF2, bVarF3, bVarF4));
        i = Arrays.asList(bVarF4, bVarF3, bVarF2, bVarF);
    }

    static boolean a(s sVar) {
        return h.contains(sVar);
    }

    public static List b() {
        return new ArrayList(i);
    }

    private s() {
    }
}
