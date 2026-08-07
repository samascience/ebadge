package defpackage;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class m2 {
    private final AccessibilityNodeInfo a;
    public int b = -1;
    private int c = -1;

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        public static final a U;
        public static final a V;
        public static final a e = new a(1, null);
        public static final a f = new a(2, null);
        public static final a g = new a(4, null);
        public static final a h = new a(8, null);
        public static final a i = new a(16, null);
        public static final a j = new a(32, null);
        public static final a k = new a(64, null);
        public static final a l = new a(128, null);
        public static final a m = new a(256, (CharSequence) null, p2.b.class);
        public static final a n = new a(512, (CharSequence) null, p2.b.class);
        public static final a o = new a(1024, (CharSequence) null, p2.c.class);
        public static final a p = new a(2048, (CharSequence) null, p2.c.class);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f352q = new a(4096, null);
        public static final a r = new a(8192, null);
        public static final a s = new a(16384, null);
        public static final a t = new a(32768, null);
        public static final a u = new a(65536, null);
        public static final a v = new a(Opcodes.ACC_DEPRECATED, (CharSequence) null, p2.g.class);
        public static final a w = new a(Opcodes.ASM4, null);
        public static final a x = new a(Opcodes.ASM8, null);
        public static final a y = new a(Eclipse.HasTypeAnnotations, null);
        public static final a z = new a(2097152, (CharSequence) null, p2.h.class);
        final Object a;
        private final int b;
        private final Class c;
        protected final p2 d;

        static {
            int i2 = Build.VERSION.SDK_INT;
            A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, p2.e.class);
            C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            G = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            H = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            I = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            J = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, p2.f.class);
            M = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, p2.d.class);
            N = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            O = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            P = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            Q = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            R = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            S = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            T = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            U = new a(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            V = new a(i2 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public a a(CharSequence charSequence, p2 p2Var) {
            return new a(null, this.b, charSequence, p2Var, this.c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            if (this.d == null) {
                return false;
            }
            Class cls = this.c;
            if (cls != null) {
                try {
                    e43.a(cls.getDeclaredConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e2) {
                    Class cls2 = this.c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e2);
                }
            }
            return this.d.a(view, null);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.a;
            if (obj2 == null) {
                return aVar.a == null;
            }
            return obj2.equals(aVar.a);
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strH = m2.h(this.b);
            if (strH.equals("ACTION_UNKNOWN") && c() != null) {
                strH = c().toString();
            }
            sb.append(strH);
            return sb.toString();
        }

        public a(int i2, CharSequence charSequence, p2 p2Var) {
            this(null, i2, charSequence, p2Var, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, p2 p2Var, Class cls) {
            this.b = i2;
            this.d = p2Var;
            if (obj == null) {
                this.a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.a = obj;
            }
            this.c = cls;
        }
    }

    private static class b {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    private static class c {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    private static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    public static class e {
        final Object a;

        e(Object obj) {
            this.a = obj;
        }

        public static e a(int i, int i2, boolean z) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
        }

        public static e b(int i, int i2, boolean z, int i3) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }
    }

    public static class f {
        final Object a;

        f(Object obj) {
            this.a = obj;
        }

        public static f f(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }

        public int a() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.a).getColumnIndex();
        }

        public int b() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.a).getColumnSpan();
        }

        public int c() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.a).getRowIndex();
        }

        public int d() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.a).getRowSpan();
        }

        public boolean e() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.a).isSelected();
        }
    }

    public static class g {
        final Object a;

        g(Object obj) {
            this.a = obj;
        }

        public static g a(int i, float f, float f2, float f3) {
            return new g(AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3));
        }
    }

    private m2(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.a = accessibilityNodeInfo;
    }

    private boolean D() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public static m2 Q0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new m2(accessibilityNodeInfo);
    }

    public static m2 W() {
        return Q0(AccessibilityNodeInfo.obtain());
    }

    public static m2 X(m2 m2Var) {
        return Q0(AccessibilityNodeInfo.obtain(m2Var.a));
    }

    public static m2 Y(View view) {
        return Q0(AccessibilityNodeInfo.obtain(view));
    }

    private void d0(int i, boolean z) {
        Bundle bundleU = u();
        if (bundleU != null) {
            int i2 = bundleU.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            bundleU.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    private List f(String str) {
        ArrayList<Integer> integerArrayList = this.a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    static String h(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case Opcodes.ACC_DEPRECATED /* 131072 */:
                return "ACTION_SET_SELECTION";
            case Opcodes.ASM4 /* 262144 */:
                return "ACTION_EXPAND";
            case Opcodes.ASM8 /* 524288 */:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private boolean j(int i) {
        Bundle bundleU = u();
        return bundleU != null && (bundleU.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public CharSequence A() {
        return Build.VERSION.SDK_INT >= 28 ? this.a.getTooltipText() : this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void A0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setPaneTitle(charSequence);
        } else {
            this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public String B() {
        return Build.VERSION.SDK_INT >= 33 ? c.a(this.a) : this.a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void B0(View view) {
        this.b = -1;
        this.a.setParent(view);
    }

    public String C() {
        return this.a.getViewIdResourceName();
    }

    public void C0(View view, int i) {
        this.b = i;
        this.a.setParent(view, i);
    }

    public void D0(g gVar) {
        this.a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) gVar.a);
    }

    public boolean E() {
        return Build.VERSION.SDK_INT >= 34 ? d.d(this.a) : j(64);
    }

    public void E0(CharSequence charSequence) {
        this.a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public boolean F() {
        return this.a.isAccessibilityFocused();
    }

    public void F0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setScreenReaderFocusable(z);
        } else {
            d0(1, z);
        }
    }

    public boolean G() {
        return this.a.isCheckable();
    }

    public void G0(boolean z) {
        this.a.setScrollable(z);
    }

    public boolean H() {
        return this.a.isChecked();
    }

    public void H0(boolean z) {
        this.a.setSelected(z);
    }

    public boolean I() {
        return this.a.isClickable();
    }

    public void I0(boolean z) {
        this.a.setShowingHintText(z);
    }

    public boolean J() {
        return this.a.isContextClickable();
    }

    public void J0(View view) {
        this.c = -1;
        this.a.setSource(view);
    }

    public boolean K() {
        return this.a.isEnabled();
    }

    public void K0(View view, int i) {
        this.c = i;
        this.a.setSource(view, i);
    }

    public boolean L() {
        return this.a.isFocusable();
    }

    public void L0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.b(this.a, charSequence);
        } else {
            this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean M() {
        return this.a.isFocused();
    }

    public void M0(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public boolean N() {
        return j(67108864);
    }

    public void N0(View view) {
        this.a.setTraversalAfter(view);
    }

    public boolean O() {
        return this.a.isImportantForAccessibility();
    }

    public void O0(boolean z) {
        this.a.setVisibleToUser(z);
    }

    public boolean P() {
        return this.a.isLongClickable();
    }

    public AccessibilityNodeInfo P0() {
        return this.a;
    }

    public boolean Q() {
        return this.a.isPassword();
    }

    public boolean R() {
        return this.a.isScrollable();
    }

    public boolean S() {
        return this.a.isSelected();
    }

    public boolean T() {
        return this.a.isShowingHintText();
    }

    public boolean U() {
        return Build.VERSION.SDK_INT >= 33 ? c.b(this.a) : j(8388608);
    }

    public boolean V() {
        return this.a.isVisibleToUser();
    }

    public boolean Z(int i, Bundle bundle) {
        return this.a.performAction(i, bundle);
    }

    public void a(int i) {
        this.a.addAction(i);
    }

    public void a0() {
    }

    public void b(a aVar) {
        this.a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.a);
    }

    public boolean b0(a aVar) {
        return this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.a);
    }

    public void c(View view) {
        this.a.addChild(view);
    }

    public void c0(boolean z) {
        this.a.setAccessibilityFocused(z);
    }

    public void d(View view, int i) {
        this.a.addChild(view, i);
    }

    public void e(CharSequence charSequence, View view) {
    }

    public void e0(Rect rect) {
        this.a.setBoundsInParent(rect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m2)) {
            return false;
        }
        m2 m2Var = (m2) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            if (m2Var.a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(m2Var.a)) {
            return false;
        }
        return this.c == m2Var.c && this.b == m2Var.b;
    }

    public void f0(Rect rect) {
        this.a.setBoundsInScreen(rect);
    }

    public List g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.a.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new a(actionList.get(i)));
        }
        return arrayList;
    }

    public void g0(boolean z) {
        this.a.setCanOpenPopup(z);
    }

    public void h0(boolean z) {
        this.a.setCheckable(z);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public int i() {
        return this.a.getActions();
    }

    public void i0(boolean z) {
        this.a.setChecked(z);
    }

    public void j0(CharSequence charSequence) {
        this.a.setClassName(charSequence);
    }

    public void k(Rect rect) {
        this.a.getBoundsInParent(rect);
    }

    public void k0(boolean z) {
        this.a.setClickable(z);
    }

    public void l(Rect rect) {
        this.a.getBoundsInScreen(rect);
    }

    public void l0(Object obj) {
        this.a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).a);
    }

    public void m(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.a, rect);
            return;
        }
        Rect rect2 = (Rect) this.a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void m0(Object obj) {
        this.a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).a);
    }

    public int n() {
        return this.a.getChildCount();
    }

    public void n0(CharSequence charSequence) {
        this.a.setContentDescription(charSequence);
    }

    public CharSequence o() {
        return this.a.getClassName();
    }

    public void o0(boolean z) {
        this.a.setDismissable(z);
    }

    public void p0(boolean z) {
        this.a.setEnabled(z);
    }

    public f q() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.a.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new f(collectionItemInfo);
        }
        return null;
    }

    public void q0(CharSequence charSequence) {
        this.a.setError(charSequence);
    }

    public CharSequence r() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.a) : this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void r0(boolean z) {
        this.a.setFocusable(z);
    }

    public CharSequence s() {
        return this.a.getContentDescription();
    }

    public void s0(boolean z) {
        this.a.setFocused(z);
    }

    public CharSequence t() {
        return this.a.getError();
    }

    public void t0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setHeading(z);
        } else {
            d0(2, z);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        k(rect);
        sb.append("; boundsInParent: " + rect);
        l(rect);
        sb.append("; boundsInScreen: " + rect);
        m(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(x());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(z());
        sb.append("; error: ");
        sb.append(t());
        sb.append("; maxTextLength: ");
        sb.append(v());
        sb.append("; stateDescription: ");
        sb.append(y());
        sb.append("; contentDescription: ");
        sb.append(s());
        sb.append("; tooltipText: ");
        sb.append(A());
        sb.append("; viewIdResName: ");
        sb.append(C());
        sb.append("; uniqueId: ");
        sb.append(B());
        sb.append("; checkable: ");
        sb.append(G());
        sb.append("; checked: ");
        sb.append(H());
        sb.append("; focusable: ");
        sb.append(L());
        sb.append("; focused: ");
        sb.append(M());
        sb.append("; selected: ");
        sb.append(S());
        sb.append("; clickable: ");
        sb.append(I());
        sb.append("; longClickable: ");
        sb.append(P());
        sb.append("; contextClickable: ");
        sb.append(J());
        sb.append("; enabled: ");
        sb.append(K());
        sb.append("; password: ");
        sb.append(Q());
        sb.append("; scrollable: " + R());
        sb.append("; containerTitle: ");
        sb.append(r());
        sb.append("; granularScrollingSupported: ");
        sb.append(N());
        sb.append("; importantForAccessibility: ");
        sb.append(O());
        sb.append("; visible: ");
        sb.append(V());
        sb.append("; isTextSelectable: ");
        sb.append(U());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(E());
        sb.append("; [");
        List listG = g();
        for (int i = 0; i < listG.size(); i++) {
            a aVar = (a) listG.get(i);
            String strH = h(aVar.b());
            if (strH.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strH = aVar.c().toString();
            }
            sb.append(strH);
            if (i != listG.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Bundle u() {
        return this.a.getExtras();
    }

    public void u0(CharSequence charSequence) {
        this.a.setHintText(charSequence);
    }

    public int v() {
        return this.a.getMaxTextLength();
    }

    public void v0(View view) {
        this.a.setLabelFor(view);
    }

    public int w() {
        return this.a.getMovementGranularities();
    }

    public void w0(boolean z) {
        this.a.setLongClickable(z);
    }

    public CharSequence x() {
        return this.a.getPackageName();
    }

    public void x0(int i) {
        this.a.setMaxTextLength(i);
    }

    public CharSequence y() {
        return Build.VERSION.SDK_INT >= 30 ? b.a(this.a) : this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void y0(int i) {
        this.a.setMovementGranularities(i);
    }

    public CharSequence z() {
        if (!D()) {
            return this.a.getText();
        }
        List listF = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listF2 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listF3 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listF4 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.a.getText(), 0, this.a.getText().length()));
        for (int i = 0; i < listF.size(); i++) {
            spannableString.setSpan(new s1(((Integer) listF4.get(i)).intValue(), this, u().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listF.get(i)).intValue(), ((Integer) listF2.get(i)).intValue(), ((Integer) listF3.get(i)).intValue());
        }
        return spannableString;
    }

    public void z0(CharSequence charSequence) {
        this.a.setPackageName(charSequence);
    }
}
