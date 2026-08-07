package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.s;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.objectweb.asm.Opcodes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class mw2 extends MenuInflater {
    static final Class[] e;
    static final Class[] f;
    final Object[] a;
    final Object[] b;
    Context c;
    private Object d;

    private static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class[] c = {MenuItem.class};
        private Object a;
        private Method b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
                }
                this.b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        v2 A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        private Menu a;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f360q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, mw2.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (mw2.this.c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(mw2.this.b(), this.z));
            }
            if (this.r >= 2) {
                if (menuItem instanceof g) {
                    ((g) menuItem).t(true);
                } else if (menuItem instanceof ri1) {
                    ((ri1) menuItem).h(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, mw2.e, mw2.this.a));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i2);
                }
            }
            v2 v2Var = this.A;
            if (v2Var != null) {
                pi1.a(menuItem, v2Var);
            }
            pi1.c(menuItem, this.B);
            pi1.g(menuItem, this.C);
            pi1.b(menuItem, this.n, this.o);
            pi1.f(menuItem, this.p, this.f360q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                pi1.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                pi1.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.h = true;
            i(this.a.add(this.b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu subMenuAddSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = mw2.this.c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.c = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.d = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.e = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            e0 e0VarU = e0.u(mw2.this.c, attributeSet, R$styleable.MenuItem);
            this.i = e0VarU.n(R$styleable.MenuItem_android_id, 0);
            this.j = (e0VarU.k(R$styleable.MenuItem_android_menuCategory, this.c) & Opcodes.V_PREVIEW) | (e0VarU.k(R$styleable.MenuItem_android_orderInCategory, this.d) & 65535);
            this.k = e0VarU.p(R$styleable.MenuItem_android_title);
            this.l = e0VarU.p(R$styleable.MenuItem_android_titleCondensed);
            this.m = e0VarU.n(R$styleable.MenuItem_android_icon, 0);
            this.n = c(e0VarU.o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.o = e0VarU.k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.p = c(e0VarU.o(R$styleable.MenuItem_android_numericShortcut));
            this.f360q = e0VarU.k(R$styleable.MenuItem_numericModifiers, 4096);
            int i = R$styleable.MenuItem_android_checkable;
            if (e0VarU.s(i)) {
                this.r = e0VarU.a(i, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = e0VarU.a(R$styleable.MenuItem_android_checked, false);
            this.t = e0VarU.a(R$styleable.MenuItem_android_visible, this.f);
            this.u = e0VarU.a(R$styleable.MenuItem_android_enabled, this.g);
            this.v = e0VarU.k(R$styleable.MenuItem_showAsAction, -1);
            this.z = e0VarU.o(R$styleable.MenuItem_android_onClick);
            this.w = e0VarU.n(R$styleable.MenuItem_actionLayout, 0);
            this.x = e0VarU.o(R$styleable.MenuItem_actionViewClass);
            String strO = e0VarU.o(R$styleable.MenuItem_actionProviderClass);
            this.y = strO;
            boolean z = strO != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (v2) e(strO, mw2.f, mw2.this.b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = e0VarU.p(R$styleable.MenuItem_contentDescription);
            this.C = e0VarU.p(R$styleable.MenuItem_tooltipText);
            int i2 = R$styleable.MenuItem_iconTintMode;
            if (e0VarU.s(i2)) {
                this.E = s.e(e0VarU.k(i2, -1), this.E);
            } else {
                this.E = null;
            }
            int i3 = R$styleable.MenuItem_iconTint;
            if (e0VarU.s(i3)) {
                this.D = e0VarU.c(i3);
            } else {
                this.D = null;
            }
            e0VarU.x();
            this.h = false;
        }

        public void h() {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public mw2(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        z2 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            v2 v2Var = bVar.A;
                            if (v2Var == null || !v2Var.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.d == null) {
            this.d = a(this.c);
        }
        return this.d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof lw2)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z = false;
        try {
            try {
                layout = this.c.getResources().getLayout(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof e) {
                    e eVar = (e) menu;
                    if (eVar.H()) {
                        eVar.i0();
                        z = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((e) menu).h0();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (z) {
                ((e) menu).h0();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
