package com.pairip.application;

import android.content.Context;
import com.pairip.licensecheck.LicenseClient;
import xfkj.fitpro.application.MyApplication;

/* JADX INFO: loaded from: classes2.dex */
public class Application extends MyApplication {
    @Override // defpackage.hl1, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        LicenseClient.checkLicense(context);
        super.attachBaseContext(context);
    }
}
