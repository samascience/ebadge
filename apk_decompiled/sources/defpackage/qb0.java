package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class qb0 implements DialogInterface.OnClickListener {
    public static qb0 a(za1 za1Var, Intent intent, int i) {
        return new is3(intent, za1Var, i);
    }

    public static qb0 b(Activity activity, Intent intent, int i) {
        return new tr3(intent, activity, i);
    }

    protected abstract void c();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            c();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
