package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import io.reactivex.annotations.SchedulerSupport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class lc1 extends Dialog {

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
        public /* synthetic */ void c(lc1 lc1Var) {
            if (lc1Var.isShowing()) {
                if (!((Activity) this.a).isDestroyed()) {
                    lc1Var.dismiss();
                }
                if (!rj2.d("p_keys", SchedulerSupport.NONE).equals(SchedulerSupport.NONE)) {
                    Context context = this.a;
                    Toast toastMakeText = Toast.makeText(context, context.getString(R.string.timeout_txt), 0);
                    toastMakeText.setGravity(17, 0, 0);
                    toastMakeText.show();
                }
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    e43.a(((WeakReference) it.next()).get());
                }
            }
        }

        public lc1 b(boolean z, int i) {
            View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_loading, (ViewGroup) null);
            final lc1 lc1Var = new lc1(this.a, R.style.MyDialogStyle);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tipTextView);
            String str = this.b;
            if (str == Constants.STR_EMPTY || str == null) {
                textView.setVisibility(8);
            } else {
                textView.setText(str);
            }
            lc1Var.setContentView(viewInflate);
            lc1Var.setCancelable(this.c);
            lc1Var.setCanceledOnTouchOutside(this.d);
            if (z) {
                lc1Var.show();
                new Handler().postDelayed(new Runnable() { // from class: ic1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.c(lc1Var);
                    }
                }, i);
            }
            return lc1Var;
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

    public lc1(Context context, int i) {
        super(context, i);
    }
}
