package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.h0;
import androidx.lifecycle.Lifecycle;
import defpackage.af3;
import defpackage.ap2;
import defpackage.be3;
import defpackage.bh2;
import defpackage.c91;
import defpackage.db1;
import defpackage.g3;
import defpackage.ia1;
import defpackage.ki3;
import defpackage.kt2;
import defpackage.kw2;
import defpackage.ln1;
import defpackage.m42;
import defpackage.m8;
import defpackage.mu1;
import defpackage.mw2;
import defpackage.o8;
import defpackage.p8;
import defpackage.q30;
import defpackage.r2;
import defpackage.r70;
import defpackage.s30;
import defpackage.tc1;
import defpackage.u2;
import defpackage.u8;
import defpackage.v8;
import defpackage.xe3;
import defpackage.y8;
import defpackage.zi3;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class AppCompatDelegateImpl extends androidx.appcompat.app.c implements androidx.appcompat.view.menu.e.a, LayoutInflater.Factory2 {
    private static final ap2 o0 = new ap2();
    private static final boolean p0 = false;
    private static final int[] q0 = {R.attr.windowBackground};
    private static final boolean r0 = !"robolectric".equals(Build.FINGERPRINT);
    private boolean F;
    ViewGroup G;
    private TextView H;
    private View I;
    private boolean J;
    private boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    boolean P;
    private boolean Q;
    private PanelFeatureState[] R;
    private PanelFeatureState S;
    private boolean T;
    private boolean U;
    private boolean V;
    boolean W;
    private Configuration X;
    private int Y;
    private int Z;
    private int a0;
    private boolean b0;
    private p c0;
    private p d0;
    boolean e0;
    int f0;
    private final Runnable g0;
    private boolean h0;
    private Rect i0;
    final Object j;
    private Rect j0;
    final Context k;
    private y8 k0;
    Window l;
    private androidx.appcompat.app.f l0;
    private n m;
    private OnBackInvokedDispatcher m0;
    final m8 n;
    private OnBackInvokedCallback n0;
    androidx.appcompat.app.a o;
    MenuInflater p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f126q;
    private r70 r;
    private h s;
    private s t;
    u2 u;
    ActionBarContextView v;
    PopupWindow w;
    Runnable x;
    xe3 y;
    private boolean z;

    protected static final class PanelFeatureState {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.e j;
        androidx.appcompat.view.menu.c k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f127q = false;
        boolean r;
        Bundle s;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            int a;
            boolean b;
            Bundle c;

            class a implements Parcelable.ClassLoaderCreator {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.a = parcel.readInt();
                boolean z = parcel.readInt() == 1;
                savedState.b = z;
                if (z) {
                    savedState.c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b ? 1 : 0);
                if (this.b) {
                    parcel.writeBundle(this.c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.a = i;
        }

        androidx.appcompat.view.menu.k a(androidx.appcompat.view.menu.j.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.l, R$layout.abc_list_menu_item_layout);
                this.k = cVar;
                cVar.h(aVar);
                this.j.b(this.k);
            }
            return this.k.b(this.g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.R(this.k);
            }
            this.j = eVar;
            if (eVar == null || (cVar = this.k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                themeNewTheme.applyStyle(i, true);
            }
            themeNewTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            } else {
                themeNewTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            s30 s30Var = new s30(context, 0);
            s30Var.getTheme().setTo(themeNewTheme);
            this.l = s30Var;
            TypedArray typedArrayObtainStyledAttributes = s30Var.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f0 & 1) != 0) {
                appCompatDelegateImpl.k0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f0 & 4096) != 0) {
                appCompatDelegateImpl2.k0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.e0 = false;
            appCompatDelegateImpl3.f0 = 0;
        }
    }

    class b implements mu1 {
        b() {
        }

        @Override // defpackage.mu1
        public zi3 a(View view, zi3 zi3Var) {
            int iL = zi3Var.l();
            int iG1 = AppCompatDelegateImpl.this.g1(zi3Var, null);
            if (iL != iG1) {
                zi3Var = zi3Var.q(zi3Var.j(), iG1, zi3Var.k(), zi3Var.i());
            }
            return be3.b0(view, zi3Var);
        }
    }

    class c implements ContentFrameLayout.a {
        c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.i0();
        }
    }

    class d implements Runnable {

        class a extends af3 {
            a() {
            }

            @Override // defpackage.ze3
            public void b(View view) {
                AppCompatDelegateImpl.this.v.setAlpha(1.0f);
                AppCompatDelegateImpl.this.y.h(null);
                AppCompatDelegateImpl.this.y = null;
            }

            @Override // defpackage.af3, defpackage.ze3
            public void c(View view) {
                AppCompatDelegateImpl.this.v.setVisibility(0);
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.w.showAtLocation(appCompatDelegateImpl.v, 55, 0, 0);
            AppCompatDelegateImpl.this.l0();
            if (!AppCompatDelegateImpl.this.W0()) {
                AppCompatDelegateImpl.this.v.setAlpha(1.0f);
                AppCompatDelegateImpl.this.v.setVisibility(0);
            } else {
                AppCompatDelegateImpl.this.v.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.y = be3.e(appCompatDelegateImpl2.v).b(1.0f);
                AppCompatDelegateImpl.this.y.h(new a());
            }
        }
    }

    class e extends af3 {
        e() {
        }

        @Override // defpackage.ze3
        public void b(View view) {
            AppCompatDelegateImpl.this.v.setAlpha(1.0f);
            AppCompatDelegateImpl.this.y.h(null);
            AppCompatDelegateImpl.this.y = null;
        }

        @Override // defpackage.af3, defpackage.ze3
        public void c(View view) {
            AppCompatDelegateImpl.this.v.setVisibility(0);
            if (AppCompatDelegateImpl.this.v.getParent() instanceof View) {
                be3.m0((View) AppCompatDelegateImpl.this.v.getParent());
            }
        }
    }

    private class f implements r2 {
        f() {
        }
    }

    interface g {
        boolean a(int i);

        View onCreatePanelView(int i);
    }

    private final class h implements androidx.appcompat.view.menu.j.a {
        h() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
            AppCompatDelegateImpl.this.b0(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackX0 = AppCompatDelegateImpl.this.x0();
            if (callbackX0 == null) {
                return true;
            }
            callbackX0.onMenuOpened(108, eVar);
            return true;
        }
    }

    class i implements u2.a {
        private u2.a a;

        class a extends af3 {
            a() {
            }

            @Override // defpackage.ze3
            public void b(View view) {
                AppCompatDelegateImpl.this.v.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.v.getParent() instanceof View) {
                    be3.m0((View) AppCompatDelegateImpl.this.v.getParent());
                }
                AppCompatDelegateImpl.this.v.k();
                AppCompatDelegateImpl.this.y.h(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.y = null;
                be3.m0(appCompatDelegateImpl2.G);
            }
        }

        public i(u2.a aVar) {
            this.a = aVar;
        }

        @Override // u2.a
        public boolean a(u2 u2Var, MenuItem menuItem) {
            return this.a.a(u2Var, menuItem);
        }

        @Override // u2.a
        public void b(u2 u2Var) {
            this.a.b(u2Var);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.w != null) {
                appCompatDelegateImpl.l.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.x);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.v != null) {
                appCompatDelegateImpl2.l0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.y = be3.e(appCompatDelegateImpl3.v).b(0.0f);
                AppCompatDelegateImpl.this.y.h(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            m8 m8Var = appCompatDelegateImpl4.n;
            if (m8Var != null) {
                m8Var.onSupportActionModeFinished(appCompatDelegateImpl4.u);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.u = null;
            be3.m0(appCompatDelegateImpl5.G);
            AppCompatDelegateImpl.this.e1();
        }

        @Override // u2.a
        public boolean c(u2 u2Var, Menu menu) {
            return this.a.c(u2Var, menu);
        }

        @Override // u2.a
        public boolean d(u2 u2Var, Menu menu) {
            be3.m0(AppCompatDelegateImpl.this.G);
            return this.a.d(u2Var, menu);
        }
    }

    static class j {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class k {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static tc1 b(Configuration configuration) {
            return tc1.b(configuration.getLocales().toLanguageTags());
        }

        public static void c(tc1 tc1Var) {
            LocaleList.setDefault(LocaleList.forLanguageTags(tc1Var.g()));
        }

        static void d(Configuration configuration, tc1 tc1Var) {
            configuration.setLocales(LocaleList.forLanguageTags(tc1Var.g()));
        }
    }

    static class l {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i = configuration.colorMode & 3;
            int i2 = configuration2.colorMode;
            if (i != (i2 & 3)) {
                configuration3.colorMode |= i2 & 3;
            }
            int i3 = configuration.colorMode & 12;
            int i4 = configuration2.colorMode;
            if (i3 != (i4 & 12)) {
                configuration3.colorMode |= i4 & 12;
            }
        }
    }

    static class m {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.e
                public final void onBackInvoked() {
                    appCompatDelegateImpl.F0();
                }
            };
            p8.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            p8.a(obj).unregisterOnBackInvokedCallback(o8.a(obj2));
        }
    }

    class n extends ki3 {
        private g b;
        private boolean c;
        private boolean d;
        private boolean e;

        n(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.c = true;
                callback.onContentChanged();
            } finally {
                this.c = false;
            }
        }

        public void d(Window.Callback callback, int i, Menu menu) {
            try {
                this.e = true;
                callback.onPanelClosed(i, menu);
            } finally {
                this.e = false;
            }
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.d) {
                return a().dispatchKeyEvent(keyEvent);
            }
            return AppCompatDelegateImpl.this.j0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.I0(keyEvent.getKeyCode(), keyEvent);
        }

        void e(g gVar) {
            this.b = gVar;
        }

        final ActionMode f(ActionMode.Callback callback) {
            kw2.a aVar = new kw2.a(AppCompatDelegateImpl.this.k, callback);
            u2 u2VarQ = AppCompatDelegateImpl.this.Q(aVar);
            if (u2VarQ != null) {
                return aVar.e(u2VarQ);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.c) {
                a().onContentChanged();
            }
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            View viewOnCreatePanelView;
            g gVar = this.b;
            return (gVar == null || (viewOnCreatePanelView = gVar.onCreatePanelView(i)) == null) ? super.onCreatePanelView(i) : viewOnCreatePanelView;
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.L0(i);
            return true;
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            if (this.e) {
                a().onPanelClosed(i, menu);
            } else {
                super.onPanelClosed(i, menu);
                AppCompatDelegateImpl.this.M0(i);
            }
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.f0(true);
            }
            g gVar = this.b;
            boolean zOnPreparePanel = gVar != null && gVar.a(i);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i, view, menu);
            }
            if (eVar != null) {
                eVar.f0(false);
            }
            return zOnPreparePanel;
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            androidx.appcompat.view.menu.e eVar;
            PanelFeatureState panelFeatureStateV0 = AppCompatDelegateImpl.this.v0(0, true);
            if (panelFeatureStateV0 == null || (eVar = panelFeatureStateV0.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // defpackage.ki3, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (AppCompatDelegateImpl.this.D0() && i == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    private class o extends p {
        private final PowerManager c;

        o(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            return j.a(this.c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            AppCompatDelegateImpl.this.V();
        }
    }

    abstract class p {
        private BroadcastReceiver a;

        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        p() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            AppCompatDelegateImpl.this.k.registerReceiver(this.a, intentFilterB);
        }
    }

    private class q extends p {
        private final androidx.appcompat.app.j c;

        q(androidx.appcompat.app.j jVar) {
            super();
            this.c = jVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            return this.c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            AppCompatDelegateImpl.this.V();
        }
    }

    private class r extends ContentFrameLayout {
        public r(Context context) {
            super(context);
        }

        private boolean b(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.j0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.d0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(v8.b(getContext(), i));
        }
    }

    private final class s implements androidx.appcompat.view.menu.j.a {
        s() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
            androidx.appcompat.view.menu.e eVarF = eVar.F();
            boolean z2 = eVarF != eVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                eVar = eVarF;
            }
            PanelFeatureState panelFeatureStateO0 = appCompatDelegateImpl.o0(eVar);
            if (panelFeatureStateO0 != null) {
                if (!z2) {
                    AppCompatDelegateImpl.this.e0(panelFeatureStateO0, z);
                } else {
                    AppCompatDelegateImpl.this.a0(panelFeatureStateO0.a, panelFeatureStateO0, eVarF);
                    AppCompatDelegateImpl.this.e0(panelFeatureStateO0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackX0;
            if (eVar != eVar.F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.L || (callbackX0 = appCompatDelegateImpl.x0()) == null || AppCompatDelegateImpl.this.W) {
                return true;
            }
            callbackX0.onMenuOpened(108, eVar);
            return true;
        }
    }

    AppCompatDelegateImpl(Activity activity, m8 m8Var) {
        this(activity, null, m8Var, activity);
    }

    private boolean A0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(q0());
        panelFeatureState.g = new r(panelFeatureState.l);
        panelFeatureState.c = 81;
        return true;
    }

    private boolean B0(PanelFeatureState panelFeatureState) {
        Resources.Theme themeNewTheme;
        Context context = this.k;
        int i2 = panelFeatureState.a;
        if ((i2 == 0 || i2 == 108) && this.r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                s30 s30Var = new s30(context, 0);
                s30Var.getTheme().setTo(themeNewTheme);
                context = s30Var;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.W(this);
        panelFeatureState.c(eVar);
        return true;
    }

    private void C0(int i2) {
        this.f0 = (1 << i2) | this.f0;
        if (this.e0) {
            return;
        }
        be3.h0(this.l.getDecorView(), this.g0);
        this.e0 = true;
    }

    private boolean H0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateV0 = v0(i2, true);
        if (panelFeatureStateV0.o) {
            return false;
        }
        return R0(panelFeatureStateV0, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    private boolean K0(int i2, KeyEvent keyEvent) {
        boolean zR0;
        r70 r70Var;
        if (this.u != null) {
            return false;
        }
        boolean zF = true;
        PanelFeatureState panelFeatureStateV0 = v0(i2, true);
        if (i2 != 0 || (r70Var = this.r) == null || !r70Var.d() || ViewConfiguration.get(this.k).hasPermanentMenuKey()) {
            boolean z = panelFeatureStateV0.o;
            if (z || panelFeatureStateV0.n) {
                e0(panelFeatureStateV0, true);
                zF = z;
            } else if (panelFeatureStateV0.m) {
                if (panelFeatureStateV0.r) {
                    panelFeatureStateV0.m = false;
                    zR0 = R0(panelFeatureStateV0, keyEvent);
                } else {
                    zR0 = true;
                }
                if (zR0) {
                    O0(panelFeatureStateV0, keyEvent);
                } else {
                    zF = false;
                }
            } else {
                zF = false;
            }
        } else if (this.r.b()) {
            zF = this.r.f();
        } else if (this.W || !R0(panelFeatureStateV0, keyEvent)) {
            zF = false;
        } else {
            zF = this.r.g();
        }
        if (zF) {
            AudioManager audioManager = (AudioManager) this.k.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zF;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    private void O0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.o || this.W) {
            return;
        }
        if (panelFeatureState.a == 0 && (this.k.getResources().getConfiguration().screenLayout & 15) == 4) {
            return;
        }
        Window.Callback callbackX0 = x0();
        if (callbackX0 != null && !callbackX0.onMenuOpened(panelFeatureState.a, panelFeatureState.j)) {
            e0(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.k.getSystemService("window");
        if (windowManager != null && R0(panelFeatureState, keyEvent)) {
            ViewGroup viewGroup = panelFeatureState.g;
            if (viewGroup != null && !panelFeatureState.f127q) {
                View view = panelFeatureState.i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                }
                panelFeatureState.n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
                layoutParams2.gravity = panelFeatureState.c;
                layoutParams2.windowAnimations = panelFeatureState.f;
                windowManager.addView(panelFeatureState.g, layoutParams2);
                panelFeatureState.o = true;
                if (panelFeatureState.a == 0) {
                    e1();
                }
            }
            if (viewGroup == null) {
                if (!A0(panelFeatureState) || panelFeatureState.g == null) {
                    return;
                }
            } else if (panelFeatureState.f127q && viewGroup.getChildCount() > 0) {
                panelFeatureState.g.removeAllViews();
            }
            if (!z0(panelFeatureState) || !panelFeatureState.b()) {
                panelFeatureState.f127q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = panelFeatureState.h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            panelFeatureState.g.setBackgroundResource(panelFeatureState.b);
            ViewParent parent = panelFeatureState.h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(panelFeatureState.h);
            }
            panelFeatureState.g.addView(panelFeatureState.h, layoutParams3);
            if (!panelFeatureState.h.hasFocus()) {
                panelFeatureState.h.requestFocus();
            }
            i2 = -2;
            panelFeatureState.n = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
            layoutParams4.gravity = panelFeatureState.c;
            layoutParams4.windowAnimations = panelFeatureState.f;
            windowManager.addView(panelFeatureState.g, layoutParams4);
            panelFeatureState.o = true;
            if (panelFeatureState.a == 0) {
                e1();
            }
        }
    }

    private boolean Q0(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || R0(panelFeatureState, keyEvent)) && (eVar = panelFeatureState.j) != null) {
            zPerformShortcut = eVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.r == null) {
            e0(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    private boolean R0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        r70 r70Var;
        r70 r70Var2;
        r70 r70Var3;
        if (this.W) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.S;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            e0(panelFeatureState2, false);
        }
        Window.Callback callbackX0 = x0();
        if (callbackX0 != null) {
            panelFeatureState.i = callbackX0.onCreatePanelView(panelFeatureState.a);
        }
        int i2 = panelFeatureState.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (r70Var3 = this.r) != null) {
            r70Var3.c();
        }
        if (panelFeatureState.i == null && (!z || !(P0() instanceof androidx.appcompat.app.h))) {
            androidx.appcompat.view.menu.e eVar = panelFeatureState.j;
            if (eVar == null || panelFeatureState.r) {
                if (eVar == null && (!B0(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z && this.r != null) {
                    if (this.s == null) {
                        this.s = new h();
                    }
                    this.r.a(panelFeatureState.j, this.s);
                }
                panelFeatureState.j.i0();
                if (!callbackX0.onCreatePanelMenu(panelFeatureState.a, panelFeatureState.j)) {
                    panelFeatureState.c(null);
                    if (z && (r70Var = this.r) != null) {
                        r70Var.a(null, this.s);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.i0();
            Bundle bundle = panelFeatureState.s;
            if (bundle != null) {
                panelFeatureState.j.S(bundle);
                panelFeatureState.s = null;
            }
            if (!callbackX0.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z && (r70Var2 = this.r) != null) {
                    r70Var2.a(null, this.s);
                }
                panelFeatureState.j.h0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.p = z2;
            panelFeatureState.j.setQwertyMode(z2);
            panelFeatureState.j.h0();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.S = panelFeatureState;
        return true;
    }

    private void S0(boolean z) {
        r70 r70Var = this.r;
        if (r70Var == null || !r70Var.d() || (ViewConfiguration.get(this.k).hasPermanentMenuKey() && !this.r.e())) {
            PanelFeatureState panelFeatureStateV0 = v0(0, true);
            panelFeatureStateV0.f127q = true;
            e0(panelFeatureStateV0, false);
            O0(panelFeatureStateV0, null);
            return;
        }
        Window.Callback callbackX0 = x0();
        if (this.r.b() && z) {
            this.r.f();
            if (this.W) {
                return;
            }
            callbackX0.onPanelClosed(108, v0(0, true).j);
            return;
        }
        if (callbackX0 == null || this.W) {
            return;
        }
        if (this.e0 && (this.f0 & 1) != 0) {
            this.l.getDecorView().removeCallbacks(this.g0);
            this.g0.run();
        }
        PanelFeatureState panelFeatureStateV1 = v0(0, true);
        androidx.appcompat.view.menu.e eVar = panelFeatureStateV1.j;
        if (eVar == null || panelFeatureStateV1.r || !callbackX0.onPreparePanel(0, panelFeatureStateV1.i, eVar)) {
            return;
        }
        callbackX0.onMenuOpened(108, panelFeatureStateV1.j);
        this.r.g();
    }

    private boolean T(boolean z) {
        return U(z, true);
    }

    private int T0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean U(boolean z, boolean z2) {
        if (this.W) {
            return false;
        }
        int iZ = Z();
        int iE0 = E0(this.k, iZ);
        tc1 tc1VarY = Build.VERSION.SDK_INT < 33 ? Y(this.k) : null;
        if (!z2 && tc1VarY != null) {
            tc1VarY = u0(this.k.getResources().getConfiguration());
        }
        boolean zD1 = d1(iE0, tc1VarY, z);
        if (iZ == 0) {
            t0(this.k).e();
        } else {
            p pVar = this.c0;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (iZ == 3) {
            s0(this.k).e();
        } else {
            p pVar2 = this.d0;
            if (pVar2 != null) {
                pVar2.a();
            }
        }
        return zD1;
    }

    private void W() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.G.findViewById(R.id.content);
        View decorView = this.l.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i2 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void X(Window window) {
        if (this.l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof n) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        n nVar = new n(callback);
        this.m = nVar;
        window.setCallback(nVar);
        e0 e0VarU = e0.u(this.k, null, q0);
        Drawable drawableH = e0VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        e0VarU.x();
        this.l = window;
        if (Build.VERSION.SDK_INT < 33 || this.m0 != null) {
            return;
        }
        M(null);
    }

    private boolean X0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int Z() {
        int i2 = this.Y;
        return i2 != -100 ? i2 : androidx.appcompat.app.c.m();
    }

    private void a1() {
        if (this.F) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AppCompatActivity b1() {
        for (Context baseContext = this.k; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void c0() {
        p pVar = this.c0;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.d0;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c1(Configuration configuration) {
        Activity activity = (Activity) this.j;
        if (activity instanceof db1) {
            if (((db1) activity).getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.V || this.W) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008c  */
    private boolean d1(int i2, tc1 tc1Var, boolean z) {
        boolean z2;
        Configuration configurationF0 = f0(this.k, i2, tc1Var, null, false);
        int iR0 = r0(this.k);
        Configuration configuration = this.X;
        if (configuration == null) {
            configuration = this.k.getResources().getConfiguration();
        }
        int i3 = configuration.uiMode & 48;
        int i4 = configurationF0.uiMode & 48;
        tc1 tc1VarU0 = u0(configuration);
        tc1 tc1VarU1 = tc1Var == null ? null : u0(configurationF0);
        int i5 = i3 != i4 ? 512 : 0;
        if (tc1VarU1 != null && !tc1VarU0.equals(tc1VarU1)) {
            i5 |= 8196;
        }
        boolean z3 = true;
        if (((~iR0) & i5) != 0 && z && this.U && (r0 || this.V)) {
            Object obj = this.j;
            if (!(obj instanceof Activity) || ((Activity) obj).isChild()) {
                z2 = false;
            } else {
                if (Build.VERSION.SDK_INT >= 31 && (i5 & 8192) != 0) {
                    ((Activity) this.j).getWindow().getDecorView().setLayoutDirection(configurationF0.getLayoutDirection());
                }
                g3.r((Activity) this.j);
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2 || i5 == 0) {
            z3 = z2;
        } else {
            f1(i4, tc1VarU1, (i5 & iR0) == i5, null);
        }
        if (z3) {
            Object obj2 = this.j;
            if (obj2 instanceof AppCompatActivity) {
                if ((i5 & 512) != 0) {
                    ((AppCompatActivity) obj2).onNightModeChanged(i2);
                }
                if ((i5 & 4) != 0) {
                    ((AppCompatActivity) this.j).onLocalesChanged(tc1Var);
                }
            }
        }
        if (tc1VarU1 != null) {
            V0(u0(this.k.getResources().getConfiguration()));
        }
        return z3;
    }

    private Configuration f0(Context context, int i2, tc1 tc1Var, Configuration configuration, boolean z) {
        int i3;
        if (i2 == 1) {
            i3 = 16;
        } else if (i2 != 2) {
            i3 = z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i3 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (tc1Var != null) {
            U0(configuration2, tc1Var);
        }
        return configuration2;
    }

    private void f1(int i2, tc1 tc1Var, boolean z, Configuration configuration) {
        Resources resources = this.k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        if (tc1Var != null) {
            U0(configuration2, tc1Var);
        }
        resources.updateConfiguration(configuration2, null);
        int i3 = this.Z;
        if (i3 != 0) {
            this.k.setTheme(i3);
            this.k.getTheme().applyStyle(this.Z, true);
        }
        if (z && (this.j instanceof Activity)) {
            c1(configuration2);
        }
    }

    private ViewGroup g0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        int i2 = R$styleable.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            H(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i2, false)) {
            H(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            H(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            H(10);
        }
        this.O = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        n0();
        this.l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.k);
        if (this.P) {
            viewGroup = this.N ? (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.O) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.M = false;
            this.L = false;
        } else if (this.L) {
            TypedValue typedValue = new TypedValue();
            this.k.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new s30(this.k, typedValue.resourceId) : this.k).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            r70 r70Var = (r70) viewGroup.findViewById(R$id.decor_content_parent);
            this.r = r70Var;
            r70Var.setWindowCallback(x0());
            if (this.M) {
                this.r.h(109);
            }
            if (this.J) {
                this.r.h(2);
            }
            if (this.K) {
                this.r.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.L + ", windowActionBarOverlay: " + this.M + ", android:windowIsFloating: " + this.O + ", windowActionModeOverlay: " + this.N + ", windowNoTitle: " + this.P + " }");
        }
        be3.E0(viewGroup, new b());
        if (this.r == null) {
            this.H = (TextView) viewGroup.findViewById(R$id.title);
        }
        h0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    private void h1(View view) {
        view.setBackgroundColor((be3.M(view) & 8192) != 0 ? q30.c(this.k, R$color.abc_decor_view_status_guard_light) : q30.c(this.k, R$color.abc_decor_view_status_guard));
    }

    private void m0() {
        if (this.F) {
            return;
        }
        this.G = g0();
        CharSequence charSequenceW0 = w0();
        if (!TextUtils.isEmpty(charSequenceW0)) {
            r70 r70Var = this.r;
            if (r70Var != null) {
                r70Var.setWindowTitle(charSequenceW0);
            } else if (P0() != null) {
                P0().v(charSequenceW0);
            } else {
                TextView textView = this.H;
                if (textView != null) {
                    textView.setText(charSequenceW0);
                }
            }
        }
        W();
        N0(this.G);
        this.F = true;
        PanelFeatureState panelFeatureStateV0 = v0(0, false);
        if (this.W) {
            return;
        }
        if (panelFeatureStateV0 == null || panelFeatureStateV0.j == null) {
            C0(108);
        }
    }

    private void n0() {
        if (this.l == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                X(((Activity) obj).getWindow());
            }
        }
        if (this.l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration p0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            k.a(configuration, configuration2, configuration3);
            int i6 = configuration.touchscreen;
            int i7 = configuration2.touchscreen;
            if (i6 != i7) {
                configuration3.touchscreen = i7;
            }
            int i8 = configuration.keyboard;
            int i9 = configuration2.keyboard;
            if (i8 != i9) {
                configuration3.keyboard = i9;
            }
            int i10 = configuration.keyboardHidden;
            int i11 = configuration2.keyboardHidden;
            if (i10 != i11) {
                configuration3.keyboardHidden = i11;
            }
            int i12 = configuration.navigation;
            int i13 = configuration2.navigation;
            if (i12 != i13) {
                configuration3.navigation = i13;
            }
            int i14 = configuration.navigationHidden;
            int i15 = configuration2.navigationHidden;
            if (i14 != i15) {
                configuration3.navigationHidden = i15;
            }
            int i16 = configuration.orientation;
            int i17 = configuration2.orientation;
            if (i16 != i17) {
                configuration3.orientation = i17;
            }
            int i18 = configuration.screenLayout & 15;
            int i19 = configuration2.screenLayout;
            if (i18 != (i19 & 15)) {
                configuration3.screenLayout |= i19 & 15;
            }
            int i20 = configuration.screenLayout & 192;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 192)) {
                configuration3.screenLayout |= i21 & 192;
            }
            int i22 = configuration.screenLayout & 48;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 48)) {
                configuration3.screenLayout |= i23 & 48;
            }
            int i24 = configuration.screenLayout & 768;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 768)) {
                configuration3.screenLayout |= i25 & 768;
            }
            l.a(configuration, configuration2, configuration3);
            int i26 = configuration.uiMode & 15;
            int i27 = configuration2.uiMode;
            if (i26 != (i27 & 15)) {
                configuration3.uiMode |= i27 & 15;
            }
            int i28 = configuration.uiMode & 48;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 48)) {
                configuration3.uiMode |= i29 & 48;
            }
            int i30 = configuration.screenWidthDp;
            int i31 = configuration2.screenWidthDp;
            if (i30 != i31) {
                configuration3.screenWidthDp = i31;
            }
            int i32 = configuration.screenHeightDp;
            int i33 = configuration2.screenHeightDp;
            if (i32 != i33) {
                configuration3.screenHeightDp = i33;
            }
            int i34 = configuration.smallestScreenWidthDp;
            int i35 = configuration2.smallestScreenWidthDp;
            if (i34 != i35) {
                configuration3.smallestScreenWidthDp = i35;
            }
            int i36 = configuration.densityDpi;
            int i37 = configuration2.densityDpi;
            if (i36 != i37) {
                configuration3.densityDpi = i37;
            }
        }
        return configuration3;
    }

    private int r0(Context context) {
        if (!this.b0 && (this.j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.j.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : 786432);
                if (activityInfo != null) {
                    this.a0 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.a0 = 0;
            }
        }
        this.b0 = true;
        return this.a0;
    }

    private p s0(Context context) {
        if (this.d0 == null) {
            this.d0 = new o(context);
        }
        return this.d0;
    }

    private p t0(Context context) {
        if (this.c0 == null) {
            this.c0 = new q(androidx.appcompat.app.j.a(context));
        }
        return this.c0;
    }

    private void y0() {
        m0();
        if (this.L && this.o == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                this.o = new androidx.appcompat.app.k((Activity) this.j, this.M);
            } else if (obj instanceof Dialog) {
                this.o = new androidx.appcompat.app.k((Dialog) this.j);
            }
            androidx.appcompat.app.a aVar = this.o;
            if (aVar != null) {
                aVar.r(this.h0);
            }
        }
    }

    private boolean z0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.i;
        if (view != null) {
            panelFeatureState.h = view;
            return true;
        }
        if (panelFeatureState.j == null) {
            return false;
        }
        if (this.t == null) {
            this.t = new s();
        }
        View view2 = (View) panelFeatureState.a(this.t);
        panelFeatureState.h = view2;
        return view2 != null;
    }

    @Override // androidx.appcompat.app.c
    public void A(Bundle bundle) {
        m0();
    }

    @Override // androidx.appcompat.app.c
    public void B() {
        androidx.appcompat.app.a aVarS = s();
        if (aVarS != null) {
            aVarS.u(true);
        }
    }

    @Override // androidx.appcompat.app.c
    public void C(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.c
    public void D() {
        U(true, false);
    }

    public boolean D0() {
        return this.z;
    }

    @Override // androidx.appcompat.app.c
    public void E() {
        androidx.appcompat.app.a aVarS = s();
        if (aVarS != null) {
            aVarS.u(false);
        }
    }

    int E0(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return t0(context).c();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return s0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i2;
    }

    boolean F0() {
        boolean z = this.T;
        this.T = false;
        PanelFeatureState panelFeatureStateV0 = v0(0, false);
        if (panelFeatureStateV0 != null && panelFeatureStateV0.o) {
            if (!z) {
                e0(panelFeatureStateV0, true);
            }
            return true;
        }
        u2 u2Var = this.u;
        if (u2Var != null) {
            u2Var.c();
            return true;
        }
        androidx.appcompat.app.a aVarS = s();
        return aVarS != null && aVarS.h();
    }

    boolean G0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.T = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            H0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.c
    public boolean H(int i2) {
        int iT0 = T0(i2);
        if (this.P && iT0 == 108) {
            return false;
        }
        if (this.L && iT0 == 1) {
            this.L = false;
        }
        if (iT0 == 1) {
            a1();
            this.P = true;
            return true;
        }
        if (iT0 == 2) {
            a1();
            this.J = true;
            return true;
        }
        if (iT0 == 5) {
            a1();
            this.K = true;
            return true;
        }
        if (iT0 == 10) {
            a1();
            this.N = true;
            return true;
        }
        if (iT0 == 108) {
            a1();
            this.L = true;
            return true;
        }
        if (iT0 != 109) {
            return this.l.requestFeature(iT0);
        }
        a1();
        this.M = true;
        return true;
    }

    boolean I0(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a aVarS = s();
        if (aVarS != null && aVarS.o(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.S;
        if (panelFeatureState != null && Q0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.S;
            if (panelFeatureState2 != null) {
                panelFeatureState2.n = true;
            }
            return true;
        }
        if (this.S == null) {
            PanelFeatureState panelFeatureStateV0 = v0(0, true);
            R0(panelFeatureStateV0, keyEvent);
            boolean zQ0 = Q0(panelFeatureStateV0, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateV0.m = false;
            if (zQ0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.c
    public void J(int i2) {
        m0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.k).inflate(i2, viewGroup);
        this.m.c(this.l.getCallback());
    }

    boolean J0(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                K0(0, keyEvent);
                return true;
            }
        } else if (F0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.c
    public void K(View view) {
        m0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.m.c(this.l.getCallback());
    }

    @Override // androidx.appcompat.app.c
    public void L(View view, ViewGroup.LayoutParams layoutParams) {
        m0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.m.c(this.l.getCallback());
    }

    void L0(int i2) {
        androidx.appcompat.app.a aVarS;
        if (i2 != 108 || (aVarS = s()) == null) {
            return;
        }
        aVarS.i(true);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    @Override // androidx.appcompat.app.c
    public void M(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.M(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.m0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.n0) != null) {
            m.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.n0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.j;
            if (!(obj instanceof Activity) || ((Activity) obj).getWindow() == null) {
                this.m0 = onBackInvokedDispatcher;
            } else {
                this.m0 = m.a((Activity) this.j);
            }
        } else {
            this.m0 = onBackInvokedDispatcher;
        }
        e1();
    }

    void M0(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a aVarS = s();
            if (aVarS != null) {
                aVarS.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            PanelFeatureState panelFeatureStateV0 = v0(i2, true);
            if (panelFeatureStateV0.o) {
                e0(panelFeatureStateV0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.c
    public void N(Toolbar toolbar) {
        if (this.j instanceof Activity) {
            androidx.appcompat.app.a aVarS = s();
            if (aVarS instanceof androidx.appcompat.app.k) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.p = null;
            if (aVarS != null) {
                aVarS.n();
            }
            this.o = null;
            if (toolbar != null) {
                androidx.appcompat.app.h hVar = new androidx.appcompat.app.h(toolbar, w0(), this.m);
                this.o = hVar;
                this.m.e(hVar.c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.m.e(null);
            }
            u();
        }
    }

    void N0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.c
    public void O(int i2) {
        this.Z = i2;
    }

    @Override // androidx.appcompat.app.c
    public final void P(CharSequence charSequence) {
        this.f126q = charSequence;
        r70 r70Var = this.r;
        if (r70Var != null) {
            r70Var.setWindowTitle(charSequence);
            return;
        }
        if (P0() != null) {
            P0().v(charSequence);
            return;
        }
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    final androidx.appcompat.app.a P0() {
        return this.o;
    }

    @Override // androidx.appcompat.app.c
    public u2 Q(u2.a aVar) {
        m8 m8Var;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        u2 u2Var = this.u;
        if (u2Var != null) {
            u2Var.c();
        }
        i iVar = new i(aVar);
        androidx.appcompat.app.a aVarS = s();
        if (aVarS != null) {
            u2 u2VarW = aVarS.w(iVar);
            this.u = u2VarW;
            if (u2VarW != null && (m8Var = this.n) != null) {
                m8Var.onSupportActionModeStarted(u2VarW);
            }
        }
        if (this.u == null) {
            this.u = Z0(iVar);
        }
        e1();
        return this.u;
    }

    void U0(Configuration configuration, tc1 tc1Var) {
        k.d(configuration, tc1Var);
    }

    public boolean V() {
        return T(true);
    }

    void V0(tc1 tc1Var) {
        k.c(tc1Var);
    }

    final boolean W0() {
        ViewGroup viewGroup;
        return this.F && (viewGroup = this.G) != null && viewGroup.isLaidOut();
    }

    tc1 Y(Context context) {
        tc1 tc1VarR;
        if (Build.VERSION.SDK_INT >= 33 || (tc1VarR = androidx.appcompat.app.c.r()) == null) {
            return null;
        }
        tc1 tc1VarU0 = u0(context.getApplicationContext().getResources().getConfiguration());
        tc1 tc1VarB = androidx.appcompat.app.g.b(tc1VarR, tc1VarU0);
        return tc1VarB.e() ? tc1VarU0 : tc1VarB;
    }

    boolean Y0() {
        if (this.m0 == null) {
            return false;
        }
        PanelFeatureState panelFeatureStateV0 = v0(0, false);
        return (panelFeatureStateV0 != null && panelFeatureStateV0.o) || this.u != null;
    }

    u2 Z0(u2.a aVar) {
        u2 u2VarOnWindowStartingSupportActionMode;
        Context s30Var;
        m8 m8Var;
        l0();
        u2 u2Var = this.u;
        if (u2Var != null) {
            u2Var.c();
        }
        if (!(aVar instanceof i)) {
            aVar = new i(aVar);
        }
        m8 m8Var2 = this.n;
        if (m8Var2 == null || this.W) {
            u2VarOnWindowStartingSupportActionMode = null;
        } else {
            try {
                u2VarOnWindowStartingSupportActionMode = m8Var2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
                u2VarOnWindowStartingSupportActionMode = null;
            }
        }
        if (u2VarOnWindowStartingSupportActionMode != null) {
            this.u = u2VarOnWindowStartingSupportActionMode;
        } else {
            if (this.v == null) {
                if (this.O) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.k.getTheme();
                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.k.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        s30Var = new s30(this.k, 0);
                        s30Var.getTheme().setTo(themeNewTheme);
                    } else {
                        s30Var = this.k;
                    }
                    this.v = new ActionBarContextView(s30Var);
                    PopupWindow popupWindow = new PopupWindow(s30Var, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                    this.w = popupWindow;
                    m42.b(popupWindow, 2);
                    this.w.setContentView(this.v);
                    this.w.setWidth(-1);
                    s30Var.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true);
                    this.v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, s30Var.getResources().getDisplayMetrics()));
                    this.w.setHeight(-2);
                    this.x = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.G.findViewById(R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(q0()));
                        this.v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.v != null) {
                l0();
                this.v.k();
                kt2 kt2Var = new kt2(this.v.getContext(), this.v, aVar, this.w == null);
                if (aVar.c(kt2Var, kt2Var.e())) {
                    kt2Var.k();
                    this.v.h(kt2Var);
                    this.u = kt2Var;
                    if (W0()) {
                        this.v.setAlpha(0.0f);
                        xe3 xe3VarB = be3.e(this.v).b(1.0f);
                        this.y = xe3VarB;
                        xe3VarB.h(new e());
                    } else {
                        this.v.setAlpha(1.0f);
                        this.v.setVisibility(0);
                        if (this.v.getParent() instanceof View) {
                            be3.m0((View) this.v.getParent());
                        }
                    }
                    if (this.w != null) {
                        this.l.getDecorView().post(this.x);
                    }
                } else {
                    this.u = null;
                }
            }
        }
        u2 u2Var2 = this.u;
        if (u2Var2 != null && (m8Var = this.n) != null) {
            m8Var.onSupportActionModeStarted(u2Var2);
        }
        e1();
        return this.u;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateO0;
        Window.Callback callbackX0 = x0();
        if (callbackX0 == null || this.W || (panelFeatureStateO0 = o0(eVar.F())) == null) {
            return false;
        }
        return callbackX0.onMenuItemSelected(panelFeatureStateO0.a, menuItem);
    }

    void a0(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.R;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.W) {
            this.m.d(this.l.getCallback(), i2, menu);
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        S0(true);
    }

    void b0(androidx.appcompat.view.menu.e eVar) {
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.r.i();
        Window.Callback callbackX0 = x0();
        if (callbackX0 != null && !this.W) {
            callbackX0.onPanelClosed(108, eVar);
        }
        this.Q = false;
    }

    void d0(int i2) {
        e0(v0(i2, true), true);
    }

    @Override // androidx.appcompat.app.c
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        m0();
        ((ViewGroup) this.G.findViewById(R.id.content)).addView(view, layoutParams);
        this.m.c(this.l.getCallback());
    }

    void e0(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        r70 r70Var;
        if (z && panelFeatureState.a == 0 && (r70Var = this.r) != null && r70Var.b()) {
            b0(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.k.getSystemService("window");
        if (windowManager != null && panelFeatureState.o && (viewGroup = panelFeatureState.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                a0(panelFeatureState.a, panelFeatureState, null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.f127q = true;
        if (this.S == panelFeatureState) {
            this.S = null;
        }
        if (panelFeatureState.a == 0) {
            e1();
        }
    }

    void e1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zY0 = Y0();
            if (zY0 && this.n0 == null) {
                this.n0 = m.b(this.m0, this);
            } else {
                if (zY0 || (onBackInvokedCallback = this.n0) == null) {
                    return;
                }
                m.c(this.m0, onBackInvokedCallback);
                this.n0 = null;
            }
        }
    }

    @Override // androidx.appcompat.app.c
    public Context g(Context context) {
        this.U = true;
        int iE0 = E0(context, Z());
        if (androidx.appcompat.app.c.v(context)) {
            androidx.appcompat.app.c.S(context);
        }
        tc1 tc1VarY = Y(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(f0(context, iE0, tc1VarY, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof s30) {
            try {
                ((s30) context).a(f0(context, iE0, tc1VarY, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!r0) {
            return super.g(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationF0 = f0(context, iE0, tc1VarY, !configuration2.equals(configuration3) ? p0(configuration2, configuration3) : null, true);
        s30 s30Var = new s30(context, R$style.Theme_AppCompat_Empty);
        s30Var.a(configurationF0);
        try {
            if (context.getTheme() != null) {
                bh2.f.a(s30Var.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.g(s30Var);
    }

    final int g1(zi3 zi3Var, Rect rect) {
        int iL;
        boolean z;
        boolean z2;
        if (zi3Var != null) {
            iL = zi3Var.l();
        } else {
            iL = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
            boolean z3 = true;
            if (this.v.isShown()) {
                if (this.i0 == null) {
                    this.i0 = new Rect();
                    this.j0 = new Rect();
                }
                Rect rect2 = this.i0;
                Rect rect3 = this.j0;
                if (zi3Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(zi3Var.j(), zi3Var.l(), zi3Var.k(), zi3Var.i());
                }
                h0.a(this.G, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                zi3 zi3VarH = be3.H(this.G);
                int iJ = zi3VarH == null ? 0 : zi3VarH.j();
                int iK = zi3VarH == null ? 0 : zi3VarH.k();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || this.I != null) {
                    View view = this.I;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i5 = marginLayoutParams2.height;
                        int i6 = marginLayoutParams.topMargin;
                        if (i5 != i6 || marginLayoutParams2.leftMargin != iJ || marginLayoutParams2.rightMargin != iK) {
                            marginLayoutParams2.height = i6;
                            marginLayoutParams2.leftMargin = iJ;
                            marginLayoutParams2.rightMargin = iK;
                            this.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.k);
                    this.I = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iJ;
                    layoutParams.rightMargin = iK;
                    this.G.addView(this.I, -1, layoutParams);
                }
                View view3 = this.I;
                z3 = view3 != null;
                if (z3 && view3.getVisibility() != 0) {
                    h1(this.I);
                }
                if (!this.N && z3) {
                    iL = 0;
                }
                z = z3;
                z3 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                this.v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.I;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return iL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View h0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        if (this.k0 == null) {
            TypedArray typedArrayObtainStyledAttributes = this.k.obtainStyledAttributes(R$styleable.AppCompatTheme);
            String string = typedArrayObtainStyledAttributes.getString(R$styleable.AppCompatTheme_viewInflaterClass);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.k0 = new y8();
            } else {
                try {
                    this.k0 = (y8) this.k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.k0 = new y8();
                }
            }
        }
        boolean z2 = p0;
        boolean zX0 = false;
        if (z2) {
            if (this.l0 == null) {
                this.l0 = new androidx.appcompat.app.f();
            }
            if (this.l0.a(attributeSet)) {
                z = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zX0 = X0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zX0 = true;
                }
                z = zX0;
            }
        } else {
            z = zX0;
        }
        return this.k0.r(view, str, context, attributeSet, z, z2, true, g0.d());
    }

    void i0() {
        androidx.appcompat.view.menu.e eVar;
        r70 r70Var = this.r;
        if (r70Var != null) {
            r70Var.i();
        }
        if (this.w != null) {
            this.l.getDecorView().removeCallbacks(this.x);
            if (this.w.isShowing()) {
                try {
                    this.w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.w = null;
        }
        l0();
        PanelFeatureState panelFeatureStateV0 = v0(0, false);
        if (panelFeatureStateV0 == null || (eVar = panelFeatureStateV0.j) == null) {
            return;
        }
        eVar.close();
    }

    @Override // androidx.appcompat.app.c
    public View j(int i2) {
        m0();
        return this.l.findViewById(i2);
    }

    boolean j0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.j;
        if (((obj instanceof c91.a) || (obj instanceof u8)) && (decorView = this.l.getDecorView()) != null && c91.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.m.b(this.l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? G0(keyCode, keyEvent) : J0(keyCode, keyEvent);
    }

    void k0(int i2) {
        PanelFeatureState panelFeatureStateV0;
        PanelFeatureState panelFeatureStateV1 = v0(i2, true);
        if (panelFeatureStateV1.j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateV1.j.U(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateV1.s = bundle;
            }
            panelFeatureStateV1.j.i0();
            panelFeatureStateV1.j.clear();
        }
        panelFeatureStateV1.r = true;
        panelFeatureStateV1.f127q = true;
        if ((i2 != 108 && i2 != 0) || this.r == null || (panelFeatureStateV0 = v0(0, false)) == null) {
            return;
        }
        panelFeatureStateV0.m = false;
        R0(panelFeatureStateV0, null);
    }

    @Override // androidx.appcompat.app.c
    public Context l() {
        return this.k;
    }

    void l0() {
        xe3 xe3Var = this.y;
        if (xe3Var != null) {
            xe3Var.c();
        }
    }

    @Override // androidx.appcompat.app.c
    public final r2 n() {
        return new f();
    }

    @Override // androidx.appcompat.app.c
    public int o() {
        return this.Y;
    }

    PanelFeatureState o0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.R;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return h0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.c
    public MenuInflater q() {
        if (this.p == null) {
            y0();
            androidx.appcompat.app.a aVar = this.o;
            this.p = new mw2(aVar != null ? aVar.k() : this.k);
        }
        return this.p;
    }

    final Context q0() {
        androidx.appcompat.app.a aVarS = s();
        Context contextK = aVarS != null ? aVarS.k() : null;
        return contextK == null ? this.k : contextK;
    }

    @Override // androidx.appcompat.app.c
    public androidx.appcompat.app.a s() {
        y0();
        return this.o;
    }

    @Override // androidx.appcompat.app.c
    public void t() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.k);
        if (layoutInflaterFrom.getFactory() == null) {
            ia1.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.c
    public void u() {
        if (P0() == null || s().l()) {
            return;
        }
        C0(0);
    }

    tc1 u0(Configuration configuration) {
        return k.b(configuration);
    }

    protected PanelFeatureState v0(int i2, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.R;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i2 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.R = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    final CharSequence w0() {
        Object obj = this.j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f126q;
    }

    @Override // androidx.appcompat.app.c
    public void x(Configuration configuration) {
        androidx.appcompat.app.a aVarS;
        if (this.L && this.F && (aVarS = s()) != null) {
            aVarS.m(configuration);
        }
        androidx.appcompat.widget.g.b().g(this.k);
        this.X = new Configuration(this.k.getResources().getConfiguration());
        U(false, false);
    }

    final Window.Callback x0() {
        return this.l.getCallback();
    }

    @Override // androidx.appcompat.app.c
    public void y(Bundle bundle) {
        String strC;
        this.U = true;
        T(false);
        n0();
        Object obj = this.j;
        if (obj instanceof Activity) {
            try {
                strC = ln1.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                androidx.appcompat.app.a aVarP0 = P0();
                if (aVarP0 == null) {
                    this.h0 = true;
                } else {
                    aVarP0.r(true);
                }
            }
            androidx.appcompat.app.c.d(this);
        }
        this.X = new Configuration(this.k.getResources().getConfiguration());
        this.V = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0045  */
    @Override // androidx.appcompat.app.c
    public void z() {
        if (this.j instanceof Activity) {
            androidx.appcompat.app.c.F(this);
        }
        if (this.e0) {
            this.l.getDecorView().removeCallbacks(this.g0);
        }
        this.W = true;
        if (this.Y != -100) {
            Object obj = this.j;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                o0.put(this.j.getClass().getName(), Integer.valueOf(this.Y));
            } else {
                o0.remove(this.j.getClass().getName());
            }
        } else {
            o0.remove(this.j.getClass().getName());
        }
        androidx.appcompat.app.a aVar = this.o;
        if (aVar != null) {
            aVar.n();
        }
        c0();
    }

    AppCompatDelegateImpl(Dialog dialog, m8 m8Var) {
        this(dialog.getContext(), dialog.getWindow(), m8Var, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private AppCompatDelegateImpl(Context context, Window window, m8 m8Var, Object obj) {
        AppCompatActivity appCompatActivityB1;
        this.y = null;
        this.z = true;
        this.Y = -100;
        this.g0 = new a();
        this.k = context;
        this.n = m8Var;
        this.j = obj;
        if (this.Y == -100 && (obj instanceof Dialog) && (appCompatActivityB1 = b1()) != null) {
            this.Y = appCompatActivityB1.getDelegate().o();
        }
        if (this.Y == -100) {
            ap2 ap2Var = o0;
            Integer num = (Integer) ap2Var.get(obj.getClass().getName());
            if (num != null) {
                this.Y = num.intValue();
                ap2Var.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            X(window);
        }
        androidx.appcompat.widget.g.h();
    }
}
