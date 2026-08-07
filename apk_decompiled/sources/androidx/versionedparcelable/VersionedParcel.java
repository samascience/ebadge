package androidx.versionedparcelable;

import android.os.Parcelable;
import defpackage.ob3;
import defpackage.u9;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class VersionedParcel {
    protected final u9 a;
    protected final u9 b;
    protected final u9 c;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(u9 u9Var, u9 u9Var2, u9 u9Var3) {
        this.a = u9Var;
        this.b = u9Var2;
        this.c = u9Var3;
    }

    private void N(ob3 ob3Var) {
        try {
            I(c(ob3Var.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(ob3Var.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    private Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws NoSuchMethodException {
        Method method = (Method) this.a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i) {
        w(i);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i) {
        w(i);
        C(charSequence);
    }

    protected abstract void E(int i);

    public void F(int i, int i2) {
        w(i2);
        E(i);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i) {
        w(i);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i) {
        w(i);
        I(str);
    }

    protected void K(ob3 ob3Var, VersionedParcel versionedParcel) {
        try {
            e(ob3Var.getClass()).invoke(null, ob3Var, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }

    protected void L(ob3 ob3Var) {
        if (ob3Var == null) {
            I(null);
            return;
        }
        N(ob3Var);
        VersionedParcel versionedParcelB = b();
        K(ob3Var, versionedParcelB);
        versionedParcelB.a();
    }

    public void M(ob3 ob3Var, int i) {
        w(i);
        L(ob3Var);
    }

    protected abstract void a();

    protected abstract VersionedParcel b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z, int i) {
        return !m(i) ? z : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i) {
        return !m(i) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i) {
        return !m(i) ? charSequence : k();
    }

    protected abstract boolean m(int i);

    protected ob3 n(String str, VersionedParcel versionedParcel) {
        try {
            return (ob3) d(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    protected abstract int o();

    public int p(int i, int i2) {
        return !m(i2) ? i : o();
    }

    protected abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i) {
        return !m(i) ? parcelable : q();
    }

    protected abstract String s();

    public String t(String str, int i) {
        return !m(i) ? str : s();
    }

    protected ob3 u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public ob3 v(ob3 ob3Var, int i) {
        return !m(i) ? ob3Var : u();
    }

    protected abstract void w(int i);

    public void x(boolean z, boolean z2) {
    }

    protected abstract void y(boolean z);

    public void z(boolean z, int i) {
        w(i);
        y(z);
    }
}
