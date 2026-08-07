package com.onmicro.omtoolbox.dfu;

import android.app.LoaderManager;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;
import com.google.gson.reflect.TypeToken;
import com.onmicro.omtoolbox.BaseActivity;
import com.onmicro.omtoolbox.R$drawable;
import com.onmicro.omtoolbox.R$id;
import com.onmicro.omtoolbox.R$layout;
import com.onmicro.omtoolbox.R$menu;
import com.onmicro.omtoolbox.R$string;
import com.onmicro.omtoolbox.scanner.ScannerFragment;
import defpackage.e43;
import defpackage.e8;
import defpackage.ed1;
import defpackage.h9;
import defpackage.hj2;
import defpackage.jm0;
import defpackage.m50;
import defpackage.o33;
import defpackage.on0;
import defpackage.pc0;
import defpackage.pj0;
import defpackage.qv0;
import defpackage.wt1;
import defpackage.xg;
import defpackage.ym1;
import java.io.File;
import java.util.List;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuBaseService;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;

/* JADX INFO: loaded from: classes3.dex */
public class DfuActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, ScannerFragment.b, LoaderManager.LoaderCallbacks<Cursor> {
    private List H;
    Toolbar a;
    TextView b;
    TextView c;
    RadioButton d;
    RelativeLayout e;
    EditText f;
    Button g;
    RelativeLayout h;
    ImageView i;
    TextView j;
    RadioButton k;
    TableLayout l;
    TextView m;
    TextView n;
    TextView o;
    Button p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Button f302q;
    private BluetoothDevice r;
    private String s;
    private Uri t;
    private boolean u;
    private boolean v;
    private boolean w;
    private String x;
    private boolean y;
    private int z = -60;
    private int F = 1;
    private String G = "6621D";
    private final DfuProgressListener I = new d();

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            DfuActivity.N(DfuActivity.this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class b implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ TextView a;

        b(TextView textView) {
            this.a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.a.setText(String.format(Locale.ROOT, "%ddBm", Integer.valueOf(i * (-1))));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class c implements wt1 {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            DfuActivity dfuActivity = DfuActivity.this;
            o33.b(dfuActivity, dfuActivity.getString(R$string.network_no_available));
        }

        public void c(xg xgVar) {
        }

        @Override // defpackage.wt1
        public void onError(Throwable th) {
            ed1.a("DfuActivity", "onError:" + th.getMessage());
            DfuActivity.this.runOnUiThread(new Runnable() { // from class: com.onmicro.omtoolbox.dfu.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
        }

        @Override // defpackage.wt1
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            e43.a(obj);
            c(null);
        }
    }

    class d extends DfuProgressListenerAdapter {
        d() {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceConnecting(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnecting(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuAborted(String str) {
            DfuActivity.this.f302q.setText(R$string.dfu_status_fialed);
            DfuActivity.this.f302q.setClickable(true);
            DfuActivity.this.P();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuCompleted(String str) {
            DfuActivity.this.f302q.setText(R$string.dfu_status_successed);
            DfuActivity.this.f302q.setClickable(true);
            DfuActivity.this.P();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarting(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onEnablingDfuMode(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onError(String str, int i, int i2, String str2) {
            ed1.b("DfuActivity", "onError:" + i);
            DfuActivity.this.f302q.setText(R$string.dfu_status_fialed);
            DfuActivity.this.f302q.setClickable(true);
            o33.b(DfuActivity.this, "升级失败：" + str2);
            DfuActivity.this.P();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onFirmwareValidating(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onProgressChanged(String str, int i, float f, float f2, int i2, int i3) {
            DfuActivity dfuActivity = DfuActivity.this;
            dfuActivity.f302q.setText(String.format(Locale.ROOT, dfuActivity.getString(R$string.updating_d), Integer.valueOf(i)));
        }
    }

    static /* synthetic */ on0 N(DfuActivity dfuActivity) {
        dfuActivity.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        new Handler().postDelayed(new Runnable() { // from class: eb0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.S();
            }
        }, 200L);
    }

    private boolean Q() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    private boolean R() {
        return h9.f(this, DfuService.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        ((NotificationManager) getSystemService("notification")).cancel(DfuBaseService.NOTIFICATION_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        this.i.setImageResource(R$drawable.ic_arrow_down_24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(m50 m50Var, int i) {
        if (getString(R$string.dfu_status_successed).equals(this.f302q.getText().toString())) {
            e43.a(this.H.get(i));
            throw null;
        }
        e43.a(this.H.get(i));
        Locale locale = Locale.ROOT;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(CheckBox checkBox, CheckBox checkBox2, EditText editText, SeekBar seekBar, DialogInterface dialogInterface, int i) {
        this.w = checkBox.isChecked();
        this.y = checkBox2.isChecked();
        this.x = editText.getText().toString().trim();
        this.z = seekBar.getProgress() * (-1);
        hj2.e(this, "is_filter_name", this.w);
        hj2.e(this, "is_filter_rssi", this.y);
        hj2.g(this, "filter_name", this.x);
        hj2.f(this, "filter_rssi", this.z);
    }

    private void Y() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(DfuBaseService.MIME_TYPE_ZIP);
        intent.addCategory("android.intent.category.OPENABLE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1);
        } else {
            o33.b(this, "请安装文件管理器");
        }
    }

    private void Z(String str) {
        e8.b(new ym1(new c()), str);
    }

    private void a0() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 0);
    }

    private void b0() {
        ScannerFragment.X().M(getSupportFragmentManager(), "scan_fragment");
    }

    private void c0() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.pop_file_list, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_empty_desc);
        List list = this.H;
        if (list == null || list.isEmpty()) {
            textView.setVisibility(0);
            Locale locale = Locale.ROOT;
            String string = getString(R$string.no_file_tip);
            String str = this.G;
            textView.setText(String.format(locale, string, str, str));
        } else {
            textView.setVisibility(4);
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new pc0(this, 1, R$drawable.divider));
        jm0 jm0Var = new jm0(this.H);
        recyclerView.setAdapter(jm0Var);
        final m50 m50VarA = new m50.c(this).e(viewInflate).b(true).d(true).f(-1, -2).c(new PopupWindow.OnDismissListener() { // from class: gb0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.a.T();
            }
        }).a();
        viewInflate.findViewById(R$id.view_cancle).setOnClickListener(new View.OnClickListener() { // from class: hb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m50VarA.n();
            }
        });
        jm0Var.f(new jm0.c() { // from class: ib0
            @Override // jm0.c
            public final void a(int i) {
                this.a.V(m50VarA, i);
            }
        });
        this.i.setImageResource(R$drawable.ic_arrow_up_24);
        m50VarA.o(this.h);
    }

    private void d0() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.dialog_fliter_settings, (ViewGroup) null);
        final CheckBox checkBox = (CheckBox) viewInflate.findViewById(R$id.cb_name);
        final EditText editText = (EditText) viewInflate.findViewById(R$id.et_name);
        final CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R$id.cb_rssi);
        final SeekBar seekBar = (SeekBar) viewInflate.findViewById(R$id.seekBar);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_rssi);
        checkBox.setChecked(this.w);
        editText.setText(this.x);
        checkBox2.setChecked(this.y);
        textView.setText(String.format(Locale.ROOT, "%ddBm", Integer.valueOf(this.z)));
        seekBar.setProgress(Math.abs(this.z));
        seekBar.setOnSeekBarChangeListener(new b(textView));
        new androidx.appcompat.app.b.a(this).u(viewInflate).k(R$string.cancel, null).o(R$string.sure, new DialogInterface.OnClickListener() { // from class: fb0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.W(checkBox, checkBox2, editText, seekBar, dialogInterface, i);
            }
        }).v();
    }

    private void e0() {
        if (R()) {
            return;
        }
        this.f302q.setText(getString(R$string.updating));
        DfuServiceInitiator unsafeExperimentalButtonlessServiceInSecureDfuEnabled = new DfuServiceInitiator(this.r.getAddress()).setDeviceName(this.r.getName()).setKeepBond(false).setForceDfu(false).setPacketsReceiptNotificationsEnabled(false).setPacketsReceiptNotificationsValue(12).setPrepareDataObjectDelay(400L).setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true);
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setZip(this.t, this.s);
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setForeground(false);
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setDisableNotification(true);
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.start(this, DfuService.class);
        DfuServiceInitiator.createDfuNotificationChannel(this);
    }

    private void f0(String str, long j) {
        this.m.setText(str);
        this.n.setText(String.format(Locale.ROOT, getString(R$string.dfu_file_size_text), Long.valueOf(j)));
        boolean zMatches = MimeTypeMap.getFileExtensionFromUrl(str).matches("(?i)ZIP");
        this.u = zMatches;
        this.o.setText(zMatches ? "OK" : getString(R$string.dfu_file_status_invalid));
    }

    private void g0() {
        this.e.setAlpha(this.v ? 1.0f : 0.3f);
        this.g.setEnabled(this.v);
        this.h.setAlpha(this.v ? 1.0f : 0.3f);
        this.l.setAlpha(this.v ? 0.3f : 1.0f);
        this.p.setEnabled(!this.v);
        if (!this.v) {
            this.j.setVisibility(8);
        }
        hj2.f(this, "dfu_update_method", !this.v ? 1 : 0);
    }

    @Override // com.onmicro.omtoolbox.BaseActivity
    public void G() {
        super.G();
        setSupportActionBar(this.a);
        getSupportActionBar().s(true);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, Cursor cursor) {
        if (cursor == null || !cursor.moveToNext()) {
            this.m.setText((CharSequence) null);
            this.n.setText((CharSequence) null);
            this.o.setText("文件读取失败");
            this.s = null;
            this.t = null;
            this.u = false;
            return;
        }
        String string = cursor.getString(cursor.getColumnIndex("_display_name"));
        int i = cursor.getInt(cursor.getColumnIndex("_size"));
        int columnIndex = cursor.getColumnIndex("_data");
        String string2 = columnIndex != -1 ? cursor.getString(columnIndex) : null;
        if (!TextUtils.isEmpty(string2)) {
            this.s = string2;
        }
        f0(string, i);
    }

    @Override // com.onmicro.omtoolbox.scanner.ScannerFragment.b
    public void b(pj0 pj0Var) {
        if (getString(R$string.dfu_status_successed).equals(this.f302q.getText().toString()) && !pj0Var.a.getAddress().equals(this.r.getAddress())) {
            this.f302q.setText("开始升级");
        }
        BluetoothDevice bluetoothDevice = pj0Var.a;
        this.r = bluetoothDevice;
        String name = bluetoothDevice.getName();
        TextView textView = this.b;
        if (TextUtils.isEmpty(name)) {
            name = "UNKNOW";
        }
        textView.setText(name);
        this.c.setText(this.r.getAddress());
    }

    @Override // com.onmicro.omtoolbox.scanner.ScannerFragment.b
    public void h() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            this.s = null;
            this.t = null;
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            ed1.b("DfuActivity", "uri:" + data.getScheme());
            if (data.getScheme().equals("file")) {
                String path = data.getPath();
                File file = new File(path);
                this.s = path;
                f0(file.getName(), file.length());
                return;
            }
            if (data.getScheme().equals("content")) {
                this.t = data;
                Bundle extras = intent.getExtras();
                if (extras != null && extras.containsKey("android.intent.extra.STREAM")) {
                    this.t = (Uri) extras.getParcelable("android.intent.extra.STREAM");
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("uri", data);
                getLoaderManager().restartLoader(1, bundle, this);
            }
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == R$id.rb_net) {
            if (this.v != z) {
                this.v = z;
                this.k.setChecked(!z);
                g0();
                return;
            }
            return;
        }
        if (id == R$id.rb_local && this.v == z) {
            boolean z2 = !z;
            this.v = z2;
            this.d.setChecked(z2);
            g0();
        }
    }

    @OnClick({2621, 2740, 2620, 2622})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.btn_sure) {
            String strTrim = this.f.getText().toString().trim();
            this.G = strTrim;
            if (TextUtils.isEmpty(strTrim)) {
                o33.b(this, "请输入芯片型号");
                return;
            } else {
                hj2.g(this, "chip_model", this.G);
                Z(this.G);
                return;
            }
        }
        if (id == R$id.iv_file_expload) {
            if (TextUtils.isEmpty(this.G)) {
                o33.b(this, getString(R$string.input_chip_model_tip));
                return;
            } else {
                c0();
                return;
            }
        }
        if (id == R$id.btn_select_file) {
            Y();
            return;
        }
        if (id == R$id.btn_update) {
            if (this.r == null) {
                o33.b(this, "请选择设备");
                return;
            }
            if (this.v) {
                o33.b(this, "请选择DFU升级文件");
            } else if (!this.u) {
                o33.b(this, "升级文件无效，请重新选择升级文件！");
            } else {
                this.f302q.setClickable(false);
                e0();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_dfu);
        this.w = hj2.a(this, "is_filter_name", this.w);
        this.x = hj2.c(this, "filter_name");
        this.y = hj2.a(this, "is_filter_rssi", this.y);
        this.z = hj2.b(this, "filter_rssi", this.z);
        this.F = hj2.b(this, "dfu_update_method", this.F);
        this.d.setOnCheckedChangeListener(this);
        this.k.setOnCheckedChangeListener(this);
        int i = this.F;
        this.v = i == 1;
        if (i != 1) {
            this.d.setChecked(true);
        } else {
            this.k.setChecked(true);
        }
        DfuServiceListenerHelper.registerProgressListener(this, this.I);
        String strC = hj2.c(this, "firmware_info_json");
        if (!TextUtils.isEmpty(strC)) {
            try {
                e43.a(new qv0().fromJson(strC, new TypeToken<on0>() { // from class: com.onmicro.omtoolbox.dfu.DfuActivity.1
                }.getType()));
            } catch (Exception e) {
                ed1.a("DfuActivity", e.getMessage());
            }
        }
        String strD = hj2.d(this, "chip_model", this.G);
        this.G = strD;
        this.f.setText(strD);
        if (!TextUtils.isEmpty(this.G)) {
            this.f.setSelection(this.G.length());
            Z(this.G);
        }
        this.f.addTextChangedListener(new a());
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, (Uri) bundle.getParcelable("uri"), null, null, null, null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.dfu_menu, menu);
        return true;
    }

    @Override // com.onmicro.omtoolbox.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        this.o.setText((CharSequence) null);
        this.n.setText((CharSequence) null);
        this.s = null;
        this.t = null;
        this.u = false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R$id.action_scanner) {
            if (itemId != R$id.action_scanner_fliter) {
                return true;
            }
            d0();
            return true;
        }
        if (Q()) {
            b0();
            return true;
        }
        a0();
        return true;
    }
}
