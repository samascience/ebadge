package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import defpackage.p31;
import defpackage.y70;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.b0;
import kotlin.collections.j;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentStrictMode {
    public static final FragmentStrictMode a = new FragmentStrictMode();
    private static b b = b.d;

    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    public interface a {
    }

    public static final class b {
        public static final a c = new a(null);
        public static final b d = new b(b0.d(), null, u.f());
        private final Set a;
        private final Map b;

        public static final class a {
            public /* synthetic */ a(y70 y70Var) {
                this();
            }

            private a() {
            }
        }

        public b(Set set, a aVar, Map map) {
            p31.f(set, "flags");
            p31.f(map, "allowedViolations");
            this.a = set;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.b = linkedHashMap;
        }

        public final Set a() {
            return this.a;
        }

        public final a b() {
            return null;
        }

        public final Map c() {
            return this.b;
        }
    }

    private FragmentStrictMode() {
    }

    private final b b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                p31.e(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.B0() != null) {
                    b bVarB0 = parentFragmentManager.B0();
                    p31.c(bVarB0);
                    return bVarB0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return b;
    }

    private final void c(b bVar, final Violation violation) {
        Fragment fragment = violation.getFragment();
        final String name = fragment.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, violation);
        }
        bVar.b();
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            o(fragment, new Runnable() { // from class: kq0
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.d(name, violation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, Violation violation) {
        p31.f(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    private final void e(Violation violation) {
        if (FragmentManager.I0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + violation.getFragment().getClass().getName(), violation);
        }
    }

    public static final void f(Fragment fragment, String str) {
        p31.f(fragment, "fragment");
        p31.f(str, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(fragmentReuseViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.p(bVarB, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.c(bVarB, fragmentReuseViolation);
        }
    }

    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        p31.f(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(fragmentTagUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, fragmentTagUsageViolation);
        }
    }

    public static final void h(Fragment fragment) {
        p31.f(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(getRetainInstanceUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getRetainInstanceUsageViolation);
        }
    }

    public static final void i(Fragment fragment) {
        p31.f(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(getTargetFragmentRequestCodeUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void j(Fragment fragment) {
        p31.f(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(getTargetFragmentUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getTargetFragmentUsageViolation);
        }
    }

    public static final void k(Fragment fragment) {
        p31.f(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(setRetainInstanceUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setRetainInstanceUsageViolation);
        }
    }

    public static final void l(Fragment fragment, Fragment fragment2, int i) {
        p31.f(fragment, "violatingFragment");
        p31.f(fragment2, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, i);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(setTargetFragmentUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setTargetFragmentUsageViolation);
        }
    }

    public static final void m(Fragment fragment, boolean z) {
        p31.f(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(setUserVisibleHintViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.p(bVarB, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setUserVisibleHintViolation);
        }
    }

    public static final void n(Fragment fragment, ViewGroup viewGroup) {
        p31.f(fragment, "fragment");
        p31.f(viewGroup, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(wrongFragmentContainerViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.p(bVarB, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.c(bVarB, wrongFragmentContainerViolation);
        }
    }

    private final void o(Fragment fragment, Runnable runnable) {
        if (!fragment.isAdded()) {
            runnable.run();
            return;
        }
        Handler handlerG = fragment.getParentFragmentManager().v0().g();
        p31.e(handlerG, "fragment.parentFragmentManager.host.handler");
        if (p31.a(handlerG.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerG.post(runnable);
        }
    }

    private final boolean p(b bVar, Class cls, Class cls2) {
        Set set = (Set) bVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (p31.a(cls2.getSuperclass(), Violation.class) || !j.D(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
