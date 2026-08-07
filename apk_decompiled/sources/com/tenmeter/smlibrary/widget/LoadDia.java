package com.tenmeter.smlibrary.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tenmeter.smlibrary.R;

/* JADX INFO: loaded from: classes3.dex */
public class LoadDia extends Dialog {
    public LoadDia(Context context) {
        super(context, R.style.LoadDiaStyle);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sm_sdk_device_loading);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public LoadDia(Context context, int i) {
        super(context, R.style.LoadDiaStyle);
    }

    protected LoadDia(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
