package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import com.blankj.utilcode.util.a;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.h;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.service.UploadDataService;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k00 {
    private static final String a = "k00";

    public static String c(Object obj) {
        return new rv0().g("yyyyMMddHHmmss").c().toJson(obj);
    }

    public static boolean d(String str) {
        if (!DBHelper.isLogin() || pv2.f(str)) {
            return false;
        }
        return !pv2.a(DBHelper.getUserInfo().getDevid(), str);
    }

    public static boolean e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(DialogInterface dialogInterface, int i) {
        a.n(h.b(c.f()));
    }

    public static String h(String str) {
        return pv2.h(str) ? Constants.STR_EMPTY : str.replaceAll("[^a-zA-Z0-9\\u0020]", Constants.STR_EMPTY);
    }

    public static void i(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        builder.setTitle(R.string.tips_txt);
        builder.setMessage(R.string.permission_refuse_tips);
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: i00
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                k00.f(dialogInterface, i);
            }
        });
        builder.setPositiveButton(R.string.open, new DialogInterface.OnClickListener() { // from class: j00
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                k00.g(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public static void j() {
        if (!DBHelper.isLogin()) {
            Log.i(a, "no login ,can not upload");
        } else if (pv2.f(DBHelper.getUserInfo().getDevid())) {
            Log.i(a, "device id is empty ,can not upload");
        } else {
            hn2.d(UploadDataService.class);
        }
    }
}
