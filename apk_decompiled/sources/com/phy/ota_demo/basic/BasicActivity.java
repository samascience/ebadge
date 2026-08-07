package com.phy.ota_demo.basic;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import defpackage.r02;

/* JADX INFO: loaded from: classes.dex */
public class BasicActivity extends AppCompatActivity {
    protected Context context;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = this;
        r02.a().a(this);
    }
}
