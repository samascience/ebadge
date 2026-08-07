package defpackage;

import java.lang.reflect.Array;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class p9 {
    private b a = null;
    private c b = null;
    private h c = null;
    private f d = null;
    private g e = null;
    private e f = null;
    private d g = null;

    static class a {
        final /* synthetic */ Class a;
        final /* synthetic */ int b;
        final /* synthetic */ Object c;

        a(Class cls, int i, Object obj) {
            this.a = cls;
            this.b = i;
            this.c = obj;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!ay.H(obj, this.a) || Array.getLength(obj) != this.b) {
                return false;
            }
            for (int i = 0; i < this.b; i++) {
                Object obj2 = Array.get(this.c, i);
                Object obj3 = Array.get(obj, i);
                if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class b extends q62 {
        @Override // defpackage.q62
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final boolean[] a(int i) {
            return new boolean[i];
        }
    }

    public static final class c extends q62 {
        @Override // defpackage.q62
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final byte[] a(int i) {
            return new byte[i];
        }
    }

    public static final class d extends q62 {
        @Override // defpackage.q62
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final double[] a(int i) {
            return new double[i];
        }
    }

    public static final class e extends q62 {
        @Override // defpackage.q62
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final float[] a(int i) {
            return new float[i];
        }
    }

    public static final class f extends q62 {
        @Override // defpackage.q62
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final int[] a(int i) {
            return new int[i];
        }
    }

    public static final class g extends q62 {
        @Override // defpackage.q62
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final long[] a(int i) {
            return new long[i];
        }
    }

    public static final class h extends q62 {
        @Override // defpackage.q62
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final short[] a(int i) {
            return new short[i];
        }
    }

    public static HashSet a(Object[] objArr) {
        if (objArr == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet(objArr.length);
        for (Object obj : objArr) {
            hashSet.add(obj);
        }
        return hashSet;
    }

    public static Object b(Object obj) {
        return new a(obj.getClass(), Array.getLength(obj), obj);
    }

    public static Object[] j(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] == obj) {
                if (i == 0) {
                    return objArr;
                }
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
                System.arraycopy(objArr, 0, objArr2, 1, i);
                objArr2[0] = obj;
                int i2 = i + 1;
                int i3 = length - i2;
                if (i3 > 0) {
                    System.arraycopy(objArr, i2, objArr2, i2, i3);
                }
                return objArr2;
            }
        }
        Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length + 1);
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr3, 1, length);
        }
        objArr3[0] = obj;
        return objArr3;
    }

    public b c() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }

    public c d() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }

    public d e() {
        if (this.g == null) {
            this.g = new d();
        }
        return this.g;
    }

    public e f() {
        if (this.f == null) {
            this.f = new e();
        }
        return this.f;
    }

    public f g() {
        if (this.d == null) {
            this.d = new f();
        }
        return this.d;
    }

    public g h() {
        if (this.e == null) {
            this.e = new g();
        }
        return this.e;
    }

    public h i() {
        if (this.c == null) {
            this.c = new h();
        }
        return this.c;
    }
}
