package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.legend.mywatch.commonlib.R$id;
import com.legend.mywatch.commonlib.R$layout;
import com.legend.mywatch.commonlib.R$style;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class kc1 extends Dialog {

    public static class a {
        private Context a;
        private String b = Constants.STR_EMPTY;
        private boolean c = false;
        private boolean d = false;
        private List e = new ArrayList();

        public a(Context context) {
            this.a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(kc1 kc1Var) {
            if (kc1Var.isShowing()) {
                if (!((Activity) this.a).isDestroyed()) {
                    kc1Var.dismiss();
                }
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    e43.a(((WeakReference) it.next()).get());
                }
            }
        }

        public kc1 b(boolean z, int i) {
            View viewInflate = LayoutInflater.from(this.a).inflate(R$layout.dialog_loading, (ViewGroup) null);
            final kc1 kc1Var = new kc1(this.a, R$style.MyDialogStyle);
            TextView textView = (TextView) viewInflate.findViewById(R$id.tipTextView);
            String str = this.b;
            if (str == Constants.STR_EMPTY || str == null) {
                textView.setVisibility(8);
            } else {
                textView.setText(str);
            }
            kc1Var.setContentView(viewInflate);
            kc1Var.setCancelable(this.c);
            kc1Var.setCanceledOnTouchOutside(this.d);
            if (z) {
                kc1Var.show();
                new Handler().postDelayed(new Runnable() { // from class: jc1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.c(kc1Var);
                    }
                }, i);
            }
            return kc1Var;
        }

        public a d(boolean z) {
            this.c = z;
            return this;
        }

        public a e(String str) {
            this.b = str;
            return this;
        }
    }

    public kc1(Context context, int i) {
        super(context, i);
    }
}
