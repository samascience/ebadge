package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.onmicro.omtoolbox.R$id;
import com.onmicro.omtoolbox.R$layout;
import com.onmicro.omtoolbox.R$style;

/* JADX INFO: loaded from: classes3.dex */
public class wz extends kg {

    public static class a {
        private Context a;
        private String b;
        private String c;
        private String d;
        private String e;
        private View f;
        private int g = 17;
        private boolean h = true;
        private int i = -1;
        private DialogInterface.OnClickListener j;
        private DialogInterface.OnClickListener k;

        /* JADX INFO: renamed from: wz$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0176a implements View.OnClickListener {
            final /* synthetic */ wz a;

            ViewOnClickListenerC0176a(wz wzVar) {
                this.a = wzVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.j.onClick(this.a, -1);
            }
        }

        class b implements View.OnClickListener {
            final /* synthetic */ wz a;

            b(wz wzVar) {
                this.a = wzVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.k.onClick(this.a, -2);
            }
        }

        public a(Context context) {
            this.a = context;
        }

        public wz c() {
            wz wzVar = new wz(this.a, R$style.common_dialog_style);
            if (this.f == null) {
                View viewInflate = LayoutInflater.from(this.a).inflate(R$layout.dialog_comm_layout, (ViewGroup) null);
                this.f = viewInflate;
                TextView textView = (TextView) viewInflate.findViewById(R$id.tv_title);
                TextView textView2 = (TextView) this.f.findViewById(R$id.tv_content);
                TextView textView3 = (TextView) this.f.findViewById(R$id.tv_negative);
                TextView textView4 = (TextView) this.f.findViewById(R$id.tv_positive);
                if (TextUtils.isEmpty(this.b)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(this.b);
                }
                if (TextUtils.isEmpty(this.d)) {
                    textView4.setVisibility(8);
                } else {
                    textView4.setText(this.d);
                    if (this.j != null) {
                        textView4.setOnClickListener(new ViewOnClickListenerC0176a(wzVar));
                    }
                }
                if (TextUtils.isEmpty(this.e)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setVisibility(0);
                    textView3.setText(this.e);
                    if (this.k != null) {
                        textView3.setOnClickListener(new b(wzVar));
                    }
                }
                if (!TextUtils.isEmpty(this.c) || this.f != null) {
                    textView2.setText(this.c);
                }
            }
            wzVar.addContentView(this.f, new ViewGroup.LayoutParams(-1, -2));
            wzVar.setCancelable(this.h);
            Window window = wzVar.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(this.g);
            int i = this.i;
            if (i != -1) {
                window.setWindowAnimations(i);
            }
            return wzVar;
        }

        public a d(boolean z) {
            this.h = z;
            return this;
        }

        public a e(int i) {
            this.f = LayoutInflater.from(this.a).inflate(i, (ViewGroup) null);
            return this;
        }

        public a f(View view) {
            this.f = view;
            return this;
        }

        public a g(String str) {
            this.c = str;
            return this;
        }

        public a h(String str, DialogInterface.OnClickListener onClickListener) {
            this.e = str;
            this.k = onClickListener;
            return this;
        }

        public a i(String str, DialogInterface.OnClickListener onClickListener) {
            this.d = str;
            this.j = onClickListener;
            return this;
        }

        public a j(String str) {
            this.b = str;
            return this;
        }
    }

    public wz(Context context, int i) {
        super(context, i);
    }
}
