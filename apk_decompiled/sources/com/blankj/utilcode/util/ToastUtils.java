package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.blankj.utilcode.R$id;
import com.blankj.utilcode.R$layout;
import defpackage.as1;
import defpackage.be3;
import java.lang.ref.WeakReference;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public final class ToastUtils {
    private static final ToastUtils l = n();
    private static WeakReference m;
    private String a;
    private int b = -1;
    private int c = -1;
    private int d = -1;
    private int e = -16777217;
    private int f = -1;
    private int g = -16777217;
    private int h = -1;
    private boolean i = false;
    private Drawable[] j = new Drawable[4];
    private boolean k = false;

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {
        private static final int a = q.e(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(q.k() - a, Integer.MIN_VALUE), i2);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtils.m != null) {
                e eVar = (e) ToastUtils.m.get();
                if (eVar != null) {
                    eVar.cancel();
                }
                WeakReference unused = ToastUtils.m = null;
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ View b;
        final /* synthetic */ CharSequence c;
        final /* synthetic */ int d;

        b(View view, CharSequence charSequence, int i) {
            this.b = view;
            this.c = charSequence;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToastUtils.l();
            e eVarO = ToastUtils.o(ToastUtils.this);
            WeakReference unused = ToastUtils.m = new WeakReference(eVarO);
            View view = this.b;
            if (view != null) {
                eVarO.c(view);
            } else {
                eVarO.b(this.c);
            }
            eVarO.a(this.d);
        }
    }

    static abstract class c implements e {
        protected Toast a = new Toast(o.a());
        protected ToastUtils b;
        protected View c;

        c(ToastUtils toastUtils) {
            this.b = toastUtils;
            if (toastUtils.b == -1 && this.b.c == -1 && this.b.d == -1) {
                return;
            }
            this.a.setGravity(this.b.b, this.b.c, this.b.d);
        }

        private void e() {
            if (q.F()) {
                c(d(-1));
            }
        }

        private void f(TextView textView) {
            if (this.b.f != -1) {
                this.c.setBackgroundResource(this.b.f);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.b.e != -16777217) {
                Drawable background = this.c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.b.e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.b.e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.b.e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.c.setBackgroundColor(this.b.e);
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void b(CharSequence charSequence) {
            View viewW = this.b.w(charSequence);
            if (viewW != null) {
                c(viewW);
                e();
                return;
            }
            View view = this.a.getView();
            this.c = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                c(q.I(R$layout.utils_toast_view));
            }
            TextView textView = (TextView) this.c.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.b.g != -16777217) {
                textView.setTextColor(this.b.g);
            }
            if (this.b.h != -1) {
                textView.setTextSize(this.b.h);
            }
            f(textView);
            e();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void c(View view) {
            this.c = view;
            this.a.setView(view);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void cancel() {
            Toast toast = this.a;
            if (toast != null) {
                toast.cancel();
            }
            this.a = null;
            this.c = null;
        }

        View d(int i) {
            Bitmap bitmapR = q.R(this.c);
            ImageView imageView = new ImageView(o.a());
            imageView.setTag("TAG_TOAST" + i);
            imageView.setImageBitmap(bitmapR);
            return imageView;
        }
    }

    static final class d extends c {
        private static int f;
        private o.a d;
        private e e;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.cancel();
            }
        }

        class b extends o.a {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            @Override // com.blankj.utilcode.util.o.a
            public void a(Activity activity) {
                if (d.this.i()) {
                    d.this.l(activity, this.a, false);
                }
            }
        }

        d(ToastUtils toastUtils) {
            super(toastUtils);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i() {
            return this.d != null;
        }

        private void j() {
            b bVar = new b(f);
            this.d = bVar;
            q.a(bVar);
        }

        private e k(int i) {
            f fVar = new f(this.b);
            fVar.a = this.a;
            fVar.a(i);
            return fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(Activity activity, int i, boolean z) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.a.getGravity();
                layoutParams.bottomMargin = this.a.getYOffset() + q.t();
                layoutParams.topMargin = this.a.getYOffset() + q.w();
                layoutParams.leftMargin = this.a.getXOffset();
                View viewD = d(i);
                if (z) {
                    viewD.setAlpha(0.0f);
                    viewD.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(viewD, layoutParams);
            }
        }

        private e m(Activity activity, int i) {
            g gVar = new g(this.b, activity.getWindowManager(), 99);
            gVar.c = d(-1);
            gVar.a = this.a;
            gVar.a(i);
            return gVar;
        }

        private void n() {
            q.M(this.d);
            this.d = null;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void a(int i) {
            if (this.a == null) {
                return;
            }
            if (!q.B()) {
                this.e = k(i);
                return;
            }
            boolean z = false;
            for (Activity activity : q.j()) {
                if (q.A(activity)) {
                    if (z) {
                        l(activity, f, true);
                    } else {
                        this.e = m(activity, i);
                        z = true;
                    }
                }
            }
            if (!z) {
                this.e = k(i);
                return;
            }
            j();
            q.O(new a(), i == 0 ? 2000L : 3500L);
            f++;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.c, com.blankj.utilcode.util.ToastUtils.e
        public void cancel() {
            Window window;
            if (i()) {
                n();
                for (Activity activity : q.j()) {
                    if (q.A(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder();
                        sb.append("TAG_TOAST");
                        sb.append(f - 1);
                        View viewFindViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (viewFindViewWithTag != null) {
                            try {
                                viewGroup.removeView(viewFindViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            e eVar = this.e;
            if (eVar != null) {
                eVar.cancel();
                this.e = null;
            }
            super.cancel();
        }
    }

    interface e {
        void a(int i);

        void b(CharSequence charSequence);

        void c(View view);

        void cancel();
    }

    static final class f extends c {
        f(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void a(int i) {
            Toast toast = this.a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i);
            this.a.show();
        }
    }

    public static void l() {
        q.N(new a());
    }

    private static CharSequence m(CharSequence charSequence) {
        if (charSequence == null) {
            return "toast null";
        }
        return charSequence.length() == 0 ? "toast nothing" : charSequence;
    }

    public static ToastUtils n() {
        return new ToastUtils();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e o(ToastUtils toastUtils) {
        if (toastUtils.k || !as1.d(o.a()).a() || q.D()) {
            return q.D() ? new g(toastUtils, 2038) : new d(toastUtils);
        }
        return new f(toastUtils);
    }

    private static void p(View view, CharSequence charSequence, int i, ToastUtils toastUtils) {
        q.N(toastUtils.new b(view, charSequence, i));
    }

    private static void q(CharSequence charSequence, int i, ToastUtils toastUtils) {
        p(null, m(charSequence), i, toastUtils);
    }

    public static void r(int i) {
        q(q.x(i), 1, l);
    }

    public static void s(CharSequence charSequence) {
        q(charSequence, 1, l);
    }

    public static void t(int i) {
        q(q.x(i), 0, l);
    }

    public static void u(CharSequence charSequence) {
        q(charSequence, 0, l);
    }

    public static void v(String str, Object... objArr) {
        q(q.h(str, objArr), 0, l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View w(CharSequence charSequence) {
        if (!"dark".equals(this.a) && !"light".equals(this.a)) {
            Drawable[] drawableArr = this.j;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View viewI = q.I(R$layout.utils_toast_view);
        TextView textView = (TextView) viewI.findViewById(R.id.message);
        if ("dark".equals(this.a)) {
            ((GradientDrawable) viewI.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.j[0] != null) {
            View viewFindViewById = viewI.findViewById(R$id.utvLeftIconView);
            be3.t0(viewFindViewById, this.j[0]);
            viewFindViewById.setVisibility(0);
        }
        if (this.j[1] != null) {
            View viewFindViewById2 = viewI.findViewById(R$id.utvTopIconView);
            be3.t0(viewFindViewById2, this.j[1]);
            viewFindViewById2.setVisibility(0);
        }
        if (this.j[2] != null) {
            View viewFindViewById3 = viewI.findViewById(R$id.utvRightIconView);
            be3.t0(viewFindViewById3, this.j[2]);
            viewFindViewById3.setVisibility(0);
        }
        if (this.j[3] != null) {
            View viewFindViewById4 = viewI.findViewById(R$id.utvBottomIconView);
            be3.t0(viewFindViewById4, this.j[3]);
            viewFindViewById4.setVisibility(0);
        }
        return viewI;
    }

    static final class g extends c {
        private WindowManager d;
        private WindowManager.LayoutParams e;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.cancel();
            }
        }

        g(ToastUtils toastUtils, int i) {
            super(toastUtils);
            this.e = new WindowManager.LayoutParams();
            this.d = (WindowManager) o.a().getSystemService("window");
            this.e.type = i;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void a(int i) {
            if (this.a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.e;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.e;
            layoutParams2.flags = Opcodes.DCMPG;
            layoutParams2.packageName = o.a().getPackageName();
            this.e.gravity = this.a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.e;
            int i2 = layoutParams3.gravity;
            if ((i2 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i2 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.a.getXOffset();
            this.e.y = this.a.getYOffset();
            this.e.horizontalMargin = this.a.getHorizontalMargin();
            this.e.verticalMargin = this.a.getVerticalMargin();
            try {
                WindowManager windowManager = this.d;
                if (windowManager != null) {
                    windowManager.addView(this.c, this.e);
                }
            } catch (Exception unused) {
            }
            q.O(new a(), i == 0 ? 2000L : 3500L);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.c, com.blankj.utilcode.util.ToastUtils.e
        public void cancel() {
            try {
                WindowManager windowManager = this.d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.c);
                    this.d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        g(ToastUtils toastUtils, WindowManager windowManager, int i) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.e = layoutParams;
            this.d = windowManager;
            layoutParams.type = i;
        }
    }
}
