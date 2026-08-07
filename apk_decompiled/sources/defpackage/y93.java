package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public final class y93 {
    private final Activity a;
    private final String b;
    private d82 c;

    public y93(Activity activity) {
        p31.f(activity, "activity");
        this.a = activity;
        this.b = "UploadProgressUiController";
    }

    private final void b(final d82 d82Var) {
        d82Var.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: x93
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                y93.c(this.a, d82Var, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(y93 y93Var, d82 d82Var, DialogInterface dialogInterface) {
        if (y93Var.c == d82Var) {
            y93Var.c = null;
        }
    }

    private final void e(d82 d82Var) {
        if (this.c == d82Var) {
            this.c = null;
        }
    }

    public final void d() {
        f();
        Log.d(this.b, "上传进度 UI 控制器已清理");
    }

    public final void f() {
        try {
            d82 d82Var = this.c;
            if (d82Var != null && d82Var.isShowing()) {
                Log.d(this.b, "隐藏上传进度对话框");
                d82Var.dismiss();
            }
            this.c = null;
        } catch (Exception e) {
            Log.e(this.b, "隐藏上传进度对话框失败: " + e.getMessage(), e);
            this.c = null;
        }
    }

    public final void g(String str, int i) {
        p31.f(str, "message");
        if (this.a.isDestroyed() || this.a.isFinishing()) {
            Log.w(this.b, "Activity 已销毁，无法显示上传进度对话框");
            return;
        }
        try {
            f();
            Log.d(this.b, "显示上传进度对话框: " + str + ", 进度: " + i + "%");
            d82 d82VarA = d82.f.a(this.a, str);
            b(d82VarA);
            this.c = d82VarA;
            d82VarA.f(i);
            d82VarA.k();
        } catch (Exception e) {
            Log.e(this.b, "显示上传进度对话框失败: " + e.getMessage(), e);
        }
    }

    public final void h(String str) {
        p31.f(str, "errorMessage");
        if (this.a.isDestroyed() || this.a.isFinishing()) {
            return;
        }
        try {
            f();
            Log.d(this.b, "显示上传失败对话框: " + str);
            d82.a aVar = d82.f;
            Activity activity = this.a;
            String string = activity.getString(R.string.upload_failed, str);
            p31.e(string, "getString(...)");
            d82 d82VarA = aVar.a(activity, string);
            b(d82VarA);
            this.c = d82VarA;
            d82VarA.f(0);
            d82VarA.l(5000);
        } catch (Exception e) {
            Log.e(this.b, "显示上传失败对话框失败: " + e.getMessage(), e);
        }
    }

    public final void i() {
        if (this.a.isDestroyed() || this.a.isFinishing()) {
            return;
        }
        try {
            f();
            Log.d(this.b, "显示上传成功对话框");
            d82.a aVar = d82.f;
            Activity activity = this.a;
            String string = activity.getString(R.string.upload_success);
            p31.e(string, "getString(...)");
            d82 d82VarA = aVar.a(activity, string);
            b(d82VarA);
            this.c = d82VarA;
            d82VarA.f(100);
            d82VarA.l(2000);
        } catch (Exception e) {
            Log.e(this.b, "显示上传成功对话框失败: " + e.getMessage(), e);
        }
    }

    public final void j(int i, String str) {
        if (this.a.isDestroyed() || this.a.isFinishing()) {
            Log.w(this.b, "Activity 已销毁，跳过进度更新: " + i + "%");
            return;
        }
        try {
            d82 d82Var = this.c;
            if (d82Var == null) {
                Log.w(this.b, "更新上传进度失败: currentDialog 为空, 目标进度=" + i + "%");
                return;
            }
            if (!d82Var.isShowing()) {
                Log.w(this.b, "更新上传进度失败: 对话框未显示, 目标进度=" + i + "%");
                e(d82Var);
                return;
            }
            Log.d(this.b, "更新上传进度: " + i + "%");
            if (str != null) {
                d82Var.h(i, str);
            } else {
                d82Var.f(i);
            }
        } catch (Exception e) {
            Log.e(this.b, "更新上传进度失败: " + e.getMessage(), e);
        }
    }
}
