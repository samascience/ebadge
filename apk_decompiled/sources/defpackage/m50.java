package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes3.dex */
public class m50 implements PopupWindow.OnDismissListener {
    private Context a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private int f;
    private View g;
    private PopupWindow h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;
    private PopupWindow.OnDismissListener m;
    private int n;
    private boolean o;
    private View.OnTouchListener p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Window f354q;
    private boolean r;
    private float s;
    private boolean t;

    class a implements View.OnKeyListener {
        a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            m50.this.h.dismiss();
            return true;
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            return (motionEvent.getAction() == 0 && (x < 0 || x >= m50.this.b || y < 0 || y >= m50.this.c)) || motionEvent.getAction() == 4;
        }
    }

    public static class c {
        private m50 a;

        public c(Context context) {
            this.a = new m50(context, null);
        }

        public m50 a() {
            this.a.m();
            return this.a;
        }

        public c b(boolean z) {
            this.a.d = z;
            return this;
        }

        public c c(PopupWindow.OnDismissListener onDismissListener) {
            this.a.m = onDismissListener;
            return this;
        }

        public c d(boolean z) {
            this.a.e = z;
            return this;
        }

        public c e(View view) {
            this.a.g = view;
            this.a.f = -1;
            return this;
        }

        public c f(int i, int i2) {
            this.a.b = i;
            this.a.c = i2;
            return this;
        }
    }

    /* synthetic */ m50(Context context, a aVar) {
        this(context);
    }

    private void l(PopupWindow popupWindow) {
        popupWindow.setClippingEnabled(this.j);
        if (this.k) {
            popupWindow.setIgnoreCheekPress();
        }
        int i = this.l;
        if (i != -1) {
            popupWindow.setInputMethodMode(i);
        }
        int i2 = this.n;
        if (i2 != -1) {
            popupWindow.setSoftInputMode(i2);
        }
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            popupWindow.setOnDismissListener(onDismissListener);
        }
        View.OnTouchListener onTouchListener = this.p;
        if (onTouchListener != null) {
            popupWindow.setTouchInterceptor(onTouchListener);
        }
        popupWindow.setTouchable(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupWindow m() {
        if (this.g == null) {
            this.g = LayoutInflater.from(this.a).inflate(this.f, (ViewGroup) null);
        }
        Activity activity = (Activity) this.g.getContext();
        if (activity != null && this.r) {
            float f = this.s;
            if (f <= 0.0f || f >= 1.0f) {
                f = 0.7f;
            }
            Window window = activity.getWindow();
            this.f354q = window;
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            this.f354q.addFlags(2);
            this.f354q.setAttributes(attributes);
        }
        if (this.b == 0 || this.c == 0) {
            this.h = new PopupWindow(this.g, -2, -2);
        } else {
            this.h = new PopupWindow(this.g, this.b, this.c);
        }
        int i = this.i;
        if (i != -1) {
            this.h.setAnimationStyle(i);
        }
        l(this.h);
        if (this.b == 0 || this.c == 0) {
            this.h.getContentView().measure(0, 0);
            this.b = this.h.getContentView().getMeasuredWidth();
            this.c = this.h.getContentView().getMeasuredHeight();
        }
        this.h.setOnDismissListener(this);
        if (this.t) {
            this.h.setFocusable(this.d);
            this.h.setBackgroundDrawable(new ColorDrawable(0));
            this.h.setOutsideTouchable(this.e);
        } else {
            this.h.setFocusable(true);
            this.h.setOutsideTouchable(false);
            this.h.setBackgroundDrawable(null);
            this.h.getContentView().setFocusable(true);
            this.h.getContentView().setFocusableInTouchMode(true);
            this.h.getContentView().setOnKeyListener(new a());
            this.h.setTouchInterceptor(new b());
        }
        this.h.update();
        return this.h;
    }

    public void n() {
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        Window window = this.f354q;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            this.f354q.setAttributes(attributes);
        }
        PopupWindow popupWindow = this.h;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.h.dismiss();
    }

    public m50 o(View view) {
        PopupWindow popupWindow = this.h;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(view);
        }
        return this;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        n();
    }

    private m50(Context context) {
        this.d = true;
        this.e = true;
        this.f = -1;
        this.i = -1;
        this.j = true;
        this.k = false;
        this.l = -1;
        this.n = -1;
        this.o = true;
        this.r = false;
        this.s = 0.0f;
        this.t = true;
        this.a = context;
    }
}
