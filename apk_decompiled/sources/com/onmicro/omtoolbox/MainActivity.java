package com.onmicro.omtoolbox;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import defpackage.as0;
import defpackage.g9;
import defpackage.h9;
import defpackage.j02;
import defpackage.o33;
import java.io.File;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends BaseActivity {
    Toolbar a;
    GridView b;
    TextView c;
    private g9 d;
    private File e;
    private String[] f = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION"};

    class a implements j02.a {
        a() {
        }

        @Override // j02.a
        public void a() {
        }

        @Override // j02.a
        public void b(String[] strArr) {
        }
    }

    private void J() {
        g9 g9Var = new g9(this);
        this.d = g9Var;
        g9Var.s(0);
        this.d.x(new g9.e() { // from class: nf1
            @Override // g9.e
            public final void a(File file) {
                this.a.N(file);
            }
        });
    }

    private boolean K() {
        if (getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return true;
        }
        o33.b(this, getString(R$string.no_support_ble));
        return false;
    }

    private void L() {
        this.b.setAdapter((ListAdapter) new as0(this));
        this.b.setEmptyView(this.c);
    }

    private void M() {
        j02.c(this, 1, this.f, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(File file) {
        if (file == null) {
            return;
        }
        this.e = file;
        if (getPackageManager().canRequestPackageInstalls()) {
            h9.e(this, file);
        } else {
            requestPermissions(new String[]{"android.permission.REQUEST_INSTALL_PACKAGES"}, 2);
        }
    }

    @Override // com.onmicro.omtoolbox.BaseActivity
    public void G() {
        this.a.setTitle(String.format(Locale.ROOT, "%s(V%s)", h9.a(this), h9.c(this)));
        setSupportActionBar(this.a);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 2 || Environment.isExternalStorageManager()) {
            return;
        }
        o33.b(this, "文件读写需要文件访问权限");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_main);
        if (!K()) {
            finish();
        }
        L();
        M();
        if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
            startActivityForResult(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"), 2);
        }
        J();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 2) {
            h9.e(this, this.e);
        } else {
            j02.b(this, i, strArr, iArr);
        }
    }
}
