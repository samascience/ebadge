package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.zabq;
import com.tencent.connect.common.Constants;
import defpackage.a52;
import defpackage.pr3;
import defpackage.qb0;
import defpackage.r10;
import defpackage.ta0;
import defpackage.vs3;
import defpackage.x32;
import defpackage.xr1;
import defpackage.za1;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    private static final Object d = new Object();
    private static final a e = new a();
    public static final int f = b.a;
    private String c;

    /* JADX INFO: renamed from: com.google.android.gms.common.a$a, reason: collision with other inner class name */
    private class HandlerC0074a extends vs3 {
        private final Context a;

        public HandlerC0074a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int iG = a.this.g(this.a);
            if (a.this.k(iG)) {
                a.this.p(this.a, iG);
            }
        }
    }

    a() {
    }

    public static a n() {
        return e;
    }

    public static Dialog q(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(r10.d(activity, 18));
        builder.setPositiveButton(Constants.STR_EMPTY, (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        t(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    static Dialog r(Context context, int i, qb0 qb0Var, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(r10.d(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strC = r10.c(context, i);
        if (strC != null) {
            builder.setPositiveButton(strC, qb0Var);
        }
        String strG = r10.g(context, i);
        if (strG != null) {
            builder.setTitle(strG);
        }
        return builder.create();
    }

    static void t(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.N(dialog, onCancelListener).M(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else {
            ErrorDialogFragment.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    private final void v(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            u(context);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strF = r10.f(context, i);
        String strE = r10.e(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        xr1.d dVarR = new xr1.d(context).l(true).e(true).j(strF).r(new xr1.b().h(strE));
        if (ta0.b(context)) {
            a52.i(x32.f());
            dVarR.q(context.getApplicationInfo().icon).o(2);
            if (ta0.c(context)) {
                dVarR.a(R$drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R$string.common_open_on_phone), pendingIntent);
            } else {
                dVarR.h(pendingIntent);
            }
        } else {
            dVarR.q(R.drawable.stat_sys_warning).s(resources.getString(com.google.android.gms.base.R$string.common_google_play_services_notification_ticker)).v(System.currentTimeMillis()).h(pendingIntent).i(strE);
        }
        if (x32.i()) {
            a52.i(x32.i());
            String strY = y();
            if (strY == null) {
                strY = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String strB = r10.b(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", strB, 4));
                } else if (!strB.equals(notificationChannel.getName())) {
                    notificationChannel.setName(strB);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            dVarR.f(strY);
        }
        Notification notificationB = dVarR.b();
        if (i == 1 || i == 2 || i == 3) {
            d.b.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationB);
    }

    private final String y() {
        String str;
        synchronized (d) {
            str = this.c;
        }
        return str;
    }

    @Override // com.google.android.gms.common.b
    public Intent c(Context context, int i, String str) {
        return super.c(context, i, str);
    }

    @Override // com.google.android.gms.common.b
    public PendingIntent d(Context context, int i, int i2) {
        return super.d(context, i, i2);
    }

    @Override // com.google.android.gms.common.b
    public final String f(int i) {
        return super.f(i);
    }

    @Override // com.google.android.gms.common.b
    public int g(Context context) {
        return super.g(context);
    }

    @Override // com.google.android.gms.common.b
    public int h(Context context, int i) {
        return super.h(context, i);
    }

    @Override // com.google.android.gms.common.b
    public final boolean k(int i) {
        return super.k(i);
    }

    public Dialog l(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return r(activity, i, qb0.b(activity, c(activity, i, "d"), i2), onCancelListener);
    }

    public PendingIntent m(Context context, ConnectionResult connectionResult) {
        return connectionResult.I0() ? connectionResult.H0() : d(context, connectionResult.F0(), 0);
    }

    public boolean o(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogL = l(activity, i, i2, onCancelListener);
        if (dialogL == null) {
            return false;
        }
        t(activity, dialogL, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void p(Context context, int i) {
        v(context, i, null, e(context, i, 0, "n"));
    }

    public final zabq s(Context context, pr3 pr3Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabq zabqVar = new zabq(pr3Var);
        context.registerReceiver(zabqVar, intentFilter);
        zabqVar.b(context);
        if (j(context, "com.google.android.gms")) {
            return zabqVar;
        }
        pr3Var.a();
        zabqVar.a();
        return null;
    }

    final void u(Context context) {
        new HandlerC0074a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean w(Activity activity, za1 za1Var, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogR = r(activity, i, qb0.a(za1Var, c(activity, i, "d"), 2), onCancelListener);
        if (dialogR == null) {
            return false;
        }
        t(activity, dialogR, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean x(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent pendingIntentM = m(context, connectionResult);
        if (pendingIntentM == null) {
            return false;
        }
        v(context, connectionResult.F0(), null, GoogleApiActivity.a(context, pendingIntentM, i));
        return true;
    }
}
