package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    private final e a;
    private final ClassLoader b;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    String k;
    int l;
    CharSequence m;
    int n;
    CharSequence o;
    ArrayList p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList f196q;
    ArrayList s;
    ArrayList c = new ArrayList();
    boolean j = true;
    boolean r = false;

    static final class a {
        int a;
        Fragment b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        Lifecycle.State h;
        Lifecycle.State i;

        a() {
        }

        a(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
            this.c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.h = state;
            this.i = state;
        }

        a(int i, Fragment fragment, boolean z) {
            this.a = i;
            this.b = fragment;
            this.c = z;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.h = state;
            this.i = state;
        }

        a(int i, Fragment fragment, Lifecycle.State state) {
            this.a = i;
            this.b = fragment;
            this.c = false;
            this.h = fragment.mMaxState;
            this.i = state;
        }
    }

    m(e eVar, ClassLoader classLoader) {
        this.a = eVar;
        this.b = classLoader;
    }

    public m b(int i, Fragment fragment, String str) {
        n(i, fragment, str, 1);
        return this;
    }

    m c(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return b(viewGroup.getId(), fragment, str);
    }

    public m d(Fragment fragment, String str) {
        n(0, fragment, str, 1);
        return this;
    }

    void e(a aVar) {
        this.c.add(aVar);
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.g = this.g;
    }

    public m f(String str) {
        if (!this.j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.i = true;
        this.k = str;
        return this;
    }

    public m g(Fragment fragment) {
        e(new a(7, fragment));
        return this;
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    public m l(Fragment fragment) {
        e(new a(6, fragment));
        return this;
    }

    public m m() {
        if (this.i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.j = false;
        return this;
    }

    void n(int i, Fragment fragment, String str, int i2) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        e(new a(i2, fragment));
    }

    public m o(Fragment fragment) {
        e(new a(3, fragment));
        return this;
    }

    public m p(int i, Fragment fragment) {
        return q(i, fragment, null);
    }

    public m q(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        n(i, fragment, str, 2);
        return this;
    }

    public m r(Fragment fragment, Lifecycle.State state) {
        e(new a(10, fragment, state));
        return this;
    }

    public m s(boolean z) {
        this.r = z;
        return this;
    }
}
