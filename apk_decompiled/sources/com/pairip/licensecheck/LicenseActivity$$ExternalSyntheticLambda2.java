package com.pairip.licensecheck;

import android.content.DialogInterface;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class LicenseActivity$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LicenseActivity f$0;

    public /* synthetic */ LicenseActivity$$ExternalSyntheticLambda2(LicenseActivity licenseActivity) {
        this.f$0 = licenseActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f$0.lambda$showErrorDialog$1(dialogInterface, i);
    }
}
