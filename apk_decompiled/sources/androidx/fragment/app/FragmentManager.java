package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.R$id;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import com.tencent.connect.common.Constants;
import defpackage.a4;
import defpackage.b4;
import defpackage.c4;
import defpackage.db1;
import defpackage.e4;
import defpackage.e43;
import defpackage.f4;
import defpackage.fm1;
import defpackage.g4;
import defpackage.iq0;
import defpackage.kw1;
import defpackage.li1;
import defpackage.ne3;
import defpackage.ou1;
import defpackage.ov1;
import defpackage.q20;
import defpackage.qu1;
import defpackage.si1;
import defpackage.tp0;
import defpackage.uv1;
import defpackage.vu1;
import defpackage.x12;
import defpackage.zj2;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {
    private static boolean S = false;
    private f4 D;
    private f4 E;
    private f4 F;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList M;
    private ArrayList N;
    private ArrayList O;
    private androidx.fragment.app.j P;
    private FragmentStrictMode.b Q;
    private boolean b;
    ArrayList d;
    private ArrayList e;
    private OnBackPressedDispatcher g;
    private ArrayList m;
    private androidx.fragment.app.f v;
    private tp0 w;
    private Fragment x;
    Fragment y;
    private final ArrayList a = new ArrayList();
    private final androidx.fragment.app.l c = new androidx.fragment.app.l();
    private final androidx.fragment.app.g f = new androidx.fragment.app.g(this);
    private final ou1 h = new b(false);
    private final AtomicInteger i = new AtomicInteger();
    private final Map j = Collections.synchronizedMap(new HashMap());
    private final Map k = Collections.synchronizedMap(new HashMap());
    private final Map l = Collections.synchronizedMap(new HashMap());
    private final androidx.fragment.app.h n = new androidx.fragment.app.h(this);
    private final CopyOnWriteArrayList o = new CopyOnWriteArrayList();
    private final q20 p = new q20() { // from class: dq0
        @Override // defpackage.q20
        public final void accept(Object obj) {
            this.a.R0((Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final q20 f195q = new q20() { // from class: eq0
        @Override // defpackage.q20
        public final void accept(Object obj) {
            this.a.S0((Integer) obj);
        }
    };
    private final q20 r = new q20() { // from class: fq0
        @Override // defpackage.q20
        public final void accept(Object obj) {
            this.a.T0((fm1) obj);
        }
    };
    private final q20 s = new q20() { // from class: gq0
        @Override // defpackage.q20
        public final void accept(Object obj) {
            this.a.U0((x12) obj);
        }
    };
    private final si1 t = new c();
    int u = -1;
    private androidx.fragment.app.e z = null;
    private androidx.fragment.app.e A = new d();
    private s B = null;
    private s C = new e();
    ArrayDeque G = new ArrayDeque();
    private Runnable R = new f();

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$6, reason: invalid class name */
    class AnonymousClass6 implements androidx.lifecycle.f {
        final /* synthetic */ String a;
        final /* synthetic */ Lifecycle b;
        final /* synthetic */ FragmentManager c;

        @Override // androidx.lifecycle.f
        public void c(db1 db1Var, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START && ((Bundle) this.c.k.get(this.a)) != null) {
                throw null;
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.b.d(this);
                this.c.l.remove(this.a);
            }
        }
    }

    class a implements a4 {
        a() {
        }

        @Override // defpackage.a4
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfo.a;
            int i2 = launchedFragmentInfo.b;
            Fragment fragmentI = FragmentManager.this.c.i(str);
            if (fragmentI != null) {
                fragmentI.onRequestPermissionsResult(i2, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class b extends ou1 {
        b(boolean z) {
            super(z);
        }

        @Override // defpackage.ou1
        public void d() {
            FragmentManager.this.E0();
        }
    }

    class c implements si1 {
        c() {
        }

        @Override // defpackage.si1
        public boolean a(MenuItem menuItem) {
            return FragmentManager.this.K(menuItem);
        }

        @Override // defpackage.si1
        public void b(Menu menu) {
            FragmentManager.this.L(menu);
        }

        @Override // defpackage.si1
        public void c(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.D(menu, menuInflater);
        }

        @Override // defpackage.si1
        public void d(Menu menu) {
            FragmentManager.this.P(menu);
        }
    }

    class d extends androidx.fragment.app.e {
        d() {
        }

        @Override // androidx.fragment.app.e
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.v0().b(FragmentManager.this.v0().f(), str, null);
        }
    }

    class e implements s {
        e() {
        }

        @Override // androidx.fragment.app.s
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new androidx.fragment.app.b(viewGroup);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.b0(true);
        }
    }

    class g implements iq0 {
        final /* synthetic */ Fragment a;

        g(Fragment fragment) {
            this.a = fragment;
        }

        @Override // defpackage.iq0
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.a.onAttachFragment(fragment);
        }
    }

    class h implements a4 {
        h() {
        }

        @Override // defpackage.a4
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfo.a;
            int i = launchedFragmentInfo.b;
            Fragment fragmentI = FragmentManager.this.c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    class i implements a4 {
        i() {
        }

        @Override // defpackage.a4
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfo.a;
            int i = launchedFragmentInfo.b;
            Fragment fragmentI = FragmentManager.this.c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    static class j extends b4 {
        j() {
        }

        @Override // defpackage.b4
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = intentSenderRequest.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.d()).b(null).c(intentSenderRequest.c(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // defpackage.b4
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    interface k {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    private class l implements k {
        final String a;
        final int b;
        final int c;

        l(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.k
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.y;
            if (fragment == null || this.b >= 0 || this.a != null || !fragment.getChildFragmentManager().d1()) {
                return FragmentManager.this.g1(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    static Fragment C0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean I0(int i2) {
        return S || Log.isLoggable("FragmentManager", i2);
    }

    private boolean J0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.q();
    }

    private boolean K0() {
        Fragment fragment = this.x;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.x.getParentFragmentManager().K0();
    }

    private void M(Fragment fragment) {
        if (fragment == null || !fragment.equals(g0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(Configuration configuration) {
        if (K0()) {
            A(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(Integer num) {
        if (K0() && num.intValue() == 80) {
            G(false);
        }
    }

    private void T(int i2) {
        try {
            this.b = true;
            this.c.d(i2);
            Y0(i2, false);
            Iterator it = u().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).j();
            }
            this.b = false;
            b0(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(fm1 fm1Var) {
        if (K0()) {
            H(fm1Var.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(x12 x12Var) {
        if (K0()) {
            O(x12Var.a(), false);
        }
    }

    private void W() {
        if (this.L) {
            this.L = false;
            u1();
        }
    }

    private void Y() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).j();
        }
    }

    private void a0(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.v == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.v.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            r();
        }
        if (this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }

    private static void d0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                aVar.t(-1);
                aVar.y();
            } else {
                aVar.t(1);
                aVar.x();
            }
            i2++;
        }
    }

    private void e0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        boolean z = ((androidx.fragment.app.a) arrayList.get(i2)).r;
        ArrayList arrayList3 = this.O;
        if (arrayList3 == null) {
            this.O = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.O.addAll(this.c.o());
        Fragment fragmentZ0 = z0();
        boolean z2 = false;
        for (int i4 = i2; i4 < i3; i4++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i4);
            fragmentZ0 = !((Boolean) arrayList2.get(i4)).booleanValue() ? aVar.z(this.O, fragmentZ0) : aVar.C(this.O, fragmentZ0);
            z2 = z2 || aVar.i;
        }
        this.O.clear();
        if (!z && this.u >= 1) {
            for (int i5 = i2; i5 < i3; i5++) {
                Iterator it = ((androidx.fragment.app.a) arrayList.get(i5)).c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((m.a) it.next()).b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.c.r(w(fragment));
                    }
                }
            }
        }
        d0(arrayList, arrayList2, i2, i3);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
        for (int i6 = i2; i6 < i3; i6++) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i6);
            if (zBooleanValue) {
                for (int size = aVar2.c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((m.a) aVar2.c.get(size)).b;
                    if (fragment2 != null) {
                        w(fragment2).m();
                    }
                }
            } else {
                Iterator it2 = aVar2.c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = ((m.a) it2.next()).b;
                    if (fragment3 != null) {
                        w(fragment3).m();
                    }
                }
            }
        }
        Y0(this.u, true);
        for (SpecialEffectsController specialEffectsController : v(arrayList, i2, i3)) {
            specialEffectsController.r(zBooleanValue);
            specialEffectsController.p();
            specialEffectsController.g();
        }
        while (i2 < i3) {
            androidx.fragment.app.a aVar3 = (androidx.fragment.app.a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue() && aVar3.v >= 0) {
                aVar3.v = -1;
            }
            aVar3.B();
            i2++;
        }
        if (z2) {
            k1();
        }
    }

    private boolean f1(String str, int i2, int i3) {
        b0(false);
        a0(true);
        Fragment fragment = this.y;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().d1()) {
            return true;
        }
        boolean zG1 = g1(this.M, this.N, str, i2, i3);
        if (zG1) {
            this.b = true;
            try {
                i1(this.M, this.N);
                s();
            } catch (Throwable th) {
                s();
                throw th;
            }
        }
        w1();
        W();
        this.c.b();
        return zG1;
    }

    private int h0(String str, int i2, boolean z) {
        ArrayList arrayList = this.d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i2 < 0) {
            if (z) {
                return 0;
            }
            return this.d.size() - 1;
        }
        int size = this.d.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.d.get(size);
            if ((str != null && str.equals(aVar.A())) || (i2 >= 0 && i2 == aVar.v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z) {
            if (size == this.d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.d.get(size - 1);
            if ((str == null || !str.equals(aVar2.A())) && (i2 < 0 || i2 != aVar2.v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    private void i1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((androidx.fragment.app.a) arrayList.get(i2)).r) {
                if (i3 != i2) {
                    e0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i3)).r) {
                        i3++;
                    }
                }
                e0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            e0(arrayList, arrayList2, i3, size);
        }
    }

    private void k1() {
        ArrayList arrayList = this.m;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        e43.a(this.m.get(0));
        throw null;
    }

    static FragmentManager l0(View view) {
        FragmentActivity fragmentActivity;
        Fragment fragmentM0 = m0(view);
        if (fragmentM0 != null) {
            if (fragmentM0.isAdded()) {
                return fragmentM0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + fragmentM0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    private static Fragment m0(View view) {
        while (view != null) {
            Fragment fragmentC0 = C0(view);
            if (fragmentC0 != null) {
                return fragmentC0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    static int m1(int i2) {
        int i3 = 4097;
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 8194) {
            i3 = 8197;
            if (i2 == 8197) {
                return 4100;
            }
            if (i2 == 4099) {
                return 4099;
            }
            if (i2 != 4100) {
                return 0;
            }
        }
        return i3;
    }

    private void n0() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).k();
        }
    }

    private boolean o0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return false;
            }
            try {
                int size = this.a.size();
                boolean zA = false;
                for (int i2 = 0; i2 < size; i2++) {
                    zA |= ((k) this.a.get(i2)).a(arrayList, arrayList2);
                }
                this.a.clear();
                this.v.g().removeCallbacks(this.R);
                return zA;
            } catch (Throwable th) {
                this.a.clear();
                this.v.g().removeCallbacks(this.R);
                throw th;
            }
        }
    }

    private androidx.fragment.app.j q0(Fragment fragment) {
        return this.P.l(fragment);
    }

    private void r() {
        if (P0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void s() {
        this.b = false;
        this.N.clear();
        this.M.clear();
    }

    private ViewGroup s0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.w.d()) {
            View viewC = this.w.c(fragment.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    private void s1(Fragment fragment) {
        ViewGroup viewGroupS0 = s0(fragment);
        if (viewGroupS0 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        int i2 = R$id.visible_removing_fragment_view_tag;
        if (viewGroupS0.getTag(i2) == null) {
            viewGroupS0.setTag(i2, fragment);
        }
        ((Fragment) viewGroupS0.getTag(i2)).setPopDirection(fragment.getPopDirection());
    }

    private void t() {
        boolean zP;
        androidx.fragment.app.f fVar = this.v;
        if (fVar instanceof ne3) {
            zP = this.c.p().p();
        } else {
            zP = fVar.f() instanceof Activity ? !((Activity) this.v.f()).isChangingConfigurations() : true;
        }
        if (zP) {
            Iterator it = this.j.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).a.iterator();
                while (it2.hasNext()) {
                    this.c.p().i((String) it2.next());
                }
            }
        }
    }

    private Set u() {
        HashSet hashSet = new HashSet();
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((androidx.fragment.app.k) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, A0()));
            }
        }
        return hashSet;
    }

    private void u1() {
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            b1((androidx.fragment.app.k) it.next());
        }
    }

    private Set v(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it = ((androidx.fragment.app.a) arrayList.get(i2)).c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((m.a) it.next()).b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    private void v1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new r("FragmentManager"));
        androidx.fragment.app.f fVar = this.v;
        if (fVar != null) {
            try {
                fVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            X("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    private void w1() {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    this.h.j(p0() > 0 && N0(this.x));
                } else {
                    this.h.j(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void A(Configuration configuration, boolean z) {
        if (z && (this.v instanceof vu1)) {
            v1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z) {
                    fragment.mChildFragmentManager.A(configuration, true);
                }
            }
        }
    }

    s A0() {
        s sVar = this.B;
        if (sVar != null) {
            return sVar;
        }
        Fragment fragment = this.x;
        return fragment != null ? fragment.mFragmentManager.A0() : this.C;
    }

    boolean B(MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public FragmentStrictMode.b B0() {
        return this.Q;
    }

    void C() {
        this.I = false;
        this.J = false;
        this.P.r(false);
        T(1);
    }

    boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && M0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    androidx.lifecycle.r D0(Fragment fragment) {
        return this.P.o(fragment);
    }

    void E() {
        this.K = true;
        b0(true);
        Y();
        t();
        T(-1);
        Object obj = this.v;
        if (obj instanceof kw1) {
            ((kw1) obj).removeOnTrimMemoryListener(this.f195q);
        }
        Object obj2 = this.v;
        if (obj2 instanceof vu1) {
            ((vu1) obj2).removeOnConfigurationChangedListener(this.p);
        }
        Object obj3 = this.v;
        if (obj3 instanceof ov1) {
            ((ov1) obj3).removeOnMultiWindowModeChangedListener(this.r);
        }
        Object obj4 = this.v;
        if (obj4 instanceof uv1) {
            ((uv1) obj4).removeOnPictureInPictureModeChangedListener(this.s);
        }
        Object obj5 = this.v;
        if (obj5 instanceof li1) {
            ((li1) obj5).removeMenuProvider(this.t);
        }
        this.v = null;
        this.w = null;
        this.x = null;
        if (this.g != null) {
            this.h.h();
            this.g = null;
        }
        f4 f4Var = this.D;
        if (f4Var != null) {
            f4Var.c();
            this.E.c();
            this.F.c();
        }
    }

    void E0() {
        b0(true);
        if (this.h.g()) {
            d1();
        } else {
            this.g.k();
        }
    }

    void F() {
        T(1);
    }

    void F0(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        s1(fragment);
    }

    void G(boolean z) {
        if (z && (this.v instanceof kw1)) {
            v1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z) {
                    fragment.mChildFragmentManager.G(true);
                }
            }
        }
    }

    void G0(Fragment fragment) {
        if (fragment.mAdded && J0(fragment)) {
            this.H = true;
        }
    }

    void H(boolean z, boolean z2) {
        if (z2 && (this.v instanceof ov1)) {
            v1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.H(z, true);
                }
            }
        }
    }

    public boolean H0() {
        return this.K;
    }

    void I(Fragment fragment) {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((iq0) it.next()).a(this, fragment);
        }
    }

    void J() {
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.J();
            }
        }
    }

    boolean K(MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void L(Menu menu) {
        if (this.u < 1) {
            return;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    boolean L0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    boolean M0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    void N() {
        T(5);
    }

    boolean N0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.z0()) && N0(fragmentManager.x);
    }

    void O(boolean z, boolean z2) {
        if (z2 && (this.v instanceof uv1)) {
            v1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.O(z, true);
                }
            }
        }
    }

    boolean O0(int i2) {
        return this.u >= i2;
    }

    boolean P(Menu menu) {
        boolean z = false;
        if (this.u < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && M0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean P0() {
        return this.I || this.J;
    }

    void Q() {
        w1();
        M(this.y);
    }

    void R() {
        this.I = false;
        this.J = false;
        this.P.r(false);
        T(7);
    }

    void S() {
        this.I = false;
        this.J = false;
        this.P.r(false);
        T(5);
    }

    void U() {
        this.J = true;
        this.P.r(true);
        T(4);
    }

    void V() {
        T(2);
    }

    void V0(Fragment fragment, String[] strArr, int i2) {
        if (this.F == null) {
            this.v.k(fragment, strArr, i2);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        this.F.a(strArr);
    }

    void W0(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (this.D == null) {
            this.v.m(fragment, intent, i2, bundle);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.D.a(intent);
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = (Fragment) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.v(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            try {
                int size3 = this.a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size3; i4++) {
                        k kVar = (k) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(kVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.w);
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    void X0(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Intent intent2;
        if (this.E == null) {
            this.v.n(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (I0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.a(intentSender).b(intent2).c(i4, i3).a();
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        if (I0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.E.a(intentSenderRequestA);
    }

    void Y0(int i2, boolean z) {
        androidx.fragment.app.f fVar;
        if (this.v == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.u) {
            this.u = i2;
            this.c.t();
            u1();
            if (this.H && (fVar = this.v) != null && this.u == 7) {
                fVar.o();
                this.H = false;
            }
        }
    }

    void Z(k kVar, boolean z) {
        if (!z) {
            if (this.v == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            r();
        }
        synchronized (this.a) {
            try {
                if (this.v == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(kVar);
                    o1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void Z0() {
        if (this.v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.r(false);
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void a1(FragmentContainerView fragmentContainerView) {
        View view;
        for (androidx.fragment.app.k kVar : this.c.k()) {
            Fragment fragmentK = kVar.k();
            if (fragmentK.mContainerId == fragmentContainerView.getId() && (view = fragmentK.mView) != null && view.getParent() == null) {
                fragmentK.mContainer = fragmentContainerView;
                kVar.b();
            }
        }
    }

    boolean b0(boolean z) {
        a0(z);
        boolean z2 = false;
        while (o0(this.M, this.N)) {
            z2 = true;
            this.b = true;
            try {
                i1(this.M, this.N);
                s();
            } catch (Throwable th) {
                s();
                throw th;
            }
        }
        w1();
        W();
        this.c.b();
        return z2;
    }

    void b1(androidx.fragment.app.k kVar) {
        Fragment fragmentK = kVar.k();
        if (fragmentK.mDeferStart) {
            if (this.b) {
                this.L = true;
            } else {
                fragmentK.mDeferStart = false;
                kVar.m();
            }
        }
    }

    void c0(k kVar, boolean z) {
        if (z && (this.v == null || this.K)) {
            return;
        }
        a0(z);
        if (kVar.a(this.M, this.N)) {
            this.b = true;
            try {
                i1(this.M, this.N);
                s();
            } catch (Throwable th) {
                s();
                throw th;
            }
        }
        w1();
        W();
        this.c.b();
    }

    void c1(int i2, int i3, boolean z) {
        if (i2 >= 0) {
            Z(new l(null, i2, i3), z);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public boolean d1() {
        return f1(null, -1, 0);
    }

    public boolean e1(int i2, int i3) {
        if (i2 >= 0) {
            return f1(null, i2, i3);
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public boolean f0() {
        boolean zB0 = b0(true);
        n0();
        return zB0;
    }

    Fragment g0(String str) {
        return this.c.f(str);
    }

    boolean g1(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        int iH0 = h0(str, i2, (i3 & 1) != 0);
        if (iH0 < 0) {
            return false;
        }
        for (int size = this.d.size() - 1; size >= iH0; size--) {
            arrayList.add((androidx.fragment.app.a) this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    void h1(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        this.c.u(fragment);
        if (J0(fragment)) {
            this.H = true;
        }
        fragment.mRemoving = true;
        s1(fragment);
    }

    void i(androidx.fragment.app.a aVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(aVar);
    }

    public Fragment i0(int i2) {
        return this.c.g(i2);
    }

    androidx.fragment.app.k j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.f(fragment, str);
        }
        if (I0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        androidx.fragment.app.k kVarW = w(fragment);
        fragment.mFragmentManager = this;
        this.c.r(kVarW);
        if (!fragment.mDetached) {
            this.c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (J0(fragment)) {
                this.H = true;
            }
        }
        return kVarW;
    }

    public Fragment j0(String str) {
        return this.c.h(str);
    }

    void j1(Fragment fragment) {
        this.P.q(fragment);
    }

    public void k(iq0 iq0Var) {
        this.o.add(iq0Var);
    }

    Fragment k0(String str) {
        return this.c.i(str);
    }

    void l(Fragment fragment) {
        this.P.f(fragment);
    }

    void l1(Parcelable parcelable) {
        androidx.fragment.app.k kVar;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.v.f().getClassLoader());
                this.k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.v.f().getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        this.c.x(arrayList);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.c.v();
        Iterator it = fragmentManagerState.a.iterator();
        while (it.hasNext()) {
            FragmentState fragmentStateB = this.c.B((String) it.next(), null);
            if (fragmentStateB != null) {
                Fragment fragmentK = this.P.k(fragmentStateB.b);
                if (fragmentK != null) {
                    if (I0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentK);
                    }
                    kVar = new androidx.fragment.app.k(this.n, this.c, fragmentK, fragmentStateB);
                } else {
                    kVar = new androidx.fragment.app.k(this.n, this.c, this.v.f().getClassLoader(), t0(), fragmentStateB);
                }
                Fragment fragmentK2 = kVar.k();
                fragmentK2.mFragmentManager = this;
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK2.mWho + "): " + fragmentK2);
                }
                kVar.o(this.v.f().getClassLoader());
                this.c.r(kVar);
                kVar.t(this.u);
            }
        }
        for (Fragment fragment : this.P.n()) {
            if (!this.c.c(fragment.mWho)) {
                if (I0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.a);
                }
                this.P.q(fragment);
                fragment.mFragmentManager = this;
                androidx.fragment.app.k kVar2 = new androidx.fragment.app.k(this.n, this.c, fragment);
                kVar2.t(1);
                kVar2.m();
                fragment.mRemoving = true;
                kVar2.m();
            }
        }
        this.c.w(fragmentManagerState.b);
        if (fragmentManagerState.c != null) {
            this.d = new ArrayList(fragmentManagerState.c.length);
            int i2 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.c;
                if (i2 >= backStackRecordStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarB = backStackRecordStateArr[i2].b(this);
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + aVarB.v + "): " + aVarB);
                    PrintWriter printWriter = new PrintWriter(new r("FragmentManager"));
                    aVarB.w("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(aVarB);
                i2++;
            }
        } else {
            this.d = null;
        }
        this.i.set(fragmentManagerState.d);
        String str3 = fragmentManagerState.e;
        if (str3 != null) {
            Fragment fragmentG0 = g0(str3);
            this.y = fragmentG0;
            M(fragmentG0);
        }
        ArrayList arrayList2 = fragmentManagerState.f;
        if (arrayList2 != null) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                this.j.put((String) arrayList2.get(i3), (BackStackState) fragmentManagerState.g.get(i3));
            }
        }
        this.G = new ArrayDeque(fragmentManagerState.h);
    }

    int m() {
        return this.i.getAndIncrement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void n(androidx.fragment.app.f fVar, tp0 tp0Var, Fragment fragment) {
        String str;
        db1 db1Var;
        if (this.v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.v = fVar;
        this.w = tp0Var;
        this.x = fragment;
        if (fragment != null) {
            k(new g(fragment));
        } else if (fVar instanceof iq0) {
            k((iq0) fVar);
        }
        if (this.x != null) {
            w1();
        }
        if (fVar instanceof qu1) {
            qu1 qu1Var = (qu1) fVar;
            OnBackPressedDispatcher onBackPressedDispatcher = qu1Var.getOnBackPressedDispatcher();
            this.g = onBackPressedDispatcher;
            if (fragment != null) {
                db1Var = qu1Var;
                db1Var = fragment;
            }
            db1Var = qu1Var;
            onBackPressedDispatcher.h(db1Var, this.h);
        }
        if (fragment != null) {
            this.P = fragment.mFragmentManager.q0(fragment);
        } else if (fVar instanceof ne3) {
            this.P = androidx.fragment.app.j.m(((ne3) fVar).getViewModelStore());
        } else {
            this.P = new androidx.fragment.app.j(false);
        }
        this.P.r(P0());
        this.c.A(this.P);
        Object obj = this.v;
        if ((obj instanceof zj2) && fragment == null) {
            androidx.savedstate.a savedStateRegistry = ((zj2) obj).getSavedStateRegistry();
            savedStateRegistry.h("android:support:fragments", new androidx.savedstate.a.c() { // from class: hq0
                @Override // androidx.savedstate.a.c
                public final Bundle a() {
                    return this.a.Q0();
                }
            });
            Bundle bundleB = savedStateRegistry.b("android:support:fragments");
            if (bundleB != null) {
                l1(bundleB);
            }
        }
        Object obj2 = this.v;
        if (obj2 instanceof g4) {
            ActivityResultRegistry activityResultRegistry = ((g4) obj2).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = Constants.STR_EMPTY;
            }
            String str2 = "FragmentManager:" + str;
            this.D = activityResultRegistry.i(str2 + "StartActivityForResult", new e4(), new h());
            this.E = activityResultRegistry.i(str2 + "StartIntentSenderForResult", new j(), new i());
            this.F = activityResultRegistry.i(str2 + "RequestPermissions", new c4(), new a());
        }
        Object obj3 = this.v;
        if (obj3 instanceof vu1) {
            ((vu1) obj3).addOnConfigurationChangedListener(this.p);
        }
        Object obj4 = this.v;
        if (obj4 instanceof kw1) {
            ((kw1) obj4).addOnTrimMemoryListener(this.f195q);
        }
        Object obj5 = this.v;
        if (obj5 instanceof ov1) {
            ((ov1) obj5).addOnMultiWindowModeChangedListener(this.r);
        }
        Object obj6 = this.v;
        if (obj6 instanceof uv1) {
            ((uv1) obj6).addOnPictureInPictureModeChangedListener(this.s);
        }
        Object obj7 = this.v;
        if ((obj7 instanceof li1) && fragment == null) {
            ((li1) obj7).addMenuProvider(this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public Bundle Q0() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        n0();
        Y();
        b0(true);
        this.I = true;
        this.P.r(true);
        ArrayList arrayListY = this.c.y();
        ArrayList<FragmentState> arrayListM = this.c.m();
        if (!arrayListM.isEmpty()) {
            ArrayList arrayListZ = this.c.z();
            ArrayList arrayList = this.d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i2 = 0; i2 < size; i2++) {
                    backStackRecordStateArr[i2] = new BackStackRecordState((androidx.fragment.app.a) this.d.get(i2));
                    if (I0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.d.get(i2));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = arrayListY;
            fragmentManagerState.b = arrayListZ;
            fragmentManagerState.c = backStackRecordStateArr;
            fragmentManagerState.d = this.i.get();
            Fragment fragment = this.y;
            if (fragment != null) {
                fragmentManagerState.e = fragment.mWho;
            }
            fragmentManagerState.f.addAll(this.j.keySet());
            fragmentManagerState.g.addAll(this.j.values());
            fragmentManagerState.h = new ArrayList(this.G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.k.get(str));
            }
            for (FragmentState fragmentState : arrayListM) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                bundle.putBundle("fragment_" + fragmentState.b, bundle2);
            }
        } else if (I0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    void o(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.c.a(fragment);
            if (I0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (J0(fragment)) {
                this.H = true;
            }
        }
    }

    void o1() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.v.g().removeCallbacks(this.R);
                    this.v.g().post(this.R);
                    w1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public m p() {
        return new androidx.fragment.app.a(this);
    }

    public int p0() {
        ArrayList arrayList = this.d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void p1(Fragment fragment, boolean z) {
        ViewGroup viewGroupS0 = s0(fragment);
        if (viewGroupS0 == null || !(viewGroupS0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupS0).setDrawDisappearingViewsLast(!z);
    }

    boolean q() {
        boolean zJ0 = false;
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                zJ0 = J0(fragment);
            }
            if (zJ0) {
                return true;
            }
        }
        return false;
    }

    void q1(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    tp0 r0() {
        return this.w;
    }

    void r1(Fragment fragment) {
        if (fragment == null || (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.y;
            this.y = fragment;
            M(fragment2);
            M(this.y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public androidx.fragment.app.e t0() {
        androidx.fragment.app.e eVar = this.z;
        if (eVar != null) {
            return eVar;
        }
        Fragment fragment = this.x;
        return fragment != null ? fragment.mFragmentManager.t0() : this.A;
    }

    void t1(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.x)));
            sb.append("}");
        } else {
            androidx.fragment.app.f fVar = this.v;
            if (fVar != null) {
                sb.append(fVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public List u0() {
        return this.c.o();
    }

    public androidx.fragment.app.f v0() {
        return this.v;
    }

    androidx.fragment.app.k w(Fragment fragment) {
        androidx.fragment.app.k kVarN = this.c.n(fragment.mWho);
        if (kVarN != null) {
            return kVarN;
        }
        androidx.fragment.app.k kVar = new androidx.fragment.app.k(this.n, this.c, fragment);
        kVar.o(this.v.f().getClassLoader());
        kVar.t(this.u);
        return kVar;
    }

    LayoutInflater.Factory2 w0() {
        return this.f;
    }

    void x(Fragment fragment) {
        if (I0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (I0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.c.u(fragment);
            if (J0(fragment)) {
                this.H = true;
            }
            s1(fragment);
        }
    }

    androidx.fragment.app.h x0() {
        return this.n;
    }

    void y() {
        this.I = false;
        this.J = false;
        this.P.r(false);
        T(4);
    }

    Fragment y0() {
        return this.x;
    }

    void z() {
        this.I = false;
        this.J = false;
        this.P.r(false);
        T(0);
    }

    public Fragment z0() {
        return this.y;
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
        String a;
        int b;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        }

        LaunchedFragmentInfo(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readInt();
        }
    }
}
