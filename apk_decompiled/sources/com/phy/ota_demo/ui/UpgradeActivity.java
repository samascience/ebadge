package com.phy.ota_demo.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.phy.ota_demo.R$id;
import com.phy.ota_demo.R$layout;
import com.phy.ota_demo.R$string;
import com.phy.ota_demo.R$style;
import com.phy.ota_demo.basic.PhyActivity;
import com.phy.ota_demo.ui.UpgradeActivity;
import com.tencent.connect.common.Constants;
import defpackage.a4;
import defpackage.d4;
import defpackage.dm0;
import defpackage.e4;
import defpackage.ev1;
import defpackage.f4;
import defpackage.fv1;
import defpackage.i5;
import defpackage.jr2;
import defpackage.o02;
import defpackage.r02;
import defpackage.rs1;
import defpackage.ss1;
import defpackage.t93;
import defpackage.u93;
import defpackage.zl0;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class UpgradeActivity extends PhyActivity implements rs1 {
    private static final String r = "UpgradeActivity";
    private t93 d;
    private String e;
    private ss1 f;
    private f4 g;
    private f4 h;
    private i5 i;
    private Button l;
    private RecyclerView m;
    private TextView n;
    private TextView o;
    private ProgressBar p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f306q;
    private final String a = Environment.getExternalStorageDirectory().getPath();
    private final String b = r02.a.getExternalFilesDir(null).getAbsolutePath();
    private final List c = new ArrayList();
    private final int j = 110;
    private Handler k = new Handler(new Handler.Callback() { // from class: l93
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.a.Y(message);
        }
    });

    class a implements TextWatcher {
        final /* synthetic */ ImageView a;
        final /* synthetic */ TextView b;

        a(ImageView imageView, TextView textView) {
            this.a = imageView;
            this.b = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() > 0) {
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            this.b.setText(charSequence.length() + "/32");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        if (this.l.getText().toString().equals("选择文件")) {
            n0();
        } else if (this.l.getText().toString().equals("输入密钥")) {
            o0();
        } else if (this.l.getText().toString().equals("开始升级")) {
            p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Y(Message message) {
        if (message.what != 110) {
            return false;
        }
        p0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(int i, o02 o02Var) {
        this.d.notifyItemRemoved(i);
        this.f.B().remove(o02Var);
        int size = this.f.B().size();
        this.n.setText(String.format(Locale.getDefault(), "要升级的设备列表，剩余：%d", Integer.valueOf(size)));
        if (size == 0) {
            showMsg(getString(R$string.upgrade_success));
            this.l.setText("开始升级");
            this.f.O(false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(int i) {
        this.p.setProgress(i);
        this.f306q.setText(getString(R$string.updatting) + " " + i + "%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(ActivityResult activityResult) {
        if (activityResult.b() == -1 && isStorageManager()) {
            showMsg("已打开外部存储管理开关");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Boolean bool) {
        if (bool.booleanValue()) {
            n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f.v();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(com.google.android.material.bottomsheet.a aVar, View view, int i) {
        this.e = ((u93) this.c.get(i)).a().getPath();
        this.o.setText(((u93) this.c.get(i)).a().getName());
        this.l.setText(this.e.endsWith(".hexe16") ? "输入密钥" : "开始升级");
        this.f.F(this.e);
        aVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(zl0 zl0Var, View view, int i) {
        File fileA = ((u93) this.c.get(i)).a();
        if (fileA.isFile()) {
            if (!fileA.delete()) {
                showMsg("删除失败");
                return;
            }
            this.c.remove(i);
            zl0Var.notifyItemRemoved(i);
            showMsg("删除成功");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(EditText editText, ImageView imageView, View view) {
        editText.setText(Constants.STR_EMPTY);
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        this.i.dismiss();
    }

    private void initView() {
        this.l.setOnClickListener(new View.OnClickListener() { // from class: o93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.X(view);
            }
        });
        this.d = new t93(this.f.B());
        this.m.setLayoutManager(new LinearLayoutManager(this));
        this.m.setAdapter(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(EditText editText, View view) {
        String string = editText.getText().toString();
        if (string.length() != 32) {
            showMsg("密钥数据长度不足");
            return;
        }
        this.f.L(string);
        this.l.setText("开始升级");
        this.i.dismiss();
    }

    private void k0() {
        this.c.clear();
        File file = new File(this.a);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.getName().endsWith(".hex16") || file2.getName().endsWith(".hex") || file2.getName().endsWith(".hexe") || file2.getName().endsWith(".res") || file2.getName().endsWith(".hexe16") || file2.getName().endsWith(".bin")) {
                        this.c.add(new u93(file2, false));
                    }
                }
                Collections.sort(this.c, new dm0());
            } else {
                showMsg("本地文件夹无法打开");
            }
        } else {
            showMsg("无法获取文件");
        }
        File file3 = new File(this.b);
        if (!file3.exists()) {
            showMsg("无法获取文件");
            return;
        }
        File[] fileArrListFiles2 = file3.listFiles();
        if (fileArrListFiles2 == null) {
            showMsg("本地文件夹无法打开");
            return;
        }
        for (File file4 : fileArrListFiles2) {
            if (file4.getName().endsWith(".hex16") || file4.getName().endsWith(".hex") || file4.getName().endsWith(".hexe") || file4.getName().endsWith(".res") || file4.getName().endsWith(".hexe16") || file4.getName().endsWith(".bin")) {
                this.c.add(new u93(file4, false));
            }
        }
        Collections.sort(this.c, new dm0());
    }

    private void l0() {
        if (this.f.E()) {
            m0();
        } else {
            this.f.u();
            finish();
        }
    }

    private void m0() {
        new AlertDialog.Builder(this).setMessage(R$string.updatting_exit_tips).setPositiveButton(getString(R$string.ok), new DialogInterface.OnClickListener() { // from class: g93
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.d0(dialogInterface, i);
            }
        }).setNegativeButton(getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: k93
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    private void n0() {
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this, R$style.BottomSheetDialogStyle);
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.dialog_file, (ViewGroup) null);
        final zl0 zl0Var = new zl0(this.c);
        zl0Var.l(new fv1() { // from class: r93
            @Override // defpackage.fv1
            public final void onItemClick(View view, int i) {
                this.a.f0(aVar, view, i);
            }
        });
        zl0Var.k(new ev1() { // from class: s93
            @Override // defpackage.ev1
            public final void a(View view, int i) {
                this.a.g0(zl0Var, view, i);
            }
        });
        k0();
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.rv_file);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(zl0Var);
        aVar.setContentView(viewInflate);
        aVar.show();
    }

    private void p0() {
        this.n.setText(String.format(Locale.getDefault(), "要升级的设备列表，剩余：%d", Integer.valueOf(this.f.B().size())));
        if (this.f.E()) {
            showMsg("正在升级中，请勿重复点击。");
            return;
        }
        this.f306q.setText(getString(R$string.prepare_update));
        this.l.setText("升级中...");
        this.f.I(this);
        ss1.U();
    }

    @Override // defpackage.rs1
    public void e(int i) {
        Log.i(r, "onDeviceStateChange:" + i);
    }

    @Override // com.phy.ota_demo.basic.PhyActivity
    protected int getLayout() {
        return R$layout.activity_upgrade;
    }

    @Override // defpackage.rs1
    public void k(final int i, final o02 o02Var) {
        Log.i(r, "onComplete:" + i);
        runOnUiThread(new Runnable() { // from class: p93
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Z(i, o02Var);
            }
        });
    }

    public void o0() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.dialog_setting_key, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R$id.et_key);
        int i = R$id.iv_clear;
        final ImageView imageView = (ImageView) viewInflate.findViewById(i);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_num);
        this.i = new i5.a(this).a().d(viewInflate).c(true).g(jr2.a(this, 280.0f), -2).e(i, new View.OnClickListener() { // from class: h93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpgradeActivity.h0(editText, imageView, view);
            }
        }).e(R$id.tv_cancel, new View.OnClickListener() { // from class: i93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.i0(view);
            }
        }).e(R$id.tv_submit, new View.OnClickListener() { // from class: j93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.j0(editText, view);
            }
        }).b();
        editText.addTextChangedListener(new a(imageView, textView));
        this.i.show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        l0();
    }

    @Override // com.phy.ota_demo.basic.PhyActivity
    protected void onCreate() {
        this.l = (Button) findViewById(R$id.btn_func);
        this.m = (RecyclerView) findViewById(R$id.rv_upgrade_device);
        this.n = (TextView) findViewById(R$id.tv_remaining);
        this.o = (TextView) findViewById(R$id.tv_file_name);
        this.p = (ProgressBar) findViewById(R$id.progress_bar);
        this.f306q = (TextView) findViewById(R$id.tv_tips);
        ss1 ss1VarB = r02.b();
        this.f = ss1VarB;
        ss1VarB.M(this);
        String stringExtra = getIntent().getStringExtra("path");
        this.e = stringExtra;
        this.f.F(stringExtra);
        this.k.sendEmptyMessageDelayed(110, 2000L);
        initView();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.k.removeMessages(110);
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        l0();
        return true;
    }

    @Override // defpackage.rs1
    public void onProgress(int i, final int i2) {
        Log.i(r, "index:" + i + ";progress:" + i2);
        runOnUiThread(new Runnable() { // from class: q93
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a0(i2);
            }
        });
    }

    @Override // com.phy.ota_demo.basic.PhyActivity
    protected void onRegister() {
        this.h = registerForActivityResult(new e4(), new a4() { // from class: m93
            @Override // defpackage.a4
            public final void a(Object obj) {
                this.a.b0((ActivityResult) obj);
            }
        });
        this.g = registerForActivityResult(new d4(), new a4() { // from class: n93
            @Override // defpackage.a4
            public final void a(Object obj) {
                this.a.c0((Boolean) obj);
            }
        });
    }
}
