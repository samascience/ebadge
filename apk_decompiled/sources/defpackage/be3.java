package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class be3 {
    private static WeakHashMap a = null;
    private static Field b = null;
    private static boolean c = false;
    private static final int[] d = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};
    private static final aw1 e = new aw1() { // from class: ae3
        @Override // defpackage.aw1
        public final x20 a(x20 x20Var) {
            return be3.X(x20Var);
        }
    };
    private static final e f = new e();

    class a extends f {
        a(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.f(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f {
        b(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return l.a(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            l.e(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f {
        c(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return n.a(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            n.c(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f {
        d(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.b(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.d(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // be3.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap a = new WeakHashMap();

        e() {
        }

        private void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z) {
                be3.Y(view, z ? 16 : 32);
                entry.setValue(Boolean.valueOf(z));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void a(View view) {
            this.a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        void d(View view) {
            this.a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext()) {
                    b((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f {
        private final int a;
        private final Class b;
        private final int c;
        private final int d;

        f(int i, Class cls, int i2) {
            this(i, cls, 0, i2);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract Object c(View view);

        abstract void d(View view, Object obj);

        Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.a);
            if (this.b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                be3.k(view);
                view.setTag(this.a, obj);
                be3.Y(view, this.d);
            }
        }

        abstract boolean g(Object obj, Object obj2);

        f(int i, Class cls, int i2, int i3) {
            this.a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }
    }

    static class g {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class h {

        class a implements View.OnApplyWindowInsetsListener {
            zi3 a = null;
            final /* synthetic */ View b;
            final /* synthetic */ mu1 c;

            a(View view, mu1 mu1Var) {
                this.b = view;
                this.c = mu1Var;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                zi3 zi3VarX = zi3.x(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    h.a(windowInsets, this.b);
                    if (zi3VarX.equals(this.a)) {
                        return this.c.a(view, zi3VarX).v();
                    }
                }
                this.a = zi3VarX;
                zi3 zi3VarA = this.c.a(view, zi3VarX);
                if (i >= 30) {
                    return zi3VarA.v();
                }
                be3.m0(view);
                return zi3VarA.v();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static zi3 b(View view, zi3 zi3Var, Rect rect) {
            WindowInsets windowInsetsV = zi3Var.v();
            if (windowInsetsV != null) {
                return zi3.x(view.computeSystemWindowInsets(windowInsetsV, rect), view);
            }
            rect.setEmpty();
            return zi3Var;
        }

        static ColorStateList c(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode d(View view) {
            return view.getBackgroundTintMode();
        }

        static float e(View view) {
            return view.getElevation();
        }

        static String f(View view) {
            return view.getTransitionName();
        }

        static float g(View view) {
            return view.getTranslationZ();
        }

        static float h(View view) {
            return view.getZ();
        }

        static boolean i(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void j(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void k(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void l(View view, float f) {
            view.setElevation(f);
        }

        static void m(View view, mu1 mu1Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.tag_on_apply_window_listener, mu1Var);
            }
            if (mu1Var == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, mu1Var));
            }
        }

        static void n(View view, String str) {
            view.setTransitionName(str);
        }

        static void o(View view, float f) {
            view.setTranslationZ(f);
        }

        static void p(View view, float f) {
            view.setZ(f);
        }

        static void q(View view) {
            view.stopNestedScroll();
        }
    }

    private static class i {
        public static zi3 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            zi3 zi3VarW = zi3.w(rootWindowInsets);
            zi3VarW.t(zi3VarW);
            zi3VarW.d(view.getRootView());
            return zi3VarW;
        }

        static void b(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    static class j {
        static void a(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    static class k {
        static int a(View view) {
            return view.getImportantForAutofill();
        }

        static void b(View view, int i) {
            view.setImportantForAutofill(i);
        }
    }

    static class l {
        static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        static void d(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void f(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    private static class m {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    private static class n {
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        public static yj3 b(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return yj3.f(windowInsetsController);
            }
            return null;
        }

        static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class o {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static x20 b(View view, x20 x20Var) {
            ContentInfo contentInfoF = x20Var.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? x20Var : x20.g(contentInfoPerformReceiveContent);
        }
    }

    static class p {
        private static final ArrayList d = new ArrayList();
        private WeakHashMap a = null;
        private SparseArray b = null;
        private WeakReference c = null;

        p() {
        }

        static p a(View view) {
            int i = R$id.tag_unhandled_key_event_manager;
            p pVar = (p) view.getTag(i);
            if (pVar != null) {
                return pVar;
            }
            p pVar2 = new p();
            view.setTag(i, pVar2);
            return pVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray d() {
            if (this.b == null) {
                this.b = new SparseArray();
            }
            return this.b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList == null || (size = arrayList.size() - 1) < 0) {
                return false;
            }
            e43.a(arrayList.get(size));
            throw null;
        }

        private void g() {
            WeakHashMap weakHashMap = this.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.a == null) {
                        this.a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static int A(View view) {
        return view.getLayoutDirection();
    }

    private static void A0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static int B(View view) {
        return view.getMinimumHeight();
    }

    public static void B0(View view, int i2) {
        k.b(view, i2);
    }

    public static int C(View view) {
        return view.getMinimumWidth();
    }

    public static void C0(View view, int i2) {
        view.setLabelFor(i2);
    }

    public static String[] D(View view) {
        return Build.VERSION.SDK_INT >= 31 ? o.a(view) : (String[]) view.getTag(R$id.tag_on_receive_content_mime_types);
    }

    public static void D0(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int E(View view) {
        return view.getPaddingEnd();
    }

    public static void E0(View view, mu1 mu1Var) {
        h.m(view, mu1Var);
    }

    public static int F(View view) {
        return view.getPaddingStart();
    }

    public static void F0(View view, int i2, int i3, int i4, int i5) {
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    public static ViewParent G(View view) {
        return view.getParentForAccessibility();
    }

    public static void G0(View view, a42 a42Var) {
        j.a(view, (PointerIcon) (a42Var != null ? a42Var.a() : null));
    }

    public static zi3 H(View view) {
        return i.a(view);
    }

    public static void H0(View view, boolean z) {
        o0().f(view, Boolean.valueOf(z));
    }

    public static CharSequence I(View view) {
        return (CharSequence) O0().e(view);
    }

    public static void I0(View view, int i2, int i3) {
        i.b(view, i2, i3);
    }

    public static String J(View view) {
        return h.f(view);
    }

    public static void J0(View view, CharSequence charSequence) {
        O0().f(view, charSequence);
    }

    public static float K(View view) {
        return h.g(view);
    }

    public static void K0(View view, String str) {
        h.n(view, str);
    }

    public static yj3 L(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return n.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return li3.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void L0(View view, float f2) {
        h.o(view, f2);
    }

    public static int M(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void M0(View view, mi3.b bVar) {
        mi3.d(view, bVar);
    }

    public static float N(View view) {
        return h.h(view);
    }

    public static void N0(View view, float f2) {
        h.p(view, f2);
    }

    public static boolean O(View view) {
        return n(view) != null;
    }

    private static f O0() {
        return new c(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    public static boolean P(View view) {
        return view.hasOnClickListeners();
    }

    public static void P0(View view) {
        h.q(view);
    }

    public static boolean Q(View view) {
        return view.hasTransientState();
    }

    public static boolean R(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean S(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean T(View view) {
        return view.isLaidOut();
    }

    public static boolean U(View view) {
        return h.i(view);
    }

    public static boolean V(View view) {
        return view.isPaddingRelative();
    }

    public static boolean W(View view) {
        Boolean bool = (Boolean) o0().e(view);
        return bool != null && bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x20 X(x20 x20Var) {
        return x20Var;
    }

    static void Y(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = p(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z) {
                    accessibilityEventObtain.getText().add(p(view));
                    A0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i2);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(p(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static void Z(View view, int i2) {
        view.offsetLeftAndRight(i2);
    }

    public static void a0(View view, int i2) {
        view.offsetTopAndBottom(i2);
    }

    private static f b() {
        return new d(R$id.tag_accessibility_heading, Boolean.class, 28);
    }

    public static zi3 b0(View view, zi3 zi3Var) {
        WindowInsets windowInsetsV = zi3Var.v();
        if (windowInsetsV != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsV);
            if (!windowInsetsB.equals(windowInsetsV)) {
                return zi3.x(windowInsetsB, view);
            }
        }
        return zi3Var;
    }

    public static int c(View view, CharSequence charSequence, p2 p2Var) {
        int iR = r(view, charSequence);
        if (iR != -1) {
            d(view, new m2.a(iR, charSequence, p2Var));
        }
        return iR;
    }

    public static void c0(View view, m2 m2Var) {
        view.onInitializeAccessibilityNodeInfo(m2Var.P0());
    }

    private static void d(View view, m2.a aVar) {
        k(view);
        k0(aVar.b(), view);
        q(view).add(aVar);
        Y(view, 0);
    }

    private static f d0() {
        return new b(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static xe3 e(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        xe3 xe3Var = (xe3) a.get(view);
        if (xe3Var != null) {
            return xe3Var;
        }
        xe3 xe3Var2 = new xe3(view);
        a.put(view, xe3Var2);
        return xe3Var2;
    }

    public static boolean e0(View view, int i2, Bundle bundle) {
        return view.performAccessibilityAction(i2, bundle);
    }

    public static boolean f(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    public static x20 f0(View view, x20 x20Var) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + x20Var + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return o.b(view, x20Var);
        }
        zv1 zv1Var = (zv1) view.getTag(R$id.tag_on_receive_content_listener);
        if (zv1Var == null) {
            return w(view).a(x20Var);
        }
        x20 x20VarA = zv1Var.a(view, x20Var);
        if (x20VarA == null) {
            return null;
        }
        return w(view).a(x20VarA);
    }

    public static zi3 g(View view, zi3 zi3Var, Rect rect) {
        return h.b(view, zi3Var, rect);
    }

    public static void g0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static zi3 h(View view, zi3 zi3Var) {
        WindowInsets windowInsetsV = zi3Var.v();
        if (windowInsetsV != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsV);
            if (!windowInsetsA.equals(windowInsetsV)) {
                return zi3.x(windowInsetsA, view);
            }
        }
        return zi3Var;
    }

    public static void h0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return p.a(view).b(view, keyEvent);
    }

    public static void i0(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return p.a(view).f(keyEvent);
    }

    public static void j0(View view, int i2) {
        k0(i2, view);
        Y(view, 0);
    }

    static void k(View view) {
        t1 t1VarM = m(view);
        if (t1VarM == null) {
            t1VarM = new t1();
        }
        p0(view, t1VarM);
    }

    private static void k0(int i2, View view) {
        List listQ = q(view);
        for (int i3 = 0; i3 < listQ.size(); i3++) {
            if (((m2.a) listQ.get(i3)).b() == i2) {
                listQ.remove(i3);
                return;
            }
        }
    }

    public static int l() {
        return View.generateViewId();
    }

    public static void l0(View view, m2.a aVar, CharSequence charSequence, p2 p2Var) {
        if (p2Var == null && charSequence == null) {
            j0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, p2Var));
        }
    }

    public static t1 m(View view) {
        View.AccessibilityDelegate accessibilityDelegateN = n(view);
        if (accessibilityDelegateN == null) {
            return null;
        }
        return accessibilityDelegateN instanceof t1.a ? ((t1.a) accessibilityDelegateN).a : new t1(accessibilityDelegateN);
    }

    public static void m0(View view) {
        g.c(view);
    }

    private static View.AccessibilityDelegate n(View view) {
        return Build.VERSION.SDK_INT >= 29 ? m.a(view) : o(view);
    }

    public static void n0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.b(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    private static View.AccessibilityDelegate o(View view) {
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    private static f o0() {
        return new a(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static CharSequence p(View view) {
        return (CharSequence) d0().e(view);
    }

    public static void p0(View view, t1 t1Var) {
        if (t1Var == null && (n(view) instanceof t1.a)) {
            t1Var = new t1();
        }
        A0(view);
        view.setAccessibilityDelegate(t1Var == null ? null : t1Var.getBridge());
    }

    private static List q(View view) {
        int i2 = R$id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    public static void q0(View view, boolean z) {
        b().f(view, Boolean.valueOf(z));
    }

    private static int r(View view, CharSequence charSequence) {
        List listQ = q(view);
        for (int i2 = 0; i2 < listQ.size(); i2++) {
            if (TextUtils.equals(charSequence, ((m2.a) listQ.get(i2)).c())) {
                return ((m2.a) listQ.get(i2)).b();
            }
        }
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[] iArr = d;
            if (i4 >= iArr.length || i3 != -1) {
                break;
            }
            int i5 = iArr[i4];
            boolean z = true;
            for (int i6 = 0; i6 < listQ.size(); i6++) {
                z &= ((m2.a) listQ.get(i6)).b() != i5;
            }
            if (z) {
                i3 = i5;
            }
            i4++;
        }
        return i3;
    }

    public static void r0(View view, int i2) {
        view.setAccessibilityLiveRegion(i2);
    }

    public static ColorStateList s(View view) {
        return h.c(view);
    }

    public static void s0(View view, CharSequence charSequence) {
        d0().f(view, charSequence);
        if (charSequence != null) {
            f.a(view);
        } else {
            f.d(view);
        }
    }

    public static PorterDuff.Mode t(View view) {
        return h.d(view);
    }

    public static void t0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static Display u(View view) {
        return view.getDisplay();
    }

    public static void u0(View view, ColorStateList colorStateList) {
        h.j(view, colorStateList);
    }

    public static float v(View view) {
        return h.e(view);
    }

    public static void v0(View view, PorterDuff.Mode mode) {
        h.k(view, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static aw1 w(View view) {
        return view instanceof aw1 ? (aw1) view : e;
    }

    public static void w0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static boolean x(View view) {
        return view.getFitsSystemWindows();
    }

    public static void x0(View view, float f2) {
        h.l(view, f2);
    }

    public static int y(View view) {
        return view.getImportantForAccessibility();
    }

    public static void y0(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static int z(View view) {
        return k.a(view);
    }

    public static void z0(View view, int i2) {
        view.setImportantForAccessibility(i2);
    }
}
