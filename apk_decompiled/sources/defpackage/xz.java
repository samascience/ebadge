package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.onmicro.omtoolbox.R$string;

/* JADX INFO: loaded from: classes3.dex */
public abstract class xz {

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static wz a(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        wz.a aVar = new wz.a(context);
        if (!TextUtils.isEmpty(str)) {
            aVar.j(str);
        }
        aVar.g(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = context.getString(R$string.sure);
        }
        aVar.i(str3, onClickListener);
        aVar.h(str4, new a());
        wz wzVarC = aVar.c();
        wzVarC.show();
        return wzVarC;
    }
}
