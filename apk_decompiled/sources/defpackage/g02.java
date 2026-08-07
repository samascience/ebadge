package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.b;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.a;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.h;
import com.legend.mywatch.commonlib.R$attr;
import com.legend.mywatch.commonlib.R$string;
import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g02 {
    static void f(b bVar) {
        Window window = bVar.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) ml2.c()) * 0.95d);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public static int g(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.data;
        }
        return 0;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(PermissionUtils.b bVar, String str, boolean z, List list, List list2, List list3) {
        if (z) {
            bVar.onGranted();
            return;
        }
        bVar.onDenied();
        if (fz.b(list2)) {
            a.n(h.b(c.f()));
            ToastUtils.s(String.format(pv2.d(R$string.permission_helper_permission_refuse), str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(String[] strArr, final PermissionUtils.b bVar, final String str, DialogInterface dialogInterface, int i) {
        PermissionUtils.y(strArr).n(new PermissionUtils.c() { // from class: c02
            @Override // com.blankj.utilcode.util.PermissionUtils.c
            public final void a(boolean z, List list, List list2, List list3) {
                g02.l(bVar, str, z, list, list2, list3);
            }
        }).z();
    }

    public static void n(final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2, String str, String... strArr) {
        Activity activityG = a.g();
        if (a.i(activityG)) {
            b.a aVar = new b.a(activityG);
            aVar.t(activityG.getString(R$string.warn));
            aVar.k(R$string.cancel, new DialogInterface.OnClickListener() { // from class: d02
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            String str2 = Constants.STR_EMPTY;
            for (String str3 : strArr) {
                str2 = str2 + str3 + "\n";
            }
            aVar.i(activityG.getString(R$string.permission_tips_format, str, str2));
            aVar.k(R$string.cancel, new DialogInterface.OnClickListener() { // from class: e02
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g02.j(onClickListener, dialogInterface, i);
                }
            });
            aVar.p(activityG.getString(R$string.agree), new DialogInterface.OnClickListener() { // from class: f02
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g02.k(onClickListener2, dialogInterface, i);
                }
            });
            b bVarA = aVar.a();
            bVarA.show();
            f(bVarA);
            int iG = g(activityG, R$attr.colorPrimary);
            Button buttonJ = bVarA.j(-1);
            if (buttonJ != null) {
                buttonJ.setTextColor(iG);
            }
            Button buttonJ2 = bVarA.j(-2);
            if (buttonJ2 != null) {
                buttonJ2.setTextColor(iG);
            }
        }
    }

    public static void o(final PermissionUtils.b bVar, final String str, final String... strArr) {
        if (PermissionUtils.t(strArr)) {
            bVar.onGranted();
        } else {
            n(null, new DialogInterface.OnClickListener() { // from class: b02
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g02.m(strArr, bVar, str, dialogInterface, i);
                }
            }, str, h02.b(strArr));
        }
    }
}
