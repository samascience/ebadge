package defpackage;

import android.graphics.Bitmap;
import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class gr2 implements cf1 {
    private static final Bitmap.Config[] d;
    private static final Bitmap.Config[] e;
    private static final Bitmap.Config[] f;
    private static final Bitmap.Config[] g;
    private static final Bitmap.Config[] h;
    private final c a = new c();
    private final nv0 b = new nv0();
    private final Map c = new HashMap();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static final class b implements g42 {
        private final c a;
        int b;
        private Bitmap.Config c;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // defpackage.g42
        public void a() {
            this.a.c(this);
        }

        public void b(int i, Bitmap.Config config) {
            this.b = i;
            this.c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && na3.c(this.c, bVar.c);
        }

        public int hashCode() {
            int i = this.b * 31;
            Bitmap.Config config = this.c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return gr2.h(this.b, this.c);
        }
    }

    static class c extends sg {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.sg
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b(i, config);
            return bVar;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        d = configArr;
        e = configArr;
        f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapJ = j(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapJ.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapJ.remove(num);
                return;
            } else {
                navigableMapJ.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
    }

    private b g(int i, Bitmap.Config config) {
        b bVarE = this.a.e(i, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer num = (Integer) j(config2).ceilingKey(Integer.valueOf(i));
            if (num != null && num.intValue() <= i * 8) {
                if (num.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVarE;
                        }
                    } else if (config2.equals(config)) {
                        return bVarE;
                    }
                }
                this.a.c(bVarE);
                return this.a.e(num.intValue(), config2);
            }
        }
        return bVarE;
    }

    static String h(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return e;
        }
        int i = a.a[config.ordinal()];
        if (i == 1) {
            return d;
        }
        if (i == 2) {
            return f;
        }
        if (i != 3) {
            return i != 4 ? new Bitmap.Config[]{config} : h;
        }
        return g;
    }

    private NavigableMap j(Bitmap.Config config) {
        NavigableMap navigableMap = (NavigableMap) this.c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(config, treeMap);
        return treeMap;
    }

    @Override // defpackage.cf1
    public String a(int i, int i2, Bitmap.Config config) {
        return h(na3.f(i, i2, config), config);
    }

    @Override // defpackage.cf1
    public int b(Bitmap bitmap) {
        return na3.g(bitmap);
    }

    @Override // defpackage.cf1
    public void c(Bitmap bitmap) {
        b bVarE = this.a.e(na3.g(bitmap), bitmap.getConfig());
        this.b.d(bVarE, bitmap);
        NavigableMap navigableMapJ = j(bitmap.getConfig());
        Integer num = (Integer) navigableMapJ.get(Integer.valueOf(bVarE.b));
        navigableMapJ.put(Integer.valueOf(bVarE.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // defpackage.cf1
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        b bVarG = g(na3.f(i, i2, config), config);
        Bitmap bitmap = (Bitmap) this.b.a(bVarG);
        if (bitmap != null) {
            f(Integer.valueOf(bVarG.b), bitmap);
            bitmap.reconfigure(i, i2, config);
        }
        return bitmap;
    }

    @Override // defpackage.cf1
    public String e(Bitmap bitmap) {
        return h(na3.g(bitmap), bitmap.getConfig());
    }

    @Override // defpackage.cf1
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.b.f();
        if (bitmap != null) {
            f(Integer.valueOf(na3.g(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.b);
        sb.append(", sortedSizes=(");
        for (Map.Entry entry : this.c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), Constants.STR_EMPTY);
        }
        sb.append(")}");
        return sb.toString();
    }
}
