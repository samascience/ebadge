package yqy.yichip.lib_pro_common.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import defpackage.e3;
import defpackage.g3;
import defpackage.jw1;
import defpackage.q30;
import defpackage.rv1;
import java.util.ArrayList;
import yqy.yichip.lib_pro_common.R$mipmap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseActivity extends FragmentActivity {
    private static final String TAG = "BaseActivity";
    private static Toast toast;
    public Context mContext;
    private rv1 mListener;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseActivity.toast.show();
        }
    }

    class b implements DialogInterface.OnClickListener {
        final /* synthetic */ jw1 a;

        b(jw1 jw1Var) {
            this.a = jw1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            jw1 jw1Var = this.a;
            if (jw1Var != null) {
                jw1Var.b(dialogInterface);
            }
        }
    }

    class c implements DialogInterface.OnClickListener {
        final /* synthetic */ jw1 a;

        c(jw1 jw1Var) {
            this.a = jw1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            jw1 jw1Var = this.a;
            if (jw1Var != null) {
                jw1Var.c(dialogInterface);
            }
        }
    }

    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public abstract class e implements View.OnClickListener {
        private long a;

        public e() {
        }

        public abstract void a(View view);

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.a >= 1000) {
                this.a = jCurrentTimeMillis;
                a(view);
            }
        }
    }

    public static boolean checkPermission(Context context, String str) {
        return q30.a(context, str) == 0;
    }

    public abstract void afterInitView();

    public abstract void beforeInitView();

    protected abstract int getLayoutId();

    protected abstract void initView();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        e3.a(this);
        setContentView(getLayoutId());
        beforeInitView();
        initView();
        afterInitView();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        e3.b(this);
    }

    public void onRequestPermission(String[] strArr, rv1 rv1Var) {
        this.mListener = rv1Var;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (q30.a(this, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            this.mListener.onGranted();
        } else {
            g3.s(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showPromptDialog(String str) {
        androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(this);
        aVar.t("提示");
        aVar.i(str);
        aVar.f(R$mipmap.ic_prompt_64);
        aVar.p("确定", new d());
        aVar.a().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showTipsDialog(String str, String str2, String str3, String str4, jw1 jw1Var) {
        androidx.appcompat.app.b bVarV = new androidx.appcompat.app.b.a(this).t(str).i(str2).p(str3, new c(jw1Var)).l(str4, new b(jw1Var)).d(false).v();
        if (jw1Var != null) {
            jw1Var.a(bVarV);
        }
    }

    @SuppressLint({"ShowToast"})
    public void showToast(String str) {
        try {
            Toast toast2 = toast;
            if (toast2 == null) {
                toast = Toast.makeText(this.mContext, str, 0);
            } else {
                toast2.setText(str);
            }
            runOnUiThread(new a());
        } catch (Exception e2) {
            e2.printStackTrace();
            Looper.prepare();
            Toast.makeText(this.mContext, str, 0).show();
            Looper.loop();
        }
    }

    protected void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
